package com.example.projet.service;

import com.example.projet.model.entity.TypeDoc;
import com.example.projet.model.entity.Utilisateur;
import java.util.List;

public interface UtilisateurService {
    Utilisateur getUtilisateur(Long id);
    List<Utilisateur> getUtilisateurActiveList();
    List<Utilisateur> getUtilisateurNotActiveList();
    Utilisateur AddUtilisateur(Utilisateur utilisateur);
    Utilisateur UpdateUtilisateur(Long id,Utilisateur utilisateur);
    void DeleteUtilisateur(Long id);
    void ActiverUtilisateur(Long id);
}
