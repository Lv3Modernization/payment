package com.dangunju.payment.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PostGubun {
    SALE("판매"),
    AUTION("경매");
		
	private String description;
}
