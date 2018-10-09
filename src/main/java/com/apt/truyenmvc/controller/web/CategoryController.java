package com.apt.truyenmvc.controller.web;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.apt.truyenmvc.entity.Category;
import com.apt.truyenmvc.service.CategoryService;
import com.apt.truyenmvc.service.InformationService;
import com.apt.truyenmvc.service.StoryService;

/**
 * @author Huy Thang
 *
 */
@Controller
@RequestMapping("/the-loai")
public class CategoryController {

	Logger logger = LoggerFactory.getLogger(CategoryController.class);

	@Autowired
	private InformationService informationService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private StoryService storyService;

	private void getMenuAndInfo(Model model) {

		// Lấy List Category cho Menu
		model.addAttribute("categorylist", categoryService.getCategoryMenu());

		// Lấy Information của Web
		model.addAttribute("information", informationService.getWebInfomation());
	}

	private void loadTableDataByCategory(Integer cID, Integer pagenumber, Model model) {
//		Page<Story> page = storyService.findByCategory(Constants.CHAPTER_STATUS_APPROVED,
//				Constants.STORY_STATUS_HIDDEN, cID, pageable);
//		int total = page.getTotalPages();
//		if (total < pagenumber) {
//			pagenumber = 1;
//			pageable = new PageRequest(pagenumber - 1, Constants.PAGESIZE);
//			page = chapterService.findByCategory(Constants.CHAPTER_STATUS_APPROVED, Constants.STORY_STATUS_HIDDEN, cID,
//					pageable);
//			total = page.getTotalPages();
//		}
//		List<Chapter> lstChapter = page.getContent();
//		int current = page.getNumber() + 1;
//		int begin = Math.max(1, current - 2);
//		int end = Math.min(begin + 4, page.getTotalPages());
//		model.addAttribute("lstchapter", lstChapter);
//		model.addAttribute("beginIndex", begin);
//		model.addAttribute("endIndex", end);
//		model.addAttribute("totalIndex", total);
//		model.addAttribute("currentIndex", current);
//		model.addAttribute("cid", cID);
	}
	
	@RequestMapping("/{cid}")
	public String theloaiPage(@PathVariable("cid") Integer cid, Model model) {

		// Lấy Category theo cID
		Optional<Category> category = categoryService.getCategoryByID(cid);

		// Kiểm tra có category có rỗng hay không
		// Nếu rỗng chuyển sang trang thông báo lỗi
		if (!category.isPresent()) {

			return "redirect:/error";

		}

		// Lấy Thông tin Category cho menu và Information Web
		getMenuAndInfo(model);

		String result = "redirect:/the-loai/" + cid + "/" + category.get().getCMetatitle();

		return result;
	}

	@RequestMapping("/{cid}/{cmetaTitle}")
	public String theloaiPage(@PathVariable("cid") Integer cid, @PathVariable("cmetaTitle") String cmetaTitle,
			Model model) {

		// Lấy Category theo cID
		Optional<Category> category = categoryService.getCategoryByID(cid);

		// Kiểm tra có category có rỗng hay không
		// Nếu rỗng chuyển sang trang thông báo lỗi
		if (!category.isPresent()) {

			return "redirect:/error";

		} else {

			Category cat = category.get();

			// Kiểm tra Metatitle có đúng hay không
			// Nếu không chuyển trang sang định dạng đúng
			if (!cmetaTitle.equalsIgnoreCase(cat.getCMetatitle())) {

				String result = "redirect:/the-loai/" + cid + "/" + cat.getCMetatitle();

				return result;
			}
		}

		// Lấy Thông tin Category cho menu và Information Web
		getMenuAndInfo(model);

		return "web/the-loai";
	}

	@RequestMapping("/the-loai/{cid}/{cmetaTitle}/trang-{page}")
	public String doLoadStoryByCategoryAndPage(@PathVariable("cid") Integer cid,
			@PathVariable("cmetaTitle") String cmetaTitle, @PathVariable("page") String page, Model model) {
//		int pagenumber = 1;
//		if (page != null && WebUtils.checkIntNumber(page) && Integer.parseInt(page) > 0) {
//			pagenumber = Integer.parseInt(page);
//		}
//		Category category = categoryService.findByCid(cid);
//		if (category == null || !category.getCstatus()) {
//			return "redirect:/error";
//		}
//		if (!cmetaTitle.equalsIgnoreCase(category.getCmetaTitle())) {
//			String result = "/the-loai/" + cid + "/" + category.getCmetaTitle();
//			return "redirect:" + result;
//		}
//		loadTableDataByCategory(cid, pagenumber, model);
//		LoadCategoryMenu(model);
//		model.addAttribute("category", category);
//		model.addAttribute("topview", storyService.findTop5ViewWithCategory(cid));
//		model.addAttribute("title", "Truyện " + category.getCname());
		return "web/theloaitruyen";
	}
}
