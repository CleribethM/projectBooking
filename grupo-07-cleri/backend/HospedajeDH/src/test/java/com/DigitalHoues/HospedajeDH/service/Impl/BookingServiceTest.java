package com.DigitalHoues.HospedajeDH.service.Impl;

import com.DigitalHoues.HospedajeDH.dto.BookingDTO;
import com.DigitalHoues.HospedajeDH.repository.BookingForClienteRepository;
import com.DigitalHoues.HospedajeDH.repository.CategoryRepository;
import com.DigitalHoues.HospedajeDH.repository.CityRepository;
import com.DigitalHoues.HospedajeDH.repository.ProductRepository;
import com.DigitalHoues.HospedajeDH.service.IAudit;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;

@RequiredArgsConstructor
public class BookingServiceTest {

    @InjectMocks
    @Spy
    BookingService bookingService;

    @Mock
    CityRepository ct;

    @Mock
    ProductRepository productRepository;

    @Mock
    BookingForClienteRepository bfr;

    @Mock
    private ObjectMapper mapper;

    @Mock
    FechasService fechasService;

    @Mock
    IAudit iAudit;

    @Mock
    CategoryRepository ca;

    @Before("")
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    /*
    @Test
    public void saveTest(){
        doNothing().when(fechasService).saveFechas(any(BookingDTO.class));
        assertNotNull(bookingService.save(BookingDTO.builder().startTime(null).startDate(null).endDate(null)
                .client_id(1L).product_id(2L).build()));
    }


     */


}
