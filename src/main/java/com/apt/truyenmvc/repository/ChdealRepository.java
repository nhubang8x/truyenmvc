package com.apt.truyenmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apt.truyenmvc.entity.Chdeal;

/**
 *
 * @author Huy Thang
 */
@Repository
public interface ChdealRepository extends JpaRepository<Chdeal, Long> {

}
