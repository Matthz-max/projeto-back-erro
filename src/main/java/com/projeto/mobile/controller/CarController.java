package com.projeto.mobile.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.mobile.dto.FavoriteDTO;
import com.projeto.mobile.entity.CarEntity;
import com.projeto.mobile.service.CarService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/listar")
    public List<CarEntity> getAllCars() {
        return carService.getAllCars();
    }

    @PostMapping("/salvar")
    public CarEntity createCar(@RequestBody CarEntity car) {
        return carService.saveCar(car);
    }

    @DeleteMapping("/deletar/{id}")
    public void deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
    }

    @PutMapping("/{id}/favorite")
    public CarEntity updateFavorite(@PathVariable Long id, @RequestBody FavoriteDTO favoriteDTO) {
        return carService.updateFavorite(id, favoriteDTO.getIsFavorite());
    }


}
