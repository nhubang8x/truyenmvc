package com.apt.truyenmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apt.truyenmvc.entity.Role;

/**
 *
 * @author Huy Thang
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}