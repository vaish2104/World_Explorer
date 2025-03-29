package com.stackroute.favourites.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.any;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.context.junit4.SpringRunner;
import com.stackroute.favourites.model.Favourites;
import com.stackroute.favourites.service.FavouritesService;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest
public class FavouritesControllerTests {


    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    private Favourites favourites;
    
    @MockBean
    FavouritesService favouritesService;
    
    @InjectMocks
    FavouritesController favouritesController;
    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(favouritesController).build();
        favourites = new Favourites();
		favourites.setCId(122);
		favourites.setCommon_name("India");
		favourites.setCapital("New Delhi");
		favourites.setFlag("https://flagcdn.com/w320/in.png");
		favourites.setOfficialname("Republic of India");
		favourites.setArea(3287590.0);
		favourites.setCoatOfArms("https://mainfacts.com/media/images/coats_of_arms/in.png");
		favourites.setPopulation(1380004385);
		favourites.setUsername("shiv@gmail.com");
		favourites.setStatus(true);
    }
    
    
    @Test
    public void addFavSuccess() throws Exception  {
        when(favouritesService.addData(any())).thenReturn(true);
        mockMvc.perform(post("/api/fav")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(favourites)))
                .andExpect(status().isCreated()).andDo(MockMvcResultHandlers.print());
    }
    
    
    @Test
    public void addFavFailure() throws Exception {
        when(favouritesService.addData(any())).thenReturn(false);
        mockMvc.perform(post("/api/fav")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(favourites)))
                .andExpect(status().isConflict()).andDo(MockMvcResultHandlers.print());
    }
   
   
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
