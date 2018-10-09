package com.apt.truyenmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apt.truyenmvc.entity.Urole;
import com.apt.truyenmvc.entity.User;
import com.apt.truyenmvc.repository.UroleRepository;
import com.apt.truyenmvc.service.UroleService;

/**
 *
 * @author Huy Thang
 */
@Service
@Transactional
public class UroleServiceImpl implements UroleService {

	@Autowired
	private UroleRepository uroleRepository;

	@Override
	public List<Urole> getListRole(User user) {
		return uroleRepository.findByuser(user);
	}

}
