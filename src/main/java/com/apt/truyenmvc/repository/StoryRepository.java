package com.apt.truyenmvc.repository;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.apt.truyenmvc.entity.Story;
import com.apt.truyenmvc.entity.inf.NewStory;
import com.apt.truyenmvc.entity.inf.TopStory;
import com.apt.truyenmvc.utils.ConstansQueryUtils;

/**
 *
 * @author Huy Thang
 */
@Repository
public interface StoryRepository extends JpaRepository<Story, Long> {

	public Page<Story> findBySStatusIn(List<Integer> listStatus, Pageable pageable);
	
	public List<Story> findTop10BySStatus(Integer sStatus);
	
	@Query(value = ConstansQueryUtils.STORY_NEW_UPDATE,
			countQuery = ConstansQueryUtils.COUNT_STORY_NEW_UPDATE,
			nativeQuery = true)
	public Page<NewStory> getStoryNew(@Param("chStatus") Integer chStatus, @Param("sStatus") List<Integer> listStatus,
			Pageable pageable);

	@Query(value = ConstansQueryUtils.STORY_NEW_UPDATE_BY_CATEGORY,
			countQuery = ConstansQueryUtils.COUNT_STORY_NEW_UPDATE_BY_CATEGORY,
			nativeQuery = true)
	public Page<NewStory> getStoryNewByCategory(@Param("chStatus") Integer chStatus, @Param("cID") Integer cID,
			@Param("sStatus") List<Integer> listStatus, Pageable pageable);

	@Query(value = ConstansQueryUtils.STORY_TOP_VIEW,
			countQuery = ConstansQueryUtils.COUNT_STORY_TOP_VIEW,
			nativeQuery = true)
	public Page<TopStory> getTopStory(@Param("sStatus") List<Integer> listStatus, @Param("startDate") Date startDate,
			@Param("endDate") Date endDate, Pageable pageable);
	
	@Query(value = ConstansQueryUtils.STORY_VIP_TOP_VIEW,
			countQuery = ConstansQueryUtils.COUNT_STORY_VIP_TOP_VIEW,
			nativeQuery = true)
	public Page<TopStory> getTopStoryVip(@Param("startDate") Date startDate,
			@Param("endDate") Date endDate,@Param("sDealStatus") Integer sDealStatus,
			@Param("sStatus") List<Integer> listStatus,Pageable pageable);
	
}
