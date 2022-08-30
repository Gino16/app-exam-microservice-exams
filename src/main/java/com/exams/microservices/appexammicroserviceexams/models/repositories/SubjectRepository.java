package com.exams.microservices.appexammicroserviceexams.models.repositories;

import com.exams.microservices.appexamlibcommonexams.models.entities.Subject;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SubjectRepository extends PagingAndSortingRepository<Subject, Long> {

}
