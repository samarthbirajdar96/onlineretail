import React from 'react';

const InventoryList = () => {
  const inventory = [
    { id: 1, item: 'Laptop', quantity: 10 },
    { id: 2, item: 'Mobile', quantity: 25 },
  ];

  return (
    <div>
      <h2>Inventory</h2>
      <ul>
        {inventory.map((item) => (
          <li key={item.id}>
            {item.item} - Quantity: {item.quantity}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default InventoryList;
