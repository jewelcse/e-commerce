package com.adminuiservice.common;

public interface RequestURLS {

    String BASE_URL_FOR_CATEGORY_SERVICE = "http://localhost:8100";
    String BASE_URL_FOR_PRODUCT_SERVICE = "http://localhost:8200";

    String GRAND_PARENT_CATEGORY_STORE_URL = BASE_URL_FOR_CATEGORY_SERVICE+"/grand-parent-category/create";
    String PARENT_CATEGORY_STORE_URL = BASE_URL_FOR_CATEGORY_SERVICE+"/parent-category/create";
    String CATEGORY_STORE_URL = BASE_URL_FOR_CATEGORY_SERVICE+"/category/create";

    String FETCH_GRAND_PARENT_CATEGORIES_URL = BASE_URL_FOR_CATEGORY_SERVICE+"/get/grand-parent-categories";
    String FETCH_PARENT_CATEGORIES_URL = BASE_URL_FOR_CATEGORY_SERVICE+"/get/parent-categories";
    String FETCH_CATEGORIES_URL = BASE_URL_FOR_CATEGORY_SERVICE+"/get/categories";
    String FETCH_CATEGORY_BY_TITLE_URL = BASE_URL_FOR_CATEGORY_SERVICE+"/get/categoryByTitle?categoryTitle=";

    String FETCH_PRODUCTS_URL = BASE_URL_FOR_PRODUCT_SERVICE+"/api/get/products";
    String FETCH_SINGLE_PRODUCT_URL = BASE_URL_FOR_PRODUCT_SERVICE+"/api/get/product?productId=";
    String PRODUCT_STORE_URL = BASE_URL_FOR_PRODUCT_SERVICE+"/api/product/create";
    String PRODUCT_REMOVE_URL = BASE_URL_FOR_PRODUCT_SERVICE+"/api/remove/product?id=";
    String PRODUCT_UPDATE_URL = BASE_URL_FOR_PRODUCT_SERVICE+"/api/update/product/{id}";
}
