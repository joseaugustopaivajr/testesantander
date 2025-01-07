package com.joseaugustopaivajr.testesantander.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Builder
@Table(name = "log_consulta")
@NoArgsConstructor
@AllArgsConstructor
public class LogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "zip_code")
    private Integer zipCode;

    private String address;

    private String city;

    private String state;

    @Column(name = "creat_at")
    private LocalDateTime createdAt;


    public LogEntity(Integer cep, String address, String city, String state) {
        this.zipCode = cep;
        this.address = address;
        this.city = city;
        this.state = state;
        this.createdAt = LocalDateTime.now();
    }
}
