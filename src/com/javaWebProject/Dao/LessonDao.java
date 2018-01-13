package com.javaWebProject.Dao;

import java.util.List;

import com.javaWebProject.JavaBean.Lesson;

public interface LessonDao {

	// 显示所有课程
	List<Lesson> lessons();

	// 添加课程
	List<Lesson> AddLesson(Lesson lesson);

	// 删除课程
	void DeleteLesson(int lessonId);

	// 检索课程
	List<Lesson> serachLesson(Lesson lesson);

	// 编辑课程
	void updateLesson(String lessonName, int lessonId);
}
