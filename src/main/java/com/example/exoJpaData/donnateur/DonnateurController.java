package com.example.exoJpaData.donnateur;

import com.example.exoJpaData.association.AssociationRepository;
import com.example.exoJpaData.don.DonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DonnateurController {
    @Autowired
    private DonnateurRepository donnateurRepository;
    @Autowired
    private DonRepository donRepository;
    @Autowired
    private AssociationRepository associationRepository;

    @GetMapping(value = "/donnateur")
    public List<Donnateur> getFindall(){

        return donnateurRepository.findAll();
    }

    @GetMapping(value = "/donnateur/{id}")
    public Optional<Donnateur> getFindById(@PathVariable ("id") Long id){

        return donnateurRepository.findById(id);
    }

    @DeleteMapping(value = "/donnateur{id}")
    public void deleteById(@PathVariable ("id") Long id){

        donnateurRepository.deleteById(id);
    }

    @PostMapping(value = "/donnateur")
    public void create(@RequestBody Donnateur donnateur){

        donnateurRepository.save(donnateur);

        }


    @PutMapping(value = "/donnateur/{id}")
    public void update(@PathVariable ("id") Long id, @RequestBody Donnateur donnateur){

        var donnateur2 = donnateurRepository.findById(id);
        if(donnateur2.isPresent()){
            donnateur.setId(id);
            donnateurRepository.save(donnateur);
        }

    }
}
