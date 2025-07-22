package gr.aueb.cf.schoolapp.validator;

import gr.aueb.cf.schoolapp.dto.TeacherInsertDTO;
import gr.aueb.cf.schoolapp.repository.RegionRepository;
import gr.aueb.cf.schoolapp.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
@Slf4j
public class TeacherInsertValidator implements Validator {
    private final TeacherRepository teacherRepository;
    private final RegionRepository regionRepository;

    @Override
    public boolean supports(@NonNull Class<?> clazz) {
        return TeacherInsertDTO.class == clazz;
    }

    @Override
    public void validate(@NonNull Object target, @NonNull Errors errors) {
        TeacherInsertDTO teacherInsertDTO = (TeacherInsertDTO) target;

        if (teacherInsertDTO.getVat() != null && teacherRepository.findByVat(teacherInsertDTO.getVat()).isPresent()) {
            log.error("Save failed for teacher  with vat={}. Teacher already exists", teacherInsertDTO.getVat());
//            errors.rejectValue("vat", "vat.teacher.exists", "Το ΑΦΜ του καθηγητή υπάρχει ήδη.");
            errors.rejectValue("vat", "vat.teacher.exists");
        }

//        if (teacherInsertDTO.getRegionId() != null && regionRepository.findById(teacherInsertDTO.getRegionId()).isEmpty()) {
//            log.error("Save failed for teacher with vat={}. Region id={} invalid.",
//                    teacherInsertDTO.getVat(), teacherInsertDTO.getRegionId());
//            errors.rejectValue("regionId", "vat.teacher.exists", "Η περιοχή του Καθηγητή δεν μπορεί να είναι κενή.");
//        }
    }
}
