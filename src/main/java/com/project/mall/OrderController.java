package com.project.mall;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrderController {
	@Autowired
	private OrderRepository orderRepository;
	
	@GetMapping("/")
	public String showOrderForm(Model model) {
		model.addAttribute("order", new Order());
		return "order-form";
	}
	
	@PostMapping("/create-order")
    public String submitOrder(@ModelAttribute("order") Order order) {
        // Process the order and save to the database
        orderRepository.save(order);
        return "order-success";
    }
}
