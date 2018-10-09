package com.apt.truyenmvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apt.truyenmvc.repository.SeditorRepository;
import com.apt.truyenmvc.service.SeditorService;

/**
 *
 * @author Huy Thang
 */
@Service
public class SeditorServiceImpl  implements SeditorService{

	@Autowired
	private SeditorRepository seditorRepository;
}
