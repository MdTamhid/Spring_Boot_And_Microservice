package com.tm.repository.promotions;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tm.entity.promotions.Promotions;

public interface IPromotionsRepository extends JpaRepository<Promotions, Long> {

}
