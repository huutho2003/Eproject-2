package uit.edu.vn.connect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import uit.edu.vn.model.PhieuMuon;


public class PhieuMuonService extends ConnectMySQL
{
	public ArrayList<PhieuMuon> layThongTinPhieuMuon()
	{
		ArrayList<PhieuMuon> dspm=new ArrayList<PhieuMuon>();
		try
		{
			String sql="select * from phieumuon";
			PreparedStatement pre=connect.prepareStatement(sql);
			ResultSet result=pre.executeQuery();
			while(result.next())
			{
				PhieuMuon pm=new PhieuMuon();
				pm.setMaPM(result.getString(1));
				pm.setMaDG(result.getString(2));
				pm.setNgayMuon(result.getDate(3));
				pm.setNgayTra(result.getDate(4));
				pm.setSoLuong(result.getInt(5));
				pm.setUser(result.getString(6));
				dspm.add(pm);
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return dspm;
	}
	public ArrayList<PhieuMuon> timKiemPhieuMuonTheoMaKH(String ma) 
	{
		ArrayList<PhieuMuon> dspm=new ArrayList<PhieuMuon>();
		try
		{
			String sql="select * from phieumuon where makh=?";
			PreparedStatement pre=connect.prepareStatement(sql);
			pre.setString(1, ma);
			ResultSet result=pre.executeQuery();
			while(result.next())
			{
				PhieuMuon pm=new PhieuMuon();
			
				dspm.add(pm);
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return dspm;
	}
	public ArrayList<PhieuMuon> timKiemPhieuMuonTheoMaPM(String mapm) 
	{
		ArrayList<PhieuMuon> dspm=new ArrayList<PhieuMuon>();
		try
		{
			String sql="select * from phieumuon where maphieu=?";
			PreparedStatement pre=connect.prepareStatement(sql);
			pre.setString(1, mapm);
			ResultSet result=pre.executeQuery();
			while(result.next())
			{
				PhieuMuon pm=new PhieuMuon();
			
				dspm.add(pm);
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return dspm;
	}
	public ArrayList<PhieuMuon> timKiemPhieuMuonTheoMaSach(String masach) 
	{
		ArrayList<PhieuMuon> dspm=new ArrayList<PhieuMuon>();
		try
		{
			String sql="select * from phieumuon where masach=?";
			PreparedStatement pre=connect.prepareStatement(sql);
			pre.setString(1, masach);
			ResultSet result=pre.executeQuery();
			while(result.next())
			{
				PhieuMuon pm=new PhieuMuon();
			
				dspm.add(pm);
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return dspm;
	}

}
