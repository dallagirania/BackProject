package com.site.SDE.Entite;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name="postulation")
@ToString

@AllArgsConstructor
public class Postulation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idP;

   private String cv;
   @OneToOne
    private Offre offre;
   @OneToOne
    private Formateur formateur;
   public Postulation( Offre offre,Formateur formateur, String cv)
      {
     this.offre=offre;
     this.formateur=formateur;
     this.cv=cv   ;
     }
}

