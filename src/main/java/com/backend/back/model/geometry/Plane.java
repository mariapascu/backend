package com.backend.back.model.geometry;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "planes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Plane extends Element {
    @OneToOne(fetch = FetchType.LAZY)
    private Point pointA;

    @OneToOne(fetch = FetchType.LAZY)
    private Point pointB;

    @OneToOne(fetch = FetchType.LAZY)
    private Point pointC;
}
