package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/workintech/animal")
public class AnimalController {

    @Value("${course.name}")
    private String courseName;

    @Value("${project.developer.fullname}")
    private String developerName;

    private final Map<Integer, Animal> animals = new HashMap<>();

    // GET: Tüm hayvanları döndür
    @GetMapping
    public List<Animal> getAllAnimals() {
        return new ArrayList<>(animals.values());
    }

    // GET: ID'ye göre hayvan döndür
    @GetMapping("/{id}")
    public Animal getAnimalById(@PathVariable Integer id) {
        return animals.get(id);
    }

    // POST: Yeni hayvan ekle
    @PostMapping
    public String addAnimal(@RequestBody Animal animal) {
        animals.put(animal.getId(), animal);
        return "Animal added successfully!";
    }

    // PUT: Hayvanı güncelle
    @PutMapping("/{id}")
    public String updateAnimal(@PathVariable Integer id, @RequestBody Animal animal) {
        if (animals.containsKey(id)) {
            animals.put(id, animal);
            return "Animal updated successfully!";
        } else {
            return "Animal not found!";
        }
    }

    // DELETE: Hayvanı sil
    @DeleteMapping("/{id}")
    public String deleteAnimal(@PathVariable Integer id) {
        animals.remove(id);
        return "Animal deleted successfully!";
    }

    @GetMapping("/info")
    public String getInfo() {
        return "Course: " + courseName + ", Developer: " + developerName;
    }
}
