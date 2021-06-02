package com.example.demo.repository;

import com.example.demo.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "staff", path = "staff")
public interface StaffRepository extends JpaRepository<Staff, Long> {
    Staff findStaffById(Long id);

    Staff findStaffByName(String name);

    Staff findStaffByPosition(String position);

}
