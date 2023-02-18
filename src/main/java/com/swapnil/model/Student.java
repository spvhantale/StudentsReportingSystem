package com.swapnil.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName="student")
public class Student {

	@Id
	private Integer roll;
	private String name;
	private List<Semester> semesters=new ArrayList<>(2);
	
}
