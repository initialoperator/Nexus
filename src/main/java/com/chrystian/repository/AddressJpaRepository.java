package com.chrystian.repository;

import com.chrystian.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Repository
public interface AddressJpaRepository extends JpaRepository<Address, Long> {
//    List<Address> findAddressesByUserId;
}
