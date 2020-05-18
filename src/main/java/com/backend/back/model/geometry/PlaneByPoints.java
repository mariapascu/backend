package com.backend.back.model.geometry;

import javax.persistence.*;

@Entity
@Table(name = "PlaneByPoints")
public class PlaneByPoints implements Plane {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "plane_id")
    private Long planeId;

    @OneToOne(fetch = FetchType.LAZY)
    private Point pointA;

    @OneToOne(fetch = FetchType.LAZY)
    private Point pointB;

    @OneToOne(fetch = FetchType.LAZY)
    private Point pointC;
}
