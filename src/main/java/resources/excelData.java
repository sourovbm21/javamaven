package resources;

import java.util.ArrayList;

public class excelData {

	
	
	 
		public static ArrayList<Object[]> getDatafromExcel() {
			
	 ArrayList<Object[]> mydata=new ArrayList<Object[]>();
			Xls_Reader reader=new Xls_Reader("/Users/tohidur/Downloads/javaMaven/src/main/java/resources/qaTestData.xlsx");
			int rowCount=reader.getRowCount("testData");
			System.out.println(rowCount);
			reader.addColumn("testData","status");
			
			for(int row =2;row<=rowCount;row++) {
				
			String email=	reader.getCellData("testData","emailid",row);
				System.out.println(email);	
				
				String password=	reader.getCellData("testData","password",row);
				System.out.println(password);
				
				Object ob[]= {email,password};
				mydata.add(ob);
				reader.setCellData("testData","status",row,"pass");
				
			
		}
			return mydata;
	}
	
	
	
}
