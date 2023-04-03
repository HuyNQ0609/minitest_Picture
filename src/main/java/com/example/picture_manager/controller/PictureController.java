package com.example.picture_manager.controller;

import com.example.picture_manager.model.Category;
import com.example.picture_manager.model.Picture;
import com.example.picture_manager.service.category.ICategoryService;
import com.example.picture_manager.service.picture.IPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class PictureController {
    @Autowired
    private IPictureService pictureService;

    @Autowired
    private ICategoryService categoryService;

    @ModelAttribute("categories")
    public Iterable<Category> categories(){
        return categoryService.findAll();
    }

    @GetMapping("/create-picture")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/picture/create");
        modelAndView.addObject("picture", new Picture());
        return modelAndView;
    }

    @PostMapping("/create-picture")
    public ModelAndView savePicture(@ModelAttribute("pictures") Picture picture) {
        pictureService.save(picture);
        ModelAndView modelAndView = new ModelAndView("/picture/create");
        modelAndView.addObject("picture", new Picture());
        modelAndView.addObject("message", "New picture created successfully");
        return modelAndView;
    }

    @GetMapping("pictures")
    public ModelAndView getAll() {
        ModelAndView modelAndView = new ModelAndView("/picture/list");
        modelAndView.addObject("pictures", pictureService.findAll());
        return modelAndView;
    }

    @GetMapping("/edit-picture/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Picture> picture = pictureService.findById(id);
        ModelAndView modelAndView;
        if (picture.isPresent()) {
            modelAndView = new ModelAndView("/picture/edit");
            modelAndView.addObject("picture", picture.get());
        } else {
            modelAndView = new ModelAndView("/error.404");
        }
        return modelAndView;
    }

    @PostMapping("/edit-picture")
    public ModelAndView updatePicture(@ModelAttribute("pictures") Picture picture) {
        pictureService.save(picture);
        ModelAndView modelAndView = new ModelAndView("/picture/edit");
        modelAndView.addObject("picture", picture);
        modelAndView.addObject("message", "Picture updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-picture/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Optional<Picture> picture = pictureService.findById(id);
        ModelAndView modelAndView;
        if (picture.isPresent()) {
            modelAndView = new ModelAndView("/picture/delete");
            modelAndView.addObject("picture", picture.get());
        } else {
            modelAndView = new ModelAndView("/error.404");
        }
        return modelAndView;
    }

    @PostMapping("/delete-picture")
    public String deletePicture(@ModelAttribute("pictures") Picture picture) {
        pictureService.remove(picture.getId());
        return "redirect:pictures";
    }

    @GetMapping("search")
    public ModelAndView getSearchByName(String name) {
        ModelAndView modelAndView = new ModelAndView("/picture/list");
        modelAndView.addObject("pictures", pictureService.findByNameContaining(name));
        return modelAndView;
    }

    @GetMapping("searchCategory")
    public ModelAndView searchByCategory(Category category) {
        ModelAndView modelAndView = new ModelAndView("/picture/list");
        modelAndView.addObject("pictures", pictureService.findByCategory(category));
        return modelAndView;
    }
}
