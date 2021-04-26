
import { productService } from '../../axios'
import * as actionTypes from './productsType'


export const productsFetchRequest = () => {
    return {
        type: actionTypes.PRODUCTS_FETCH_REQUEST
    }
}

export const productsFetchSuccess = products => {
    return {
        type: actionTypes.PRODUCTS_FETCH_SUCCESS,
        payLoad: products
    }
}

export const productsFetchError = errorMsg => {
    return {
        type: actionTypes.PRODUCTS_FETCH_ERROR,
        payLoad: errorMsg
    }

}

export const fetchProducts = () => {
    return (dispatch) => {
        dispatch(productsFetchRequest)
        productService.get("get/products")
            .then(response => {
                const products = response.data
                dispatch(productsFetchSuccess(products))
            }).catch(error => {
                const errorMsg = error.message
                dispatch(productsFetchError(errorMsg))
            })
    }
}

