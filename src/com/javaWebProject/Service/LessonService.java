package com.javaWebProject.Service;

import java.util.List;

import com.javaWebProject.Dao.LessonDao;
import com.javaWebProject.DaoImpl.LessonDaoImpl;
import com.javaWebProject.JavaBean.Lesson;

public class LessonService {

	LessonDao lessonDao = new LessonDaoImpl();

	// 显示所有课程
	public List<Lesson> lessons() {
		List<Lesson> lessons = lessonDao.lessons();
		return lessons;
	}

	// 添加课程
	public List<Lesson> AddLesson(Lesson lesson) {
		lessonDao.AddLesson(lesson);
		return null;
	}

	// 删除课程
	public void DeleteLesson(int lessonId) {
		lessonDao.DeleteLesson(lessonId);
	}

	// 条件检索课程
	public List<Lesson> serachLesson(Lesson lesson) {
		List<Lesson> lessons = lessonDao.serachLesson(lesson);
		return lessons;
	}

	// 编辑课程
	public void updateLesson(String lessonName, int lessonId) {
		lessonDao.updateLesson(lessonName, lessonId);
	}
}
