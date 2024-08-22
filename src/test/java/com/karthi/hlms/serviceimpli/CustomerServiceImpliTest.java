package com.karthi.hlms.serviceimpli;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.karthi.hlms.model.Customer;
import com.karthi.hlms.repository.CustomerRepo;

import java.util.Date;

class CustomerServiceImpliTest {

    @Mock
    private CustomerRepo cRepo;

    @Mock
    private JWTService jwtService;

    @InjectMocks
    private CustomerServiceImpli customerService;

    private BCryptPasswordEncoder encoder;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        encoder = new BCryptPasswordEncoder(12);
    }

    @Test
    void testRegisterCustomer() {
        Customer customer = new Customer(1L, "Karthi", "karthi.doe@example.com", "1234567890", 30, new Date(), "Madurai", "password", "user");
        when(cRepo.save(any(Customer.class))).thenReturn(customer);

        Customer registeredCustomer = customerService.registerCustomer(customer);

        assertNotNull(registeredCustomer);
        assertEquals("Karthi", registeredCustomer.getName());
        assertTrue(encoder.matches("password", registeredCustomer.getPassword()));
        verify(cRepo).save(customer);
    }

    @Test
    void testGetCustomerByName() {
        Customer customer = new Customer(1L, "Karthi", "karthi@example.com", "1234567890", 30, new Date(), "Madurai", "password", "user");
        when(cRepo.findByName("Karthi")).thenReturn(customer);

        Customer foundCustomer = customerService.getCustomerByName("Karthi");

        assertNotNull(foundCustomer);
        assertEquals("Karthi", foundCustomer.getName());
        verify(cRepo).findByName("Karthi");
    }

    @Test
    void testEditCustomer() {
        Customer existingCustomer = new Customer(1L, "Karthi", "karthi@example.com", "1234567890", 30, new Date(), "Madurai", "password", "user");
        Customer updatedCustomer = new Customer(1L, "Karthi", "karthi@example.com", "0987654321", 31, new Date(), "New Address", "password", "user");

        when(cRepo.findByName("Karthi")).thenReturn(existingCustomer);
        when(cRepo.update(any(Customer.class))).thenReturn(updatedCustomer);

        Customer result = customerService.editCustomer(updatedCustomer);

        assertNotNull(result);
        assertEquals("0987654321", result.getPhone());
        assertEquals("New Address", result.getAddress());
        verify(cRepo).findByName("Karthi");
    }

    @Test
    void testEditPassword() {
        Customer customer = new Customer(1L, "Karthi", "karthi.doe@example.com", "1234567890", 30, new Date(), "Madurai", encoder.encode("oldPassword"), "user");

        when(cRepo.findByName("Karthi")).thenReturn(customer);
        when(cRepo.update(any(Customer.class))).thenReturn(customer);

        Customer updatedCustomer = customerService.editPassword("Karthi", "newPassword", "oldPassword");

        assertNotNull(updatedCustomer);
        assertTrue(encoder.matches("newPassword", updatedCustomer.getPassword()));
        verify(cRepo).findByName("Karthi");
        verify(cRepo).update(updatedCustomer);
    }
}
