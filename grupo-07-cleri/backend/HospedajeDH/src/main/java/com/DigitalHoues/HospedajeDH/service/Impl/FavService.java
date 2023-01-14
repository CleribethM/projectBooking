package com.DigitalHoues.HospedajeDH.service.Impl;

import com.DigitalHoues.HospedajeDH.dto.FavDTO;
import com.DigitalHoues.HospedajeDH.entities.Category;
import com.DigitalHoues.HospedajeDH.entities.City;
import com.DigitalHoues.HospedajeDH.entities.Fav;
import com.DigitalHoues.HospedajeDH.entities.Product;
import com.DigitalHoues.HospedajeDH.exception.NotFoundException;
import com.DigitalHoues.HospedajeDH.repository.CategoryRepository;
import com.DigitalHoues.HospedajeDH.repository.CityRepository;
import com.DigitalHoues.HospedajeDH.repository.FavRepository;
import com.DigitalHoues.HospedajeDH.repository.ProductRepository;
import com.DigitalHoues.HospedajeDH.service.IFav;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FavService implements IFav {

    @Autowired
    FavRepository favRepository;

    @Autowired
    ProductRepository pr;

    @Autowired
    CategoryRepository ct;

    @Autowired
    CityRepository ci;


    @Override
    public Fav saveFav(FavDTO favDTO) {

        Product pro = pr.findById(favDTO.getProduct_id())
                .orElseThrow(()-> new NotFoundException("Product does not exist"));

        String title = pro.getTitle();
        Long idCity = pro.getCity_id();
        Long idCategory = pro.getCategory_id();
        City city = ci.findById(idCity)
                .orElseThrow(()-> new NotFoundException("City does not exist"));
        String cit = city.getName();
        Category category = ct.findById(idCategory)
                .orElseThrow(()-> new NotFoundException("Category does not exist"));
        String cate = category.getTitle();

        String im = pro.getImage().toString();
        String [] parts = im.split("}");
        String part1 = parts[0];

        Fav fv = new Fav(favDTO.getId_client(),pro.getTitle(),
                cit,cate,part1,pro.getPunctuation(),favDTO.getProduct_id());

        favRepository.save(fv);
        return fv;

    }

    @Override
    public List<Fav> FavForClien(Long id) {
         List<Fav> fv = favRepository.findByClient(id);

         return fv;
    }

    @Override
    public void deletFavForClient(Long id) {
       favRepository.deleteById(id);
    }
}
