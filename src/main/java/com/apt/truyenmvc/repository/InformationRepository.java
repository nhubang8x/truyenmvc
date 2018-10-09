package com.apt.truyenmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apt.truyenmvc.entity.Information;

/**
 *
 * @author Huy Thang
 */
@Repository
public interface InformationRepository extends JpaRepository<Information, Integer>{
	
	public Information findFirstByOrderByInfoIDDesc();
}
