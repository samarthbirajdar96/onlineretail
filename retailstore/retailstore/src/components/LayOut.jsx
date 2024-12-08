import React from 'react';
import { Link } from 'react-router-dom';
import './Layout.css';

const Layout = ({ children }) => (
  <div>
    <nav>
      <Link to="/products">Products</Link> | 
      <Link to="/customers">Customers</Link> | 
      <Link to="/inventory">Inventory</Link> | 
      <Link to="/orders">Orders</Link> | 
      <Link to="/cart">Cart</Link>
    </nav>
    <hr />
    <div>{children}</div>
  </div>
);

export default Layout;
