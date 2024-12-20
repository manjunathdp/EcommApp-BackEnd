package com.ecommerce.project.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.project.models.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long>{

}