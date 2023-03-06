package com.site.SDE.Service;

import com.site.SDE.Entite.Formateur;
import com.site.SDE.Repository.FormateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FormateurServiceImpl implements FormateurService{
    @Autowired
    FormateurRepository formateurRepository;
    @Override
    public Formateur ajouterFormateur(Formateur formateur) {
        return formateurRepository.save(formateur);
    }

    @Override
    public Formateur modifierFormateur(Formateur formateur) {
        return formateurRepository.save(formateur);
    }

    @Override
    public List<Formateur> listFormateur() {
        return formateurRepository.findAll();
    }

    @Override
    public void supprimerById(Long id) {
        formateurRepository.deleteById(id);
    }

    @Override
    public Optional<Formateur> GetFormateurById(Long id) {
        return  formateurRepository.findById(id);
    }
}
