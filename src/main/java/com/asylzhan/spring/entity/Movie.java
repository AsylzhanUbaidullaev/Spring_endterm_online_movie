package com.asylzhan.spring.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "movies")
@Data
@NoArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String genre;
    private String premiere;
    private String director;

//    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    List<User> users;
}
