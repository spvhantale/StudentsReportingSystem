package com.swapnil.Repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.swapnil.model.Semester;

@Repository
public interface SemesterDAO extends ElasticsearchRepository<Semester, Integer>{

}
