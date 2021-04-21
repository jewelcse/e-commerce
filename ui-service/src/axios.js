import axios from 'axios'

export const product = axios.create({
    baseURL: 'http://localhost:9090/ecom/product-service/api/'
});

export const grandParentCategory = axios.create({
    baseURL: 'http://localhost:9090/ecom/category-service/'
});
