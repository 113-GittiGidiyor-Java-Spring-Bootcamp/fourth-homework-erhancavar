package dev.schoolmanagement.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Course extends AbstractEntity {
    private String name;
    private String courseCode;
    private float creditScore;
    @ManyToOne(cascade = CascadeType.MERGE)
    private Instructor instructor;
    @ManyToMany(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Set<Student> students = new HashSet<>();
}