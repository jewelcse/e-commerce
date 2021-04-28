
import React, { useState, useEffect } from 'react'
import { connect } from 'react-redux'

import { Button } from 'react-bootstrap';
import { Container, Col, Row } from 'react-bootstrap'

import { productService } from '../../axios'
import Product from '../product/Product'
import Layout from '../layout/Layout'

import loader from '../../img/loader.gif'

import { useDispatch } from 'react-redux'

import * as shoppingActions from '../../redux/shopping/shoppingActions'



const ProductsItemList = ({ products }) => {


    const [loading, setLoading] = useState(true);
    const [error, setError] = useState('');

    const dispatch = useDispatch();

    console.log(products)
    console.log("Before useeffect")



    useEffect(() => {

        console.log("Within useeffect")

        async function fetchAllProducts3rdMethod() {
            productService.get("get/products").then(res => {
                setLoading(false)
                setError('')
                dispatch(shoppingActions.setProducts(res.data))
            }).catch(error => {
                console.log(error);
                setLoading(true)
                setError('Check Connection')
            });

        }
        fetchAllProducts3rdMethod();
    }, []);



    if (loading) {
        return <div style={{ width: '100%', height: '100%', textAlign: 'center' }}><img src={loader} /></div>
    }

    if (error) {
        return <div style={{ width: '100%', height: '100%', textAlign: 'center' }}><img src={loader} /></div>
    }

    const productList = products.map((product) =>
        <Product data={product} id={product.id} key={product.id} />
    )

    return (
        <React.Fragment>
            <Row>
                {productList}
            </Row>

        </React.Fragment>
    );

}


const mapStateToProps = (state) => {
    return {
        products: state.shop.products
    }
}




export default connect(
    mapStateToProps
)(ProductsItemList);