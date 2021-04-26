
import React, { useState, useEffect, useReducer } from 'react'

import { Button } from 'react-bootstrap';
import { Container, Col, Row } from 'react-bootstrap'


import { productService } from '../../axios'
import Product from '../product/Product'
import Layout from '../layout/Layout'

import loader from '../../img/loader.gif'


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
            productService.get("get/products").then(res => {
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
        return <div style={{ width: '100%', height: '100%', textAlign: 'center' }}><img src={loader} /></div>
    }

    const productList = state.products.map((product) => <Product data={product} id={product.id} key={product.id} />
    )

    return (
        <React.Fragment>
            <Row>
                {productList}
            </Row>

        </React.Fragment>
    );

}


export default ProductList;