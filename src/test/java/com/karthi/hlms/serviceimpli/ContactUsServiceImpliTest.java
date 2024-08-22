package com.karthi.hlms.serviceimpli;

import com.karthi.hlms.model.ContactUs;
import com.karthi.hlms.repository.ContactUsRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ContactUsServiceImpliTest {

    @Mock
    private ContactUsRepo cUsRepo;

    @InjectMocks
    private ContactUsServiceImpli contactUsServiceImpli;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRequestToAdmin() {
        // Arrange
        ContactUs contactUs = new ContactUs();
        contactUs.setId(1L);

        // Act
        ContactUs result = contactUsServiceImpli.requestToAdmin(contactUs);

        // Assert
        assertEquals(contactUs, result);
        verify(cUsRepo).save(contactUs);
    }

    @Test
    void testGetAllFeedbacks() {
        // Arrange
        ContactUs feedback1 = new ContactUs();
        ContactUs feedback2 = new ContactUs();
        List<ContactUs> feedbacks = Arrays.asList(feedback1, feedback2);

        when(cUsRepo.getAllFeedback()).thenReturn(feedbacks);

        // Act
        List<ContactUs> result = contactUsServiceImpli.getAllFeedbacks();

        // Assert
        assertEquals(feedbacks, result);
        verify(cUsRepo).getAllFeedback();
    }
}
