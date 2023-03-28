package step9_04.student;

public class StudentSelect_연습 {
	
	private StudentDAO_연습 studentDAO;
	private Object ture;
	
	public StudentSelect_연습(StudentDAO_연습 stDAO) {
		studentDAO = stDAO;
	}
	
	public StudentVO select(String id) {
		
		if(checkId(id)) {
			return studentDAO.select(id);
		}
		else {
			System.out.println("정보가 없습니다.");
		}
		
		return null;		
	}

	private boolean checkId(String id) {
		
		StudentVO studentVO = studentDAO.select(id);
		return studentVO != null? true:false;
	}

}
