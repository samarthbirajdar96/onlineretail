import React from 'react';

const OrderList = () => {
  const orders = [
    { id: 1, product: 'Laptop', customer: 'John Doe', status: 'Shipped' },
    { id: 2, product: 'Mobile', customer: 'Jane Smith', status: 'Delivered' },
  ];

  return (
    <div>
      <h2>Orders</h2>
      <ul>
        {orders.map((order) => (
          <li key={order.id}>
            {order.product} ordered by {order.customer} - Status: {order.status}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default OrderList;
