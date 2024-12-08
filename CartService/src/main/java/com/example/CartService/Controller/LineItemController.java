package com.example.CartService.Controller;


import com.example.CartService.Model.LineItem;
import com.example.CartService.Service.LineItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/lineitem")
public class LineItemController {

    @Autowired
    private LineItemService lineItemService;

    // Add a line item to the cart
    @PostMapping
    public ResponseEntity<LineItem> addLineItem(@RequestBody LineItem lineItem) {
        LineItem createdLineItem = lineItemService.addLineItem(lineItem);
        return new ResponseEntity<>(createdLineItem, HttpStatus.CREATED);
    }

    // Update a line item
    @PutMapping("/{id}")
    public ResponseEntity<LineItem> updateLineItem(@PathVariable Long id, @RequestBody LineItem lineItem) {
        LineItem updatedLineItem = lineItemService.updateLineItem(id, lineItem);
        return new ResponseEntity<>(updatedLineItem, HttpStatus.OK);
    }

    // Delete a line item
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLineItem(@PathVariable Long id) {
        lineItemService.deleteLineItem(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
