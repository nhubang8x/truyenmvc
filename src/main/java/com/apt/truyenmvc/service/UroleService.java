package com.apt.truyenmvc.service;

import java.util.List;

import com.apt.truyenmvc.entity.Urole;
import com.apt.truyenmvc.entity.User;

/**
 *
 * @author Huy Thang
 */
public interface UroleService {
	
	public List<Urole> getListRole(User user);
}
