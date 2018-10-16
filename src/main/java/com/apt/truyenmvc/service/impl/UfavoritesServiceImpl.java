package com.apt.truyenmvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apt.truyenmvc.repository.UfavoritesRepository;
import com.apt.truyenmvc.service.UfavoritesService;

/**
 *
 * @author Huy Thang
 */

@Service
public class UfavoritesServiceImpl implements UfavoritesService {

	@Autowired
	private UfavoritesRepository ufavoritesRepository;
}
