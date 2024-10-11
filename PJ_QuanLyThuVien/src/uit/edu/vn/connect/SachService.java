package uit.edu.vn.connect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import uit.edu.vn.model.Sach;


public class SachService extends ConnectMySQL
{
	public ArrayList<Sach> layToanBoSach()
	{
		ArrayList<Sach> ds=new ArrayList<Sach>();
		try
		{
			String sql="select * from sach";
			PreparedStatement pre=connect.prepareStatement(sql);
			ResultSet result=pre.executeQuery();
			while(result.next())
			{
				Sach sh=new Sach();
				sh.setMaSach(result.getString(1));
				sh.setTenSach(result.getString(2));
				sh.setTenTG(result.getString(3));
				sh.setNhaXB(result.getString(4));
				sh.setTheLoai(result.getString(5));
				sh.setSoLuong(result.getInt(6));
				sh.setGiaTien(result.getDouble(7));
				ds.add(sh);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return ds;
	}
	public ArrayList<Sach> timKiemSachTheoMaSach(String masach)
	{
		ArrayList<Sach> ds=new ArrayList<Sach>();
		try
		{
			String sql="select * from sach where masach=?";
			PreparedStatement pre=connect.prepareStatement(sql);
			pre.setString(1, masach);
			ResultSet result=pre.executeQuery();
			while(result.next())
			{
				Sach sh=new Sach();
				
				ds.add(sh);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return ds;
	}
	public ArrayList<Sach> timKiemSachTheoMaNXB(String manxb)
	{
		ArrayList<Sach> ds=new ArrayList<Sach>();
		try
		{
			String sql="select * from sach where manxb=?";
			PreparedStatement pre=connect.prepareStatement(sql);
			pre.setString(1, manxb);
			ResultSet result=pre.executeQuery();
			while(result.next())
			{
				Sach sh=new Sach();
			
				ds.add(sh);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return ds;
	}
	public ArrayList<Sach> timKiemSachTheoTenSach(String tensach)
	{
		ArrayList<Sach> ds=new ArrayList<Sach>();
		try
		{
			String sql="select * from sach where tensach like ? ";
			PreparedStatement pre=connect.prepareStatement(sql);
			pre.setString(1, '%'+tensach+'%');
			ResultSet result=pre.executeQuery();
			while(result.next())
			{
				Sach sh=new Sach();
				
				ds.add(sh);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return ds;
	}
	public ArrayList<Sach> laySachTheoPhieuMuon(String mapm)
	{
		ArrayList<Sach> dssach=new ArrayList<Sach>();
		try
		{
			String sql= "Select a.MaSach,a.TenSach from sach a,ctpm b where a.MaSach=b.MaSach and b.MaPM=?";
			PreparedStatement pre= connect.prepareStatement(sql);
			pre.setString(1, mapm);
			ResultSet result= pre.executeQuery();
			while(result.next())
			{
				Sach sach=new Sach();
				sach.setMaSach(result.getString(1));
				sach.setTenSach(result.getString(2));
				dssach.add(sach);
			}
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return dssach;
	}

}
