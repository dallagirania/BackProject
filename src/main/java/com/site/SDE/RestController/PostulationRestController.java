package com.site.SDE.RestController;

import com.site.SDE.Entite.Postulation;
import com.site.SDE.Entite.PostulationRQ;
import com.site.SDE.Service.PostulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@CrossOrigin("*")
@RequestMapping (value = "/postulation")
public class PostulationRestController {
    @Autowired
    PostulationService postulationService;
    @RequestMapping(method = RequestMethod.POST)
    public Postulation ajouterPostulation(@RequestBody PostulationRQ postulation)
    {
        return (Postulation)postulationService.ajouterPostulation(postulation);
    }
    @GetMapping("/listPostulationFormateur/{id}")
    public List<Postulation>postulationFormateur(@PathVariable long id){
        return postulationService.listPostulationByFormateurId(id);
    }
    @GetMapping("/listPostulationOffre/{id}")
    public List<Postulation>postulationOffre(@PathVariable long id){
        return postulationService.listPostulationByEntrepriseId(id);
    }



}
