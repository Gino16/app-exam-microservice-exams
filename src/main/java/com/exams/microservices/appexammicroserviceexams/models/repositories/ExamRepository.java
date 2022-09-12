package com.exams.microservices.appexammicroserviceexams.models.repositories;

import com.exams.microservices.appexamlibcommonexams.models.entities.Exam;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ExamRepository extends PagingAndSortingRepository<Exam, Long> {

  @Query("SELECT e FROM Exam e WHERE e.name LIKE %?1%")
  public List<Exam> findByName(String name);

  @Query("SELECT e.id FROM Question q JOIN q.exam e WHERE q.id IN ?1 GROUP BY e.id ")
  public Iterable<Long> findExamIdsWithAnswersByQuestionIds(Iterable<Long> questionIds);
}
