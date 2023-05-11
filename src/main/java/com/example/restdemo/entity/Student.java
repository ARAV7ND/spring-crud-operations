package com.example.restdemo.entity;




import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "student")
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter int id;

    @Column(name = "name")
    private @Getter @Setter String name;


    @Column(name = "address")
    private @Getter @Setter String address;

    public Student(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
