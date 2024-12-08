import axios from "axios";

const BASE_URL = "http://localhost:8085/api";

export const fetchProducts = () => axios.get(`${BASE_URL}/products`);
export const fetchCustomers = () => axios.get(`${BASE_URL}/customers`);
export const fetchInventory = () => axios.get(`${BASE_URL}/inventory`);
export const fetchOrders = () => axios.get(`${BASE_URL}/orders`);
export const fetchCart = () => axios.get(`${BASE_URL}/cart`);

export const addToCart = (item) =>
  axios.post(`${BASE_URL}/cart`, { item });
