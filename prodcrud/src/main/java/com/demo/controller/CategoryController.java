package com.demo.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.Category;
import com.demo.service.CategoryService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/categories")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
    //POST -create category
	@PostMapping
	public ResponseEntity<Category> CreateCategory(@RequestBody Category category){
		System.out.println(category);
		Category createdcategory=this.categoryService.createCategory(category);
		return new ResponseEntity<>(createdcategory,HttpStatus.CREATED);
	}
	
	//PUT -update category
	@PutMapping("/{di}")
	public ResponseEntity<Optional<Category>> UpdateCategory(@RequestBody Category category,@PathVariable("di") Integer cid ){
		Optional<Category> updatedCategory=this.categoryService.updateCategory(category, cid);
		return ResponseEntity.ok(updatedCategory);
	}
	
	
	//DELETE -delete category
	 @DeleteMapping("/{di}")
		public ResponseEntity<?>deleteCategory(@PathVariable("di") Integer id){
		     this.categoryService.deleteCategory(id);
			return new ResponseEntity((Map.of("message","category deleted successfully")),HttpStatus.OK);
		}
	 
	 
	//GET -get all category
	 @GetMapping
	 public ResponseEntity<List<Category>> getAllCategory(@RequestParam("page") int page){
		 System.out.println(this.categoryService.getAllCategory());
		 return ResponseEntity.ok(this.categoryService.getAllCategory());
	 }
	
	 
	 
		//GET -get category by id
		 @GetMapping("/{di}")
		 public ResponseEntity<Category> getSingleCategory(@PathVariable("di") Integer cid){
			 return ResponseEntity.ok(this.categoryService.getCategoryById(cid));
		 }
		
}
