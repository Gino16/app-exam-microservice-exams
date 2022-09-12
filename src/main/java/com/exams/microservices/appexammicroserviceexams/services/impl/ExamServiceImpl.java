package com.exams.microservices.appexammicroserviceexams.services.impl;

import com.exams.microservices.appexamlibcommonexams.models.entities.Exam;
import com.exams.microservices.appexamlibcommonexams.models.entities.Subject;
import com.exams.microservices.appexammicroserviceexams.models.repositories.ExamRepository;
import com.exams.microservices.appexammicroserviceexams.models.repositories.SubjectRepository;
import com.exams.microservices.appexammicroserviceexams.services.ExamService;
import com.exams.microservices.libcommonmicroservices.services.impl.GenericServiceImpl;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ExamServiceImpl extends GenericServiceImpl<Exam, ExamRepository> implements
    ExamService {

  private final SubjectRepository subjectRepository;

  public ExamServiceImpl(ExamRepository repository, SubjectRepository subjectRepository) {
    super(repository);
    this.subjectRepository = subjectRepository;
  }

  @Transactional(readOnly = true)
  @Override
  public List<Exam> findByName(String name) {
    return this.repository.findByName(name);
  }

  @Transactional(readOnly = true)
  @Override
  public Iterable<Subject> findAllSubjects() {
    return subjectRepository.findAll();
  }

  @Override
  @Transactional(readOnly = true)
  public Iterable<Long> findExamIdsWithAnswersByQuestionIds(Iterable<Long> questionIds) {
    return repository.findExamIdsWithAnswersByQuestionIds(questionIds);
  }
}
