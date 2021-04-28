
import React, { useState, useEffect } from 'react'
import { Link } from 'react-router-dom';

import { connect } from 'react-redux'
import { addToCart } from '../../redux/shopping/shoppingActions'

import { Container, Col, Row } from 'react-bootstrap'
import './Product.css'


const Product = ({ data, addToCart }) => {
    const MAX_LENGTH = 20;
    return (
        <React.Fragment>

            <Col xs={12} md={4} xl={3} lg={3} >
                <div className="four wide column">
                    <div class="ui link card">
                        <Link to={`/product/${data.id}`} class="image">
                            <img src="http://placehold.it/600x650" />
                        </Link>
                        <div class="content">
                            <Link to={`/product/${data.id}`} class="header">{data.productTitle.substring(0, MAX_LENGTH)},...</Link>
                            <div class="meta">
                                <p>&#2547;{data.productPrice}</p>
                            </div>
                            <button onClick={() => addToCart(data.id)} class="ui vertical animated button" tabindex="0">
                                <div class="hidden content">Add to Cart</div>
                                <div class="visible content">
                                    <i class="shop icon"></i>
                                </div>
                            </button>
                        </div>
                    </div>

                </div>
            </Col>

        </React.Fragment>
    )
}

const mapDispatchToProps = dispatch => {
    return {
        addToCart: (id) => dispatch(addToCart(id))

    }
}

export default connect(null, mapDispatchToProps)(Product);