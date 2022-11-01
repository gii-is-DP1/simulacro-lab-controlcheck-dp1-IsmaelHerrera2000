package org.springframework.samples.petclinic.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ProductService {
	 ProductRepository repo;
	    @Autowired
	    public ProductService(ProductRepository repo){
	        this.repo=repo;
	    }
	    
	//Ejercicio 5
    public List<Product> getAllProducts(){
        return repo.findAll();
    }
    //Ejercicio2
    public List<ProductType> findAllProductTypes(){
        return repo.findAllProductTypes();
    }
    //Ejercicio6
    public ProductType getProductType(String typeName) {
        return repo.getProductType(typeName);
    }
    
    
    public List<Product> getProductsCheaperThan(double price) {
        return repo.findByLessThan(price);
    }

    public Product save(Product p){
        return repo.save(p);       
    }

    
}
