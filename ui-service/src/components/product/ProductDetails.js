

import React from 'react'

const ProductDetails = (props) => {
    return (
        <React.Fragment>
            <h1>{props.data.productTitle}</h1>
            <p>{props.data.category.parentCategory.grandParentCategory.grandParentCategoryTitle}
                ->{props.data.category.parentCategory.parentCategoryTitle}
                ->{props.data.category.categoryTitle}</p>
            <p>{props.data.productDescription}</p>
            <p>{props.data.productPrice}</p>
            <p>{props.data.productImagePath}</p>
        </React.Fragment>
    )
}


export deault ProductDetails