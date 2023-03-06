package com.site.SDE.Repository;

import com.site.SDE.Entite.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
   Admin findIdByEmail(String email);
   boolean existsByEmail(String email);
}
