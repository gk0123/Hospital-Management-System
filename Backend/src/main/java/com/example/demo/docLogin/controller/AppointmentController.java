package com.example.demo.docLogin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.AttributeNotFoundException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.docLogin.entity.Appointment;
import com.example.demo.docLogin.repository.AppointmentRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v2")
public class AppointmentController {
	
	private AppointmentRepository appointmentRepository;

    public AppointmentController(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @PostMapping("/appointments")
    public Appointment createAppointment(@RequestBody Appointment appointment){
        return appointmentRepository.save(appointment);
    }

    @GetMapping("/appointments")
    public List<Appointment> getAllAppointments(){
        return appointmentRepository.findAll();
    }

    @DeleteMapping("/appointments/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteAppointment(@PathVariable Long id) throws AttributeNotFoundException{
    	Appointment appointment = appointmentRepository.findById(id).orElseThrow(() -> new AttributeNotFoundException("Appointment not found with id:"+id));
    	appointmentRepository.delete(appointment);
    	Map<String, Boolean> response = new HashMap<>();
    	response.put("Deleted", Boolean.TRUE);
    	return ResponseEntity.ok(response);
    	
    }
    
}
