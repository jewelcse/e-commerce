
import React from 'react'
import { Link } from 'react-router-dom'
import { Nav, Navbar, NavDropdown, Container } from 'react-bootstrap'


const Category = (props) => {

    return (
        <NavDropdown.Item as={Link} to={`/category/${props.data.id}`} >{props.data.grandParentCategoryTitle}</NavDropdown.Item>
    )
}


export default Category