package com.apt.truyenmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apt.truyenmvc.entity.Seditor;
import com.apt.truyenmvc.entity.SeditorPK;

/**
 *
 * @author Huy Thang
 */
@Repository
public interface SeditorRepository extends JpaRepository<Seditor, SeditorPK>{

}
