package com.example.backendproject.features.model;


 import lombok.Data;
 import lombok.NoArgsConstructor;

 import javax.persistence.*;
 import java.io.Serializable;

 @Entity
 @Data
 @NoArgsConstructor
public class Formateur {
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     @Column(nullable = false, updatable = false )
    private long id;
    private String name;
    private String email;
    private String junior;
    private String phone;
    private String imageUrl;
     @Column (nullable = false, updatable = false)
    private String formateurCode;


     @Override
     public String toString() {
         return "formateur{" +
                 "id=" + id +
                 ", name=" + name +
                 ", email=" + email +
                 ", junior=" + junior +
                 ", phone=" + phone +
                 ", imageUrl=" + imageUrl +
                 ", formateurCode=" + formateurCode +
                 '}';
     }
 }
