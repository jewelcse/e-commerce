
import React, { useState, useEffect, useReducer } from 'react'

import { Button } from 'react-bootstrap';
import { Container, Col, Row } from 'react-bootstrap'
import { useDispatch } from 'react-redux'
import * as shoppingActions from '../../redux/shopping/shoppingActions'


import { productService } from '../../axios'
import Product from '../product/Product'
import Layout from '../layout/Layout'
import Loader from '../loader/Loader'

import loader from '../../img/loader.gif'

const ProductList = () => {

    const [products, setProducts] = useState([])
    const [loading, setloading] = useState(true)

    const dispatch = useDispatch();
    useEffect(() => {

        async function fetchAllProducts() {
            productService.get("get/products").then(res => {
                setProducts(res.data)
                setloading(false)
                dispatch(shoppingActions.setProducts(res.data))
            }).catch(error => {

            })
        }

        fetchAllProducts();


    }, []);



    const productList = products.map((product) =>
        <Product data={product} id={product.id} key={product.id} />
    );



    return (
        <React.Fragment>
            <Row>
                {loading ? <Loader /> : productList}
                {/* {productList} */}
            </Row>

        </React.Fragment>
    );

}


export default ProductList;