package desafio.example.desafio.entity;

import jakarta.persistence.*;

import lombok.Data;


import java.util.Date;

@Entity
@Data
@Table(name="tbl_customer")
public class Customer {
    @Id
    private Long id;
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private String firsName;
    private String  lastName;
    private String email;
    private Date createAt;



}
