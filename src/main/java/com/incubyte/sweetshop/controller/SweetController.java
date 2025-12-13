package com.incubyte.sweetshop.controller;

import com.incubyte.sweetshop.Sweet;
import com.incubyte.sweetshop.service.SweetService;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sweets")
public class SweetController {

    private final SweetService sweetService;

    public SweetController(SweetService sweetService) {
        this.sweetService = sweetService;
    }

    // ✅ USER + ADMIN
    @GetMapping
    public List<Sweet> getAllSweets() {
        return sweetService.getAllSweets();
    }

    // 🔒 ADMIN ONLY
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public Sweet addSweet(@Valid @RequestBody Sweet sweet) {
        return sweetService.addSweet(sweet);
    }

    // 🔒 ADMIN ONLY
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public Sweet updateSweet(
            @PathVariable Long id,
            @Valid @RequestBody Sweet sweet
    ) {
        return sweetService.updateSweet(id, sweet);
    }

    // 🔒 ADMIN ONLY
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void deleteSweet(@PathVariable Long id) {
        sweetService.deleteSweet(id);
    }

    // ✅ USER + ADMIN
    @GetMapping("/search/name")
    public List<Sweet> searchByName(@RequestParam String name) {
        return sweetService.searchByName(name);
    }

    // ✅ USER + ADMIN
    @GetMapping("/search/category")
    public List<Sweet> searchByCategory(@RequestParam String category) {
        return sweetService.searchByCategory(category);
    }
 // 🛒 USER + ADMIN can purchase sweets
    @PostMapping("/{id}/purchase")
    public Sweet purchaseSweet(
            @PathVariable Long id,
            @RequestParam int quantity
    ) {
        return sweetService.purchaseSweet(id, quantity);
    }

    // 🔒 ADMIN ONLY can restock
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/{id}/restock")
    public Sweet restockSweet(
            @PathVariable Long id,
            @RequestParam int quantity
    ) {
        return sweetService.restockSweet(id, quantity);
    }

    
    
    
}
