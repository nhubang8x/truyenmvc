package com.apt.truyenmvc.service;

import com.apt.truyenmvc.entity.Chapter;

import java.util.List;

/**
 *
 * @author Huy Thang
 */
public interface ChapterService {

    /**
     * Lấy List Tất Cả Chapter Favorites Của Người Dùng
     *
     * @param uID
     *
     * @return List<Chapter>
     */
    public List<Chapter> getAllChapterFavoritesByUser(Long uID);
}
