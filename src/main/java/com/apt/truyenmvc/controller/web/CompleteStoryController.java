package com.apt.truyenmvc.controller.web;

import com.apt.truyenmvc.entity.Story;
import com.apt.truyenmvc.entity.inf.NewStory;
import com.apt.truyenmvc.service.CategoryService;
import com.apt.truyenmvc.service.InformationService;
import com.apt.truyenmvc.service.StoryService;
import com.apt.truyenmvc.utils.ConstantsUtils;
import com.apt.truyenmvc.utils.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author Huy Thang on 16/10/2018
 * @project truyenmvc
 */

@Controller
@PropertySource(value = "classpath:messages.properties", encoding = "UTF-8")
@RequestMapping(value = "/danh-sach/hoan-thanh")
public class CompleteStoryController {

    Logger logger = LoggerFactory.getLogger(CompleteStoryController.class);

    @Value("${hthang.truyenmvc.title.complete.story}")
    private String titleCompleteStory;

    @Autowired
    private InformationService informationService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private StoryService storyService;

    private void getMenuAndInfo(Model model, String title) {

        // Lấy Title Cho Page
        model.addAttribute("title", title);

        // Lấy List Category cho Menu
        model.addAttribute("categorylist", categoryService.getCategoryMenu());

        // Lấy Information của Web
        model.addAttribute("information", informationService.getWebInfomation());
    }

    private void loadData(int pagenumber, Model model) {
        Page<NewStory> page = storyService.getStoryCompletedByPage(pagenumber, ConstantsUtils.PAGE_SIZE_DEFAULT);

        // Lấy tổng số trang
        int total = page.getTotalPages();

        // Kiểm tra tổng số trang có nhỏ hơn pagenumber không
        if (total < pagenumber) {
            pagenumber = ConstantsUtils.PAGE_DEFAULT;
            page = storyService.getStoryCompletedByPage(pagenumber, ConstantsUtils.PAGE_SIZE_DEFAULT);
            total = page.getTotalPages();
        }

        // Lấy List Story
        List<NewStory> lstStory = page.getContent();

        // Lấy số trang hiện tại
        int current = page.getNumber() + 1;

        // Lấy số trang bắt đầu
        int begin = Math.max(1, current - 2);

        //Lấy số trang kết thúc
        int end = Math.min(begin + 4, page.getTotalPages());
        model.addAttribute("listStory", lstStory);
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("totalIndex", total);
        model.addAttribute("currentIndex", current);
    }

    @RequestMapping()
    public String defaultCompleteStory(Model model) {

        getMenuAndInfo(model, titleCompleteStory);

        loadData(ConstantsUtils.PAGE_DEFAULT, model);

        return "web/danhmuc";
    }

    @RequestMapping(value = "/trang-{page}")
    public String pageCompleteStory(@PathVariable("page") String page, Model model) {
        int pagenumber = 1;

        // Kiểm tra page != null
        // Kiểm tra page có phải kiểu int
        // Kiểm tra page > 0
        if (page != null && WebUtils.checkIntNumber(page) && Integer.parseInt(page) > 0) {
            pagenumber = Integer.parseInt(page);
        }

        //Lấy Top View Trong Tháng
        List<Story> topView = storyService.getCompleteStorySwapper();
        model.addAttribute("topView", topView);

        getMenuAndInfo(model, titleCompleteStory);

        loadData(pagenumber, model);

        return "web/danhmuc";
    }

}
