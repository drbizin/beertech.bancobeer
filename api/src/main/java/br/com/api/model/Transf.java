package br.com.api.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Transf {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String contaOrigemHash;
    private String contaDestinoHash;
    private Double valor;
}