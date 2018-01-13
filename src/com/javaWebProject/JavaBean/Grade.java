package com.javaWebProject.JavaBean;

public class Grade {
	private String term;
	private String lessonName;
	private String teaName;
	private String stuNum;
	private String grade;

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public String getLessonName() {
		return lessonName;
	}

	public void setLessonName(String lessonName) {
		this.lessonName = lessonName;
	}

	public String getTeaName() {
		return teaName;
	}

	public void setTeaName(String teaName) {
		this.teaName = teaName;
	}

	public String getStuNum() {
		return stuNum;
	}

	public void setStuNum(String stuNum) {
		this.stuNum = stuNum;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Grade [term=" + term + ", lessonName=" + lessonName + ", teaName=" + teaName + ", stuNum=" + stuNum
				+ ", grade=" + grade + "]";
	}

	public Grade(String term, String lessonName, String teaName, String stuNum, String grade) {
		super();
		this.term = term;
		this.lessonName = lessonName;
		this.teaName = teaName;
		this.stuNum = stuNum;
		this.grade = grade;
	}

	public Grade() {
		super();
	}

}
