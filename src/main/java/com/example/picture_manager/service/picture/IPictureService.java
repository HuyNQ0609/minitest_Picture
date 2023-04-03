package com.example.picture_manager.service.picture;

import com.example.picture_manager.model.Category;
import com.example.picture_manager.model.Picture;
import com.example.picture_manager.service.IGenericService;

import java.util.List;

public interface IPictureService extends IGenericService<Picture> {
    List<Picture> findByCategory(Category category);
    List<Picture> findByNameContaining(String name);
}
