package com.example.exoJpaData.donnateur;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonnateurRepository extends JpaRepository<Donnateur, Long> {
}
