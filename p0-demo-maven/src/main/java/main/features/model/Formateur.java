package main.features.model;


 import lombok.Data;
 import lombok.NoArgsConstructor;

 import javax.persistence.*;

 @Entity
 @Data
 @NoArgsConstructor
 @Table (name= "formateurs_enicar")
public class Formateur {
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     @Column(nullable = false, updatable = false )
    private long id;
    private String name;
    private String email;
    private String classe;
    private String phone;



     @Override
     public String toString() {
         return "formateur{" +
                 "id=" + id +
                 ", name=" + name +
                 ", email=" + email +
                 ", classe=" + classe +
                 ", phone=" + phone +
                 '}';
     }



 }
