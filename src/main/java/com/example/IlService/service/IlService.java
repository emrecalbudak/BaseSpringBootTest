package com.example.IlService.service;

import com.example.IlService.model.Il;
import com.example.IlService.repository.IlRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

//bilgileri al, işlem yap, geri gönder

@Service
@AllArgsConstructor
public class IlService {

    private final IlRepository ilRepository;
    public List<Il> getIller(){
        return ilRepository.findAll();
    }

    public Il createIl(Il newIl) {
        return ilRepository.save(newIl);
    }

    public void deleteIl(String id) {
        ilRepository.deleteById(id);
    }

    public Il getIlById(String id) {
        return ilRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Il not found"));
    }
}
