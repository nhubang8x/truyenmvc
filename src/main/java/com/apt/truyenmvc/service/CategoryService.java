package com.apt.truyenmvc.service;

import java.util.List;
import java.util.Optional;

import com.apt.truyenmvc.entity.Category;

/**
 *
 * @author Huy Thang
 */
public interface CategoryService {

	public List<Category> getCategoryMenu();

	public Optional<Category> getCategoryByID(Integer cID);
}
