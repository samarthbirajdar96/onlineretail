package com.example.OrderService;


import com.example.OrderService.Model.Order;
import com.example.OrderService.Repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    // Add a new order
    public Order addOrder(Order order) {
        return orderRepository.save(order);
    }

    // Delete an order
    public void deleteOrder(Long orderid) {
        orderRepository.deleteById(orderid);
    }

    // Update an order
    public Order updateOrder(Long orderid, Order orderDetails) {
        Order order = getOrder(orderid);
        order.setLineItems(orderDetails.getLineItems());
        return orderRepository.save(order);
    }

    // Get an order by ID
    public Order getOrder(Long orderid) {
        return orderRepository.findById(orderid)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }
}
