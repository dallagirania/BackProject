package com.site.SDE.RestController;


import com.site.SDE.Entite.Entreprise;
import com.site.SDE.Entite.Offre;
import com.site.SDE.Entite.OffreDto;
import com.site.SDE.Entite.modifOffre;
import com.site.SDE.Service.EntrepriseService;
import com.site.SDE.Service.OffreService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/offre")
public class OffreRestController {

    @Autowired
    OffreService offresService;
    @Autowired
    EntrepriseService entrepriseService;
    @Autowired
    private ModelMapper modelMapper;

//    @RequestMapping(method = RequestMethod.POST)
//    public Offre ajouterOffre(@RequestBody modifOffre offre){
////        System.out.println(offre.getId_e());
//        Optional<Entreprise>entreprise=entrepriseService.GetEntrepriseById(offre.getId_e());
//        System.out.println(entreprise);
//        if(entreprise.isPresent()) {
//            Offre off = new Offre();
//            off.setDatedeb(offre.getDatedeb());
//            off.setDatefin(offre.getDatefin());
//            off.setDescription(offre.getDescription());
//            off.setEtat(offre.isEtat());
//            off.setExperience(offre.getExperience());
//            off.setGenre(offre.getGenre());
//            off.setEntreprise(entreprise.get());
//            off.setLogo(offre.getLogo());
//            off.setLangue(offre.getLangue());
//            off.setNbpersonne(offre.getNbpersonne());
//            off.setNiveau(offre.getNiveau());
//            off.setSalaire(offre.getSalaire());
//            off.setTitre(offre.getTitre());
//            off.setType(offre.getType());
//            return offresService.ajouterOffre(off);
//        }
//        else{return null;}
//    }
     @RequestMapping(method = RequestMethod.POST)
    public OffreDto ajouterOffre(@RequestBody OffreDto offreDto){
        Offre offreRequest=modelMapper.map(offreDto,Offre.class);
        Offre offre=offresService.ajouterOffre(offreRequest);
        OffreDto offreResponse=modelMapper.map(offre,OffreDto.class);
    return offreResponse;
}
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Offre modifierOffre(@PathVariable("id")Long id,@RequestBody Offre offre){
        Offre newOffre=offresService.modifierOffre(offre);
        return newOffre;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void supprimerOffre(@PathVariable("id")Long id){
        offresService.supprimerOffre(id);
    }

//    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
//    public Optional<Offre>getOffreById(@PathVariable("id")Long id){
//        Optional<Offre>offre=offresService.getOffreById(id);
//        return offre;
//    }
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<OffreDto> getOffreById(@PathVariable("id")Long id){
    Offre offre=offresService.getOffreById(id);
    OffreDto offresDto=modelMapper.map(offre,OffreDto.class);
    return ResponseEntity.ok().body(offresDto);
}
//    @RequestMapping(method = RequestMethod.GET)
//    public List<Offre>lstOffres(){
//        return offresService.lstOffres();
//    }
    @RequestMapping(method = RequestMethod.GET)
    public List<OffreDto>lstOffres(){
        return offresService.lstOffres().stream().map(offres -> modelMapper.map(offres,OffreDto.class)).collect(Collectors.toList());
    }

    @GetMapping("list-offre-by-entreprise/{idE}")
    public List<Offre> listOffreByIdEnt(@PathVariable Long id) {
        return offresService.listeoffreByEntId(id);
    }
}