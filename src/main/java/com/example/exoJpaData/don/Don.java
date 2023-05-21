package com.example.exoJpaData.don;

import com.example.exoJpaData.association.Association;
import com.example.exoJpaData.donnateur.Donnateur;
import jakarta.persistence.*;


@Entity
public class Don {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    int numDon;
    String type;
    int montant;
    String remarque;

    @ManyToOne
    @JoinColumn(name = "donnateur_id")
    private Donnateur donnateur;

    @ManyToOne
    @JoinColumn(name = "association_id")
    private Association association;

    public Don(){

    }

    public Don(Long id, int numDon, String type, int montant, String remarque) {
        this.id = id;
        this.numDon = numDon;
        this.type = type;
        this.montant = montant;
        this.remarque = remarque;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumDon() {
        return numDon;
    }

    public void setNumDon(int numDon) {
        this.numDon = numDon;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public String getRemarque() {
        return remarque;
    }

    public void setRemarque(String remarque) {
        this.remarque = remarque;
    }

    public Donnateur getDonnateur() {
        return donnateur;
    }

    public void setDonnateur(Donnateur donnateur) {
        this.donnateur = donnateur;
    }

    public Association getAssociation() {
        return association;
    }

    public void setAssociation(Association association) {
        this.association = association;
    }
}
