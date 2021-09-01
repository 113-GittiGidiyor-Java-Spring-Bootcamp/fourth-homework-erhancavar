package dev.schoolmanagement.utility;

import dev.schoolmanagement.entity.PermanentInstructor;
import dev.schoolmanagement.entity.VisitingResearcher;

public class InstructorFactory {
    public PermanentInstructor createPermanentInstructor() {
        return new PermanentInstructor();
    }

    public VisitingResearcher createVisitingResearcher() {
        return new VisitingResearcher();
    }
}

