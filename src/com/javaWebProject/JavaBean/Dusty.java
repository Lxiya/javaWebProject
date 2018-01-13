package com.javaWebProject.JavaBean;

public class Dusty {
	private Integer dId;
	private String term;
	private String lessonName;
	private String teaName;
	private String classHour;

	public Integer getdId() {
		return dId;
	}

	public void setdId(Integer dId) {
		this.dId = dId;
	}

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

	public String getClassHour() {
		return classHour;
	}

	public void setClassHour(String classHour) {
		this.classHour = classHour;
	}

	public Dusty(Integer dId, String term, String lessonName, String teaName, String classHour) {
		super();
		this.dId = dId;
		this.term = term;
		this.lessonName = lessonName;
		this.teaName = teaName;
		this.classHour = classHour;
	}

	public Dusty() {
		super();
	}

	@Override
	public String toString() {
		return "Dusty [dId=" + dId + ", term=" + term + ", lessonName=" + lessonName + ", teaName=" + teaName
				+ ", classHour=" + classHour + "]";
	}

}
