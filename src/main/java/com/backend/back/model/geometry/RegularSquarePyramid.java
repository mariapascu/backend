package com.backend.back.model.geometry;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "regular_square_pyramids")
@NoArgsConstructor
@Data
public class RegularSquarePyramid {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pyramid_id")
    private Long pyramidId;

    @ElementCollection
    @CollectionTable(name = "pyramid_info_mapping", joinColumns = {@JoinColumn(name = "pyramid_id", referencedColumnName = "pyramid_id")})
    @MapKeyColumn(name = "info_type")
    @Column(name = "value")
    private Map<String, Float> details = new HashMap<>();
}
