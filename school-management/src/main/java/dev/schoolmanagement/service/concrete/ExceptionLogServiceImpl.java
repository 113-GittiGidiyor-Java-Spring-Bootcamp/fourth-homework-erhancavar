package dev.schoolmanagement.service.concrete;

import dev.schoolmanagement.entity.ExceptionLog;
import dev.schoolmanagement.repository.ExceptionLogRepository;
import dev.schoolmanagement.service.ExceptionLogService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class ExceptionLogServiceImpl implements ExceptionLogService {
    ExceptionLogRepository exceptionLogRepository;

    @Override
    public ExceptionLog save(ExceptionLog exceptionLog) {
        return null;
    }

    @Override
    public List<ExceptionLog> findAll() {
        return null;
    }

    @Override
    public ExceptionLog findById(long id) {
        return null;
    }

    @Override
    public void delete(ExceptionLog exceptionLog) {

    }

    @Override
    public void deleteById(long id) {

    }

    @Override
    public ExceptionLog update(ExceptionLog exceptionLog) {
        return null;
    }
}