package com.demo.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.Category;
import com.demo.repository.CategoryRepo;
import com.demo.service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	private CategoryRepo categoryRepo;



	public Category createCategory(Category category) {
		Category savedCategory=this.categoryRepo.save(category);
		return savedCategory;
	}


	public Category getCategoryById(Integer id) {
		Category gcategory=this.categoryRepo.findById(id).get();
		return gcategory;
	}

	
	@Override
	public List<Category> getAllCategory() {
		List<Category> categories=this.categoryRepo.findAll();
		return categories;
	}


	@Override
	public void deleteCategory(Integer id) {
		this.categoryRepo.deleteById(id);

	}


	@Override
	public Optional<Category> updateCategory(Category category, Integer id) {
		Optional<Category> optionalCategory= this.categoryRepo.findById(id);
		Category uCategory = optionalCategory.get();
		uCategory.setCname(category.getCname());
		uCategory.setDescription(category.getDescription());
		uCategory.setProducts(category.getProducts());
		this.categoryRepo.save(uCategory);
		return optionalCategory;
	}

}
