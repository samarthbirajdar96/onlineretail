import React from 'react';

const Cart = () => {
  const cartItems = [
    { id: 1, product: 'Laptop', price: 50, quantity: 1 },
    { id: 2, product: 'Mobile', price: 100, quantity: 2 },
  ];

  return (
    <div>
      <h2>Cart</h2>
      <ul>
        {cartItems.map((item) => (
          <li key={item.id}>
            {item.product} - ${item.price} x {item.quantity}
          </li>
        ))}
      </ul>
      <h3>
        Total: $
        {cartItems.reduce((total, item) => total + item.price * item.quantity, 0)}
      </h3>
    </div>
  );
};

export default Cart;
