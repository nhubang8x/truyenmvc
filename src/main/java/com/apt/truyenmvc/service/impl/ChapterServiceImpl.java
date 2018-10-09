package com.apt.truyenmvc.service.impl;

import com.apt.truyenmvc.entity.Chapter;
import com.apt.truyenmvc.utils.ConstantsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apt.truyenmvc.repository.ChapterRepository;
import com.apt.truyenmvc.service.ChapterService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 * @author Huy Thang
 */
@Service
@Transactional
public class ChapterServiceImpl implements ChapterService {

	@Autowired
	private ChapterRepository chapterRepository;

    @Override
    public List<Chapter> getAllChapterFavoritesByUser(Long uID) {
        return chapterRepository.getAllFavoritesByUser(uID, ConstantsUtils.STATUS_ACTIVED
                , ConstantsUtils.STATUS_ACTIVED,  ConstantsUtils.STORY_STATUS_HIDDEN);
    }
}
