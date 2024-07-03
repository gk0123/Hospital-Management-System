package com.example.demo.docLogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.docLogin.entity.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long>{

}
