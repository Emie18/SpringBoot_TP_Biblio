package com.example.client_biblio;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.http.MediaType;
@SpringBootTest
@AutoConfigureMockMvc
public class BiblioClientTests {
    @Autowired
    public MockMvc mockMvc;
    @Test
    void contextLoad(){

    }
    @Test
    public void TestIndex()throws Exception{
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(content().string(containsString("Le Matre du Haut Chteau")));
    }
    @Test
    public void TestGetLivre()throws Exception{
        mockMvc.perform(get("/livre/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("livre"))
                .andExpect(content().string(containsString("Le Matre du Haut Chteau")));
    }
    @Test
    public void testFormLivre() throws Exception{
        mockMvc.perform(get("/livres/form/add"))
                .andExpect(status().isOk())
                .andExpect(view().name("ajouterlivre"));
    }
    @Test
    public void testAddLivre() throws Exception{
        mockMvc.perform(post("/livre/form/add")
                        .param("titre", "John Doe")
                        .param("auteur", "Emilie Le Rouzic")
                        .param("edition", "Hachette")
                        .param("description", "point faible: trop forte")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/"));
    }
    @Test
    public void testMajLivre() throws Exception{
        mockMvc.perform(get("/livre/3"))
                .andExpect(status().isOk())
                .andExpect(view().name("livre"))
                .andExpect(content().string(containsString("Gontier")));
    }
    @Test
    public void testUpdateLivre() throws Exception{
        mockMvc.perform(post("/livre/maj/3")
                        .param("titre", "Erich Gamma")
                        .param("auteur", "Holland")
                        .param("edition", "Gontier")
                        .param("description", "bla blo blu")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/"));
    }
    @Test
    public void testDeleteLivre() throws Exception {
        mockMvc.perform(get("/livre/del/{id}", 3))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/"));
    }
    /*--------------------------------------------*/
    /*         TEST EMPRUNTEUR                    */
    /*--------------------------------------------*/
    @Test
    public void TestListEmprunteur()throws Exception{
        mockMvc.perform(get("/emprunteur"))
                .andExpect(status().isOk())
                .andExpect(view().name("emprunteur"))
                .andExpect(content().string(containsString("Sven")));
    }
    @Test
    public void testFormEmprunteur() throws Exception{
        mockMvc.perform(get("/emprunteur/form/add"))
                .andExpect(status().isOk())
                .andExpect(view().name("ajouterunemprunteur"));
    }
    @Test
    public void testAddEmprunteur() throws Exception{
        mockMvc.perform(post("/emprunteur/form/add")
                        .param("nom", "Emilie")
                        .param("numero", "18012002")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/emprunteur"));
    }
    @Test
    public void testUpdateEmprunteur() throws Exception{
        mockMvc.perform(post("/emprunteur/maj/2")
                        .param("nom", "Erich Gamma")
                        .param("numero", "Holland")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/emprunteur"));
    }
    @Test
    public void testDeleteEmprunteur() throws Exception {
        mockMvc.perform(get("/emprunteur/del/{id}", 4))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/emprunteur"));
    }

}
