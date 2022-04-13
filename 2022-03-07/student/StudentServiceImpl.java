package xyz.itwill05.di;

import java.util.List;

//Service 클래스 : 프로그램 실행에 필요한 기능을 제공하기 위한 클래스 - 컴퍼넌트(모듈)
// => Service 클래스의 메소드는 DAO 클래스의 메소드를 호출하여 프로그램 실행에 필요한 기능 제공
// => Service 클래스가 변경돼도 프로그램 작성에 영향를 최소화 하기 위해 인터페이스를 상속받아 작성
public class StudentServiceImpl implements StudentService {
	//StudnetJdbcDAO 객체를 필드에 저장해야 포함관계(의존관계) 성립
	// => DAO 클래스가 변경될 경우 Service 클래스의 필드 및 메소드 변경 가능 - 유지보수의 효율성 감소 
	//private StudnetJdbcDAO studnetJdbcDAO;
	
	//StudentDAO 인터페이스를 상속받은 자식클래스의 객체를 필드에 저장해야 포함관계 성립
	// => 부모 인터페이스를 참조변수(필드)로 선언하면 모든 자식 클래스의 객체 저장 가능
	// => 부모 인터페이스의 참조변수(필드)로 메소드를 호출하면 참조변수(필드)에 저장된 자식클래스 객체의 메소드 호출 - 오버라이드에 의한 다형성
	//객체간의 결합도를 낮추어 유지보수의 효율성 증가 
	// => DAO 클래스가 클래스가 변경돼도 Service 클래스 클래스에 미치는 영향 최소화
	private StudentDAO studentDAO;	
	
	public StudentServiceImpl() {
		System.out.println("### StudentServiceImpl 클래스의 기본 생성자 호출 ###");
	}
	
	public StudentServiceImpl(StudentDAO studentDAO) {
		super();
		this.studentDAO = studentDAO;
		System.out.println("### StudentServiceImpl 클래스의 매개변수가 선언된 생성자 호출 ###");
	}

	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
		System.out.println("*** StudentServiceImpl 클래스의 setStudentDAO(StudentDAO studentDAO) 메소드 호출 ***");
	}

	@Override
	public void addStudent(Student student) {
		System.out.println("*** StudentServiceImpl 클래스의 addStudent(Student student) 메소드 호출 ***");
		studentDAO.insertStudent(student);
	}

	@Override
	public void modifyStudent(Student student) {
		System.out.println("*** StudentServiceImpl 클래스의 modifyStudent(Student student) 메소드 호출 ***");
		studentDAO.updateStudent(student);
	}

	@Override
	public void removeStudent(int num) {
		System.out.println("*** StudentServiceImpl 클래스의 removeStudent(int num) 메소드 호출 ***");
		studentDAO.deleteStudent(num);
	}

	@Override
	public Student getStudent(int num) {
		System.out.println("*** StudentServiceImpl 클래스의 getStudent(int num) 메소드 호출 ***");
		return studentDAO.selectStudent(num);
	}

	@Override
	public List<Student> getStudentList() {
		System.out.println("*** StudentServiceImpl 클래스의 getStudentList() 메소드 호출 ***");
		return studentDAO.selectStudentList();
	}

}
