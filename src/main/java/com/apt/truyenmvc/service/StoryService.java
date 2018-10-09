package com.apt.truyenmvc.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.domain.Page;

import com.apt.truyenmvc.entity.Story;
import com.apt.truyenmvc.entity.inf.NewStory;
import com.apt.truyenmvc.entity.inf.TopStory;

/**
 *
 * @author Huy Thang
 */
public interface StoryService {

	public Page<Story> getUpdateStoryInHome(int page, int size);

	/**
	 * Lấy List Truyện Mới Cập Nhật
	 * 
	 * @param page
	 * @param size
	 * 
	 * @return Page<NewStory>
	 */
	public Page<NewStory> getStoryNew(int page, int size);

	/**
	 * Lấy List Truyện Mới Cập Nhật theo Category
	 * 
	 * @param cID
	 * @param page
	 * @param size
	 * 
	 * @return Page<NewStory>
	 */
	public Page<NewStory> getStoryNewByCID(Integer cID, int page, int size);

	/**
	 * Lấy List Truyện Top View Trong Tuần
	 * 
	 * @param startDate
	 * @param endDate
	 * @param page
	 * @param size
	 * 
	 * @return Page<TopStory>
	 */
	public Page<TopStory> getTopStory(Date startDate, Date endDate, int page, int size);
	
	/**
	 * Lấy List Truyện Vip Top Deal Trong Tuần
	 * 
	 * @param startDate
	 * @param endDate
	 * @param page
	 * @param size
	 * 
	 * @return Page<TopStory>
	 */
	public Page<TopStory> getTopStoryVip(Date startDate, Date endDate, int page, int size);
	
	/**
	 * Lấy List Truyện Mới hoàn thành
	 * 
	 * @return List<Story>
	 */
	public List<Story> getNewStoryCompleted() ;
}
