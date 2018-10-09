package com.apt.truyenmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apt.truyenmvc.entity.Comment;

/**
 *
 * @author Huy Thang
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

}
