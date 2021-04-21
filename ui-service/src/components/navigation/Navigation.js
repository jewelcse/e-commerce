import React from 'react'
import { Link } from 'react-router-dom'
import { Nav, Navbar, NavDropdown, Container } from 'react-bootstrap'

const Navigation = () => {
    return (
        <Navbar collapseOnSelect expand="lg" className="navbar" fixed="top" >
            <Container>
                <Navbar.Brand to="/" as={Link} style={{ color: '#fff', fontSize: '30px', fontFamilly: 'Lato' }}>ECOM</Navbar.Brand>
                <Navbar.Toggle aria-controls="responsive-navbar-nav" />
                <Navbar.Collapse id="responsive-navbar-nav">
                    <Nav className="mr-auto" className="nav_item" >

                        <Nav.Link as={Link} to="/products">Products</Nav.Link>
                        <Nav.Link as={Link} to="/cart">Contact</Nav.Link>

                    </Nav>
                    <Nav className="nav_item">
                        <Nav.Link as={Link} to="/login">Login</Nav.Link>
                        <Nav.Link as={Link} to="/register">Register</Nav.Link>

                    </Nav>
                </Navbar.Collapse>
            </Container>
        </Navbar>
    )
}

export default Navigation