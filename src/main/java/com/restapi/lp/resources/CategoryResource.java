package com.restapi.lp.resources;

import com.restapi.lp.entities.Category;
import com.restapi.lp.entities.User;
import com.restapi.lp.services.CategoryService;
import com.restapi.lp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryResource {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        List<Category> categoryList = categoryService.findAll();
        return ResponseEntity.ok().body(categoryList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(categoryService.findById(id));
    }

}
