package com.apt.truyenmvc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apt.truyenmvc.entity.Urole;
import com.apt.truyenmvc.entity.User;
import com.apt.truyenmvc.entity.custom.MyUserDetails;
import com.apt.truyenmvc.service.UroleService;
import com.apt.truyenmvc.service.UserService;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserService userService;

	@Autowired
	private UroleService uroleService;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = this.userService.getUserByUserName(userName);

		if (user == null) {
			System.out.println("Không tìm thấy user:" + userName);
			throw new UsernameNotFoundException("User " + userName + " was not found in the database");
		} else {
			System.out.println("Tim thấy user: " + user.getUEmail());
		}
		List<Urole> listRole = this.uroleService.getListRole(user);

		System.out.println("Size" + listRole.size());
		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		if (listRole != null) {
			for (Urole urole : listRole) {
				GrantedAuthority authority = new SimpleGrantedAuthority(urole.getRole().getRName());
				grantList.add(authority);
			}
		}

		MyUserDetails myUserDetails = new MyUserDetails(user, grantList);
		return myUserDetails;
	}

	public List<GrantedAuthority> getRoleUser(User user) {
		List<Urole> listRole = this.uroleService.getListRole(user);

		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		if (listRole != null) {
			for (Urole urole : listRole) {
				GrantedAuthority authority = new SimpleGrantedAuthority(urole.getRole().getRName());
				grantList.add(authority);
			}
		}
		return grantList;
	}
}