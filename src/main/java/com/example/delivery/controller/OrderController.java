package com.example.delivery.controller;

import com.example.delivery.domain.Order;
import com.example.delivery.dto.OrderDTO;
import com.example.delivery.mappers.OrderMapper;
import com.example.delivery.service.OrderService;
import com.example.delivery.service.OrderServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderServiceImpl orderService;

    @GetMapping
    public ResponseEntity<List<OrderDTO>> getAll() {
        return ResponseEntity.ok().body(OrderMapper.INSTANCE.OrdersToOrdersDTO(orderService.getAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> findOrderById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(OrderMapper.INSTANCE.OrderToOrderDTO(orderService.getOrderById(id)));
    }

    @PostMapping
    public ResponseEntity<Order> saveOrder(@RequestBody Order order, @RequestParam(name = "dishes") Long[] dishes,
                                           @RequestParam(name="cour_id") Long cour_id,
                                           @RequestParam (name = "rest_id") Long rest_id) {
        return ResponseEntity.ok().body(orderService.saveOrder(order, dishes, cour_id, rest_id));
    }

    @PutMapping("/{id}/dishes/{dish_id}")
    public ResponseEntity<Order> addDishedToOrder(@PathVariable("id") Long ord_id, @PathVariable("dish_id") Long dish_id) {
        return ResponseEntity.ok().body(orderService.addDishesToOrder(ord_id, dish_id));
    }

    @PutMapping
    public ResponseEntity<Order> updateOrderInfo(@RequestBody Order order) {
        return ResponseEntity.ok().body(orderService.updateOrderInfo(order));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable("id") Long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.ok().build();
    }
}
