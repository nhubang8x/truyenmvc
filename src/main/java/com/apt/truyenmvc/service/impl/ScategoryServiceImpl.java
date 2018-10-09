package com.apt.truyenmvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apt.truyenmvc.repository.ScategoryRepository;
import com.apt.truyenmvc.service.ScategoryService;

/**
 *
 * @author Huy Thang
 */
@Service
public class ScategoryServiceImpl implements ScategoryService {

	@Autowired
	private ScategoryRepository scategoryRepository;

}
