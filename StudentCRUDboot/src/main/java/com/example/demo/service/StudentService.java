package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.domain.stud;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {
    
    @Autowired
    private StudentRepository repo;
    
    public List<stud> listAll() {
        return repo.findAll();
    }
     
    public void save(stud std) {
        repo.save(std);
    }
     
    public stud get(long id) {
        return repo.findById(id).get();
    }
     
    public void delete(long id) {
        repo.deleteById(id);
    }

}

