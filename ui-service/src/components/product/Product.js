
import React, { useState, useEffect } from 'react'



const Product = (props) => {

    return (
        <div>
            <h1>{props.data.productTitle}</h1>
            <p>{props.data.category.parentCategory.grandParentCategory.grandParentCategoryTitle}
                ->{props.data.category.parentCategory.parentCategoryTitle}
                ->{props.data.category.categoryTitle}</p>
            <p>{props.data.productDescription}</p>
            <p>{props.data.productPrice}</p>
            <p>{props.data.productImagePath}</p>
        </div>
    )
}


export default Product;