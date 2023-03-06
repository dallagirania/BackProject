package com.site.SDE.Service;

import com.site.SDE.Entite.Offre;

import java.util.List;
import java.util.Optional;

public interface OffreService {

    Offre ajouterOffre(Offre offre);
    Offre modifierOffre(Offre offre);
    List<Offre>lstOffres();
   Offre getOffreById(Long id);
    List<Offre> listeoffreByEntId(Long id);
    void supprimerOffre(Long id);
}