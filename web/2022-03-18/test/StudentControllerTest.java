package xyz.itwill.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
//[*] ���Ϲ��ڸ� ����Ͽ� Bean Configuration File ���� ����
// => [**] �������� ������ ǥ���ϸ� 0�� �̻��� ���� ������ ǥ��
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class StudentControllerTest {
	public static final Logger logger=LoggerFactory.getLogger(StudentControllerTest.class);
	
	//WebApplicationContext : SpringMVC(�����α׷�)���� ����ϴ� Spring Container ��ü
	@Autowired
	private WebApplicationContext context;
	
	//MockMvc : ��û�� ������ �������� �����ϱ� ���� Ŭ����
	private MockMvc mvc;
	
	//@Before : �׽�Ʈ �޼ҵ� ȣ�� �� ����� ������ �ۼ��� �޼ҵ忡 �����ϴ� ������̼� - �ʱ�ȭ �۾�
	@Before
	public void setup() {
		//MockMvcBuilders.webAppContextSetup(WebApplicationContext context) : MockMvcBuilder ��ü�� ��ȯ�ϴ� �޼ҵ�
		//MockMvcBuilder.build() : MockMvc ��ü�� ��ȯ�ϴ� �޼ҵ�
		mvc=MockMvcBuilders.webAppContextSetup(context).build();
		logger.info("MockMvc ��ü ����");
	}
	
	@Test
	public void testStudentDisplay() throws Exception {
		//MockMvc.perform(Builder requestBuilder) : �������� �����α׷��� ��û�ϴ� �޼ҵ�
		// => ResultActions ��ü(��û�� ���� ó�� ����� ������ ��ü) ��ȯ
		//MockMvcRequestBuilders.get(String url) : ��û URL �ּҸ� �̿��Ͽ� GET ������� ��û�ϴ� �޼ҵ�
		// => RequestBuilder ��ü(�����α׷��� ��û������ ������ ��ü) ��ȯ 
		//ResultActions.andReturn() : ��û ó�� �޼ҵ��� ����� MvcResult ��ü�� ��ȯ�ϴ� �޼ҵ�
		MvcResult result=mvc.perform(MockMvcRequestBuilders.get("/student/display")).andReturn();
		
		logger.info(result.getModelAndView().getViewName());
		logger.info(result.getModelAndView().getModel().toString());
	}
}








