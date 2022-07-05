package com.example.projectaidana.dao;
import com.example.projectaidana.models.Payment;
import com.example.projectaidana.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public Payment save(Payment payment){
       return paymentRepository.save(payment);
    }

    public List<Payment>findAll(){
        return paymentRepository.findAll();
    }


}
