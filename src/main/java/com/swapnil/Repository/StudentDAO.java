package com.swapnil.Repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.swapnil.model.Student;

@Repository
public interface StudentDAO extends ElasticsearchRepository<Student, Integer>{

}
