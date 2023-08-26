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
    @Column(name="first_name")
    private String firstName; // Corrección aquí
    @Column(name="last_name")
    private String lastName;
    @Column(name="email")
    private String email;
    @Column(name="create_at")
    private Date createAt;

    // Constructores, getters, setters, etc.
}



