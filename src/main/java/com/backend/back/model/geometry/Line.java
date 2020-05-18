package com.backend.back.model.geometry;

import javax.persistence.*;

@Entity
@Table(name = "Lines")
public class Line {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "line_id")
    private Long lineId;

    @OneToOne(fetch = FetchType.LAZY)
    private Point pointA;

    @OneToOne(fetch = FetchType.LAZY)
    private Point pointB;


}
