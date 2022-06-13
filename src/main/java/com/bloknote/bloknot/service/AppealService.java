package com.bloknote.bloknot.service;

import com.bloknote.bloknot.model.Appeal;
import com.bloknote.bloknot.repository.AppealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppealService {

    private final AppealRepository appealRepository;

    @Autowired
    public AppealService(AppealRepository appealRepository) {
        this.appealRepository = appealRepository;
    }


    public Appeal findById(Long id){
        return appealRepository.findById(id).orElse(null);
    }

    public List<Appeal> findAll(){
        return appealRepository.findAll();
    }

    public Appeal saveAppeal(Appeal appeal){
        return appealRepository.save(appeal);
    }

    public void deleteById(Long id){
        appealRepository.deleteById(id);
    }

}
