package com.example.exoJpaData.don;

import com.example.exoJpaData.association.AssociationRepository;
import com.example.exoJpaData.donnateur.Donnateur;
import com.example.exoJpaData.donnateur.DonnateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DonControlleur {
    @Autowired
    private DonRepository donRepository;
    @Autowired
    private DonnateurRepository donnateurRepository;
    @Autowired

    private AssociationRepository associationRepository;

    @GetMapping(value = "/don")
    public List<Don> getFindall(){

        return donRepository.findAll();
    }

    @GetMapping(value = "/don/{id}")
    public Optional<Don> getFindById(@PathVariable("id") Long id, @RequestBody Don don){

        return donRepository.findById(id);
    }

    @DeleteMapping(value = "/don/{id}")
    public void deleteById(@PathVariable ("id") Long id){

        donRepository.deleteById(id);
    }

    @PostMapping(value = "/don/{idDonnateur}/{idAsso}")
    public void create(@PathVariable ("idDonnateur") Long idDonnateur, @PathVariable ("idAsso") Long idAsso, @RequestBody Don don){

      var assoc = associationRepository.findById(idAsso);
      var donnateur = donnateurRepository.findById(idDonnateur);
      if(assoc.isPresent() && donnateur.isPresent()){

          don.setAssociation(assoc.get());
          don.setDonnateur(donnateur.get());
          donRepository.save(don);
      }

    }


    @PutMapping(value = "/don/{id}")
    public void update(@PathVariable ("id") Long id, @RequestBody Don don){

        var don2 = donRepository.findById(id);
        if(don2.isPresent()){
            don.setId(id);
            donRepository.save(don);
        }

    }
}
