package com.site.SDE.Service;

import com.site.SDE.Entite.Offre;
import com.site.SDE.Repository.OffreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OffreServiceImpl implements OffreService{

    @Autowired
    OffreRepository offresRepository;

    @Override
    public Offre ajouterOffre(Offre offre) {
        return offresRepository.save(offre);
    }

    @Override
    public Offre modifierOffre(Offre offre) {
        return offresRepository.save(offre);
    }

    @Override
    public List<Offre> lstOffres() {
        return offresRepository.findAll();
    }

//    @Override
//    public Optional<Offre> getOffreById(Long id) {
//        return offresRepository.findById(id);
//    }
   @Override
    public Offre getOffreById(Long id) {
        Optional<Offre> offre = offresRepository.findById(id);

        if(offre.isPresent()) {
            return offre.get();
        }
        return null;
    }

    @Override
    public void supprimerOffre(Long id) {
        offresRepository.deleteById(id);

    }
    @Override
    public List<Offre> listeoffreByEntId(Long id) {
        return offresRepository.findEntrepriseById(id);
    }
}