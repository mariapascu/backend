package com.backend.back.model.geometry;

import javax.persistence.*;

@Entity
@Table(name = "PlaneByLines")
public class PlaneByLines implements Plane {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "plane_id")
    private Long Id;

    @OneToOne(fetch = FetchType.LAZY)
    private Line lineA;

    @OneToOne(fetch = FetchType.LAZY)
    private Line lineB;
}
