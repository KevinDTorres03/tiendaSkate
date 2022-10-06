package com.tienda.skate.repository;

import com.tienda.skate.model.Admin;
import com.tienda.skate.repository.interfaces.AdminRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AdminRepository {

    @Autowired
    private AdminRepositoryInterface adminRepositoryInterface;

    public AdminRepository() {
    }

    public List<Admin> getAll(){
        return (List<Admin>) adminRepositoryInterface.findAll();
    }
    public Optional<Admin> getAdmin(int id){
        return adminRepositoryInterface.findById(id);
    }
    public Admin save(Admin admin){
        return adminRepositoryInterface.save(admin);
    }
    public void delete(Admin admin){
        adminRepositoryInterface.delete(admin);
    }
}
