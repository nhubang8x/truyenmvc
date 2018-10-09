package com.apt.truyenmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apt.truyenmvc.entity.Card;


/**
 *
 * @author Huy Thang
 */

@Repository
public interface CardRepository extends JpaRepository<Card, Long>{

}
