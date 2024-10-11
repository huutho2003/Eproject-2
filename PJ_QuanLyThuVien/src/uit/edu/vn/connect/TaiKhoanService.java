package uit.edu.vn.connect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import uit.edu.vn.model.TaiKhoan;

public class TaiKhoanService extends ConnectMySQL
{
	public ArrayList<TaiKhoan> layTaiKhoan()
	{
		ArrayList<TaiKhoan> ds= new ArrayList<TaiKhoan>();
		try
		{
			String sql="Select * from taikhoan";
			PreparedStatement pre = connect.prepareStatement(sql);
			ResultSet result = pre.executeQuery();
			while(result.next())
			{
				TaiKhoan tk= new TaiKhoan();
				tk.setUser(result.getString(1));
				tk.setPass(result.getString(2));
				tk.setPhanQuyen(result.getInt(3));
				tk.setTenND(result.getString(4));
				tk.setSoDienThoai(result.getString(5));
				tk.setCMND(result.getString(6));
				ds.add(tk);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return ds;
	}
	public ArrayList<TaiKhoan> layTaiKhoanTheoUser(String User)
	{
		ArrayList<TaiKhoan> ds=new ArrayList<TaiKhoan>();
		try
		{
			String sql="Select * from taikhoan where user=?";
			PreparedStatement pre=connect.prepareStatement(sql);
			pre.setString(1, User);
			ResultSet result=pre.executeQuery();
			while(result.next())
			{
				TaiKhoan tk= new TaiKhoan();
				tk.setUser(result.getString(1));
				tk.setPass(result.getString(2));
				tk.setPhanQuyen(result.getInt(3));
				tk.setTenND(result.getString(4));
				tk.setSoDienThoai(result.getString(5));
				tk.setCMND(result.getString(6));
				ds.add(tk);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return ds;
	}
}

