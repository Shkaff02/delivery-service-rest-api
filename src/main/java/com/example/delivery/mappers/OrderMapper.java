package com.example.delivery.mappers;

import com.example.delivery.domain.Order;
import com.example.delivery.dto.OrderDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    OrderDTO OrderToOrderDTO(Order order);

    List<OrderDTO> OrdersToOrdersDTO(List<Order> orders);
}
