package com.example.api_livre.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "livre")
public class Livre {
    private @Id @GeneratedValue Long id;
    private String titre;

    private String auteur;
    private String edition;
    private String description;
    public Livre(){}

    public Livre(String titre, String auteur, String edition, String description) {
        this.titre = titre;
        this.auteur = auteur;
        this.edition = edition;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
