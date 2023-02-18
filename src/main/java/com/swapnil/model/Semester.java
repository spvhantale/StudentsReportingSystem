package com.swapnil.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "semester")
public class Semester {

	@Id
	private Integer id;
	private Integer english;
	private Integer maths;
	private Integer science;
	
}
