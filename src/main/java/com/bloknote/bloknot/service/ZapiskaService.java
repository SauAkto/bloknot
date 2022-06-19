package com.bloknote.bloknot.service;

import com.bloknote.bloknot.model.Zapiska;
import com.bloknote.bloknot.repository.ZapiskaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ZapiskaService {

    private final ZapiskaRepository zapiskaRepository;

    @Autowired
    public ZapiskaService(ZapiskaRepository zapiskaRepository) {
        this.zapiskaRepository = zapiskaRepository;
    }

    public Zapiska getZapiska(Long id){
        return zapiskaRepository.getOne(id);
    }

    public Zapiska saveZapiska(Zapiska zapiska){
        return zapiskaRepository.save(zapiska);
    }

}
