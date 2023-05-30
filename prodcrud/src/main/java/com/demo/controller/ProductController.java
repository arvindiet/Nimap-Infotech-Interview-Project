package com.demo.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.demo.entity.Product;
import com.demo.service.ProductService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/products")
public class ProductController {
	@Autowired
	private ProductService productService;

	//POST -create product
	@PostMapping
	public ResponseEntity<Product> CreateProduct(@RequestBody Product product){
		System.out.println(product);
		Product createdcategory=this.productService.createProduct(product);
		return new ResponseEntity<>(createdcategory,HttpStatus.CREATED);
	}


	//GET -get product by id
	@GetMapping("/{di}")
	public ResponseEntity<Product> getSingleProduct(@PathVariable("di") Integer cid){
		return ResponseEntity.ok(this.productService.getProductById(cid));
	}


	// GET -get all product
	@GetMapping
	public ResponseEntity<List<Product>> getAllProduct(@RequestParam("page") int page){
		System.out.println(this.productService.getAllProduct());
		return ResponseEntity.ok(this.productService.getAllProduct());
	}

	//PUT -update product
	@PutMapping("/{di}")
	public ResponseEntity<Optional<Product>> UpdateProduct(@RequestBody Product product,@PathVariable("di") Integer id ){
		Optional<Product> updatedProduct=this.productService.updateProduct(product, id);
		return ResponseEntity.ok(updatedProduct);
	}


	//DELETE -delete product
	@DeleteMapping("/{di}")
	public ResponseEntity<?>deleteProductById(@PathVariable("di") Integer id){
		this.productService.deleteProduct(id);
		return new ResponseEntity((Map.of("message","product deleted successfully")),HttpStatus.OK);
	}

}
