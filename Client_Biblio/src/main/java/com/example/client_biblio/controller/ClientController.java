package com.example.client_biblio.controller;

import com.example.client_biblio.model.Emprunteur;
import com.example.client_biblio.model.Livre;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class ClientController {
    private RestTemplate restTemplate;
    @GetMapping("/")
    public String index(Model model){
        this.restTemplate = new RestTemplate();
        String url = "http://localhost:8080/api_livre/livres";
        ResponseEntity<List<Livre>> response = restTemplate.exchange(url,
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Livre>>() {});
        List<Livre> livres = response.getBody();
        model.addAttribute("livres", livres);
        return "index";
    }
    @GetMapping("/emprunteur")
    public String emprunteur(Model model){

        this.restTemplate = new RestTemplate();
        String url = "http://localhost:8080/api_livre/emprunteur";
        ResponseEntity<List<Emprunteur>> response = restTemplate.exchange(url,
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Emprunteur>>() {});
        List<Emprunteur> emprunteurs = response.getBody();
        model.addAttribute("emprunteurs", emprunteurs);
        return "emprunteur";
    }
    @GetMapping("/emprunteur/form/add")
    public String formEmprunteur(Model model){
        Emprunteur emprunteur = new Emprunteur();
        model.addAttribute("emprunteur", emprunteur);
        return "ajouterunemprunteur";
    }
    @PostMapping("/emprunteur/form/add")
    public String addEmprunteur(@ModelAttribute("emprunteur") Emprunteur emprunteur) {
        this.restTemplate = new RestTemplate();
        String url = "http://localhost:8080/api_livre/emprunteur";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Emprunteur> request = new HttpEntity<>(emprunteur, headers);
        ResponseEntity<Emprunteur> response = restTemplate.postForEntity(url, request, Emprunteur.class);
        return "redirect:/emprunteur";
    }

    /*-------------------------------------------*/
    /*         AJOUTER UN LIVRE                  */
    /*-------------------------------------------*/
    @GetMapping("/livre/form/add")
    public String formLivre(Model model) {
        Livre livre = new Livre();
        model.addAttribute("livre", livre);
        return "ajouterlivre";
    }
    @PostMapping("/livre/form/add")
    public String addLivre(@ModelAttribute("livre") Livre livre) {
        this.restTemplate = new RestTemplate();
        String url = "http://localhost:8080/api_livre/livres";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Livre> request = new HttpEntity<>(livre, headers);
        ResponseEntity<Livre> response = restTemplate.postForEntity(url, request, Livre.class);
        return "redirect:/";
    }
    /*-------------------------------------------*/
    /*         MODIFIER UN LIVRE                 */
    /*-------------------------------------------*/
    @GetMapping("/livre/maj/{id}")
    public String majLivre(Model model, @PathVariable long id) {
        this.restTemplate = new RestTemplate();
        String url = "http://localhost:8080/api_livre/livres/{id}";
        ResponseEntity<Livre> response = restTemplate.getForEntity(url,
                Livre.class, id);
        Livre ll = response.getBody();
        model.addAttribute("livre", ll);
        return "ajouterlivre";
    }
    @PostMapping("/livre/maj/{id}")
    public String updateLivre(@ModelAttribute("livre") Livre livre,
                              @PathVariable long id) {
        this.restTemplate = new RestTemplate();
        String url = "http://localhost:8080/api_livre/livre/{id}";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Livre> request = new HttpEntity<>(livre, headers);
        ResponseEntity<Livre> response = restTemplate.exchange(url,
                HttpMethod.PUT, request, Livre.class, id);
        return "redirect:/";
    }
    /*-------------------------------------------*/
    /*         DETAIL D' UN LIVRE                 */
    /*-------------------------------------------*/

    @GetMapping("/livre/{id}")
    public String getLivre(Model model, @PathVariable long id) {
        this.restTemplate = new RestTemplate();
        String url = "http://localhost:8080/api_livre/livres/{id}";
        ResponseEntity<Livre> response = restTemplate.getForEntity(url,
                Livre.class, id);
        Livre livre = response.getBody();
        model.addAttribute("livre", livre);
        return "livre";
    }
    /*-------------------------------------------*/
    /*         SUPPRESSION D' UN LIVRE           */
    /*-------------------------------------------*/
    @GetMapping("/livre/del/{id}")
    public String delLivre(Model model, @PathVariable long id) {
        this.restTemplate = new RestTemplate();
        String url = "http://localhost:8080/api_livre/livres/{id}";
        restTemplate.delete(url, id);
        return "redirect:/";
    }

    @GetMapping("/emprunteur/maj/{id}")
    public String majEmprunteur(Model model, @PathVariable long id) {
        this.restTemplate = new RestTemplate();
        String url = "http://localhost:8080/api_livre/emprunteur/{id}";
        ResponseEntity<Emprunteur> response = restTemplate.getForEntity(url,
                Emprunteur.class, id);
        Emprunteur ll = response.getBody();
        model.addAttribute("emprunteur", ll);
        return "ajouterunemprunteur";
    }
    @PostMapping("/emprunteur/maj/{id}")
    public String updateEmprunteur(@ModelAttribute("emprunteur") Emprunteur emprunteur,
                              @PathVariable long id) {
        this.restTemplate = new RestTemplate();
        String url = "http://localhost:8080/api_livre/emprunteur/{id}";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Emprunteur> request = new HttpEntity<>(emprunteur, headers);
        ResponseEntity<Emprunteur> response = restTemplate.exchange(url,
                HttpMethod.PUT, request, Emprunteur.class, id);
        return "redirect:/emprunteur";
    }
    @GetMapping("/emprunteur/del/{id}")
    public String delEmprunteur(Model model, @PathVariable long id) {
        this.restTemplate = new RestTemplate();
        String url = "http://localhost:8080/api_livre/emprunteur/{id}";
        restTemplate.delete(url, id);
        return "redirect:/emprunteur";
    }

}
