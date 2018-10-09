package com.apt.truyenmvc.repository;

import com.apt.truyenmvc.utils.ConstansQueryUtils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.apt.truyenmvc.entity.Chapter;

import java.util.List;

/**
 *
 * @author Huy Thang
 */
@Repository
public interface ChapterRepository extends JpaRepository<Chapter, Long> {

    @Query(value = ConstansQueryUtils.LIST_ALL_FAVORITES_CHAPTER,
            nativeQuery = true)
    public List<Chapter> getAllFavoritesByUser(@Param("uID") Long uID,@Param("ufStatus") Integer ufStatus
            ,@Param("chStatus") Integer chStatus,@Param("sStatus") Integer sStatus);
}
