package com.karthi.hlms.serviceimpli;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.karthi.hlms.model.Borrower;
import com.karthi.hlms.repository.BorrowerRepo;

import java.util.Date;

class BorrowerServiceImpliTest {

    @Mock
    private BorrowerRepo bRepo;

    @InjectMocks
    private BorrowerServiceImpli borrowerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddBorrower() {
        // Arrange
        Borrower borrower = new Borrower(1L, "Jane Doe", "jane.doe@example.com", "1234567890", 25, new Date(), "123 Main St", 50000, "Aadhar123", "PAN123", 750, null);
        when(bRepo.save(any(Borrower.class))).thenReturn(borrower);

        // Act
        Borrower savedBorrower = borrowerService.addBorrower(borrower);

        // Assert
        assertNotNull(savedBorrower);
        assertEquals("Jane Doe", savedBorrower.getName());
        assertEquals(50000, savedBorrower.getSalary());
        verify(bRepo).save(borrower);
    }
}
