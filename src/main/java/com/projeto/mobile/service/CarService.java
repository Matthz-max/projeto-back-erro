package com.projeto.mobile.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.mobile.entity.CarEntity;
import com.projeto.mobile.repository.CarRepository;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public List<CarEntity> getAllCars() {
        return carRepository.findAll();
    }

    public CarEntity getCarById(Long id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Car not found with id: " + id));
    }

    public CarEntity createCar(CarEntity car) {
        return carRepository.save(car);
    }

    public CarEntity updateCar(Long id, CarEntity carDetails) {
        CarEntity car = carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Car not found with id: " + id));
 
        car.setImagem(carDetails.getImagem());
      

        return carRepository.save(car);
    }

    public void deleteCar(Long id) {
        if (!carRepository.existsById(id)) {
            throw new RuntimeException("Car not found with id: " + id);
        }
        carRepository.deleteById(id);
    }
}
