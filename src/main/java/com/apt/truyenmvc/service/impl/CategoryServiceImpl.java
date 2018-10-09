package com.apt.truyenmvc.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apt.truyenmvc.entity.Category;
import com.apt.truyenmvc.repository.CategoryRepository;
import com.apt.truyenmvc.service.CategoryService;
import com.apt.truyenmvc.utils.ConstantsUtils;

/**
 *
 * @author Huy Thang
 */
@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<Category> getCategoryMenu() {
		return categoryRepository.findByCStatus(ConstantsUtils.STATUS_ACTIVED);
	}

	@Override
	public Optional<Category> getCategoryByID(Integer cID) {
		return categoryRepository.findById(cID);
	}

}
