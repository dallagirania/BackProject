package com.site.SDE.RestController;
import com.site.SDE.Entite.Admin;
import com.site.SDE.Repository.AdminRepository;
import com.site.SDE.Service.AdminService;
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
@RequestMapping (value = "/admin")
public class AdminRestController {
    @Autowired
    private AdminRepository adminRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    @Autowired
    public AdminRestController(AdminRepository candidatRepository) {this.adminRepository= adminRepository;}

    @PostMapping(path = "loginadmin")
    public ResponseEntity<Map<String, Object>> loginAdmin(@RequestBody Admin admin) {

        HashMap<String, Object> response = new HashMap<>();

        Admin userFromDB = adminRepository.findIdByEmail(admin.getEmail());

        if (userFromDB == null) {
            response.put("message", "Admin not found !");
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
    @PostMapping(path = "registeradmin")
    public ResponseEntity<?> addAdmin(@RequestBody Admin admin) {
        if(adminRepository.existsByEmail(admin.getEmail()))
            return new ResponseEntity<Void>(HttpStatus.FOUND);
        admin.setMdp(this.bCryptPasswordEncoder.encode(admin.getMdp()));
        Admin savedUser = adminRepository.save(admin);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }
    @Autowired
    AdminService adminService;

    @RequestMapping(method = RequestMethod.POST)
    public Admin ajouterAdmin(@RequestBody Admin admin){
        return adminService.ajouterAdmin(admin);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Admin modifierAdmin(@PathVariable("id")Long id,@RequestBody Admin admin){
        Admin newAdmin=adminService.modifierAdmin(admin);
        return newAdmin;
    }
    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    public Optional<Admin>GetAdminById(@PathVariable("id")Long id){
        Optional<Admin>admin=adminService.GetAdminById(id);
        return admin;
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void suprrimerAdmin(@PathVariable("id")Long id){
        adminService.supprimerById(id);
    }
    @RequestMapping(method = RequestMethod.GET)
    public List<Admin>listAdmin(){
        return adminService.listAdmin();
    }


}