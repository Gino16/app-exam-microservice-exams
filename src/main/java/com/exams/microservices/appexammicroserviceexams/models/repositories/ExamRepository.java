package com.exams.microservices.appexammicroserviceexams.models.repositories;

import com.exams.microservices.appexamlibcommonexams.models.entities.Exam;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ExamRepository extends CrudRepository<Exam, Long> {

  @Query("SELECT e FROM Exam e WHERE e.name LIKE %?1%")
  public List<Exam> findByName(String name);
}
