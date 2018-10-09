package com.apt.truyenmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apt.truyenmvc.entity.User;
import com.apt.truyenmvc.entity.inf.TopConverter;
import com.apt.truyenmvc.repository.UserRepository;
import com.apt.truyenmvc.service.UserService;
import com.apt.truyenmvc.utils.ConstantsUtils;

/**
 *
 * @author Huy Thang
 */

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User getUserByUserName(String username) {
		return userRepository.findByUName(username);
	}

	@SuppressWarnings("deprecation")
	@Override
	public Page<User> getPageUser() {
		return userRepository.findAll(new PageRequest(0, 1));
	}

	@Override
	public List<TopConverter> getTopConverter(int page, int size) {
		Pageable pageable = PageRequest.of(page - 1, size);
		Page<TopConverter> result = userRepository.getTopConverter(ConstantsUtils.STATUS_ACTIVED, ConstantsUtils.STATUS_ACTIVED, pageable);
		return result.getContent();
	}

}
