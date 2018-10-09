package com.apt.truyenmvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apt.truyenmvc.repository.SconverterRepository;
import com.apt.truyenmvc.service.SconverterService;

/**
 *
 * @author Huy Thang
 */
@Service
public class SconverterServiceImpl  implements SconverterService{

	@Autowired
	private SconverterRepository sconverterRepository;

}
