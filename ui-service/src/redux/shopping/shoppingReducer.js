import * as actionTypes from './shoppingTypes'


const initialState = {
    products: [],
    cart: []
}


const shopReducer = (state = initialState, action) => {
    switch (action.type) {
        case actionTypes.ADD_TO_CART: return {

        }
        case actionTypes.REMOVE_FROM_CART: return {

        }
        case actionTypes.ADJUST_QTY: return {

        }
        default: return state
    }
}

export default shopReducer