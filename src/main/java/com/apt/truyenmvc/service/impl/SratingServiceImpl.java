package com.apt.truyenmvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apt.truyenmvc.repository.SratingRepository;
import com.apt.truyenmvc.service.SratingService;

/**
 *
 * @author Huy Thang
 */
@Service
public class SratingServiceImpl implements SratingService{

	@Autowired
	private SratingRepository sratingRepository;
}
