package com.site.SDE.Repository;

import com.site.SDE.Entite.Offre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OffreRepository extends JpaRepository<Offre,Long> {
    List<Offre> findEntrepriseById(Long id_e);
}