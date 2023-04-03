package com.example.picture_manager.service.picture;

import com.example.picture_manager.model.Category;
import com.example.picture_manager.model.Picture;
import com.example.picture_manager.repository.IPictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PictureService implements IPictureService {
    @Autowired
    private IPictureRepository pictureRepository;

    @Override
    public Iterable<Picture> findAll() {
        return pictureRepository.findAll();
    }

    @Override
    public Optional<Picture> findById(Long id) {
        return pictureRepository.findById(id);
    }

    @Override
    public void save(Picture customer) {
        pictureRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
        pictureRepository.deleteById(id);
    }

    @Override
    public List<Picture> findByCategory(Category category) {
        return pictureRepository.findByCategory(category);
    }

    @Override
    public List<Picture> findByNameContaining(String name) {
        return pictureRepository.findByNameContaining(name);
    }

}
