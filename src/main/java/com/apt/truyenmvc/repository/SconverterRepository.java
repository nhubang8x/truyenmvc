package com.apt.truyenmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apt.truyenmvc.entity.Sconverter;
import com.apt.truyenmvc.entity.SconverterPK;

/**
 *
 * @author Huy Thang
 */
@Repository
public interface SconverterRepository extends JpaRepository<Sconverter, SconverterPK>{

}
