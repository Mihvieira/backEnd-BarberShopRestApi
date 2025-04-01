package com.barbershop.api.service.impl;

import java.util.List;

import com.barbershop.api.dto.payments.PaymentDTO;
import com.barbershop.api.service.interfaces.IPaymentService;

public class PaymentService implements IPaymentService{

    @Override
    public PaymentDTO findPaymentById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findPaymentById'");
    }

    @Override
    public List<PaymentDTO> findAllPayments() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllPayments'");
    }

    @Override
    public PaymentDTO insertPayment(PaymentDTO paymentToCreate) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertPayment'");
    }

    @Override
    public void deletePaymentById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletePaymentById'");
    }

    @Override
    public PaymentDTO updatePayment(PaymentDTO paymentToUpdate) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updatePayment'");
    }

}
