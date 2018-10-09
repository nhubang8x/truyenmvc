package com.apt.truyenmvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apt.truyenmvc.repository.UcardRepository;
import com.apt.truyenmvc.service.UcardService;

/**
 *
 * @author Huy Thang
 */
@Service
public class UcardServiceImpl  implements UcardService{

	@Autowired
	private UcardRepository ucardRepository;

}
