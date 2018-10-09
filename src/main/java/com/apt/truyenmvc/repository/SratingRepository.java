package com.apt.truyenmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apt.truyenmvc.entity.Srating;
import com.apt.truyenmvc.entity.SratingPK;

/**
 *
 * @author Huy Thang
 */
@Repository
public interface SratingRepository extends JpaRepository<Srating, SratingPK>{

}
