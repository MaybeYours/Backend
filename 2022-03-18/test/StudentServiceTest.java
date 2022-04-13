package xyz.itwill.controller;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import xyz.itwill10.dto.Student;
import xyz.itwill10.service.StudentService;

//�׽�Ʈ ���α׷��� DAO Ŭ���� �Ǵ� Service Ŭ������ �޼ҵ带 �˻��� �������� �ۼ�
@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration : WebAppcationContext ��ü(Spring Container)�� �̿��Ͽ� Spring Bean�� 
//�����ϵ��� �����ϴ� ������̼�
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"
		,"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class StudentServiceTest {
	public static final Logger logger=LoggerFactory.getLogger(StudentServiceTest.class);
	
	@Autowired
	private StudentService studentService;
	
	@Test
	public void testStudentList() {
		List<Student> studentList=studentService.getStudentList();
		
		for(Student student:studentList) {
			/*
			logger.info(student.getNo()+", "+student.getName()+", "+student.getPhone()
				+", "+student.getAddress()+", "+student.getBirthday().substring(0, 10));
			*/
			logger.info(student.toString());
		}
	}
}




