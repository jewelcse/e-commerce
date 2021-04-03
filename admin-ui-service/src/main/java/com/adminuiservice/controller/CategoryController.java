package com.adminuiservice.controller;

import com.adminuiservice.dto.Category;
import com.adminuiservice.dto.GrandParentCategory;
import com.adminuiservice.dto.ParentCategory;
import com.adminuiservice.service.CategoryServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;


@Controller
public class CategoryController {


    @Autowired
    private CategoryServiceImp categoryService;


    @GetMapping("/category/add")
    public String _addCategory(Model model){

        List<ParentCategory> parentCategories
                = categoryService.fetchAllParentCategories();
        List<Category> categories = categoryService.getCategories();

        model.addAttribute("parentCategories",parentCategories);
        model.addAttribute("categories",categories);

        model.addAttribute("category", new Category());
        return "category/add-category";
    }


    @PostMapping("/save/category")
    public RedirectView saveCategory(@ModelAttribute("category")
                                                         Category category){

        System.out.println("category controller "+category);
        ResponseEntity<Category> response = categoryService.save(category);
        System.out.println("Saving category => "+response);
        return new RedirectView("/category/add");
    }

    @GetMapping("/category/remove/{id}")
    public RedirectView removeCategory(@PathVariable("id") int id){


        System.out.println("delete category id " + id);
        categoryService.removeCategory(id);

        return new RedirectView("/categories");
    }

    @GetMapping("/category/edit/{id}")
    public String editCategory(@PathVariable("id") Long id, Model model){

        Category category = categoryService.getCategoryById(id);


        List<ParentCategory> parentCategories
                =categoryService.fetchAllParentCategories();

        model.addAttribute("parentCategories",parentCategories);
        model.addAttribute("category", category);

        return "category/edit-category";
    }

    @PostMapping("/update/category")
    public RedirectView updateCategory(@ModelAttribute("category")
                                               Category category){


        System.out.println("Updating  category "+ category);

        ResponseEntity<Category> response = categoryService.update(category);

        System.out.println("Updating category => "+response);

        return new RedirectView("/category/add");

    }


}
