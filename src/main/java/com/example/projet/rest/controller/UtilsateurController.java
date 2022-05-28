package com.example.projet.rest.controller;

import com.example.projet.model.entity.Utilisateur;
import com.example.projet.rest.dto.UtilisateurDto;
import com.example.projet.service.UtilisateurService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;

public class UtilsateurController {
    @Autowired
    private UtilisateurService utilisateurService ;
    @Autowired
    private ModelMapper modelMapper ;


    @GetMapping("/Utilisateurs")
    public Object Utilisateurlist() {
        List<Utilisateur> utilisateur= utilisateurService.getUtilisateurActiveList();
        Type listUser = new TypeToken<List<UtilisateurDto>>() {}.getType() ;
        List <Utilisateur> utilisateurDtos= modelMapper.map(utilisateur,listUser);
        return ResponseEntity.status(HttpStatus.OK).body(utilisateurDtos);
    }
    @GetMapping("/Utilisateurs/{idUtilisateur}")
    public Object UtilsateurById(@PathVariable Long idUtilisateur) {
        Utilisateur utilisateur= utilisateurService.getUtilisateur(idUtilisateur);
        UtilisateurDto dto= modelMapper.map(utilisateur, UtilisateurDto.class);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @GetMapping("/Utilisateurs/requests")
    public Object UtilisateurNotActivelist() {
        List<Utilisateur> utilisateur= utilisateurService.getUtilisateurNotActiveList();
        Type listUser = new TypeToken<List<UtilisateurDto>>() {}.getType() ;
        List <Utilisateur> utilisateurDtos= modelMapper.map(utilisateur,listUser);
        return ResponseEntity.status(HttpStatus.OK).body(utilisateurDtos);
    }

    @PutMapping ("/Utilisateurs/{idUtilisateur}/activate}")
    public void ActiverUtilisateur(@PathVariable Long idUtilisateur) {
        utilisateurService.ActiverUtilisateur(idUtilisateur);
    }

    @DeleteMapping("/Utilisateurs/{idUtilisateur}")
    public Object DeleteUtilisateur(@PathVariable Long idUtilisateur) {
        utilisateurService.DeleteUtilisateur(idUtilisateur);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
