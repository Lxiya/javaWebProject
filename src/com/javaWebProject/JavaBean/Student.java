package com.javaWebProject.JavaBean;

public class Student {
	private String stuNum;
	private String stuName;
	private String stuSex;
	private String stuDept;
	private String lessonName;
	private String grade;

	public String getStuNum() {
		return stuNum;
	}

	public void setStuNum(String stuNum) {
		this.stuNum = stuNum;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getStuSex() {
		return stuSex;
	}

	public void setStuSex(String stuSex) {
		this.stuSex = stuSex;
	}

	public String getStuDept() {
		return stuDept;
	}

	public void setStuDept(String stuDept) {
		this.stuDept = stuDept;
	}

	public String getLessonName() {
		return lessonName;
	}

	public void setLessonName(String lessonName) {
		this.lessonName = lessonName;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Student [stuNum=" + stuNum + ", stuName=" + stuName + ", stuSex=" + stuSex + ", stuDept=" + stuDept
				+ ", lessonName=" + lessonName + ", grade=" + grade + "]";
	}

	public Student(String stuNum, String stuName, String stuSex, String stuDept, String lessonName, String grade) {
		super();
		this.stuNum = stuNum;
		this.stuName = stuName;
		this.stuSex = stuSex;
		this.stuDept = stuDept;
		this.lessonName = lessonName;
		this.grade = grade;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

}
