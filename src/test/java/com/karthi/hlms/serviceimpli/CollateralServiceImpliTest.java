package com.karthi.hlms.serviceimpli;

import com.karthi.hlms.model.Collateral;
import com.karthi.hlms.model.LoanApplication;
import com.karthi.hlms.repository.CollateralRepo;
import com.karthi.hlms.repository.LoanApplicationRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CollateralServiceImpliTest {

    @Mock
    private CollateralRepo cRepo;

    @Mock
    private LoanApplicationRepo lRepo;

    @InjectMocks
    private CollateralServiceImpli collateralServiceImpli;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAdd() {
        long loanId = 1L;
        LoanApplication loanApplication = new LoanApplication();
        Collateral collateral = new Collateral();
        collateral.setId(1L);
        
        when(lRepo.findById(loanId)).thenReturn(loanApplication);

        collateralServiceImpli.add(collateral, loanId);

        assertEquals(loanApplication, collateral.getLoanApplication());
        verify(lRepo).findById(loanId);
        verify(cRepo).save(collateral);
    }

    @Test
    void testFindByLoanId() {
        int loanId = 1;
        Collateral collateral1 = new Collateral();
        Collateral collateral2 = new Collateral();
        
        when(cRepo.findByLoanId(loanId)).thenReturn(Arrays.asList(collateral1, collateral2));

        var collaterals = collateralServiceImpli.findByLoanId(loanId);

        assertEquals(2, collaterals.size());
        verify(cRepo).findByLoanId(loanId);
    }
}
