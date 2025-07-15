package gr.aueb.cf.schoolapp.mapper;

import gr.aueb.cf.schoolapp.dto.TeacherInsertDTO;
import gr.aueb.cf.schoolapp.dto.TeacherReadOnlyDTO;
import gr.aueb.cf.schoolapp.model.Teacher;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public Teacher mapToTeacherEntity(TeacherInsertDTO dto) {
        return new Teacher(null, null, dto.getVat(), dto.getFirstname(), dto.getLastname(), null);
    }

    public TeacherReadOnlyDTO mapToTeacherReadOnlyDTO(Teacher teacher) {
        return new TeacherReadOnlyDTO(teacher.getId(), teacher.getCreatedAt(), teacher.getUpdatedAt(),
                teacher.getFirstname(), teacher.getLastname(), teacher.getVat(), teacher.getRegion().getName());
    }
}
