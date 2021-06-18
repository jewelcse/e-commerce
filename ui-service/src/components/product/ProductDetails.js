import React, { useState, useEffect } from 'react'
import { useParams } from 'react-router-dom'

import { productService } from '../../axios'
import { connect } from 'react-redux'
import { addToCart } from '../../redux/shopping/shoppingActions'

import { Container, Col, Row, Button } from 'react-bootstrap'
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faHeart } from "@fortawesome/free-solid-svg-icons";
import './ProductDetails.css'
import loader from '../../img/loader.gif'
import Loader from '../loader/Loader'
const ProductDetails = ({ item, addToCart }) => {

    const [productDetails, setProductDetails] = useState({
        id: "",
        productTitle: "",
        productCategory: {},
        productDescription: "",
        productPrice: "",
        productImagePath: ""
    })
    
    const [error, setError] = useState(null)

    const { id } = useParams();


    useEffect(() => {

        console.log("[use effect] product details")

        async function fetchProduct() {

            productService.get(`get/product?productId=${id}`)
                .then(res => {
                    console.log(res.data)
                    setProductDetails({
                        id: res.data.id,
                        productTitle: res.data.productTitle,
                        productCategory: res.data.category,
                        productDescription: res.data.productDescription,
                        productPrice: res.data.productPrice,
                        productImagePath: res.data.productImagePath
                    })
                    
                    
                })
                .catch(error => { setError("Does't exit this article") })
        }

        fetchProduct();

    }, []);

   
    return (
        <React.Fragment>

            <Row>
                <p>{productDetails.productCategory ? productDetails.productCategory.parentCategory.grandParentCategory.grandParentCategoryTitle : "not set" }->
                    {productDetails.productCategory ? productDetails.productCategory.parentCategory.parentCategoryTitle : "not set" }
                    ->{productDetails.productCategory ? productDetails.productCategory.categoryTitle : "not set" }</p>
            </Row>
            <Row>
                <Col xs={12} md={6} xl={6} lg={6}>
                    <div className="product-img">
                        <img src="http://placehold.it/400x400" />
                        <ul className="preview-thumbnail nav nav-tabs">
                            <li className="active"><a data-target="#pic-1" data-toggle="tab" aria-expanded="true"><img src="http://placekitten.com/200/126" /></a></li>
                            <li className=""><a data-target="#pic-2" data-toggle="tab" aria-expanded="false"><img src="http://placekitten.com/200/126" /></a></li>
                            <li className=""><a data-target="#pic-3" data-toggle="tab" aria-expanded="false"><img src="http://placekitten.com/200/126" /></a></li>
                            <li className=""><a data-target="#pic-4" data-toggle="tab" aria-expanded="false"><img src="http://placekitten.com/200/126" /></a></li>
                            <li><a data-target="#pic-5" data-toggle="tab"><img src="http://placekitten.com/200/126" /></a></li>
                        </ul>
                    </div>
                </Col>
                <Col xs={12} md={6} xl={6} lg={6}>
                    <h3 className="product-title">{productDetails.productTitle ? productDetails.productTitle : "Title not found"}</h3>
                    <p>{productDetails.productCategory ?  productDetails.productCategory.categoryTitle: "not set" }</p>
                    <p className="product-description">
                        {productDetails.productDescription ?productDetails.productDescription : ""}
                    </p>
                    <h3 className="product-price">Price: &#2547;<span>{productDetails.productPrice ? productDetails.productPrice:""}</span></h3>

                    <div className="action">
                        <Button className="add-to-cart-btn" onClick={() => addToCart(productDetails.id)}>Add to Cart</Button>
                        <Button className="like-btn"><FontAwesomeIcon icon={faHeart} /></Button>
                    </div>
                </Col>
            </Row>



        </React.Fragment>
    )
}

const mapDispatchToProps = dispatch => {
    return {
        addToCart: (id) => dispatch(addToCart(id))

    }
}


export default connect(null, mapDispatchToProps)(ProductDetails)