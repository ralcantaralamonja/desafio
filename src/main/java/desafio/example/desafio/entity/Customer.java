package desafio.example.desafio.entity;

import jakarta.persistence.*;

import lombok.Data;


import java.util.Date;

@Entity
@Data
@Table(name = "tbl_customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String firstName; // Corrección aquí
    private String lastName;
    private String email;
    private Date createAt;

    // Constructores, getters, setters, etc.
}



