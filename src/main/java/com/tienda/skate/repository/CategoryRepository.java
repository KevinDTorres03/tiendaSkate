package com.tienda.skate.repository;

import com.tienda.skate.model.Category;
import com.tienda.skate.repository.interfaces.CategoryRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepository {

    @Autowired
    private CategoryRepositoryInterface categoryRepositoryInterface;

    public List<Category> getAll(){
        return (List<Category>) categoryRepositoryInterface.findAll();
    }
    public Optional<Category> getCategory(int id){
        return categoryRepositoryInterface.findById(id);
    }
    public Category save(Category category){
        return categoryRepositoryInterface.save(category);
    }
    public void delete(Category category){
        categoryRepositoryInterface.delete(category);
    }
}
