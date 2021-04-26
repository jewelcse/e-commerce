import logo from './logo.svg';
import './App.css';

import React from 'react'

import 'bootstrap/dist/css/bootstrap.min.css';
import 'semantic-ui-css/semantic.min.css'

import { BrowserRouter as Router, Route, Switch } from 'react-router-dom'

import GrandParentCategory from './components/grandParentCategory/GrandParentCategoryList'

import ProductList from './components/productList/ProductList'
import ProductListFromRedux from './components/productList/ProductListFromRedux'
import ProductDetails from './components/product/ProductDetails'
import Navigation from './components/navigation/Navigation'
import Layout from './components/layout/Layout'
import Error from './components/error/Error'




function App() {
  return (
    <React.Fragment>
      <Router>
        <Navigation />
        <div style={{ "marginTop": "100px" }}></div>

        <Layout>
          <Switch>
            <Route exact path="/">
              <ProductListFromRedux />
            </Route>

            <Route path="/products">
              <ProductListFromRedux />
            </Route>
            <Route path="/product/:id" children={<ProductDetails />}>
            </Route>
            <Route path="*">
              <Error />
            </Route>
          </Switch>
        </Layout>
      </Router>
    </React.Fragment >
  );
}

export default App;
