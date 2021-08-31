package dev.schoolmanagement.service.concrete;

import dev.schoolmanagement.entity.ExceptionLog;
import dev.schoolmanagement.repository.ExceptionLogRepository;
import dev.schoolmanagement.service.ExceptionLogService;
import dev.schoolmanagement.utility.Constants;
import lombok.AllArgsConstructor;
import org.apache.tomcat.jni.Local;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class ExceptionLogServiceImpl implements ExceptionLogService {
    ExceptionLogRepository exceptionLogRepository;

    @Override
    @Transactional
    public ExceptionLog save(ExceptionLog exceptionLog) {
        return exceptionLogRepository.save(exceptionLog);
    }

    @Override
    public List<ExceptionLog> findAll() {
        return exceptionLogRepository.findAll();
    }

    @Override
    public List<ExceptionLog> findAllByCreatedDate(Local createdDate) {
        return findAllByCreatedDate(createdDate);
    }

    @Override
    public ExceptionLog findById(long id) {
        return exceptionLogRepository.findById(id).orElseThrow(()-> new EntityNotFoundException(Constants.EXCEPTION_LOG_NOT_FOUND));
    }

    @Override
    public List<ExceptionLog> findAllByType(String type) {
        return exceptionLogRepository.findAllByType(type);
    }
}