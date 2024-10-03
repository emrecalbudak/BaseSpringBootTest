package com.example.IlService.controller;

import com.example.IlService.model.Il;
import com.example.IlService.service.IlService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


 // iş katmanı - bilgileri al servise gönder.

@RestController
@RequestMapping("/iller")
@AllArgsConstructor // kurucu metot oluşturur
public class IlController {

    private final IlService ilService;

    @GetMapping  // getirmek için
    public ResponseEntity<List<Il>> getIller(){
        return new ResponseEntity<>(ilService.getIller(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Il> getIl(@PathVariable String id){
        return new ResponseEntity<>(getIlById(id), HttpStatus.OK);
    }

    @PostMapping // eklemek için
    public ResponseEntity<Il> createIl(@RequestBody Il newIl){
        return new ResponseEntity<>(ilService.createIl(newIl), HttpStatus.CREATED); //postMapping'de Created verilir.
    }
    @PutMapping("/{id}") //Güncellemek için
    public ResponseEntity<Void> getIl(@PathVariable String id, @RequestBody Il newIl){
        Il oldIl = getIlById(id);
        oldIl.setName(newIl.getName());
        oldIl.setCreateDate(new Date());
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/{id}") // silmek için
    public ResponseEntity<Void> deleteIl(@PathVariable String id){
        ilService.deleteIl(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    private Il getIlById(String id) {
        return  ilService.getIlById(id);
    }
}
