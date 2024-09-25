package com.LMS.LMSOrderService.Controller;

import com.LMS.LMSOrderService.Data.Customer;
import com.LMS.LMSOrderService.Data.CustomerRepository;
import com.LMS.LMSOrderService.Data.Order;
import com.LMS.LMSOrderService.Data.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @ApiIgnore
    @RequestMapping(value = "/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping("/info")
    public String orderInfo() {
        return "This is the order service.";
    }

    @PostMapping("/order")
    public int createOrder(@RequestBody Order order) {
        Order savedOrder = orderRepository.save(order);
        return savedOrder.getOrder_id();
    }

    @GetMapping("/order/{id}")
    public Order getOrderById(@PathVariable("id") int id) {
        return orderRepository.findById(id).orElse(null);
    }

    @PutMapping("/order")
    public Order updateOrder(@RequestBody Order order) {
        return orderRepository.save(order);
    }

    @DeleteMapping("/order/{id}")
    public String deleteOrder(@PathVariable("id") int id) {
        orderRepository.deleteById(id);
        return "Order with id: " + id + " deleted";
    }

    @GetMapping("/customer/{id}")
    public Order getOrderByCustomerId(@PathVariable("id") int id) {
        return orderRepository.findById(id).orElse(null);
    }

    @PostMapping("/customer")
    public int createCustomer(@RequestBody Customer customer) {
        Customer savedCustomer = customerRepository.save(customer);
        return savedCustomer.getCustomer_id();
    }

    @PutMapping("/customer")
    public Customer updateCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    @DeleteMapping("/customer/{id}")
    public int deleteCustomer(@PathVariable("id") int id) {
        customerRepository.deleteById(id);
        return id;
    }

}
