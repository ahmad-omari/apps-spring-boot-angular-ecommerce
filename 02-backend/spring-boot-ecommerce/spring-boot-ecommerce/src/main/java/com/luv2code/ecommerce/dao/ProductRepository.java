package com.luv2code.ecommerce.dao;

import com.luv2code.ecommerce.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin("http://localhost:4200")
public interface ProductRepository extends JpaRepository<Product, Long> {

    // Behind the scenes, Spring will execute a query similar to this
    // SELECT * FROM product where category_id=?
    Page<Product> findByCategoryId(@RequestParam("id") Long id, Pageable pageable);

    // SELECT * FROM Product p WHERE p.name LIKE CONCAT('%', :name ,'%')
    Page<Product> findByNameContaining(@RequestParam("name") String name, Pageable pageable);
}
