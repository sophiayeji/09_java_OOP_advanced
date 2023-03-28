package step9_04.student;

public class StudentInsert_연습 {
	
	private StudentDAO_연습 studentDAO;
	
	public StudentInsert_연습(StudentDAO_연습 stDAO) {
		this.studentDAO = stDAO;
	}

	public void insert(StudentVO studentVO) {
		String id = studentVO.getId();
		if(checkId(id)) {
			studentDAO.insert(studentVO);
		}
		else {
			System.out.println("중복아이디 입니다.");
		}
	}

	private boolean checkId(String id) {
		StudentVO studentVO = studentDAO.select(id);
		return studentVO == null? true: false;
	}
}
