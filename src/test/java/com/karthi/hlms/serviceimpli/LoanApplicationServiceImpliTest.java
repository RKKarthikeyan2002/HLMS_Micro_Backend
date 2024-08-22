package com.karthi.hlms.serviceimpli;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.karthi.hlms.model.Customer;
import com.karthi.hlms.model.LoanApplication;
import com.karthi.hlms.repository.CustomerRepo;
import com.karthi.hlms.repository.LoanApplicationRepo;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

class LoanApplicationServiceImpliTest {

    @Mock
    private LoanApplicationRepo lRepo;

    @Mock
    private CustomerRepo cRepo;

    @InjectMocks
    private LoanApplicationServiceImpli loanApplicationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testApplyLoan() {
        LoanApplication loanApplication = new LoanApplication(1L, 10000, "Personal", 5.0, 12, "Pending", null);
        when(lRepo.save(any(LoanApplication.class))).thenReturn(loanApplication);

        LoanApplication result = loanApplicationService.applyLoan(loanApplication);

        assertNotNull(result);
        assertEquals(10000, result.getAmount());
        verify(lRepo).save(loanApplication);
    }

    @Test
    void testGetLoanApplicationsByCustomer() {
        Customer customer = new Customer(1L, "Karthi", "john.doe@example.com", "1234567890", 30, new Date(), "Address", "password", "user");
        LoanApplication loanApplication = new LoanApplication(1L, 10000, "Personal", 5.0, 12, "Pending", null);
        when(cRepo.findByName("Karthi")).thenReturn(customer);
        when(lRepo.findByBorrowerCustomer(customer)).thenReturn(Arrays.asList(loanApplication));

        List<LoanApplication> results = loanApplicationService.getLoanApplicationsByCustomer("Karthi");

        assertNotNull(results);
        assertEquals(1, results.size());
        assertEquals("Personal", results.get(0).getType());
        verify(cRepo).findByName("Karthi");
        verify(lRepo).findByBorrowerCustomer(customer);
    }

    @Test
    void testGetLoanApplicationByLoanId() {
        LoanApplication loanApplication = new LoanApplication(1L, 10000, "Personal", 5.0, 12, "Pending", null);
        when(lRepo.findById(1L)).thenReturn(loanApplication);

        LoanApplication result = loanApplicationService.getLoanApplicationByLoanId(1L);

        assertNotNull(result);
        assertEquals(10000, result.getAmount());
        verify(lRepo).findById(1L);
    }

    @Test
    void testGetLoanApplicationsByStatus() {
        LoanApplication loanApplication = new LoanApplication(1L, 10000, "Personal", 5.0, 12, "Approved", null);
        when(lRepo.findByStatus("Approved")).thenReturn(Arrays.asList(loanApplication));

        List<LoanApplication> results = loanApplicationService.getLoanApplicationsByStatus("Approved");

        assertNotNull(results);
        assertEquals(1, results.size());
        assertEquals("Approved", results.get(0).getStatus());
        verify(lRepo).findByStatus("Approved");
    }

    @Test
    void testEditStatus() {
        LoanApplication loanApplication = new LoanApplication(1L, 10000, "Personal", 5.0, 12, "Pending", null);
        when(lRepo.findById(1L)).thenReturn(loanApplication);
        when(lRepo.updateApplicationByStatus(any(LoanApplication.class))).thenReturn(loanApplication);

        LoanApplication result = loanApplicationService.editStatus(1L, "Approved");

        assertNotNull(result);
        assertEquals("Approved", result.getStatus());
        verify(lRepo).findById(1L);
        verify(lRepo).updateApplicationByStatus(loanApplication);
    }

    @Test
    void testGetAlLoanApplications() {
        LoanApplication loanApplication = new LoanApplication(1L, 10000, "Personal", 5.0, 12, "Pending", null);
        when(lRepo.findAll()).thenReturn(Arrays.asList(loanApplication));

        List<LoanApplication> results = loanApplicationService.getAlLoanApplications();

        assertNotNull(results);
        assertEquals(1, results.size());
        assertEquals("Personal", results.get(0).getType());
        verify(lRepo).findAll();
    }
}
