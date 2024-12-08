import axios from 'axios';

const baseURL = 'http://localhost:8085'; // API Gateway URL

export const fetchProducts = () => axios.get(`${baseURL}/api/products`);
export const fetchCustomers = () => axios.get(`${baseURL}/api/customers`);
export const fetchInventory = () => axios.get(`${baseURL}/api/inventory`);
export const fetchOrders = () => axios.get(`${baseURL}/api/orders`);
export const fetchCart = () => axios.get(`${baseURL}/api/cart`);

const api = {
  fetchProducts,
  fetchCustomers,
  fetchInventory,
  fetchOrders,
  fetchCart,
};

export default api;
