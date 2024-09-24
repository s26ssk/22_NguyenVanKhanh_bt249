package com.example.controller;

import com.example.model.Order;
import com.example.service.impl.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @GetMapping
    public String listOrders(Model model) {
        model.addAttribute("orders", orderService.findAll());
        return "order/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("order", new Order());
        return "order/create";
    }

    @PostMapping("/create")
    public String createOrder(@ModelAttribute Order order) {
        orderService.save(order);
        return "redirect:/orders";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<Order> order = orderService.findById(id);
        if (order.isPresent()) {
            model.addAttribute("order", order.get());
            return "order/edit";
        } else {
            return "redirect:/orders";
        }
    }

    @PostMapping("/edit")
    public String updateOrder(@ModelAttribute Order order) {
        orderService.save(order);
        return "redirect:/orders";
    }

    @GetMapping("/delete/{id}")
    public String deleteOrder(@PathVariable Long id) {
        orderService.deleteById(id);
        return "redirect:/orders";
    }
}