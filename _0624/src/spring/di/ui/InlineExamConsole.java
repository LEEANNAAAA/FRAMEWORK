package spring.di.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import spring.di.entity.Exam;

@Component("console")	//이름부여
public class InlineExamConsole implements ExamConsole {
	
	@Autowired
//	@Qualifier("exam2")	//기본생성자 호출
	private Exam exam;
	
	public InlineExamConsole() {
		System.out.println("constructor");
	}
	
	
	public InlineExamConsole(Exam exam) {
		System.out.println("overloadconstructor");
		this.exam = exam;
	}



	@Override
	public void print() {
		if(exam==null) {
			System.out.printf("total is %d, avg is %f\n", 0, 0.0);		
		}
		else {
			System.out.printf("total is %d, avg is %f\n", exam.total(), exam.avg());
		}
	}


//	@Autowired
//	@Qualifier("exam2")	 //기본생성자,setter 실행
	@Override
	public void setExam(Exam exam) {
		System.out.println("setter");
		this.exam = exam;
	}

}
