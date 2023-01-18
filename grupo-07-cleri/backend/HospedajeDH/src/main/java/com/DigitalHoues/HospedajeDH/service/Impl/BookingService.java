package com.DigitalHoues.HospedajeDH.service.Impl;

import com.DigitalHoues.HospedajeDH.dto.BookingDTO;
import com.DigitalHoues.HospedajeDH.dto.BookingResponse;
import com.DigitalHoues.HospedajeDH.dto.ProductDTO;
import com.DigitalHoues.HospedajeDH.entities.*;
import com.DigitalHoues.HospedajeDH.exception.NotFoundException;
import com.DigitalHoues.HospedajeDH.repository.*;
import com.DigitalHoues.HospedajeDH.service.IAudit;
import com.DigitalHoues.HospedajeDH.service.IBookingService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookingService implements IBookingService{

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CityRepository ct;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    BookingForClienteRepository bfr;

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    FechasService fechasService;

    @Autowired
    IAudit iAudit;

    @Autowired
    CategoryRepository ca;



    @Override
    public BookingDTO save(BookingDTO bookingDTO){

        fechasService.saveFechas(bookingDTO);
        Booking booking = mapper.convertValue(bookingDTO, Booking.class);
        Product product = productRepository.findById(bookingDTO.getProduct_id())
                .orElseThrow(()-> new NotFoundException("Product does not exist"));

        booking.setProduct_id(bookingDTO.getProduct_id());
        Booking newBooking = bookingRepository.save(booking);

        String im =  product.getImage().toString();
        String [] parts = im.split("}");
        String part1 = parts[0];



        iAudit.saveAuditBooking(newBooking);
        Optional<City> city = ct.findById(product.getCity_id());
        Optional<Category> category = ca.findById(product.getCategory_id());

        BookingForCliente bfd = new BookingForCliente(newBooking.getClient_id(),
                newBooking.getId(),product.getTitle(),newBooking.getStartDate(),
                newBooking.getEndDate(), city.get().getName(), category.get().getTitle(), part1,
                product.getPunctuation(), bookingDTO.getProduct_id());
        bfr.save(bfd);
        return mapper.convertValue(newBooking, BookingDTO.class);
    }

    @Override
    public List<BookingResponse> findByProductId(Long productId){
        productRepository.findById(productId).orElseThrow(()-> new NotFoundException("Product does not exist"));
        List<Booking> bookings = bookingRepository.findByProductId(productId);
        List<BookingResponse> bookingsDTO = new ArrayList<>();
        bookings.forEach(booking -> bookingsDTO.add(mapper.convertValue(booking, BookingResponse.class)));
        return bookingsDTO;
    }

    @Override
    public List<BookingForCliente> BookingForCliente(Long client_id) {

       List<BookingForCliente> br = bfr.findByClient(client_id);
       return br;

    }

    @Override
    public void deleteBooking(Long id) {
        this.findById(id);
        bookingRepository.deleteById(id);
    }

    @Override
    public Optional<Booking> findById(Long id) {
        Booking br = bookingRepository.findById(id).orElseThrow(()-> new NotFoundException("Booking does not exist"));
        return Optional.ofNullable(br);
    }
}
