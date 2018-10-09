package com.apt.truyenmvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apt.truyenmvc.repository.ChdealRepository;
import com.apt.truyenmvc.service.ChdealService;

/**
 *
 * @author Huy Thang
 */
@Service
public class ChdealServiceImpl implements ChdealService{

	@Autowired
	private ChdealRepository chdealRepository;

}
