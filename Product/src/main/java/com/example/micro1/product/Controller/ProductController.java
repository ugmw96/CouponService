package com.example.micro1.product.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.micro1.product.Entity.Product;
import com.example.micro1.product.Repository.ProductRepo;
import com.example.micro1.product.dto.Coupon;

@RestController
@RequestMapping("/productapi")
public class ProductController {
	
	@Autowired 
	private ProductRepo repo;
	@Autowired
	private RestTemplate restTemplate;
	@Value("${coupenService.url}")
	private String couponServiceURL;

	@RequestMapping(value="/products", method=RequestMethod.POST)
	public Product createProduct(@RequestBody Product product) {
		
		Coupon coupon = restTemplate.getForObject(couponServiceURL+product.getCouponCode(), Coupon.class);
		product.setPrice(product.getPrice().subtract(coupon.getDiscount()));
		
		return repo.save(product);
		
	}
}
