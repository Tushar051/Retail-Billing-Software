package com.example.retailbillingsoftware.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.sql.Timestamp;

@Entity
@Table(name = "tbl_category")
@Builder
@Data
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String categoryId;

    @Column(unique = true)
    private String name;

    private String description;

    private String bgColor;

    private String imgUrl;

    @CreationTimestamp
    @Column(updatable = false) // should not be updated
    private Timestamp createdAt;

    @UpdateTimestamp
    private Timestamp updatedAt;

}
