import React from "react";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import ProductList from "./Components/ProductList"
import CustomerList from "./Components/CustomerList";
import InventoryList from "./Components/InventoryList";
import OrderList from "./Components/OrderList";
import Cart from "./Components/Cart";
import Layout from "/Components/Layout";

const App = () => (
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

export default App;

