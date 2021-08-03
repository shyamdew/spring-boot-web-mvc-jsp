package edu.dreamcool.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.dreamcool.springsecurity.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}