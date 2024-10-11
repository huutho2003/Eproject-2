package uit.edu.vn.connect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import uit.edu.vn.model.DocGia;

public class DocGiaService extends ConnectMySQL
{
	public ArrayList<DocGia> layToanBoDocGia()
	{
		ArrayList<DocGia> dsdg=new ArrayList<DocGia>();
		try
		{
			String sql="select * from docgia";
			PreparedStatement pre=connect.prepareStatement(sql);
			ResultSet result=pre.executeQuery();
			while(result.next())
			{
				DocGia dg=new DocGia();
				dg.setMaDG(result.getString(1));
				dg.setTenDG(result.getString(2));
				dg.setSoDienThoai(result.getString(3));
				dg.setDiaChi(result.getString(4));
				dg.setGioiTinh(result.getString(5));
				dg.setMatSach(result.getInt(6));	
				dsdg.add(dg);
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return dsdg;
	}
	public ArrayList<DocGia> timDocGiaTheoMaDG(String madg)
	{
		ArrayList<DocGia> dsdg=new ArrayList<DocGia>();
		try
		{
			String sql="select * from docgia where madg=?";
			PreparedStatement pre=connect.prepareStatement(sql);
			pre.setString(1, madg);
			ResultSet result=pre.executeQuery();
			while(result.next())
			{
				DocGia dg=new DocGia();
				dg.setMaDG(result.getString(1));
				dg.setTenDG(result.getString(2));
				dg.setDiaChi(result.getString(3));
				dg.setGioiTinh(result.getString(4));
				dg.setSoDienThoai(result.getString(5));
				dsdg.add(dg);
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return dsdg;
	}

}
