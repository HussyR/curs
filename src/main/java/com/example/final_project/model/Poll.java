package com.example.final_project.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "poll")
@Data
@NoArgsConstructor
public class Poll {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column(name = "poll_name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "poll", fetch=FetchType.LAZY)
    private List<Question> questions;

}
