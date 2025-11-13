package com.bitsnbytes.productlist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepository<Category> extends JpaRepository<Category,Long> {
}
