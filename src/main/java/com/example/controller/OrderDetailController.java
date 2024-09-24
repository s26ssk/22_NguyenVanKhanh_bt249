package com.example.controller;

import com.example.model.OrderDetail;
import com.example.service.impl.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/order-details")
public class OrderDetailController {

    @Autowired
    private IOrderDetailService orderDetailService;

    @GetMapping
    public String listOrderDetails(Model model) {
        model.addAttribute("orderDetails", orderDetailService.findAll());
        return "orderDetail/list";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("orderDetail", new OrderDetail());
        return "orderDetail/create";
    }

    @PostMapping("/create")
    public String createOrderDetail(@ModelAttribute OrderDetail orderDetail) {
        orderDetailService.save(orderDetail);
        return "redirect:/order-details";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<OrderDetail> orderDetail = orderDetailService.findById(id);
        if (orderDetail.isPresent()) {
            model.addAttribute("orderDetail", orderDetail.get());
            return "orderDetail/edit";
        } else {
            return "redirect:/order-details";
        }
    }

    @PostMapping("/edit")
    public String updateOrderDetail(@ModelAttribute OrderDetail orderDetail) {
        orderDetailService.save(orderDetail);
        return "redirect:/order-details";
    }

    @GetMapping("/delete/{id}")
    public String deleteOrderDetail(@PathVariable Long id) {
        orderDetailService.deleteById(id);
        return "redirect:/order-details";
    }
}