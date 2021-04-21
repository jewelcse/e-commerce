import axios from 'axios'

export const productService = axios.create({
    baseURL: 'http://localhost:9090/ecom/product-service/api/'
});

export const categoryService = axios.create({
    baseURL: 'http://localhost:9090/ecom/category-service/'
});
