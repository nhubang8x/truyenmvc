package com.apt.truyenmvc.controller.web;

import com.apt.truyenmvc.entity.User;
import com.apt.truyenmvc.service.CategoryService;
import com.apt.truyenmvc.service.InformationService;
import com.apt.truyenmvc.service.UroleService;
import com.apt.truyenmvc.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * @author Huy Thang on 12/10/2018
 * @project truyenmvc
 */

@Controller
@PropertySource(value = "classpath:messages.properties", encoding = "UTF-8")
@RequestMapping("/dang-ky")
public class RegisterController {

    Logger logger = LoggerFactory.getLogger(RegisterController.class);
    @Autowired
    private InformationService informationService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private UserService userService;
    @Autowired
    private UroleService uroleService;

    @Autowired
    private MessageSource messageSource;

    private void getMenuAndInfo(Model model, String title) {

        // Lấy Title Cho Page
        model.addAttribute("title", title);

        // Lấy List Category cho Menu
        model.addAttribute("categorylist", categoryService.getCategoryMenu());

        // Lấy Information của Web
        model.addAttribute("information", informationService.getWebInfomation());
    }

    @GetMapping
    public String showRegisterForm(final Model model) {
        logger.info("Get Dang ky");
        // Lấy List Category Menu
        getMenuAndInfo(model, "Đăng Ký | Truyện Online | Vietphrase");

        model.addAttribute("user", new User());
        return "web/dangky";
    }

    @PostMapping
    public String register(@Valid User user, BindingResult result, Model model, HttpServletRequest request) {
        boolean hasError = result.hasErrors();
        if (hasError) {
            getMenuAndInfo(model, "Đăng Ký | Truyện Online | Vietphrase");

            model.addAttribute("user", user);
            return "web/dangky";
        }
        if (!hasError) {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            user.setUPass(passwordEncoder.encode(user.getPasswordRegister()));
            user.setUDname(user.getUName());
            userService.updateUser(user);
        }

        return "redirect:/";
    }
}