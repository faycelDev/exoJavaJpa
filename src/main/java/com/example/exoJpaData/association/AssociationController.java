package com.example.exoJpaData.association;


import com.example.exoJpaData.don.DonRepository;
import com.example.exoJpaData.donnateur.Donnateur;
import com.example.exoJpaData.donnateur.DonnateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
public class AssociationController {
    @Autowired
    private AssociationRepository associationRepository;
    @Autowired
    private DonRepository donRepository;
    @Autowired
    private DonnateurRepository donnateurRepository;



    @GetMapping(value = "/asso")
    public List<Association> getFindAll(){

        return  associationRepository.findAll();
    }

    @GetMapping(value = "/asso/{id}")
    public Optional<Association> getFindById(@PathVariable("id") Long id, @RequestBody Association association){

        return associationRepository.findById(id);
    }

    @DeleteMapping(value = "/asso{id}")
    public void deleteById(@PathVariable ("id") Long id){

        associationRepository.deleteById(id);
    }

    @PostMapping(value = "/asso")
    public void create(@RequestBody Association association){



           associationRepository.save(association);
       }





    @PutMapping(value = "/asso/{id}")
    public void update(@PathVariable ("id") Long id, @RequestBody Association association2){

                var asso = associationRepository.findById(id);
                if(asso.isPresent()){
                    association2.setId(id);
                    associationRepository.save(association2);
                }

        }
}
