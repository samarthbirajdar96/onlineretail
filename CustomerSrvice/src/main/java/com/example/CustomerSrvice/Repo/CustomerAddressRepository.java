package com.example.CustomerSrvice.Repo;

import com.example.CustomerSrvice.Model.CustomerAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerAddressRepository extends JpaRepository<CustomerAddress,Long> {
}
