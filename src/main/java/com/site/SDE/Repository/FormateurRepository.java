package com.site.SDE.Repository;

import com.site.SDE.Entite.Formateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormateurRepository extends JpaRepository<Formateur,Long> {
    Formateur findIdByEmail(String email);
    boolean existsByEmail(String email);
}
