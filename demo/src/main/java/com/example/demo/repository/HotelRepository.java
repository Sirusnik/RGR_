package com.example.demo.repository;

import com.example.demo.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "hotel", path = "hotel")
public interface HotelRepository extends JpaRepository<Hotel, Long> {
    Hotel findHotelById(Long id);

    Hotel findHotelByName(String name);

}
