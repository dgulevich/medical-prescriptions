package com.it.app.controller;

import com.it.app.dto.request.OrderRequestDto;
import com.it.app.dto.response.OrderResponseDto;
import com.it.app.model.Medicament;
import com.it.app.model.Order;
import com.it.app.service.OrderService;
import org.dozer.Mapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * The type Order controller.
 */
@RestController
@RequestMapping("/orders")
public class OrderController {

    private OrderService orderService;

    private Mapper mapper;

    /**
     * Instantiates a new Order controller.
     *
     * @param orderService the order service
     * @param mapper       the mapper
     */
    public OrderController(OrderService orderService, Mapper mapper) {
        this.orderService = orderService;
        this.mapper = mapper;
    }

    /**
     * Gets all.
     *
     * @return the all
     */
    @GetMapping
    public ResponseEntity<List<OrderResponseDto>> getAll() {
        final List<Order> orders = orderService.findAll();
        final List<OrderResponseDto> orderResponseDtoList = orders.stream()
                .map((order) -> mapper.map(order, OrderResponseDto.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(orderResponseDtoList, HttpStatus.OK);
    }

    /**
     * Gets one.
     *
     * @param id the id
     * @return the one
     */
    @GetMapping("/{id}")
    public ResponseEntity<OrderResponseDto> getOne(@PathVariable Long id) {
        final Order order = orderService.findById(id);
        final OrderResponseDto orderResponseDto = mapper.map(order, OrderResponseDto.class);
        return new ResponseEntity<>(orderResponseDto, HttpStatus.OK);
    }

    /**
     * Save response entity.
     *
     * @param orderRequestDto the order request dto
     * @return the response entity
     */
    @PostMapping
    public ResponseEntity<OrderResponseDto> save(@RequestBody OrderRequestDto orderRequestDto) {
        orderRequestDto.setId(null);
        final Order order = getOrder(orderRequestDto);
        final OrderResponseDto orderResponseDto = mapper.map(orderService.save(order), OrderResponseDto.class);
        return new ResponseEntity<>(orderResponseDto, HttpStatus.OK);
    }

    /**
     * Update response entity.
     *
     * @param orderRequestDto the order request dto
     * @param id              the id
     * @return the response entity
     */
    @PutMapping("/{id}")
    public ResponseEntity<OrderResponseDto> update(@RequestBody OrderRequestDto orderRequestDto, @PathVariable Long id) {
        if (!Objects.equals(id, orderRequestDto.getId())) throw new RuntimeException("Url param id is not equals to orderId!");
        final Order order = getOrder(orderRequestDto);
        final OrderResponseDto orderResponseDto = mapper.map(orderService.update(order), OrderResponseDto.class);
        return new ResponseEntity<>(orderResponseDto, HttpStatus.OK);
    }

    /**
     * Delete.
     *
     * @param id the id
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        orderService.deleteById(id);
    }

    private Order getOrder(OrderRequestDto orderRequestDto) {
        final Order order = mapper.map(orderRequestDto, Order.class);
        final Medicament medicament = new Medicament();
        medicament.setId(orderRequestDto.getMedicamentId());
        order.setMedicament(medicament);
        return order;
    }
}
