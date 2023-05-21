package com.example.exoJpaData.donnateur;

import com.example.exoJpaData.association.Association;
import com.example.exoJpaData.don.Don;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Donnateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    int numDonnateur;
    @Column
    String nom;
    @Column
    String prenom;
    @Column
    String email;
    @JsonIgnore
    @OneToMany(mappedBy = "donnateur")
    private List<Don> don;

    public Donnateur(){
    }

    public Donnateur(Long id, int numDonnateur, String nom, String prenom, String email) {
        this.id = id;
        this.numDonnateur = numDonnateur;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumDonnateur() {
        return numDonnateur;
    }

    public void setNumDonnateur(int numDonnateur) {
        this.numDonnateur = numDonnateur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Don> getDon() {
        return don;
    }

    public void setDon(List<Don> don) {
        this.don = don;
    }
}
