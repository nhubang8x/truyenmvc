package com.apt.truyenmvc.repository;

import com.apt.truyenmvc.entity.Story;
import com.apt.truyenmvc.entity.inf.NewStory;
import com.apt.truyenmvc.entity.inf.TopStory;
import com.apt.truyenmvc.utils.ConstansQueryUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author Huy Thang
 */
@Repository
public interface StoryRepository extends JpaRepository<Story, Long> {

    Page<Story> findBySStatusIn(List<Integer> listStatus, Pageable pageable);

    List<Story> findTop10BySStatus(Integer sStatus);

    @Query(value = ConstansQueryUtils.STORY_NEW_UPDATE,
            countQuery = ConstansQueryUtils.COUNT_STORY_NEW_UPDATE,
            nativeQuery = true)
    Page<NewStory> getStoryNew(@Param("chStatus") Integer chStatus, @Param("sStatus") List<Integer> listStatus,
                               Pageable pageable);

    @Query(value = ConstansQueryUtils.STORY_NEW_UPDATE_BY_CATEGORY,
            countQuery = ConstansQueryUtils.COUNT_STORY_NEW_UPDATE_BY_CATEGORY,
            nativeQuery = true)
    Page<NewStory> getStoryNewByCategory(@Param("chStatus") Integer chStatus, @Param("cID") Integer cID,
                                         @Param("sStatus") List<Integer> listStatus, Pageable pageable);

    @Query(value = ConstansQueryUtils.STORY_TOP_VIEW,
            countQuery = ConstansQueryUtils.COUNT_STORY_TOP_VIEW,
            nativeQuery = true)
    Page<TopStory> getTopStory(@Param("sStatus") List<Integer> listStatus, @Param("startDate") Date startDate,
                               @Param("endDate") Date endDate, Pageable pageable);

    @Query(value = ConstansQueryUtils.STORY_VIP_TOP_VIEW,
            countQuery = ConstansQueryUtils.COUNT_STORY_VIP_TOP_VIEW,
            nativeQuery = true)
    Page<TopStory> getTopStoryVip(@Param("startDate") Date startDate,
                                  @Param("endDate") Date endDate, @Param("sDealStatus") Integer sDealStatus,
                                  @Param("sStatus") List<Integer> listStatus, Pageable pageable);

    /**
     * Lấy Danh sách Truyện Hoàn Thành
     *
     * @param chStatus
     * @param sStatus
     * @param pageable
     *
     * @return Page<NewStory>
     */
    @Query(value = ConstansQueryUtils.STORY_COMPLETE,
            countQuery = ConstansQueryUtils.COUNT_STORY_COMPLETE,
            nativeQuery = true)
    Page<NewStory> getPageStoryComplete(@Param("chStatus") Integer chStatus, @Param("sStatus") Integer sStatus,
                                        Pageable pageable);

    /**
     * Lấy Danh sách Truyện Hoàn Thành
     *
     * @param chStatus
     * @param pageable
     * @param listStatus
     *
     * @return Page<NewStory>
     */
    @Query(value = ConstansQueryUtils.VIP_STORY_NEW_UPDATE,
            countQuery = ConstansQueryUtils.COUNT_VIP_STORY_NEW_UPDATE,
            nativeQuery = true)
    Page<NewStory> getVipStoryNew(@Param("chStatus") Integer chStatus, @Param("sStatus") List<Integer> listStatus,
                                  @Param("sDealStatus") Integer sDealStatus, Pageable pageable);

    /**
     * Lấy Top View Truyện Hoàn Thành Trong Tháng
     *
     * @param sStatus
     * @param startDate
     * @param endDate
     * @param pageable
     *
     * @return Page<Story>
     */
    @Query(value = ConstansQueryUtils.COMPLETE_STORY_TOP_VIEW_SWAPPER,
            countQuery = ConstansQueryUtils.COUNT_COMPLETE_STORY_TOP_VIEW_SWAPPER,
            nativeQuery = true)
    Page<Story> getCompleteStoryTopView(@Param("sStatus") Integer sStatus, @Param("startDate") Date startDate,
                                        @Param("endDate") Date endDate, Pageable pageable);

}
