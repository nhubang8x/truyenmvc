package com.apt.truyenmvc.service.impl;

import com.apt.truyenmvc.entity.Story;
import com.apt.truyenmvc.entity.inf.NewStory;
import com.apt.truyenmvc.entity.inf.TopStory;
import com.apt.truyenmvc.repository.StoryRepository;
import com.apt.truyenmvc.service.StoryService;
import com.apt.truyenmvc.utils.ConstantsUtils;
import com.apt.truyenmvc.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Huy Thang
 */
@Service
@Transactional
public class StoryServiceImpl implements StoryService {

    @Autowired
    private StoryRepository storyRepository;

    /**
     * Lấy List Truyện Mới Cập Nhật
     *
     * @param page
     * @param size
     *
     * @return Page<NewStory>
     */
    @Override
    public Page<NewStory> getStoryNew(int page, int size) {
        List<Integer> listStatus = new ArrayList<>();
        listStatus.add(ConstantsUtils.STORY_STATUS_COMPLETED);
        listStatus.add(ConstantsUtils.STORY_STATUS_GOING_ON);
        Pageable pageable = PageRequest.of(page - 1, size);
        return storyRepository
                .getStoryNew(ConstantsUtils.STATUS_ACTIVED, listStatus, pageable);
    }

    /**
     * Lấy List Truyện Vip Mới Cập Nhật
     *
     * @param page
     * @param size
     *
     * @return Page<NewStory>
     */
    @Override
    public Page<NewStory> getVipStoryNew(int page, int size) {
        List<Integer> listStatus = new ArrayList<>();
        listStatus.add(ConstantsUtils.STORY_STATUS_COMPLETED);
        listStatus.add(ConstantsUtils.STORY_STATUS_GOING_ON);
        Pageable pageable = PageRequest.of(page - 1, size);
        return storyRepository
                .getVipStoryNew(ConstantsUtils.STATUS_ACTIVED, listStatus, ConstantsUtils.STATUS_ACTIVED ,pageable);
    }

    /**
     * Lấy List Truyện Mới Cập Nhật theo Category
     *
     * @param cID
     * @param page
     * @param size
     *
     * @return Page<NewStory>
     */
    @Override
    public Page<NewStory> getStoryNewByCID(Integer cID, int page, int size) {
        List<Integer> listStatus = new ArrayList<>();
        listStatus.add(ConstantsUtils.STORY_STATUS_COMPLETED);
        listStatus.add(ConstantsUtils.STORY_STATUS_GOING_ON);
        Pageable pageable = PageRequest.of(page - 1, size);
        return storyRepository
                .getStoryNewByCategory(ConstantsUtils.STATUS_ACTIVED, cID, listStatus, pageable);
    }

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
    @Override
    public Page<TopStory> getTopStory(Date startDate, Date endDate, int page, int size) {
        List<Integer> listStatus = new ArrayList<>();
        listStatus.add(ConstantsUtils.STORY_STATUS_COMPLETED);
        listStatus.add(ConstantsUtils.STORY_STATUS_GOING_ON);
        Pageable pageable = PageRequest.of(page - 1, size);
        return storyRepository
                .getTopStory(listStatus, startDate, endDate, pageable);
    }

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
    @Override
    public Page<TopStory> getTopStoryVip(Date startDate, Date endDate, int page, int size) {
        List<Integer> listStatus = new ArrayList<>();
        listStatus.add(ConstantsUtils.STORY_STATUS_COMPLETED);
        listStatus.add(ConstantsUtils.STORY_STATUS_GOING_ON);
        Pageable pageable = PageRequest.of(page - 1, size);
        return storyRepository
                .getTopStoryVip(startDate, endDate, ConstantsUtils.STATUS_ACTIVED, listStatus, pageable);
    }

    /**
     * Lấy Top 10 Truyện Mới hoàn thành
     *
     * @return List<Story>
     */
    @Override
    public List<Story> getNewStoryCompleted() {
        return storyRepository
                .findTop10BySStatus(ConstantsUtils.STORY_STATUS_COMPLETED);
    }

    /**
     * Lấy Page Truyện Hoàn Thành
     *
     * @param page
     * @param size
     *
     * @return Page<NewStory>
     */
    @Override
    public Page<NewStory> getStoryCompletedByPage(int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size, Sort.Direction.DESC, "sUpdate");
        return storyRepository
                .getPageStoryComplete(ConstantsUtils.STATUS_ACTIVED, ConstantsUtils.STORY_STATUS_COMPLETED, pageable);
    }

    /**
     * Lấy List Truyện Hoàn Thành Top View Trong Tháng
     *
     * @return List<Story>
     */
    @Override
    public List<Story> getCompleteStorySwapper() {
        Pageable pageable = PageRequest.of(ConstantsUtils.PAGE_DEFAULT - 1, ConstantsUtils.PAGE_SIZE_SWAPPER,
                Sort.Direction.DESC, "sUpdate");
        Stream<Story> storyStream = storyRepository.getCompleteStoryTopView(ConstantsUtils.STORY_STATUS_COMPLETED,
                DateUtils.getFirstDayOfMonth(), DateUtils.getLastDayOfMonth(), pageable).get();
        return storyStream.collect(Collectors.toList());
    }
}
