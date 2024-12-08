package com.example.CartService.Service;


import com.example.CartService.Model.LineItem;
import com.example.CartService.Repo.LineItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LineItemService {

    @Autowired
    private LineItemRepository lineItemRepository;

    // Add a new LineItem
    public LineItem addLineItem(LineItem lineItem) {
        return lineItemRepository.save(lineItem);
    }

    // Update a LineItem
    public LineItem updateLineItem(Long itemId, LineItem updatedLineItem) {
        LineItem lineItem = lineItemRepository.findById(itemId)
                .orElseThrow(() -> new RuntimeException("LineItem not found"));
        lineItem.setProductId(updatedLineItem.getProductId());
        lineItem.setProductName(updatedLineItem.getProductName());
        lineItem.setQuantity(updatedLineItem.getQuantity());
        lineItem.setPrice(updatedLineItem.getPrice());
        return lineItemRepository.save(lineItem);
    }

    // Delete a LineItem
    public void deleteLineItem(Long itemId) {
        lineItemRepository.deleteById(itemId);
    }
}
