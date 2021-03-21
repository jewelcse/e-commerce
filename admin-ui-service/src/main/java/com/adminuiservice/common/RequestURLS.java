package com.adminuiservice.common;

public interface RequestURLS {

    String BASE_URL = "http://localhost:8100";

    String GRAND_PARENT_CATEGORY_STORE_URL = BASE_URL+"/grand-parent-category/create";
    String PARENT_CATEGORY_STORE_URL = BASE_URL+"/parent-category/create";
    String CATEGORY_STORE_URL = BASE_URL+"/category/create";

    String FETCH_GRAND_PARENT_CATEGORIES_URL = BASE_URL+"/get/grand-parent-categories";
    String FETCH_PARENT_CATEGORIES_URL = BASE_URL+"/get/parent-categories";
    String FETCH_CATEGORIES_URL = BASE_URL+"/get/categories";
}
