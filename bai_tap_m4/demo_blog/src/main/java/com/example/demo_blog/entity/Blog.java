package com.example.demo_blog.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;



@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;
    private LocalDateTime createAt;
    @PrePersist
    public void prePersist() {
        this.createAt = LocalDateTime.now();
    }

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
