package com.site.SDE.Service;

import com.site.SDE.Entite.Postulation;
import com.site.SDE.Entite.PostulationRQ;

import java.util.List;
import java.util.Optional;

public interface PostulationService {
    Postulation ajouterPostulation(PostulationRQ postulation);

    List<Postulation>listPostulationByFormateurId(long id);
    List<Postulation>listPostulationByEntrepriseId(long id);

}