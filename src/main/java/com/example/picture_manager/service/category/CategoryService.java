package com.example.picture_manager.service.category;

import com.example.picture_manager.model.Category;
import com.example.picture_manager.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService implements  ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public void save(Category province) {
        categoryRepository.save(province);
    }

    @Override
    public void remove(Long id) {
        categoryRepository.deleteById(id);
    }
}
