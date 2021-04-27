
import React, { useState, useEffect } from 'react'
import { connect } from 'react-redux'

import { Button } from 'react-bootstrap';
import { Container, Col, Row } from 'react-bootstrap'

import { productService } from '../../axios'
import Product from '../product/Product'
import Layout from '../layout/Layout'

import loader from '../../img/loader.gif'

import { useDispatch } from 'react-redux'

import * as productActions from '../../redux/products/productsAction'
import * as shoppingActions from '../../redux/shopping/shoppingActions'



const ProductsItemList = ({ loading, products, error }) => {


    const dispatch = useDispatch();

    console.log(products)
    console.log("Before useeffect")

    const fetchAllProducts = async () => {
        const response = await productService.get("get/products").catch(err => {
            console.log(err);
        })
        dispatch(productActions.productsFetchSuccess(response.data))
        dispatch(shoppingActions.setProducts(response.data))

        console.log("fetchAllProducts", response.data)
    }

    useEffect(() => {

        console.log("Within useeffect")
        //fetchProducts(); // get data from redux actions
        fetchAllProducts(); // get data using react axios


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
        products: state.products.products,
        loading: state.products.loading,
        error: state.products.error
    }
}

// const mapDispatchToProps = (dispatch) => {
//     return {
//         fetchProducts: () => {
//             dispatch(fetchProducts())
//         }
//     }
// }

// export default connect(
//     mapStateToProps,
//     mapDispatchToProps
// )(ProductListFromRedux);




export default connect(
    mapStateToProps
)(ProductsItemList);