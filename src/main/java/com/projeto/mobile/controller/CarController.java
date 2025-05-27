package com.projeto.mobile.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.projeto.mobile.entity.CarEntity;
import com.projeto.mobile.service.CarService;

@RestController
@RequestMapping("/cars")
@CrossOrigin(origins = "*") 
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/listar")
    public List<CarEntity> getAllCars() {
        return carService.getAllCars();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarEntity> getCarById(@PathVariable Long id) {
        try {
            CarEntity car = carService.getCarById(id);
            return ResponseEntity.ok(car);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public CarEntity createCar(@RequestBody CarEntity car) {
        return carService.createCar(car);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<CarEntity> updateCar(@PathVariable Long id, @RequestBody CarEntity carDetails) {
        try {
            CarEntity updatedCar = carService.updateCar(id, carDetails);
            return ResponseEntity.ok(updatedCar);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        try {
            carService.deleteCar(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
