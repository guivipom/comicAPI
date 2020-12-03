package sevensenders.challenge.comic.controllers;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import sevensenders.challenge.api.domain.ComicCompilation;
import sevensenders.challenge.comic.services.ApiService;
import sevensenders.challenge.comic.services.ApiServiceImpl;

import java.util.ArrayList;
import java.util.List;



import static org.junit.Assert.*;
import static org.mockito.Mockito.when;


//@RunWith(SpringRunner.class)
//@WebMvcTest(ComicController.class)
public class ComicControllerTest {

    @Autowired
    private ApiService apiService;

    @Autowired
    private MockMvc mockMvc;


    ComicController controller;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);

        controller = new ComicController(this.apiService);
    }

    @Test
    @Ignore
    public void getCompilation() throws Exception {
        ComicCompilation comic = new ComicCompilation();
        List<ComicCompilation> comics = new ArrayList<>();
        comics.add(comic);

        when(apiService.getCompilation(1)).thenReturn(comics);

        ArgumentCaptor<List<ComicCompilation>> argumentCaptor = ArgumentCaptor.forClass(List.class);

        List<ComicCompilation> ListInController = argumentCaptor.getValue();

        assertEquals(1, ListInController.size());
    }

}