package com.incubyte.sweetshop.controller;

import com.incubyte.sweetshop.Sweet;
import com.incubyte.sweetshop.service.SweetService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sweets")
public class SweetController {

    private final SweetService sweetService;

    public SweetController(SweetService sweetService) {
        this.sweetService = sweetService;
    }

    
    @PostMapping
    public Sweet addSweet(@Valid @RequestBody Sweet sweet) {
        return sweetService.addSweet(sweet);
    }

    @GetMapping
    public List<Sweet> getAllSweets() {
        return sweetService.getAllSweets();
    }
    @PutMapping("/{id}")
    public Sweet updateSweet(@PathVariable Long id, @Valid @RequestBody Sweet sweet) {
        return sweetService.updateSweet(id, sweet);
    }

    @DeleteMapping("/{id}")
    public void deleteSweet(@PathVariable Long id) {
        sweetService.deleteSweet(id);
    }
    @GetMapping("/search/name")
    public List<Sweet> searchByName(@RequestParam String name) {
        return sweetService.searchByName(name);
    }

    @GetMapping("/search/category")
    public List<Sweet> searchByCategory(@RequestParam String category) {
        return sweetService.searchByCategory(category);
    }

    
    
}
