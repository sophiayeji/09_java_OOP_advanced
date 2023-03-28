package step9_04.student;

import java.util.Map;

public class StudentSelectAll_연습 {

	private StudentDAO_연습 studentDAO;
	
	public StudentSelectAll_연습(StudentDAO_연습 studentDAO) {
		this.studentDAO = studentDAO;
	}
	
	public Map<String, StudentVO>	allSelect() {
		return studentDAO.getStudentDB();
	} 
	
	public void printAll() {
		
		Map<String, StudentVO> map = studentDAO.getStudentDB();
		
		for(String key: map.keySet()) {
			map.get(key).printOneInfo();		
		}
	}
	
}
