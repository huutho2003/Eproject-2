package uit.edu.vn.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
public class ConnectMySQL {
	public static Connection connect;
	public ConnectMySQL()
	{
		try
		{
			connect=DriverManager.getConnection("jdbc:mysql://127.0.0.1/qlsach", "root", "");

		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

}
