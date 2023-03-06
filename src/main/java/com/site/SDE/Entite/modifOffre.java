package com.site.SDE.Entite;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Lob;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class modifOffre {
    private Long id_e;
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
}
