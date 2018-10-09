package com.apt.truyenmvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apt.truyenmvc.repository.CardRepository;
import com.apt.truyenmvc.service.CardService;

/**
 *
 * @author Huy Thang
 */
@Service
public class CardServiceImpl implements CardService {
	
	@Autowired
	private CardRepository cardRepository;

}
