package com.backend.back.model.geometry;

import lombok.*;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "rectangular_parallelepipeds")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RectangularParallelepiped implements GeometricFigure {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "parallelepiped_id")
    private Long parallelepipedId;

    @ElementCollection
    @CollectionTable(name = "parallelepiped_info_mapping",
            joinColumns = {@JoinColumn(name = "parallelepiped_id", referencedColumnName = "parallelepiped_id")})
    @MapKeyColumn(name = "information_name")
    @Column(name = "value")
    private Map<String, Float> details = new HashMap<>();
}
