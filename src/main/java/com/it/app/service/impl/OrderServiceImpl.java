package com.it.app.service.impl;

import com.it.app.component.Validation;
import com.it.app.model.Order;
import com.it.app.repository.OrderRepository;
import com.it.app.service.MedicamentService;
import com.it.app.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    private MedicamentService medicamentService;

    private Validation validation;

    public OrderServiceImpl(OrderRepository orderRepository, MedicamentService medicamentService, Validation validation) {
        this.orderRepository = orderRepository;
        this.medicamentService = medicamentService;
        this.validation = validation;
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order findById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order doesn't exist"));
    }

    public Order save(Order order) {
        final Long id = order.getId();
        validation.validate(id != null, "Transient Order must not have an ID");
        return saveAndFlush(order);
    }

    public Order update(Order order) {
        final Long id = order.getId();
        validation.validate(id == null, "Order must have an ID");
        findById(id);
        return saveAndFlush(order);
    }

    public void delete(Order order) {
        final Long id = order.getId();
        validation.validate(id == null, "Persistent Order must have an ID");
        findById(id);
        orderRepository.delete(order);
    }

    public void deleteById(Long id) {
        findById(id);
        orderRepository.deleteById(id);
    }

    private Order saveAndFlush(Order order) {
        validation.validate(order.getMedicament() == null || order.getMedicament().getId() == null, "Order must have a Medicament");
        order.setMedicament(medicamentService.findById(order.getMedicament().getId()));
        return orderRepository.saveAndFlush(order);
    }
}