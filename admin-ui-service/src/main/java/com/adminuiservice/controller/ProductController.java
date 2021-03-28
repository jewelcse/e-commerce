package com.adminuiservice.controller;

import com.adminuiservice.dto.Categories;
import com.adminuiservice.dto.Category;
import com.adminuiservice.dto.Product;
import com.adminuiservice.service.CategoryServiceImp;
import com.adminuiservice.service.GrandParentCategoryServiceImp;
import com.adminuiservice.service.ParentCategoryServiceImp;
import com.adminuiservice.service.ProductServiceImp;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("admin")
public class ProductController {

    @Autowired
    private ProductServiceImp productService;
    @Autowired
    private CategoryServiceImp categoryService;
    @Autowired
    private GrandParentCategoryServiceImp grandParentCategoryService;
    @Autowired
    private ParentCategoryServiceImp parentCategoryService;

    @GetMapping("/products")
    @HystrixCommand(fallbackMethod = "getFallBackProducts")
    public String getProducts(Model model){

        List<Product> products = productService.fetchAllProduct();

        System.out.println(products);
        model.addAttribute("products",products);
        return "product/product-list";
    }

    public String getFallBackProducts(Model model){
        List<Product> products = new ArrayList<>();
        model.addAttribute("products",products);
        return "product/product-list";
    }

    @GetMapping("/product/add")
    public String addProduct(Model model){

        List<Categories> categories = categoryService.getCategories();

        model.addAttribute("categories",categories);
        model.addAttribute("product", new Product());
        return "product/add-product";
    }

    @PostMapping("/product/store")
    public RedirectView save(@ModelAttribute("product") Product product){


        Category category = categoryService.getCategoryByTitle(product.getCategory().getCategoryTitle());

        product.setCategory(category);

        System.out.println("admin controller" + product);
        ResponseEntity<Product> response = productService.storeProduct(product);

        System.out.println("Saving product => "+response);

        return new RedirectView("/admin/products");
    }


    @GetMapping("/product/remove/{id}")
    public RedirectView remove(@PathVariable("id") String id){

        ResponseEntity<Product> response = productService.removeProduct(id);
        System.out.println("Deleting product where ID "+ id +" "+" => "+response);

        return new RedirectView("/admin/products");
    }

    @GetMapping("/product/edit/{id}")
    public String updateProduct(Model model,@PathVariable("id") String productId){

        Product product = productService.getSingleProduct(productId);

        List<Categories> categories = categoryService.getCategories();

        model.addAttribute("categories",categories);
        model.addAttribute("product",product);


        System.out.println("fetching.."+product);
        return "product/edit-product";
    }


    @PostMapping("/product/update/{id}")
    public RedirectView update(@ModelAttribute("product") Product product){

        System.out.println("updating"+product);

        productService.updateProduct(product);
        System.out.println("Updating product => ");

        return new RedirectView("/admin/products");
    }



}
