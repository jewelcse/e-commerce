
import React, { useState, useEffect } from 'react'
import { Link } from 'react-router-dom';

import { Container, Col, Row } from 'react-bootstrap'
import './Product.css'


const Product = (props) => {
    const MAX_LENGTH = 20;
    return (
        <React.Fragment>
            <Col xs={12} md={4} xl={3} lg={3} >
                <div className="product">
                    <Link to={`/product/${props.data.id}`}>
                        <div className="product-img">
                            <img src="http://placehold.it/600x650" />
                        </div>

                        <div className="product-title">
                            <h3>
                                <small>{props.data.productTitle.substring(0, MAX_LENGTH)},...</small>
                            </h3>
                            <p className="product-text price">&#2547;{props.data.productPrice}</p>
                        </div>
                    </Link>
                </div>
            </Col>
            {/* <Col xs={12} md={4} xl={4} lg={3} >
                <div>
                    <h1>{props.data.productTitle}</h1>
                    <p>{props.data.category.categoryTitle}</p>
                    <p>{props.data.productDescription}</p>
                    <p>{props.data.productPrice}</p>
                    <p>{props.data.productImagePath}</p>
                </div>
            </Col> */}
        </React.Fragment>
    )
}


export default Product;