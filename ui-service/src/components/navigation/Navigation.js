import React from 'react'
import { Link } from 'react-router-dom'
import { Nav, Navbar, NavDropdown, Container } from 'react-bootstrap'

import './Navigation.css'
import GrandParentCategoryList from '../grandParentCategory/GrandParentCategoryList'
import CategoryList from '../category/CategoryList'


import cartImg from '../../img/shopping-cart-solid.svg'

const Navigation = () => {
    return (
        <Navbar collapseOnSelect expand="lg" className="navbar" fixed="top" bg="dark"  >
            <Container>
                <Navbar.Brand to="/" as={Link} style={{ color: '#fff', fontSize: '30px', fontFamilly: 'Lato' }}>ECOM</Navbar.Brand>
                <Navbar.Toggle aria-controls="responsive-navbar-nav" />
                <Navbar.Collapse id="responsive-navbar-nav">
                    <Nav className="navbar-nav mr-auto" >
                        <NavDropdown title="Category" id="collasible-nav-dropdown">

                            <GrandParentCategoryList />
                            {/* <CategoryList /> */}

                            <NavDropdown.Divider />
                            <NavDropdown.Item href="#action/3.4">Separated link</NavDropdown.Item>
                        </NavDropdown>
                        <Nav.Link as={Link} to="/products">Products</Nav.Link>
                        <Nav.Link as={Link} to="/cart">
                            <img src={cartImg} /> <span>5</span> cart
                        </Nav.Link>

                    </Nav>
                    <Nav className="navbar-nav">
                        <Nav.Link as={Link} to="/login">Login</Nav.Link>
                        <Nav.Link as={Link} to="/register">Register</Nav.Link>

                    </Nav>
                </Navbar.Collapse>
            </Container>
        </Navbar>
    )
}

export default Navigation