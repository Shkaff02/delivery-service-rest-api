package com.example.delivery.repo;

import com.example.delivery.domain.Courier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourierRepository extends JpaRepository<Courier, Long> {

}
