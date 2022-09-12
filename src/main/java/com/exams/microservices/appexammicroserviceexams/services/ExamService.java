package com.exams.microservices.appexammicroserviceexams.services;

import com.exams.microservices.appexamlibcommonexams.models.entities.Exam;
import com.exams.microservices.appexamlibcommonexams.models.entities.Subject;
import com.exams.microservices.libcommonmicroservices.services.GenericService;
import java.util.List;

public interface ExamService extends GenericService<Exam> {
  public List<Exam> findByName(String name);

  public Iterable<Subject> findAllSubjects();


  public Iterable<Long> findExamIdsWithAnswersByQuestionIds(Iterable<Long> questionIds);
}
