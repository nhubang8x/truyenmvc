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

	/**
	 * Lấy List Truyện Mới Cập Nhật
	 * 
	 * @param page
	 * @param size
	 * 
	 * @return Page<NewStory>
	 */
    Page<NewStory> getStoryNew(int page, int size);

    /**
     * Lấy List Truyện Vip Mới Cập Nhật
     *
     * @param page
     * @param size
     *
     * @return Page<NewStory>
     */
    Page<NewStory> getVipStoryNew(int page, int size);

	/**
	 * Lấy List Truyện Mới Cập Nhật theo Category
	 * 
	 * @param cID
	 * @param page
	 * @param size
	 * 
	 * @return Page<NewStory>
	 */
    Page<NewStory> getStoryNewByCID(Integer cID, int page, int size);

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
    Page<TopStory> getTopStory(Date startDate, Date endDate, int page, int size);
	
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
    Page<TopStory> getTopStoryVip(Date startDate, Date endDate, int page, int size);
	
	/**
	 * Lấy Top 10 Truyện Mới hoàn thành
	 * 
	 * @return List<Story>
	 */
    List<Story> getNewStoryCompleted() ;

    /**
     * Lấy Page Truyện Hoàn Thành
     *
     * @param page
     * @param size
     *
     * @return Page<NewStory>
     */
    Page<NewStory> getStoryCompletedByPage(int page, int size);

    /**
     * Lấy List Truyện Hoàn Thành Top View Trong Tháng
     *
     * @return List<Story>
     */
    List<Story> getCompleteStorySwapper();
}
