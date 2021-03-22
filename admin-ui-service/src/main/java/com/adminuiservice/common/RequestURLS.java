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

    String FETCH_PRODUCTS_URL = BASE_URL_FOR_PRODUCT_SERVICE+"/api/get/products";
}
