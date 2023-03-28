package step9_04.student;

import java.util.HashMap;

public class StudentRepository_연습 { // 저장소
	
	private static HashMap<String, StudentVO> stDB = new HashMap<String,StudentVO>(); 

	public static HashMap<String,StudentVO> getStDB() {
		return stDB;
	}
	
	public static void setStDB(HashMap<String,StudentVO>stDB) {
		StudentRepository_연습.stDB = stDB;
	}
}	
