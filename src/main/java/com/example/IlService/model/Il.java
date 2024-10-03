package com.example.IlService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data // Lombok - getter setter oluşturur
@NoArgsConstructor //parametresiz kurucu metot oluşturur
@AllArgsConstructor // parametreli kurucu metot oluşturur
public class Il {
    @Id
    private String id;
    private Date createDate = new Date();
    private String name;

}
