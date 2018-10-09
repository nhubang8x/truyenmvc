package com.apt.truyenmvc.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.apt.truyenmvc.entity.User;
import com.apt.truyenmvc.entity.inf.TopConverter;

/**
 *
 * @author Huy Thang
 */
public interface UserService {

	public User getUserByUserName(String username);

	public Page<User> getPageUser();

	/**
	 * Lấy List Truyện Top View Trong Tháng
	 * 
	 * @param page
	 * @param size
	 * 
	 * @return List<TopConverter>
	 */
	public List<TopConverter> getTopConverter(int page, int size);
}
