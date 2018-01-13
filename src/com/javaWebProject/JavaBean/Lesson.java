package com.javaWebProject.JavaBean;

public class Lesson {
	private Integer lessonId;
	private String lessonName;

	public Integer getLessonId() {
		return lessonId;
	}

	public void setLessonId(Integer lessonId) {
		this.lessonId = lessonId;
	}

	public String getLessonName() {
		return lessonName;
	}

	public void setLessonName(String lessonName) {
		this.lessonName = lessonName;
	}

	public Lesson(Integer lessonId, String lessonName) {
		super();
		this.lessonId = lessonId;
		this.lessonName = lessonName;
	}

	public Lesson() {
		super();
	}

}
