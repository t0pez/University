package edu.ntudp.polisnichenko.controllers.services.factories;

import edu.ntudp.polisnichenko.models.University;

import java.util.UUID;

public class UniversityFactory {
    public static University createTypicalUniversity() {
        var university = create("NTU");

        var faculty1 = FacultyFactory.create("Faculty " + UUID.randomUUID());
        university.addFaculty(faculty1);

        var dept1 = DepartmentFactory.create("Dept " + UUID.randomUUID());
        faculty1.addDepartment(dept1);

        var group11 = GroupFactory.create("Group " + UUID.randomUUID(), 19);
        dept1.addGroup(group11);
        var group12 = GroupFactory.create("Group " + UUID.randomUUID(), 21);
        dept1.addGroup(group12);

        var dept2 = DepartmentFactory.create("Dept 2");
        faculty1.addDepartment(dept2);

        var group21 = GroupFactory.create("Group " + UUID.randomUUID(), 17);
        dept2.addGroup(group21);
        var group22 = GroupFactory.create("Group " + UUID.randomUUID(), 22);
        dept2.addGroup(group22);

        var faculty2 = FacultyFactory.create("Faculty " + UUID.randomUUID());
        university.addFaculty(faculty2);

        var dept3 = DepartmentFactory.create("Dept " + UUID.randomUUID());
        faculty2.addDepartment(dept3);

        var group31 = GroupFactory.create("Group " + UUID.randomUUID(), 21);
        dept3.addGroup(group31);
        var group32 = GroupFactory.create("Group " + UUID.randomUUID(), 19);
        dept3.addGroup(group32);

        return university;
    }

    public static University create(String name) {
        return new University(name, HeadFactory.create());
    }
}
