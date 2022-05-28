package com.example.projet.service.Imp;

import com.example.projet.model.entity.Utilisateur;
import com.example.projet.repository.UtilisateurRepository;
import com.example.projet.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UtilisateurImpService implements UtilisateurService {
    @Autowired
    private UtilisateurRepository utilisateurRepository ;

    @Override
    public Utilisateur getUtilisateur(Long id) { return utilisateurRepository.findById(id).get(); }

    @Override
    public List<Utilisateur> getUtilisateurActiveList() { return (List<Utilisateur>)utilisateurRepository.findByActive(1); }
    @Override
    public List<Utilisateur> getUtilisateurNotActiveList() { return (List<Utilisateur>)utilisateurRepository.findByActive(0); }
    @Override
    public Utilisateur AddUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    @Override
    public Utilisateur UpdateUtilisateur(Long id, Utilisateur utilisateur) {
        getUtilisateur(id);
        utilisateur.setId(id);
        return utilisateurRepository.save(utilisateur);
    }

    @Override
    public void DeleteUtilisateur(Long id) {
        utilisateurRepository.deleteById(id);
    }

    @Override
    public void ActiverUtilisateur(Long id) {
    Utilisateur user= utilisateurRepository.findById(id).get();
    user.setActive(1);
    }
}
