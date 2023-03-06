package com.site.SDE.RestController;

import com.site.SDE.Entite.Admin;
import com.site.SDE.Entite.Entreprise;
import com.site.SDE.Repository.AdminRepository;
import com.site.SDE.Repository.EntrepriseRepository;
import com.site.SDE.Service.EntrepriseService;
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
@RequestMapping(value = "/entreprise")
public class EntrepriseRestController {

    @Autowired
    private EntrepriseRepository entrepriseRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    @Autowired
    public EntrepriseRestController(EntrepriseRepository candidatRepository) {this.entrepriseRepository= entrepriseRepository;}

    @PostMapping(path = "loginentreprise")
    public ResponseEntity<Map<String, Object>> loginEntreprie(@RequestBody Entreprise entreprise) {
       // System.out.println("loginentreprise"+entreprise.getIdE());
        HashMap<String, Object> response = new HashMap<>();

        Entreprise userFromDB = entrepriseRepository.findIdByEmail(entreprise.getEmail());

        if (userFromDB == null) {
            response.put("message", "Entreprise not found !");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        } else {

            Boolean compare = this.bCryptPasswordEncoder.matches(entreprise.getMdp(), userFromDB.getMdp());

            if (!compare) {
                response.put("message", "Entreprise not found !");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            } else {
                if (!userFromDB.isEtat()) {
                    response.put("message", "Entreprise not allowed !");
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
                } else {
            String token = Jwts.builder()
                    .claim("data", userFromDB)
                    .signWith(SignatureAlgorithm.HS256, "SECRET")
                    .compact();
            response.put("token", token);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }}
    }}
    @PostMapping(path = "registerentreprise")
    public ResponseEntity<?> addEntreprise(@RequestBody Entreprise entreprise) {
        if((entrepriseRepository).existsByEmail(entreprise.getEmail()))
            return new ResponseEntity<Void>(HttpStatus.FOUND);
        entreprise.setMdp(this.bCryptPasswordEncoder.encode(entreprise.getMdp()));
        Entreprise savedUser = entrepriseRepository.save(entreprise);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }
    @Autowired
    EntrepriseService entrepriseService;
    @RequestMapping(method = RequestMethod.POST)
    public Entreprise ajouterEntreprise(@RequestBody Entreprise entreprise){
        return entrepriseService.ajouterEntreprise(entreprise);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Entreprise modifierAdmin(@PathVariable("id")Long id,@RequestBody Entreprise entreprise){
        Entreprise newEntreprise=entrepriseService.modifierEntreprise(entreprise);
        return newEntreprise;
    }
    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    public Optional<Entreprise>GetEntrepriseById(@PathVariable("id")Long id){
        Optional<Entreprise>entreprise=entrepriseService.FindById(id);
        return entreprise;
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void suprrimerEntreprise(@PathVariable("id")Long id){
        entrepriseService.supprimerById(id);
    }
    @RequestMapping(method = RequestMethod.GET)
    public List<Entreprise> listEntreprise(){
        return entrepriseService.listEntreprise();
    }

    @RequestMapping(method = RequestMethod.GET,value = "GetEntrepriseByOffreId/{id}")
    public Entreprise findEntrepriseByOffreId(@PathVariable("id")Long id){
        Entreprise newEntreprise=entrepriseRepository.findEntrepriseByOffreId(id);
        return newEntreprise;
    }
}
