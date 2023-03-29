package step9_04.student;

import java.util.Scanner;

public class Main_연습 {

	public static void main(String[] args) {
		
		Scanner scan= new Scanner(System.in);
		Controller controller = new Controller();
		
		while(true) {
			
			System.out.println("[1]추가 [2]수정 [3]삭제 [4]출력 [5]전체출력 [6]종료 :");
			int selectMenu = scan.nextInt();
			
			if(selectMenu == 1) { // 1. 추가 
				
				System.out.println("아이디를 입력하세요 :");
				String id = scan.next();
				
				System.out.println("번호를 입력하세요 : ");
				int num = scan.nextInt();
				
				System.out.println("이름을 입력하세요 : ");
				String name = scan.next();
				
				StudentInsert stInsert = controller.getInsert();
				stInsert.insert(new StudentVO(id,num,name));
			}
			else if(selectMenu == 2) {//2.수정 
				System.out.println("아이디를 입력하세요 :");
				String insertid = scan.next();
				
				StudentInsert stInsert = controller.getInsert();
				StudentSelect stSelect = controller.getSelect();
				
				if(stInsert.checkId(insertid)) {
					System.out.println("ID를 확인하세요");
				}
				else {
					
					StudentRepository.getStDB().remove(insertid);
					
					System.out.println("변경할 이름을 입력하세요");
					String newname = scan.next();
					
					System.out.println("변경할 번호를 입력하세요");
					int newnumber = scan.nextInt();
					
					stInsert.insert(new StudentVO(insertid, newnumber,newname));
					System.out.println("변경이 완료가 되었습니다.");
				}
				
			}
			if(selectMenu == 3) { // 3. 삭제
				System.out.println("삭제할 아이디를 입력하세요 :"); {
				String deleteid = scan.next();
				
				StudentInsert stInsert = controller.getInsert();
				StudentSelect stSelect = controller.getSelect();
				
				if(stInsert.checkId(deleteid)) {
					System.out.println("ID를 확인하세요");
				}
				else {
					StudentRepository.getStDB().remove(deleteid);
					System.out.println("입력한 아이디 삭제완료");
				}					
				}	
			}
				
			if(selectMenu == 4) { // 4. 출력
				
				System.out.println("아이디를 입력하세요 :");
				String id = scan.next();
				
				StudentSelect stSelect = controller.getSelect();
				StudentVO st = stSelect.select(id);
				
				if(st != null) st.printOneInfo();			
				
			}
			else if(selectMenu == 5) { // 5. 전체출력

				StudentSelectAll stAll = controller.getSelectAll();
				stAll.printAll();
			}
			else if(selectMenu == 6) {
				
				System.out.println("종료");
				scan.close();
				break;				
			}			
		}
	}
}	

