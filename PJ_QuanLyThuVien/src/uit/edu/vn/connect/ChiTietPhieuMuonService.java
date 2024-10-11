package uit.edu.vn.connect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import uit.edu.vn.model.ChiTietPhieuMuon;


public class ChiTietPhieuMuonService extends ConnectMySQL
{
	public ArrayList<ChiTietPhieuMuon> layChiTietPhieuMuon()
	{
		ArrayList<ChiTietPhieuMuon> dspm=new ArrayList<ChiTietPhieuMuon>();
		try
		{
			String sql="Select * from ctpm";
			PreparedStatement pre=connect.prepareStatement(sql);
			ResultSet result=pre.executeQuery();
			while(result.next())
			{
				ChiTietPhieuMuon ctpm=new ChiTietPhieuMuon();
				ctpm.setMaPM(result.getString(1));
				ctpm.setMaSach(result.getString(2));
				ctpm.setNgayTra(result.getDate(3));
				ctpm.setTinhTrangSach(result.getInt(4));
				ctpm.setTinhTrangTra(result.getInt(5));
				ctpm.setUser(result.getString(6));
				ctpm.setGhiChu(result.getString(7));
				dspm.add(ctpm);
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return dspm;
	}

}
