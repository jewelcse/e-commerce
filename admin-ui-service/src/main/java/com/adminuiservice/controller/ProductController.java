package com.adminuiservice.controller;

import com.adminuiservice.dto.Category;
import com.adminuiservice.dto.Product;
import com.adminuiservice.service.*;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import javax.websocket.Decoder;
import javax.websocket.Encoder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.Deflater;

@Controller
@RequestMapping("admin")
public class ProductController {

    @Autowired
    private ProductServiceImp productService;
    @Autowired
    private CategoryServiceImp categoryService;


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

        List<Category> categories = categoryService.getCategories();

        model.addAttribute("categories",categories);
        model.addAttribute("product", new Product());
        return "product/add-product";
    }

    @PostMapping("/product/store")
    public RedirectView save(@ModelAttribute("product") @RequestParam("productImagePath") MultipartFile file, Product product) throws IOException {


        System.out.println("saving.."+product);

        Category category = categoryService.getCategoryByTitle(product.getCategory().getCategoryTitle());

        product.setCategory(category);
        product.setProductImagePath(compressBytes(file.getBytes()));

        System.out.println("admin controller" + product);
        ResponseEntity<Product> response = productService.storeProduct(product);

        System.out.println("Saving product => "+response);

        return new RedirectView("/admin/products");
    }

    // compress the image bytes before storing it in the database

    public static byte[] compressBytes(byte[] data) {

        Deflater deflater = new Deflater();
        deflater.setInput(data);
        deflater.finish();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        while (!deflater.finished()) {
            int count = deflater.deflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        try {
            outputStream.close();
        } catch (IOException e) {
        }
        System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
        return outputStream.toByteArray();
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

        List<Category> categories = categoryService.getCategories();

        model.addAttribute("categories",categories);
        model.addAttribute("product",product);


        System.out.println("fetching.."+product);
        return "product/edit-product";
    }


    @PostMapping("/product/update/{id}")
    public RedirectView update(@ModelAttribute("product") Product product){

        System.out.println("updating"+product);

        Category category = categoryService.getCategoryByTitle(product.getCategory().getCategoryTitle());

        product.setCategory(category);

        productService.updateProduct(product);
        System.out.println("Updating product => ");

        return new RedirectView("/admin/products");
    }

    @GetMapping("/product/view/{id}")
    public String getProduct(@PathVariable("id") String id,Model model){

        Product product = productService.getSingleProduct(id);
        System.out.println("view product"+product);
        model.addAttribute("product",product);
        return "product/view-product";
    }


}
