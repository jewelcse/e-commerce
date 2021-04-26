
import React, { useState, useEffect } from 'react'
import { connect } from 'react-redux'
import { fetchProducts } from '../../redux/products/productsAction'

import { Button } from 'react-bootstrap';
import { Container, Col, Row } from 'react-bootstrap'


import Product from '../product/Product'
import Layout from '../layout/Layout'

import loader from '../../img/loader.gif'



const ProductListFromRedux = ({ loading, productsData, fetchProducts }) => {



    console.log(productsData)
    console.log("Before useeffect")

    useEffect(() => {
        console.log("Within useeffect")

        fetchProducts();

        console.log(fetchProducts())

    }, []);



    if (loading) {
        return <div style={{ width: '100%', height: '100%', textAlign: 'center' }}><img src={loader} /></div>
    }

    const productList = productsData.map((product) =>
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
        productsData: state.products.products,
        loading: state.products.loading,
        error: state.products.error
    }
}

const mapDispatchToProps = (dispatch) => {
    return {
        fetchProducts: () => {
            dispatch(fetchProducts())
        }
    }
}

export default connect(
    mapStateToProps,
    mapDispatchToProps
)(ProductListFromRedux);