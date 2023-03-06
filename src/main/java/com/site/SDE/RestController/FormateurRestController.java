package com.site.SDE.RestController;


import com.site.SDE.Entite.Formateur;

import com.site.SDE.Repository.FormateurRepository;
import com.site.SDE.Service.FormateurService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/formateur")
public class FormateurRestController {
    @Autowired
    private FormateurRepository formateurRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    @Autowired
    public FormateurRestController(FormateurRepository candidatRepository) {this.formateurRepository=formateurRepository;}

    @PostMapping(path = "loginformateur")
    public ResponseEntity<Map<String, Object>> loginFormateur(@RequestBody Formateur formateur) {

        HashMap<String, Object> response = new HashMap<>();

        Formateur userFromDB =formateurRepository.findIdByEmail(formateur.getEmail());

        if (userFromDB == null) {
            response.put("message", "Formateur not found !");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }  else {
            String token = Jwts.builder()
                    .claim("data", userFromDB)
                    .signWith(SignatureAlgorithm.HS256, "SECRET")
                    .compact();
            response.put("token", token);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
    }
    @PostMapping(path = "registerformateur")
    public ResponseEntity<?> addFormateur(@RequestBody Formateur formateur) {
        if(formateurRepository.existsByEmail(formateur.getEmail()))
            return new ResponseEntity<Void>(HttpStatus.FOUND);
        formateur.setMdp(this.bCryptPasswordEncoder.encode(formateur.getMdp()));
        Formateur savedUser = formateurRepository.save(formateur);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }
    @Autowired
    FormateurService formateurService;

    @RequestMapping(method = RequestMethod.POST)
    public Formateur ajouterFormateur (@RequestBody Formateur formateur){
        return formateurService.ajouterFormateur(formateur);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Formateur modifierFormateur(@PathVariable("id")Long id,@RequestBody Formateur formateur){
        Formateur newFormateur=formateurService.modifierFormateur(formateur);
        return newFormateur;
    }
    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    public Optional<Formateur> GetFormateurById(@PathVariable("id")Long id){
        Optional<Formateur>formateur=formateurService.GetFormateurById(id);
        return formateur;
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void suprrimerformateur(@PathVariable("id")Long id){
        formateurService.supprimerById(id);
    }
    @RequestMapping(method = RequestMethod.GET)
    public List<Formateur>listFormateur(){
        return formateurService.listFormateur();
    }


}
