package com.trip.tripmanagement.controller;

import com.trip.tripmanagement.entity.Payment;
import com.trip.tripmanagement.service.PaymentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    // CREATE
    @PostMapping
    public Payment create(@RequestBody Payment payment) {
        return paymentService.create(payment);
    }

    // GET ALL
    @GetMapping
    public List<Payment> getAll() {
        return paymentService.getAll();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Payment getById(@PathVariable Integer id) {
        return paymentService.getById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Payment update(@PathVariable Integer id, @RequestBody Payment updatedPayment) {
        return paymentService.update(id, updatedPayment);
    }

    // PATCH
    @PatchMapping("/{id}")
    public Payment patch(@PathVariable Integer id, @RequestBody Payment updatedPayment) {
        return paymentService.patch(id, updatedPayment);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        paymentService.delete(id);
        return "Payment deleted successfully";
    }
}