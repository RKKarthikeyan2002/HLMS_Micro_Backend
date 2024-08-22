package com.karthi.hlms.serviceimpli;

import com.karthi.hlms.model.Loan;
import com.karthi.hlms.model.LoanApplication;
import com.karthi.hlms.repository.LoanApplicationRepo;
import com.karthi.hlms.repository.LoanRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class LoanServiceImpliTest {

    @Mock
    private LoanRepo lRepo;

    @Mock
    private LoanApplicationRepo lApplicationRepo;

    @InjectMocks
    private LoanServiceImpli loanServiceImpli;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateLoan() {
        Long loanId = 1L;
        LoanApplication loanApplication = new LoanApplication();
        Loan loan = new Loan();
        loan.setId(1L);
        loan.setLoanApplication(loanApplication);

        when(lApplicationRepo.findById(loanId)).thenReturn(loanApplication);
        when(lRepo.save(loan)).thenReturn(loan);

        Loan createdLoan = loanServiceImpli.createLoan(loan, loanId);

        assertEquals(loan, createdLoan);
        verify(lApplicationRepo).findById(loanId);
        verify(lRepo).save(loan);
    }

    @Test
    void testGetAllLoans() {
        Loan loan1 = new Loan();
        Loan loan2 = new Loan();
        when(lRepo.findAll()).thenReturn(Arrays.asList(loan1, loan2));

        var loans = loanServiceImpli.getAllLoans();

        assertEquals(2, loans.size());
        verify(lRepo).findAll();
    }

    @Test
    void testGetLoansByCustomerId() {
        Long customerId = 1L;
        Loan loan1 = new Loan();
        Loan loan2 = new Loan();
        when(lRepo.findByLoanCustomerId(customerId)).thenReturn(Arrays.asList(loan1, loan2));

        var loans = loanServiceImpli.getLoansByCustomerId(customerId);

        assertEquals(2, loans.size());
        verify(lRepo).findByLoanCustomerId(customerId);
    }

    @Test
    void testGetLoanById() {
        Long loanId = 1L;
        Loan loan = new Loan();
        when(lRepo.findById(loanId)).thenReturn(loan);

        Loan retrievedLoan = loanServiceImpli.getLoanById(loanId);

        assertEquals(loan, retrievedLoan);
        verify(lRepo).findById(loanId);
    }
}
