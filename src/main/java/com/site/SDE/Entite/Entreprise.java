package com.site.SDE.Entite;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
@AllArgsConstructor
public class Entreprise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private boolean etat=false;
    private String mdp;
    private String email;
    private String adr;
    private String tel;
    @Lob
    private String img;

     @OneToMany (mappedBy ="entreprise")
     private List<Offre> offre;

     @JsonManagedReference
     public List<Offre> getOffre() {
       return offre;
      }
}
