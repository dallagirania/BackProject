package com.site.SDE.Service;
import com.site.SDE.Entite.Formateur;

import java.util.List;
import java.util.Optional;

public interface FormateurService {
    Formateur ajouterFormateur(Formateur formateur);
    Formateur modifierFormateur(Formateur formateur);
    List<Formateur>listFormateur();
    void supprimerById(Long id);
    Optional<Formateur>GetFormateurById(Long id);
}
