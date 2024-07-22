package RRG_SantanderSpringBoot.demo3.dominio.model;

import jakarta.persistence.*;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cpf;
    private String nome;
    @Column(unique = true)
    private Long conta;
    private String endereco;
    private String cidade;
    private String estado;

}
