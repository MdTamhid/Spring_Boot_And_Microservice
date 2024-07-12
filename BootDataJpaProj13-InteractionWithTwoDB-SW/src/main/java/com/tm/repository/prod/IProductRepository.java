package com.tm.repository.prod;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tm.entity.prod.Product;

public interface IProductRepository extends JpaRepository<Product, Integer> {

}
