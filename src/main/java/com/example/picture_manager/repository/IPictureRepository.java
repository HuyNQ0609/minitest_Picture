package com.example.picture_manager.repository;

import com.example.picture_manager.model.Category;
import com.example.picture_manager.model.Picture;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface IPictureRepository extends PagingAndSortingRepository<Picture, Long> {
    List<Picture> findByCategory(Category category);
    List<Picture> findByNameContaining(String name);
}
