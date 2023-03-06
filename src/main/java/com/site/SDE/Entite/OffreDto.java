package com.site.SDE.Entite;

import lombok.*;

import javax.persistence.Lob;
import java.io.Serializable;
@Data
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
public class OffreDto implements Serializable {
    private Long id;
    private String titre;
    private boolean etat=false;
    private String description;
    private String experience;
    private String genre;
    private long nbpersonne;
    private String logo;
    private String type;
    private String niveau;
    private String salaire;
    private String datedeb;
    private String datefin;
    private String langue;
    private Entreprise entreprise;
}
