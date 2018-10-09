package com.apt.truyenmvc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apt.truyenmvc.entity.Urole;
import com.apt.truyenmvc.entity.UrolePK;
import com.apt.truyenmvc.entity.User;

/**
 *
 * @author Huy Thang
 */
@Repository
public interface UroleRepository extends JpaRepository<Urole, UrolePK> {

	public List<Urole> findByuser(User user);
}
