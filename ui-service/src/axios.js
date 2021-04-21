import axios from 'axios'

const instance = axios.create({
    baseURL: 'http://localhost:9090/ecom/product-service/api/'
});


export default instance;