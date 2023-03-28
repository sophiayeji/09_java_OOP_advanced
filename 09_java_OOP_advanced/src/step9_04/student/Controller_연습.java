package step9_04.student;

public class Controller_연습 {

	private StudentDAO_연습 stDAO;
	private StudentInsert_연습 insert;
	private StudentSelect_연습 select;
	private StudentSelectAll selectAll;

	public Controller_연습() {
		stDAO = new StudentDAO_연습();
		insert = new StudentInsert_연습(stDAO);

	}
	
	public StudentDAO_연습 getStDAO() {
		return stDAO;		
	}
	
	public void setStDAO(StudentDAO_연습 stDAO) {
		this.stDAO = stDAO;
	}
	
	public StudentInsert_연습 getInsesrt() {
		return insert;		
	}
	public void setInsert(StudentInsert_연습 insesrt) {
		this.insert = insert; 
	}
	public StudentSelect_연습 getSelect() {
		return select;		
	}
	public void setSelect(StudentSelect_연습 select) {
		this.select = select;
	}
	public StudentSelectAll getSelectAll() {
		return selectAll;	
	}
	

}
