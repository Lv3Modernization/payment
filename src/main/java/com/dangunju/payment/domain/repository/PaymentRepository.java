package com.dangunju.payment.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dangunju.payment.domain.entity.Payment;
import com.dangunju.payment.domain.entity.PostGubun;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
	List<Payment> findBySeller(Long seller);
	List<Payment> findByBuyer(Long buyer);
	List<Payment> findByPostGubunAndPostId(PostGubun postGubun, Long postId);
}
