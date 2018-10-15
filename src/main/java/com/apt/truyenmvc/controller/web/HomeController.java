package com.apt.truyenmvc.controller.web;

import java.security.Principal;
import java.util.*;

import com.apt.truyenmvc.entity.Chapter;
import com.apt.truyenmvc.entity.User;
import com.apt.truyenmvc.entity.custom.MyUserDetails;
import com.apt.truyenmvc.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.apt.truyenmvc.entity.Story;
import com.apt.truyenmvc.entity.inf.NewStory;
import com.apt.truyenmvc.entity.inf.TopConverter;
import com.apt.truyenmvc.entity.inf.TopStory;
import com.apt.truyenmvc.utils.ConstantsUtils;
import com.apt.truyenmvc.utils.DateUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Huy Thang
 *
 */

@Controller
@PropertySource(value = "classpath:messages.properties", encoding = "UTF-8")
public class HomeController {

	@Value("${email.signature}")
	private String signature;

	@Value("${email.url}")
	private String url;

	@Value("${email.subject}")
	private String subject;

	Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private InformationService informationService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private StoryService storyService;

	@Autowired
	private EmailService emailService;

	@Autowired
	private UserService userService;

	@Autowired
    private ChapterService chapterService;

	private void getMenuAndInfo(Model model, String title) {

	    // Lấy Title Cho Page
        model.addAttribute("title", title);

		// Lấy List Category cho Menu
		model.addAttribute("categorylist", categoryService.getCategoryMenu());

		// Lấy Information của Web
		model.addAttribute("information", informationService.getWebInfomation());
	}

	@RequestMapping(value = "/")
	public String homePage(Model model,Principal principal, HttpServletRequest request, HttpServletResponse response) {
	    // Kiểm tra người dùng đã đăng nhập chưa
		if(principal !=null){
            System.out.println("Đã đăng nhập");
            // Lấy Danh sách truyện đang đọc của người dùng
            MyUserDetails loginedUser = (MyUserDetails) ((Authentication) principal).getPrincipal();
            User user= loginedUser.getUser();
            List<Chapter> chapterListFavorites = chapterService.getAllChapterFavoritesByUser(user.getUID());
            model.addAttribute("listFavorites",chapterListFavorites);
        }else{
            model.addAttribute("listFavorites",null);
        }

        //Lấy ngày bắt đầu của tuần
        Date firstDayOfWeek = DateUtils.getFirstDayOfWeek();

        //Lấy ngày kết thúc của tuần
        Date lastDayOfWeek = DateUtils.getLastDayOfWeek();

	    // Lấy Danh Sách Truyện Mới Cập Nhật
		List<NewStory> newstory = storyService
                .getStoryNew(ConstantsUtils.PAGE_DEFAULT, ConstantsUtils.PAGE_SIZE_HOME)
				.getContent();
		model.addAttribute("newstory", newstory);

		// Lấy Danh Sách Truyện Top View trong Tuần
		List<TopStory> topstory = storyService
                .getTopStory(firstDayOfWeek, lastDayOfWeek,
				ConstantsUtils.PAGE_DEFAULT, ConstantsUtils.RANK_SIZE)
                .getContent();
		model.addAttribute("topstory", topstory);
		
		// Lấy Danh Sách Top Converter
		List<TopConverter> topConverters = userService
                .getTopConverter(ConstantsUtils.PAGE_DEFAULT, ConstantsUtils.RANK_SIZE);
		model.addAttribute("topconverter", topConverters);
		
		// Lấy Danh Sách Truyện Vip Top trong tuần
		List<TopStory> topvipstory = storyService
                .getTopStoryVip(firstDayOfWeek, lastDayOfWeek,ConstantsUtils.PAGE_DEFAULT, ConstantsUtils.RANK_SIZE)
                .getContent();
		model.addAttribute("topstoryvip", topvipstory);
		
		// Lấy Danh Sách Truyện Mới Hoàn Thành 
		List<Story> topCompleted = storyService.getNewStoryCompleted();
		model.addAttribute("storyCompleted",topCompleted);
		
		getMenuAndInfo(model, "Truyện Online | Vietphrase");
		return "web/trangchu";
	}

    @RequestMapping(value = "/dang-nhap")
    public String loginPage(Model model) {

        getMenuAndInfo(model, "Đăng nhập | Truyện Online | Vietphrase");

        return "web/dangnhap";
    }

}
