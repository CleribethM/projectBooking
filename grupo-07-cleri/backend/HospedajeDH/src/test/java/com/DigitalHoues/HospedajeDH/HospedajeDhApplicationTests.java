package com.DigitalHoues.HospedajeDH;

import ch.qos.logback.core.net.ObjectWriter;
import com.DigitalHoues.HospedajeDH.controller.ProductController;
import com.DigitalHoues.HospedajeDH.dto.ProductDTO;
import com.DigitalHoues.HospedajeDH.dto.UserClientDTO;
import com.DigitalHoues.HospedajeDH.entities.Product;
import com.DigitalHoues.HospedajeDH.entities.UserClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.twilio.type.Client;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
class HospedajeDhApplicationTests {
/*

    @Autowired
    private MockMvc mvc;

    @Test
    void  FindAllProduct() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/public/api/v1/products")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void  FindAllCities() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/public/api/v1/cities/")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void  FindAllFeature() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/public/api/v1/features/")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void  FindAllFechas() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/public/api/v1/fechas/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void  FindAllImge() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/public/api/v1/images/")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void  FindAllFav() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/user/api/v1/fav/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isFound());
    }

    @Test
    void  FindAllCategory() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/public/api/v1/categories")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void  FindAllUser() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/admin/api/v1/users/")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void SaveUser() throws  Exception{

        mvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/public/api/v1/users/")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \n" +
                        "    \"name\": \"BookingG7\",\n" +
                        "    \"lastName\": \"DH\",\n" +
                        "    \"email\": \"bookinggrupo7@gmail.com\",\n" +
                        "    \"password\": \"secreto\",\n" +
                        "    \"phone\": 5092494\n" +
                        "             \n" +
                        "}"))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    void SaveFeature() throws  Exception{

        mvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/admin/api/v1/features/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "    \n" +
                                "    \"name\": \"TV\",\n" +
                                "    \"icon\": \"favTV\"\n" +
                                "    \n" +
                                "} "))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    void SaveCity() throws  Exception{

        mvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/admin/api/v1/cities/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "    \n" +
                                "    \"name\": \"Centro Historico\",\n" +
                                "    \"location\": \"Cartagena\",\n" +
                                "    \"country\": \"Colombia\",\n" +
                                "    \"postalcode\": 345234\n" +
                                "\n" +
                                "} "))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    void SaveCategory() throws  Exception{

        mvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/admin/api/v1/categories/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "    \n" +
                                "    \"title\": \"CASA1\",\n" +
                                "    \"description\" : \"Comoda casa\",\n" +
                                "    \"url\": \"https://www.google.com/imgres?imgurl=https%3A%2F%2Fdefinicion.de%2Fwp-content%2Fuploads%2F2011%2F01%2Fcasa-1.jpg&imgrefurl=https%3A%2F%2Fdefinicion.de%2Fcasa%2F&tbnid=OtkjXavqYWvSBM&vet=12ahUKEwjL8pP4xvv6AhVM4VMKHcNgCcYQMygDegUIARDeAg..i&docid=TjYh8Ph3yJ9eLM&w=640&h=426&q=casa&ved=2ahUKEwjL8pP4xvv6AhVM4VMKHcNgCcYQMygDegUIARDeAg\"\n" +
                                "}"))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    void SaveImage() throws  Exception{

        mvc.perform(MockMvcRequestBuilders.post("http://localhost:8080/admin/api/v1/images/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "    \n" +
                                "    \"title\" : \"Habitacion\",\n" +
                                "    \"url\": \"esto es una url\"\n" +
                                "   \n" +
                                "}"))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    void deleteImage() throws  Exception{

        mvc.perform(MockMvcRequestBuilders.delete("http://localhost:8080/admin/api/v1/images/1")
                        .accept(MediaType.APPLICATION_JSON))
                        .andDo(MockMvcResultHandlers.print())
                        .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void deleteCategory() throws  Exception{

        mvc.perform(MockMvcRequestBuilders.delete("http://localhost:8080/admin/api/v1/categories/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void deleteCity() throws  Exception{

        mvc.perform(MockMvcRequestBuilders.delete("http://localhost:8080/admin/api/v1/images/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void deleteUser() throws  Exception{

        mvc.perform(MockMvcRequestBuilders.delete("http://localhost:8080/admin/api/v1/users/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void deleteProduct() throws  Exception{

        mvc.perform(MockMvcRequestBuilders.delete("http://localhost:8080/admin/api/v1/products/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void deleteFav() throws  Exception{

        mvc.perform(MockMvcRequestBuilders.delete("http://localhost:8080/user/api/v1/fav/2")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void deleteBooking() throws  Exception{

        mvc.perform(MockMvcRequestBuilders.delete("http://localhost:8080/user/api/v1/booking/2/bookings")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void deleteFeature() throws  Exception{

        mvc.perform(MockMvcRequestBuilders.delete("http://localhost:8080/admin/api/v1/features/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

 */
}
