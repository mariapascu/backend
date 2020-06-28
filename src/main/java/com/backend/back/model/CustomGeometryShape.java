package com.backend.back.model;

import com.backend.back.model.geometry.Element;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "custom_geometric_shapes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomGeometryShape {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "shape_id")
    private Long shapeId;

    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private Student student;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "element_id")
    private List<Element> elements;


}
