
import * as actionTypes from './shoppingTypes'

const addToCart = id => {
    return {
        type: actionTypes.ADD_TO_CART,
        payLoad: id
    }
}

const removeFromCart = id => {
    return {
        type: actionTypes.REMOVE_FROM_CART,
        payLoad: id
    }
}

const adjustQty = (id, value) => {
    return {
        type: actionTypes.ADJUST_QTY,
        payLoad: value
    }
}