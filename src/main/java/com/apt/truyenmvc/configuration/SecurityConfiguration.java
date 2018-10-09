package com.apt.truyenmvc.configuration;

import com.apt.truyenmvc.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import com.apt.truyenmvc.security.CustomAuthenticationSuccessHandler;
import com.apt.truyenmvc.service.impl.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		// Sét đặt dịch vụ để tìm kiếm User trong Database.
		// Và sét đặt PasswordEncoder.
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());

	}

	@Bean
    public AuthenticationSuccessHandler myAuthenticationSuccessHandler(){
        return new CustomAuthenticationSuccessHandler();
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable();

		// Các trang không yêu cầu login
		http.authorizeRequests()
				.antMatchers(SecurityUtils.PERMIT_ALL_LINK).permitAll();

		// Trang /userInfo yêu cầu phải login với tối thiểu là vai trò ROLE_USER
		// Nếu chưa login, nó sẽ redirect tới trang /login.
		http.authorizeRequests().antMatchers(SecurityUtils.ROLE_USER_LINK).access("hasAnyRole('ROLE_USER')");

		// Trang chỉ dành cho ADMIN
		http.authorizeRequests().antMatchers(SecurityUtils.ROLE_ADMIN_LINK).access("hasRole('ROLE_ADMIN')");

		// Khi người dùng đã login, với vai trò XX.
		// Nhưng truy cập vào trang yêu cầu vai trò YY,
		// Ngoại lệ AccessDeniedException sẽ ném ra.
		http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");

		// Cấu hình cho Login Form.
		http.authorizeRequests().and().formLogin()//
				// Submit URL của trang login
				.loginProcessingUrl("/j_spring_security_check") // Submit URL
				.loginPage("/login")//
				.defaultSuccessUrl("/")//
				.failureUrl("/login?error=true")//
				.usernameParameter("username")//
				.passwordParameter("password")
				.successHandler(myAuthenticationSuccessHandler())
				// Cấu hình cho Logout Page.
				.and().logout().logoutUrl("/logout").logoutSuccessUrl("/logoutSuccessful");

		// Cấu hình Remember Me.
		http.authorizeRequests().and() //
				.rememberMe().tokenRepository(this.persistentTokenRepository()) //
				.tokenValiditySeconds(1 * 24 * 60 * 60); // 24h

	}

	@Bean
	public PersistentTokenRepository persistentTokenRepository() {
		InMemoryTokenRepositoryImpl memory = new InMemoryTokenRepositoryImpl();
		return memory;
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
	}

}