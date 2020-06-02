package com.backend.back.model.geometry;

import lombok.*;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "geometric_figures")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeometricFigure {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "figure_id")
    private Long figureId;

    @Column(name = "figure_name")
    private String figureName;

    @ElementCollection
    @CollectionTable(name = "figure_info_mapping",
            joinColumns = {@JoinColumn(name = "figure_id", referencedColumnName = "figure_id")})
    @MapKeyColumn(name = "information_name")
    @Column(name = "value")
    private Map<String, Float> details = new HashMap<>();
}
