package com.tienda.skate.services;

import com.tienda.skate.model.Category;
import com.tienda.skate.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> listAll() {
        return categoryRepository.getAll();
    }

    public Optional<Category> get(int id) {
        return categoryRepository.getCategory(id);
    }

    public CategoryService() {
    }

    public Category save(Category category) {
        if (category.getId() == null) {
            return categoryRepository.save(category);
        } else {
            Optional<Category> c = categoryRepository.getCategory(category.getId());
            if (c.isPresent()) {
                return c.get();
            } else {
                return categoryRepository.save(category);
            }
        }
    }

    public Category update(Category category) {
        if (category.getId() != null) {
            Optional<Category> ct = categoryRepository.getCategory(category.getId());
            if (ct.isPresent()) {
                if (category.getName() != null) {
                    ct.get().setName(category.getName());
                }
                if (category.getDescription() != null) {
                    ct.get().setDescription(category.getDescription());
                }
                if (category.getSkates() != null) {
                    ct.get().setSkates(category.getSkates());
                }
                categoryRepository.save(ct.get());
                return ct.get();
            } else {
                return category;
            }
        } else {
            return category;
        }
    }

    public boolean delete(int id) {
        boolean marca = false;
        Optional<Category> ctr = categoryRepository.getCategory(id);
        if (ctr.isPresent()) {
            categoryRepository.delete(ctr.get());
            marca = true;
        }
        return marca;
    }
}
