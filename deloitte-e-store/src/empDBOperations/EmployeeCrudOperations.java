package empDBOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class EmployeeCrudOperations {
public static void main(String[] args) throws SQLException {
	
	//Create Connection
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
	
	if(con!=null)
		System.out.println("Connection successful");
	
	//Create Statement
	Statement stmt = con.createStatement();
	
	//Execute Query
	ResultSet rs = stmt.executeQuery("select * from employee where job='salesman'");
	
	
	ResultSetMetaData rsmd = rs.getMetaData();
	System.out.println(rsmd.getColumnCount()+" "+rsmd.getTableName(1));
	System.out.println(rs.toString());
	//Process ResultSet
    System.out.println("Emp IDs\tEmp Names");
 	
     	while(rs.next()) {
		System.out.println(rs.getInt(1)+"\t"+rs.getString(2));
		
     	}
    	con.close();
     	con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");

//	int r = stmt.executeUpdate("insert into dept values(60,'CRM','bangalore')");
//   if(r>0)
//	 System.out.println("table updated!");
   Scanner input = new Scanner(System.in);
   int deptNo=0;
   String deptName=null, location;
System.out.print("Enter Dept. index value: ");
if(input.hasNextInt())
	deptNo=input.nextInt();

System.out.print("Enter name: ");   
deptName = input.next().trim().toUpperCase();

System.out.print("Enter Location: ");
location=input.next().trim().toUpperCase();

System.out.println(deptNo+ deptName+location);

PreparedStatement pstmt = con.prepareStatement("insert into dept values(?,?,?)");
pstmt.setInt(1,deptNo);
pstmt.setString(2,deptName);
pstmt.setString(3,location);
int r = pstmt.executeUpdate();

if(r>0)
System.out.println("table updated!");

}
}
