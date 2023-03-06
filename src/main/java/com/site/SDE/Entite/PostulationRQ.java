package com.site.SDE.Entite;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostulationRQ {

    private Long idOffre;
    private Long idFormateur;
    @Lob
    private String cv;

}
