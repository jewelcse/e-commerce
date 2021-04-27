import React, { useState, useEffect } from 'react'
import { connect } from 'react-redux'
import { removeFromCart } from '../../redux/shopping/shoppingActions'
import './Cart.css'
import CartItem from './CartItem'

const Cart = ({ cart }) => {

    const [totalPrice, setTotalPrice] = useState(0);
    const [totalItem, setTotalItem] = useState(0);


    useEffect(() => {

        let items = 0;
        let price = 0;
        cart.forEach(item => {
            items += item.qty;
            price += (item.qty * item.productPrice)
        });

        setTotalItem(items);
        setTotalPrice(price);

    }, [cart, totalItem, totalPrice, setTotalPrice, setTotalItem])




    const cartList = cart.map(item => <CartItem cartData={item} key={item.id} />);

    return (
        <React.Fragment>
            <div className="col-sm-12 col-md-10 col-md-offset-1">
                <table className="table table-hover">
                    <thead>
                        <tr>
                            <th>Product</th>
                            <th>Quantity</th>
                            <th className="text-center">Price</th>
                            <th className="text-center">Total</th>
                            <th> </th>
                        </tr>
                    </thead>
                    <tbody>

                        {cartList}

                        <tr>
                            <td>   </td>
                            <td>   </td>
                            <td>   </td>
                            <td><h5>Total items</h5></td>
                            <td className="text-right"><h5><strong>{totalItem}</strong></h5></td>
                        </tr>

                        <tr>
                            <td>   </td>
                            <td>   </td>
                            <td>   </td>
                            <td><h5>Subtotal</h5></td>
                            <td className="text-right"><h5><strong>&#2547; {totalPrice}</strong></h5></td>
                        </tr>
                        <tr>
                            <td>   </td>
                            <td>   </td>
                            <td>   </td>
                            <td><h5>Estimated shipping</h5></td>
                            <td className="text-right"><h5><strong>$9.999.99</strong></h5></td>
                        </tr>
                        <tr>
                            <td>   </td>
                            <td>   </td>
                            <td>   </td>
                            <td><h3>Total</h3></td>
                            <td className="text-right"><h3><strong>$9.999.99</strong></h3></td>
                        </tr>
                        <tr>
                            <td>   </td>
                            <td>   </td>
                            <td>   </td>
                            <td>
                                <button type="button" className="btn btn-default">
                                    <span className="fa fa-shopping-cart"></span> Continue Shopping
                                </button></td>
                            <td>
                                <button type="button" className="btn btn-success">
                                    Checkout <span className="fa fa-play"></span>
                                </button></td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </React.Fragment>
    )
}

const mapStateToProps = state => {
    return {
        cart: state.shop.cart
    }
}



export default connect(mapStateToProps)(Cart)
