package com.apt.truyenmvc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apt.truyenmvc.entity.Category;

/**
 *
 * @author Huy Thang
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

	public List<Category> findByCStatus(Integer cStatus);
	
}
