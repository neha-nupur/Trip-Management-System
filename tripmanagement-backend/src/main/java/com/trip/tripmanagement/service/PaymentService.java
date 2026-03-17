package com.trip.tripmanagement.service;

import com.trip.tripmanagement.entity.Payment;
import com.trip.tripmanagement.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    // CREATE
    public Payment create(Payment payment) {
        return paymentRepository.save(payment);
    }

    // GET ALL
    public List<Payment> getAll() {
        return paymentRepository.findAll();
    }

    // GET BY ID
    public Payment getById(Integer id) {
        return paymentRepository.findById(id).orElse(null);
    }

    // UPDATE (PUT)
    public Payment update(Integer id, Payment updatedPayment) {

        Optional<Payment> optional = paymentRepository.findById(id);

        if (optional.isPresent()) {

            Payment payment = optional.get();

            payment.setTrip(updatedPayment.getTrip());
            payment.setPaymentMethod(updatedPayment.getPaymentMethod());
            payment.setPaymentStatus(updatedPayment.getPaymentStatus());
            payment.setPaymentDate(updatedPayment.getPaymentDate());
            payment.setAmount(updatedPayment.getAmount());
            payment.setRefund(updatedPayment.getRefund());

            return paymentRepository.save(payment);
        }

        return null;
    }

    // PATCH (PARTIAL UPDATE)
    public Payment patch(Integer id, Payment updatedPayment) {

        Optional<Payment> optional = paymentRepository.findById(id);

        if (optional.isPresent()) {

            Payment payment = optional.get();

            if (updatedPayment.getTrip() != null)
                payment.setTrip(updatedPayment.getTrip());

            if (updatedPayment.getPaymentMethod() != null)
                payment.setPaymentMethod(updatedPayment.getPaymentMethod());

            if (updatedPayment.getPaymentStatus() != null)
                payment.setPaymentStatus(updatedPayment.getPaymentStatus());

            if (updatedPayment.getPaymentDate() != null)
                payment.setPaymentDate(updatedPayment.getPaymentDate());

            if (updatedPayment.getAmount() != null)
                payment.setAmount(updatedPayment.getAmount());

            if (updatedPayment.getRefund() != null)
                payment.setRefund(updatedPayment.getRefund());

            return paymentRepository.save(payment);
        }

        return null;
    }

    // DELETE
    public void delete(Integer id) {
        paymentRepository.deleteById(id);
    }
}