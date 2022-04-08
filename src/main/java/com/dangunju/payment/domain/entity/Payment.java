package com.dangunju.payment.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    PaymentGubun paymentGubun;
    PaymentResult paymentResult;
    PostGubun postGubun;
    Long postId;
    Long seller; //판매자 사번
    Long buyer; //구매자 사번
    String postTitle;
    Long amount;
}
