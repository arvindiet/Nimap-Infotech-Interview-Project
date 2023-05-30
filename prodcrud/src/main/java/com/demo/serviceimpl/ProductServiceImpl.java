package com.demo.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.Category;
import com.demo.entity.Product;
import com.demo.repository.ProductRepo;
import com.demo.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService{
 
	@Autowired
	private ProductRepo productRepo;
	@Override
	public Product createProduct(Product product) {
		Product savedproduct=  this.productRepo.save(product);
		return savedproduct;
	}

	@Override
	public Product getProductById(Integer id) {
		 Product product= this.productRepo.findById(id).get();
		return product;
	}

	@Override
	public List<Product> getAllProduct() {
		List<Product> products=this.productRepo.findAll();
		return products;
		
	}

	@Override
	public void deleteProduct(Integer id) {
		this.productRepo.deleteById(id);
		
	}

	@Override
	public Optional<Product> updateProduct(Product product, Integer id) {
		Optional<Product> optionalProduct= this.productRepo.findById(id);
		Product uproduct = optionalProduct.get();
		uproduct.setPname(product.getPname());
		uproduct.setPrice(product.getPrice());
		uproduct.setDescription(product.getDescription());
		this.productRepo.save(uproduct);
return optionalProduct;
	}


	

}
