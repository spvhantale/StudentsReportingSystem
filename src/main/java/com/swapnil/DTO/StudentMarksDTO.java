package com.swapnil.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentMarksDTO {

	private Integer roll;
	private Integer semesterNo;
	private String subject;
	private Integer marks;
	
}
