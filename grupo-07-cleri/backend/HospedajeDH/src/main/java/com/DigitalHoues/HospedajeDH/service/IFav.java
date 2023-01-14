package com.DigitalHoues.HospedajeDH.service;

import com.DigitalHoues.HospedajeDH.dto.BookingDTO;
import com.DigitalHoues.HospedajeDH.dto.FavDTO;
import com.DigitalHoues.HospedajeDH.entities.Fav;
import com.DigitalHoues.HospedajeDH.entities.Fechas;

import java.util.List;
import java.util.Optional;

public interface IFav {

    Fav saveFav(FavDTO fav);
    List<Fav> FavForClien(Long id);
    void deletFavForClient(Long id);

}
