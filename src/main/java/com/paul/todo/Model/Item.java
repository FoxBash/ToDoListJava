package com.paul.todo.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "Title")
    private String title;
    @Column(name = "Content")
    private String content;

}
