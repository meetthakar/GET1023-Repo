package view;

import model.Course;
import model.Qualification;
import model.Student;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import dao.StudentDao;
import dao.StudentDaoImplInMemory;

public class Main {
	public static void main(String[] args) {
		StudentDao dao = new StudentDaoImplInMemory();
		Student student1 = new Student("john",LocalDate.of(2000, 10, 12),Qualification.Graduate,"9858585843","john@lti.com","Mumbai");
		Student student2 = new Student("mike",LocalDate.of(2001, 9, 15),Qualification.Master,"6758585843","mike@lti.com","Chennai");
		Student student3 = new Student("kevin",LocalDate.of(2000, 1, 22),Qualification.Graduate,"7858585843","kevin@lti.com","Pune");
		Student student4 = new Student("brett",LocalDate.of(2001, 11, 12),Qualification.Intermidiate,"8858585843","brett@lti.com","Bengaluru");
		
		dao.addNewStudent(student1);
		dao.addNewStudent(student2);
		dao.addNewStudent(student3);
		dao.addNewStudent(student4);
		
		Course course1 = new Course("Java",6,4000,Qualification.Graduate);
		Course course2 = new Course("Python",3,2000,Qualification.Graduate);
		Course course3 = new Course("Azure",6,8000,Qualification.Master);
		Course course4 = new Course(".Net",5,5000,Qualification.Graduate);
		
		dao.addNewCourse(course1);
		dao.addNewCourse(course2);
		dao.addNewCourse(course3);
		dao.addNewCourse(course4);
		
		List<Course> courses= dao.viewAllCourses();
		Iterator<Course> iteratorCourse = courses.iterator();
		while(iteratorCourse.hasNext()) {
			Course course = iteratorCourse.next();
			System.out.println(course.getCourseId()+" "+course.getCourseName()+" "+course.getDurationInMonths()+" "+course.getFee()+" "+course.getEligibility());
		}
		
		System.out.println("View all students");
		List<Student> students = dao.viewAllStudents();
		Iterator<Student> iterator = students.iterator();
		while(iterator.hasNext()) {
			Student student=iterator.next();
			
			System.out.println(student.getRollNo()+" "+student.getName()+" "+student.getEmail()+" "+student.getPhoneNo()+" "+student.getCollegename());
			 
		}
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter student roll no and course applying for");
		int rollNo = scanner.nextInt();
		int courseId = scanner.nextInt();
		Student stud1= dao.findStudentByRollNo(rollNo);
		Course c1= dao.findCourseById(courseId);
		if(stud1!=null) {
			if(c1!=null) {
				dao.registration(stud1, c1);
				System.out.println("Registration successful");
				
			}
			else {
				System.out.println("Course not found");
			}
		}else {
			System.out.println("student not found");
		}
		System.out.println("view all registrations");
		Map<Student,Course> registrations=dao.viewAllRegistrations();
		Set<Map.Entry<Student,Course>> regs=registrations.entrySet();
		for(Map.Entry<Student, Course> r:regs) {
			Student s = r.getKey();
			Course c=r.getValue();
			System.out.println(s.getRollNo()+" "+s.getName()+" "+c.getCourseId()+" "+c.getCourseName());
		}
		
		
		
	}
}
