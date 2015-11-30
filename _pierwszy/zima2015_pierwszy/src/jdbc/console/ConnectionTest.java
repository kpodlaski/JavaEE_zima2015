package jdbc.console;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionTest {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		try {
            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
        }
        catch (Exception ex) {   
        	ex.printStackTrace();
        	System.exit(1);
        }
		
		Connection con = 
				DriverManager
		.getConnection("jdbc:oracle:thin:@oradb.pi.uni.lodz.pl:1521:orcl",
				"javastudent","p@ssw0rd");
		//DatabaseMetaData dbMeta = con.getMetaData();
        Statement st = con.createStatement();
        st.execute("Select id,nazwa from Jednostka");
		ResultSet rs = st.getResultSet();
		while (rs.next()){
			System.out.print(rs.getInt(1));
			System.out.println(" "+rs.getString("Nazwa"));
			
		}
		System.out.println("==============================");
		PreparedStatement pst = con
			.prepareStatement("Select * From Stanowisko where id>=?");
		
		pst.setInt(1,4);  //Fill the parameter ?
		pst.execute();
		rs = pst.getResultSet();
		while (rs.next()){
			System.out.print(rs.getInt(1));
			System.out.println(" "+rs.getString("Nazwa"));
			
		}
		System.out.println("==============================");
		ResultSetMetaData meta = rs.getMetaData();
        for (int i=1; i<=meta.getColumnCount();i++)
           System.out.println(meta.getColumnName(i)+":"+meta.getColumnTypeName(i));
        System.out.println("==============================");
		con.close();
	}

}
