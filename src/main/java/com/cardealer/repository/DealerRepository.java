package com.cardealer.repository;

import com.cardealer.model.Dealer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DealerRepository extends JpaRepository<Dealer, Integer> {
}
