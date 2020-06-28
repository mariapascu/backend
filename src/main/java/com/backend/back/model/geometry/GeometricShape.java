package com.backend.back.model.geometry;

import lombok.*;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "geometric_shapes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeometricShape {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "shape_id")
    private Long shapeId;

    @Column(name = "figure_name")
    private String shapeName;

    @ElementCollection
    @CollectionTable(name = "shape_info_mapping",
            joinColumns = {@JoinColumn(name = "shape_id", referencedColumnName = "shape_id")})
    @MapKeyColumn(name = "information_name")
    @Column(name = "value")
    private Map<String, Float> details = new HashMap<>();
}
