package step9_02.atm_연습1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {
	
	private FileManager() {}
	private static FileManager instance = new FileManager();
	public static FileManager getInstance1() {
		return instance;
	}
	
	String fileNmae = "ATM.txt";
	String data = "";
	UserManager um = UserManager.getInstance();
	private String fileName;
	
	
	void setData() {
	
		data = "";
		int userCount = um.userCnt;
		data += userCount;
		data += "\n";
		
		for (int i = 0; i < userCount; i++) {
			data += um.userList[i].id;
			data += "\n";
			data += um.userList[i].pw;
			data += "\n";
			data += um.userList[i].getAccCnt();
			data += "\n";
			
			if(um.userList[i].getAccCnt() == 0) {
				data += "0\n"; 
		}
			else {
				for (int j = 0; j < um.userList[i].getAccCnt(); j++) {
					data += um.userList[i].acc[j].accNumber;
					data += "/";
					data += um.userList[i].acc[j].money;
					if(j != um.userList[i].getAccCnt()-1) {
						data += ",";
						}
					}
					data += "\n";
				}
		}
}
	
	public void save() {
		
		setData();
		
		FileWriter fw = null;
		
		try {
		fw = new FileWriter(fileName);
		fw.write(data);
		} catch(Exception e) {
			e.printStackTrace();
		}	finally {
			if(fw != null) {try {fw.close();} catch(IOException e) {}}
			
		}
		
	}
	
	
	void load()  {
		
		File file = new File(fileName);
		FileReader fr = null;
		BufferedReader br = null;
		
		
		try {
			
			if(file.exists()) {
			
			fr= new FileReader(file);
			br = new BufferedReader(fr);
			while(true) {
				String line = br.readLine();
				if(line == null) {
					break;
				}
				data +=  line;
				data += "\n";
			}
			
			String[]temp = data.split("\n");
			um.userCnt = Integer.parseInt(temp[0]);
			um.userList = new User[um.userCnt];
			for (int i = 0; i < um.userCnt; i++) {
				um.userList[i] = new User();
			}
			
			int j = 0;
			for (int i = 0; i < temp.length; i+=4) {
				
				String id = temp[i];
				String pw = temp[i+1];
				int accCnt = Integer.parseInt(temp[i+2]);
				
				um.userList[j].id = id;
				um.userList[j].pw = pw;
				um.userList[j].setAccCnt(accCnt);
				String accInfo = temp[i+3];
				
				if(accCnt ==1) {
					String[] tmp = accInfo.split("/");
					
					String acc = tmp[0];
					int money = Integer.parseInt(tmp[1]);
					
					um.userList[j].acc[0] = new Account();
					um.userList[j].acc[0].accNumber = acc;
					um.userList[j].acc[0].money = money;			
				}
				if(accCnt > 1) {
					
					String[] tmp = accInfo.split(",");
					
					for (int k = 0; k < tmp.length; k++) {
						String[]parse = temp[k].split("/");
						String acc = parse[0];
						int money = Integer.parseInt(parse[1]);
						
						um.userList[j].acc[k] = new Account();
						um.userList[j].acc[k].accNumber = acc;
						um.userList[j].acc[k].money = money;
					}
				}
				j++;
			}
			
		} 
		else {
			setData();
			save();
		}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (br != null) {try{br.close();} catch(IOException e) {}}
			if (fr != null)	{try{br.close();} catch(IOException e) {}}
		}
	}
	
}

		
		
	

