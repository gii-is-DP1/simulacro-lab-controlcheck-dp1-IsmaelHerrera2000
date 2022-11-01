package org.springframework.samples.petclinic.product;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;



public interface ProductRepository extends CrudRepository<Product, Integer>{
	
    //Ejercicio 2
    @Query("SELECT producttype FROM ProductType producttype")
    List<ProductType> findAllProductTypes();
  //Ejercicio5
    List<Product> findAll();
  //Ejercicio 6
    @Query("SELECT p FROM ProductType p WHERE p.name =?1")
    ProductType getProductType(String name);
    //Ejercicio8
    @Query("SELECT p FROM Product p WHERE p.price < ?1")
    List<Product> findByLessThan(Double price);
    
    Optional<Product> findById(int id);
    Product findByName(String name);
    Product save(Product p);
}
