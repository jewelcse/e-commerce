
import React, { useState, useEffect, useReducer } from 'react'

import { Button } from 'react-bootstrap';


import axios from '../../axios'
import Product from '../product/Product'


const initialState = {
    products: {},
    isLoading: true,
    error: '',
}
const reducer = (state, action) => {
    switch (action.type) {
        case 'FETCH_SUCCESS':
            return {
                products: action.data,
                isLoading: false,
                error: '',

            }
        case 'FETCH_ERROR':
            return {
                products: {},
                isLoading: true,
                error: 'Something went Wrong! Check your Internet Connection plz',
            }
        default:
            return state
    }
}

const ProductList = () => {

    const [state, dispatch] = useReducer(reducer, initialState)


    useEffect(() => {

        async function fetchAllProducts() {
            axios.get("get/products").then(res => {
                //console.log(res.data)
                dispatch({
                    type: 'FETCH_SUCCESS',
                    data: res.data,
                })
            }).catch(error => {
                console.log("cant find any product")
                dispatch({ type: 'FETCH_ERROR' })
            })
        }

        fetchAllProducts();


    }, []);

    console.log(state.products)
    console.log(state.error)

    if (state.isLoading) {
        return <h3>Loading.... please wait</h3>
    }

    const productList = state.products.map((product) => <Product data={product} id={product.id} key={product.id} />
    )

    return (
        <div>
            <h1>All Products <Button>Fetch</Button></h1>
            {productList}

        </div>
    );

}


export default ProductList;