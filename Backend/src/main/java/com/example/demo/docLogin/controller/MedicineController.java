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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.docLogin.entity.Medicine;
import com.example.demo.docLogin.repository.MedicineRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v3")
public class MedicineController {

	private MedicineRepository medicineRepository;

	public MedicineController(MedicineRepository medicineRepository) {
		super();
		this.medicineRepository = medicineRepository;
	}
	
	@PostMapping("/medicine")
	public Medicine createMedicine(@RequestBody Medicine medicine) {
		return medicineRepository.save(medicine);
	}
	
	@GetMapping("/medicine")
	public List<Medicine> getAllMedincine(){
		return medicineRepository.findAll();
	} 
	
	@GetMapping("/medicine/{id}")
	public ResponseEntity<Medicine> getMedicineById(@PathVariable long id) throws AttributeNotFoundException{
		Medicine medicine = medicineRepository.findById(id).orElseThrow(()-> new AttributeNotFoundException("Medicine not found with id:"+id));
		return ResponseEntity.ok(medicine);
	}
	@PutMapping("medicine/{id}")
    public ResponseEntity<Medicine> updateMedicine(@PathVariable long id, @RequestBody Medicine medicineDetails) throws AttributeNotFoundException {
        Medicine medicine = medicineRepository.findById(id).orElseThrow(()-> new AttributeNotFoundException("Medicine with id "+id+" not found"));
        medicine.setDrugName(medicineDetails.getDrugName());
        medicine.setStock(medicineDetails.getStock());
        Medicine savedMedicine = medicineRepository.save(medicine);
        return ResponseEntity.ok(savedMedicine);
    }
	@DeleteMapping("medicine/{id}")
	public ResponseEntity<Map<String, Boolean>> delete(@PathVariable long id) throws AttributeNotFoundException{
		Medicine medicine = medicineRepository.findById(id).orElseThrow(()-> new AttributeNotFoundException("Medicine with id "+id+" not found"));
		medicineRepository.delete(medicine);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
}
