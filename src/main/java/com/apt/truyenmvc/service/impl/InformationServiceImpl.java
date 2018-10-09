package com.apt.truyenmvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apt.truyenmvc.entity.Information;
import com.apt.truyenmvc.repository.InformationRepository;
import com.apt.truyenmvc.service.InformationService;

/**
 *
 * @author Huy Thang
 */
@Service
public class InformationServiceImpl implements InformationService {

	@Autowired
	private InformationRepository informationRepository;

	@Override
	public Information getWebInfomation() {
		return informationRepository.findFirstByOrderByInfoIDDesc();
	}

}
