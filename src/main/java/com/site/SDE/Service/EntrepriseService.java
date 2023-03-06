package com.site.SDE.Service;
import com.site.SDE.Entite.Entreprise;

import java.util.List;
import java.util.Optional;

public interface EntrepriseService {
    Entreprise ajouterEntreprise(Entreprise entreprise);
    Entreprise modifierEntreprise(Entreprise entreprise);
    List<Entreprise>listEntreprise();
    void supprimerById(Long id);
    Optional<Entreprise>FindById(Long id);


}
