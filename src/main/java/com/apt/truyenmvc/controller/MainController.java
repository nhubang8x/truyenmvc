package com.apt.truyenmvc.controller;

import java.security.Principal;
import java.util.List;

import com.apt.truyenmvc.entity.custom.MyUserDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.apt.truyenmvc.entity.Urole;
import com.apt.truyenmvc.entity.User;
import com.apt.truyenmvc.service.CategoryService;
import com.apt.truyenmvc.service.InformationService;
import com.apt.truyenmvc.service.UroleService;
import com.apt.truyenmvc.service.UserService;

@Controller
@SessionAttributes("uaccount")
public class MainController {

	Logger logger = LoggerFactory.getLogger(MainController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private UroleService uroleService;

	@Autowired
	private InformationService informationService;

	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value = { "/home", "/index" })
	public String welcomePage(Model model) {
		User user = userService.getUserByUserName("nhubang8x");
		if (user != null) {
			logger.info("Name: " + user.getUName());
			logger.info("Email: " + user.getUEmail());
		}
		List<Urole> list = uroleService.getListRole(user);
		model.addAttribute("title", "Welcome");
		model.addAttribute("uaccount", user);
		model.addAttribute("rolelist", list);
		return "trangchu";
	}

	@RequestMapping(value = "/admin")
	public String adminPage(Model model, Principal principal) {

//		org.springframework.security.core.userdetails.User loginedUser = (org.springframework.security.core.userdetails.User) ((Authentication) principal)
//				.getPrincipal();
//
//		String userInfo = com.apt.truyenmvc.utils.WebUtils.toString(loginedUser);
//		model.addAttribute("userInfo", userInfo);

		return "adminPage";
	}

	@RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
	public String logoutSuccessfulPage(Model model) {
		model.addAttribute("title", "Logout");
		return "logoutSuccessfulPage";
	}

	@RequestMapping(value = "/userInfo")
	public String userInfo(Model model, Principal principal) {

		// Sau khi user login thanh cong se co principal
//		String userName = principal.getName();
//
//		System.out.println("User Name: " + userName);
//
//		User loginedUser = (User) ((Authentication) principal).getPrincipal();
//
//		String userInfo = com.apt.truyenmvc.utils.WebUtils.toString(loginedUser);
//		model.addAttribute("userInfo", userInfo);
//
		return "userInfoPage";
	}

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String accessDenied(Model model, Principal principal) {

		if (principal != null) {
			MyUserDetails loginedUser = (MyUserDetails) ((Authentication) principal).getPrincipal();
			loginedUser.getUser().getUID();
//
//			String userInfo = com.apt.truyenmvc.utils.WebUtils.toString(loginedUser);
//
//			model.addAttribute("userInfo", userInfo);

			String message = "Hi " + principal.getName() //
					+ "<br> You do not have permission to access this page!";
			model.addAttribute("message", message);

		}

		return "web/403Page";
	}

}
