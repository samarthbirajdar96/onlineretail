import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Layout from './components/LayOut';
import ProductList from './components/ProductList';
import CustomerList from './components/CustomerList';
import InventoryList from './components/InventoryList';
import OrderList from './components/OrderList';
import Cart from './components/Cart';

const App = () => {
  return (
    <Router>
      <Layout>
        <Routes>
          <Route path="/products" element={<ProductList />} />
          <Route path="/customers" element={<CustomerList />} />
          <Route path="/inventory" element={<InventoryList />} />
          <Route path="/orders" element={<OrderList />} />
          <Route path="/cart" element={<Cart />} />
        </Routes>
      </Layout>
    </Router>
  );
};

export default App;
