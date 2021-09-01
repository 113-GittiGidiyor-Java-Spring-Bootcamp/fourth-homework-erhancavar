package dev.schoolmanagement.service.concrete;

import dev.schoolmanagement.DTO.InstructorDTO;
import dev.schoolmanagement.DTO.PermanentInstructorDTO;
import dev.schoolmanagement.DTO.VisitingResearcherDTO;
import dev.schoolmanagement.entity.Instructor;
import dev.schoolmanagement.entity.PermanentInstructor;
import dev.schoolmanagement.entity.VisitingResearcher;
import dev.schoolmanagement.exceptions.EntityNotFoundException;
import dev.schoolmanagement.mappers.InstructorMapper;
import dev.schoolmanagement.repository.InstructorRepository;
import dev.schoolmanagement.service.InstructorService;
import dev.schoolmanagement.utility.Constants;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class InstructorServiceImpl implements InstructorService {
    InstructorRepository instructorRepository;
    InstructorMapper instructorMapper;
    @Override
    @Transactional
    public InstructorDTO save(InstructorDTO instructorDTO) {
        if(instructorDTO instanceof VisitingResearcherDTO){
            return instructorMapper.mapToDTO(instructorRepository.save(instructorMapper.mapToVisitingResearcher((VisitingResearcherDTO) instructorDTO)));
        }
        return instructorMapper.mapToDTO(instructorRepository.save(instructorMapper.mapToPermanentInstructor((PermanentInstructorDTO) instructorDTO)));
    }

    @Override
    public List<InstructorDTO> findAll() {
        return instructorRepository.findAll()
                .stream()
                .map(
                        (e) -> e instanceof PermanentInstructor ?
                                instructorMapper.mapToDTO((PermanentInstructor) e):
                                instructorMapper.mapToDTO((VisitingResearcher) e))
                .collect(Collectors.toList());
    }

    @Override
    public InstructorDTO findById(long id) {
        Instructor instructor = instructorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(Constants.INSTRUCTOR_NOT_FOUND));
        return  instructor instanceof PermanentInstructor?
                instructorMapper.mapToDTO((PermanentInstructor) instructor):
                instructorMapper.mapToDTO((VisitingResearcher) instructor);
    }


    @Override
    public void deleteById(long id) {
        if (!instructorRepository.existsById(id)) {
            throw new EntityNotFoundException(Constants.INSTRUCTOR_NOT_FOUND);
        }
        instructorRepository.deleteById(id);
    }

    @Override
    public InstructorDTO update(InstructorDTO instructor) {
        if (!instructorRepository.existsById(instructor.getId())) {
            throw new EntityNotFoundException(Constants.INSTRUCTOR_NOT_FOUND);
        }
        if(instructor instanceof PermanentInstructorDTO){
            return instructorMapper.mapToDTO(instructorRepository.save(instructorMapper.mapToPermanentInstructor((PermanentInstructorDTO) instructor)));
        }
        return instructorMapper.mapToDTO(instructorRepository.save(instructorMapper.mapToVisitingResearcher((VisitingResearcherDTO) instructor)));
    }
}