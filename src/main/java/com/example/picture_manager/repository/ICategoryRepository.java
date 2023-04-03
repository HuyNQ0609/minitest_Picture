package com.example.picture_manager.repository;

import com.example.picture_manager.model.Category;
import org.springframework.data.repository.PagingAndSortingRepository;
public interface ICategoryRepository extends PagingAndSortingRepository<Category, Long> {

}
