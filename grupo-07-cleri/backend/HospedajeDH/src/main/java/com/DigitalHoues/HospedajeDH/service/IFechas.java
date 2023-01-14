package com.DigitalHoues.HospedajeDH.service;

import com.DigitalHoues.HospedajeDH.dto.BookingDTO;
import com.DigitalHoues.HospedajeDH.entities.Fechas;

import java.util.List;
import java.util.Optional;

public interface IFechas {

    Fechas saveFechas(BookingDTO fechasDto);
    Optional<List<Fechas>> FechasForProduct(Long id);

}
