package com.apt.truyenmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apt.truyenmvc.entity.Ufavorites;

/**
 *
 * @author Huy Thang
 */
@Repository
public interface UfavoritesRepository extends JpaRepository<Ufavorites, Long>{

}
