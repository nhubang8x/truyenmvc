package com.apt.truyenmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apt.truyenmvc.entity.Scategory;
import com.apt.truyenmvc.entity.ScategoryPK;

/**
 *
 * @author Huy Thang
 */
@Repository
public interface ScategoryRepository extends JpaRepository<Scategory, ScategoryPK>{

}
