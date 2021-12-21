package org.springframework.samples.petclinic.product;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;



public interface ProductRepository extends CrudRepository<Product, Integer> {
    
	List<Product> findAll();
	
	@Query("SELECT productType FROM ProductType productType")
    public List<ProductType> findAllProductTypes();
    
	Optional<Product> findById(int id);
    
    @Query("SELECT product FROM Product product WHERE product.name =:name")
    public Product findByName(@Param("name") String name);
    
    @Query("SELECT productType FROM ProductType productType WHERE productType.name =:name")
    public ProductType findProductTypeByName(@Param("name") String name);
    
    Product save(Product p);
    
    @Query("SELECT product FROM Product product WHERE product.price < :price")
    public List<Product> findByPriceLessThan(@Param("price") double price);
}
