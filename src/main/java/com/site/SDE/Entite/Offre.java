package com.site.SDE.Entite;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Blob;
import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter

@Entity
public class Offre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private boolean etat=false;


    private String description;
    private String experience;
    private String genre;
    private long nbpersonne;
    @Lob
    private String logo;
    private String type;
    private String niveau;
    private String salaire;
    private String datedeb;
    private String datefin;
    private String langue;
    @ManyToOne
    @JoinColumn(name="entrepriseId")
    private Entreprise entreprise;

    public Long getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public boolean isEtat() {
        return etat;
    }

    public String getDescription() {
        return description;
    }

    public String getExperience() {
        return experience;
    }

    public String getGenre() {
        return genre;
    }

    public long getNbpersonne() {
        return nbpersonne;
    }

    public String getLogo() {
        return logo;
    }

    public String getType() {
        return type;
    }

    public String getNiveau() {
        return niveau;
    }

    public String getSalaire() {
        return salaire;
    }

    public String getDatedeb() {
        return datedeb;
    }

    public String getDatefin() {
        return datefin;
    }

    public String getLangue() {
        return langue;
    }
    @JsonBackReference
    public Entreprise getEntreprise() {
         return entreprise;
      }

}
