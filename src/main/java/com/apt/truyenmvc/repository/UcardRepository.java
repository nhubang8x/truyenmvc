package com.apt.truyenmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apt.truyenmvc.entity.Ucard;
import com.apt.truyenmvc.entity.UcardPK;

/**
 *
 * @author Huy Thang
 */
@Repository
public interface UcardRepository extends JpaRepository<Ucard, UcardPK>{

}
