/**
 * 
 */
package com.apt.truyenmvc.restful;

import javax.servlet.http.HttpServletRequest;

import com.apt.truyenmvc.entity.Chapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apt.truyenmvc.entity.Information;
import com.apt.truyenmvc.entity.User;
import com.apt.truyenmvc.entity.inf.TopStory;
import com.apt.truyenmvc.service.CategoryService;
import com.apt.truyenmvc.service.InformationService;
import com.apt.truyenmvc.service.StoryService;
import com.apt.truyenmvc.service.UserService;
import com.apt.truyenmvc.utils.DateUtils;
import com.apt.truyenmvc.utils.ImageUtils;

import java.util.List;

/**
 * @author Huy Thang
 *
 */

@RestController
public class UserResful {

	@Autowired
	private UserService userService;

	@Autowired
	private InformationService informationService;

	@Autowired
	private StoryService storyService;

	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value = "/api/load", method = RequestMethod.GET)
	public Page<User> loadUser() {
		return userService.getPageUser();
	}

	@RequestMapping(value = "/api/load1", method = RequestMethod.GET)
	public Information loadUser1() {
		return informationService.getWebInfomation();
	}

	@RequestMapping(value = "/api/load2", method = RequestMethod.GET)
	public boolean loadUser2() {
		return true;
	}

	@RequestMapping(value = "/api/load3", method = RequestMethod.GET)
	public ResponseEntity<Page<TopStory>> loadUser3(@RequestParam("page") int page, @RequestParam("size") int size) {
//		Page<NewStory> rs = storyService.getStoryNew(page, size);
		Page<TopStory> rs = storyService.getTopStory(DateUtils.getFirstDayOfWeek(), DateUtils.getLastDayOfWeek(), page, size);
		System.out.println("Start Date :" + DateUtils.getFirstDayOfWeek());
		System.out.println("End Date :" + DateUtils.getLastDayOfWeek());
		System.out.println("Size: " + rs.getContent().size());
		System.out.println("Total element: " + rs.getTotalElements());
		System.out.println("Total Page: " + rs.getTotalPages());
		return new ResponseEntity<Page<TopStory>>(rs, HttpStatus.OK);
	}
}
