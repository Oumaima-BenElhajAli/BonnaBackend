package com.example.projet.repository;

import com.example.projet.model.entity.Utilisateur;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UtilisateurRepository extends CrudRepository<Utilisateur,Long> {
    Utilisateur findByUsernameAndPassword(String username,String password);
    List<Utilisateur> findByActive(int active);
}
