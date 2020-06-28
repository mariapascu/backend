package com.backend.back.model.geometry;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Element {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "element_id")
    private Long elementId;
}
