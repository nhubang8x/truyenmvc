package com.apt.truyenmvc.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apt.truyenmvc.entity.Story;
import com.apt.truyenmvc.entity.inf.NewStory;
import com.apt.truyenmvc.entity.inf.TopStory;
import com.apt.truyenmvc.repository.StoryRepository;
import com.apt.truyenmvc.service.StoryService;
import com.apt.truyenmvc.utils.ConstantsUtils;

import javax.annotation.PostConstruct;

/**
 *
 * @author Huy Thang
 */
@Service
@Transactional
public class StoryServiceImpl implements StoryService {

	@Autowired
	private StoryRepository storyRepository;

	@Override
	public Page<Story> getUpdateStoryInHome(int page, int size) {
		List<Integer> listStatus = new ArrayList<>();
		listStatus.add(ConstantsUtils.STORY_STATUS_COMPLETED);
		listStatus.add(ConstantsUtils.STORY_STATUS_GOING_ON);
		Pageable pageable = PageRequest.of(page - 1, size, Sort.Direction.DESC, "sUpdate");
		return storyRepository.findBySStatusIn(listStatus, pageable);
	}

	@Override
	public Page<NewStory> getStoryNew(int page, int size) {
		List<Integer> listStatus = new ArrayList<>();
		listStatus.add(ConstantsUtils.STORY_STATUS_COMPLETED);
		listStatus.add(ConstantsUtils.STORY_STATUS_GOING_ON);
		Pageable pageable = PageRequest.of(page - 1, size);
		return storyRepository.getStoryNew(ConstantsUtils.STATUS_ACTIVED, listStatus, pageable);
	}

	@Override
	public Page<NewStory> getStoryNewByCID(Integer cID, int page, int size) {
		List<Integer> listStatus = new ArrayList<>();
		listStatus.add(ConstantsUtils.STORY_STATUS_COMPLETED);
		listStatus.add(ConstantsUtils.STORY_STATUS_GOING_ON);
		Pageable pageable = PageRequest.of(page - 1, size);
		return storyRepository.getStoryNewByCategory(ConstantsUtils.STATUS_ACTIVED, cID, listStatus, pageable);
	}

	@Override
	public Page<TopStory> getTopStory(Date startDate, Date endDate, int page, int size) {
		List<Integer> listStatus = new ArrayList<>();
		listStatus.add(ConstantsUtils.STORY_STATUS_COMPLETED);
		listStatus.add(ConstantsUtils.STORY_STATUS_GOING_ON);
		Pageable pageable = PageRequest.of(page - 1, size);
		return storyRepository.getTopStory(listStatus, startDate, endDate, pageable);
	}

	@Override
	public Page<TopStory> getTopStoryVip(Date startDate, Date endDate, int page, int size) {
		List<Integer> listStatus = new ArrayList<>();
		listStatus.add(ConstantsUtils.STORY_STATUS_COMPLETED);
		listStatus.add(ConstantsUtils.STORY_STATUS_GOING_ON);
		Pageable pageable = PageRequest.of(page - 1, size);
		return storyRepository.getTopStoryVip(startDate, endDate, ConstantsUtils.STATUS_ACTIVED, listStatus, pageable);
	}

	@Override
	public List<Story> getNewStoryCompleted() {
        return storyRepository.findTop10BySStatus(ConstantsUtils.STORY_STATUS_COMPLETED);
	}

}
