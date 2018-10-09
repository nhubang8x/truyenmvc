package com.apt.truyenmvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apt.truyenmvc.repository.RoleRepository;
import com.apt.truyenmvc.service.RoleService;

/**
 *
 * @author Huy Thang
 */
@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;

}
