package com.site.SDE.Repository;

import com.site.SDE.Entite.Postulation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostulationRepository extends JpaRepository<Postulation,Long> {
     List<Postulation> findByFormateurId(long id);
     List<Postulation>findByOffreId(long id);
     boolean existsByFormateurIdAndOffreId(long idF,long idO);
}
