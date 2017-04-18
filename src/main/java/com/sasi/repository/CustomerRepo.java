package com.sasi.repository;

import com.sasi.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by myelleswarapu on 18-04-2017.
 */
@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {
}
