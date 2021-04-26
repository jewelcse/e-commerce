
import { combineReducers } from 'redux';
import productsReducer from './products/productsReducer'
import shopReducer from './shopping/shoppingReducer'

const rootReducer = combineReducers({
    products: productsReducer,
    shop: shopReducer
});

export default rootReducer;
