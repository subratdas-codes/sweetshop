package com.incubyte.sweetshop;

import com.incubyte.sweetshop.repository.SweetRepository;
import com.incubyte.sweetshop.service.SweetService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SweetServiceTest {

    @Mock
    private SweetRepository sweetRepository;

    @InjectMocks
    private SweetService sweetService;

    @Test
    void shouldCreateSweetWithValidDetails() {
        Sweet sweet = new Sweet("Rasgulla", "Dessert", 10.0, 100);

        assertEquals("Rasgulla", sweet.getName());
        assertEquals("Dessert", sweet.getCategory());
        assertEquals(10.0, sweet.getPrice());
        assertEquals(100, sweet.getQuantity());
    }

    @Test
    void shouldAddSweetUsingService() {
        Sweet sweet = new Sweet("Ladoo", "Snack", 5.0, 50);

        when(sweetRepository.save(sweet)).thenReturn(sweet);
        when(sweetRepository.findAll()).thenReturn(List.of(sweet));

        sweetService.addSweet(sweet);

        List<Sweet> sweets = sweetService.getAllSweets();

        assertEquals(1, sweets.size());
        assertEquals("Ladoo", sweets.get(0).getName());

        verify(sweetRepository, times(1)).save(sweet);
        verify(sweetRepository, times(1)).findAll();
    }
}
