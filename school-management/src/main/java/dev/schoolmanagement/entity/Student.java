package dev.schoolmanagement.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student extends AbstractEntity {
    private String name;
    private String address;
    private LocalDate birthday;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @ManyToMany(mappedBy = "students", cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    private Set<Course> courses;

    public void addCourses(Course course) {
        courses.add(course);
        course.getStudents().add(this);
    }
}
