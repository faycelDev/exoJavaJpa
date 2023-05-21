package com.example.exoJpaData.association;

import com.example.exoJpaData.don.Don;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


import java.util.List;


@Entity
public class Association {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    String nomAss;
    @Column
    String dateAss;
    @Column
    String adresse;
    @Column
    String tel;
    @Column
    String secteurActivite;
    @JsonIgnore
    @OneToMany(mappedBy = "association")
    private List<Don> don;



    public Association(){

    }

    public Association(Long id, String nomAss, String dateAss, String adresse, String tel, String secteurActivite) {
        this.id = id;
        this.nomAss = nomAss;
        this.dateAss = dateAss;
        this.adresse = adresse;
        this.tel = tel;
        this.secteurActivite = secteurActivite;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getNomAss() {
        return nomAss;
    }

    public void setNomAss(String nomAss) {
        this.nomAss = nomAss;
    }

    public String getDateAss() {
        return dateAss;
    }

    public void setDateAss(String dateAss) {
        this.dateAss = dateAss;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getSecteurActivite() {
        return secteurActivite;
    }

    public void setSecteurActivite(String secteurActivite) {
        this.secteurActivite = secteurActivite;
    }

    public List<Don> getDon() {
        return don;
    }

    public void setDon(List<Don> don) {
        this.don = don;
    }


}
