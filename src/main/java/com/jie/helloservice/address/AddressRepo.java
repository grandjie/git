package com.jie.helloservice.address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AddressRepo extends JpaRepository<AddressEntity, String> {

    List<AddressEntity> findByUserIdOrderByCreateDateDesc(String userId);

    Optional<AddressEntity> findByCity(String city);
}
