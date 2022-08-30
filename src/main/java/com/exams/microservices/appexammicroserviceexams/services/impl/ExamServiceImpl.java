package com.exams.microservices.appexammicroserviceexams.services.impl;

import com.exams.microservices.appexamlibcommonexams.models.entities.Exam;
import com.exams.microservices.appexammicroserviceexams.models.repositories.ExamRepository;
import com.exams.microservices.appexammicroserviceexams.services.ExamService;
import com.exams.microservices.libcommonmicroservices.services.impl.GenericServiceImpl;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ExamServiceImpl extends GenericServiceImpl<Exam, ExamRepository> implements
    ExamService {

  public ExamServiceImpl(ExamRepository repository) {
    super(repository);
  }

  @Transactional(readOnly = true)
  @Override
  public List<Exam> findByName(String name) {
    return this.repository.findByName(name);
  }
}
