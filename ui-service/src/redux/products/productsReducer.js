
import * as actions from './productsType'

const initialState = {
    loading: false,
    products: [],
    error: ''
}

const productsReducer = (state = initialState, action) => {

    switch (action.type) {
        case actions.PRODUCTS_FETCH_REQUEST: return {
            ...state,
            loading: true

        }
        case actions.PRODUCTS_FETCH_SUCCESS: return {
            ...state,
            products: action.payLoad,
            error: ''
        }

        case actions.PRODUCTS_FETCH_ERROR: return {
            ...state,
            products: [],
            error: action.payLoad

        }
        default: return state

    }
}

export default productsReducer