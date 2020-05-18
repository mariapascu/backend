package com.backend.back.model.geometry;

import javax.persistence.*;

@Entity
@Table(name = "Tetrahedrons")
public class Tetrahedron {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tetrahedron_id")
    private Long tetrahedronId;

    @Column(name = "edge_length")
    private Float edgeLength;
}
