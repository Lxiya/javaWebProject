package com.javaWebProject.JavaBean;

public class Teacher {
	private Integer teaId;
	private String teaName;
	private String teaSex;

	public Integer getTeaId() {
		return teaId;
	}

	public void setTeaId(Integer teaId) {
		this.teaId = teaId;
	}

	public String getTeaName() {
		return teaName;
	}

	public void setTeaName(String teaName) {
		this.teaName = teaName;
	}

	public String getTeaSex() {
		return teaSex;
	}

	public void setTeaSex(String teaSex) {
		this.teaSex = teaSex;
	}

	public Teacher(Integer teaId, String teaName, String teaSex) {
		super();
		this.teaId = teaId;
		this.teaName = teaName;
		this.teaSex = teaSex;
	}

	public Teacher() {
		super();
	}

}
