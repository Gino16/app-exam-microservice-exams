package com.exams.microservices.appexammicroserviceexams.controllers;

import com.exams.microservices.appexamlibcommonexams.models.entities.Exam;
import com.exams.microservices.appexammicroserviceexams.services.ExamService;
import com.exams.microservices.libcommonmicroservices.controllers.GenericController;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExamController extends GenericController<ExamService, Exam> {

  public ExamController(ExamService service) {
    super(service);
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> edit(@RequestBody Exam exam, @PathVariable Long id) {
    Optional<Exam> o = this.service.findById(id);
    if (o.isEmpty()) {
      return ResponseEntity.notFound().build();
    }
    Exam examDb = o.get();
    examDb.setName(exam.getName());

    examDb.getQuestions().parallelStream()
        .filter(q -> !exam.getQuestions().contains(q))
        .forEach(q -> examDb.getQuestions().remove(q));

    examDb.setQuestions(exam.getQuestions());

    return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(examDb));
  }

  @GetMapping("/filter/{name}")
  public ResponseEntity<?> findByName(@PathVariable String name) {
    return ResponseEntity.status(HttpStatus.OK).body(this.service.findByName(name));
  }
}

