package com.DigitalHoues.HospedajeDH.service.Impl;

import com.DigitalHoues.HospedajeDH.dto.BookingDTO;
import com.DigitalHoues.HospedajeDH.dto.ProductDTO;
import com.DigitalHoues.HospedajeDH.entities.Fechas;
import com.DigitalHoues.HospedajeDH.entities.Product;
import com.DigitalHoues.HospedajeDH.repository.FechasRepository;
import com.DigitalHoues.HospedajeDH.service.IFechas;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.web.servlet.oauth2.resourceserver.OpaqueTokenDsl;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FechasService implements IFechas {

    @Autowired
    FechasRepository fechasRepository;

    @Autowired
    ObjectMapper mapper;



    @Override
    public Fechas saveFechas(BookingDTO fechasDto) {



        ArrayList<BookingDTO> fe = new ArrayList<>();
        fe.add(fechasDto);
        LocalDate fechaIn = fe.get(0).getStartDate();
        LocalDate fechaFinal = fe.get(0).getEndDate();
        Long product = fe.get(0).getProduct_id();

        Fechas fss = new Fechas(fechaIn,product);
        fechasRepository.save(fss);

        while (fechaIn.isBefore (fechaFinal.plusDays(0))){
            fechaIn = fechaIn.plusDays(1);
            Fechas fs = new Fechas(fechaIn,product);
            fechasRepository.save(fs);
        }
         return fss;

    }

    public Optional<List<Fechas>> FechasForProduct(Long id){
        Optional<List<Fechas>> fechasNoDisponibles  = fechasRepository.FechasForProduct(id);
        return fechasNoDisponibles;

    }



}
