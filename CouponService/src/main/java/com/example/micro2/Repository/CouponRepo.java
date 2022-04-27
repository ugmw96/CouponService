package com.example.micro2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.micro2.couponEntity.Coupon;

public interface CouponRepo extends JpaRepository<Coupon, Long> {

	Coupon findByCode(String code);

}
