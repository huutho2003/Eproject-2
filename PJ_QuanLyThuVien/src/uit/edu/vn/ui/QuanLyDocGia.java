package uit.edu.vn.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import uit.edu.vn.connect.ConnectMySQL;


public class QuanLyDocGia extends JFrame 
{
	public String tentk = "";
	JTextField txtMaDocGia, txtTenDocGia, txtSDT, txtDiaChi, txtGioiTinh, txtLanMatSach;
	JButton btnThem, btnXoa, btnSua, btnQuayLai, btnThongTin;
	DefaultTableModel dtmPhieuMuon, dtmDocGia;
	JTable tblDocGia, tblPhieuMuon;
	Connection conn = ConnectMySQL.connect;
	public int thongke=0;	
	public QuanLyDocGia(String tieude) 
	{
		this.setTitle(tieude);
		addControls();
		lietKeDocGia();
		addEvents();
	}
	private void addEvents() 
	{
		btnQuayLai.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int phanquyen=0;
				if(thongke == 1)
				{
					ThongKe ui=new ThongKe("Thống kê");
					ui.tenTk=tentk;
					ui.showWindow();
					dispose();
					thongke =0;
					return;
				}
				try
				{

					String sql="select PhanQuyen from taikhoan where User=?";
					PreparedStatement pre=ConnectMySQL.connect.prepareStatement(sql);
					pre.setString(1, tentk);
					ResultSet rs=pre.executeQuery();
					while(rs.next())
					{
						phanquyen=rs.getInt(1);
					}
				}
				catch( Exception ex)
				{
					ex.printStackTrace();
				}
				if(phanquyen == 1)
				{
					QuanLyAdmin ql = new QuanLyAdmin("Trang Chủ Phần Mềm Quản Lý Thư Viện");
					ql.tentk = tentk;
					ql.showWindow();
					dispose();
				}
				if(phanquyen == 2)
				{
					QuanLyThuThu ql=new QuanLyThuThu("Thủ thư: "+tentk);
					ql.tentk = tentk;
					ql.showWindow();
					dispose();
				}
			}
		});
		
		btnThem.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				// TODO Auto-generated method stub
				uit.edu.vn.eventqldg.Them themdg = new uit.edu.vn.eventqldg.Them("Thêm độc giả");
				themdg.showWindow();
				dtmDocGia.setRowCount(0);
				lietKeDocGia();
			}
		});
		btnXoa.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				uit.edu.vn.eventqldg.Xoa xoadg = new uit.edu.vn.eventqldg.Xoa("Xóa độc giả");
				xoadg.machon = txtMaDocGia.getText();
				xoadg.hienThi();
				xoadg.showWindow();
				dtmDocGia.setRowCount(0);
				lietKeDocGia();
			}
		});
		btnSua.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				uit.edu.vn.eventqldg.Sua suadg =new uit.edu.vn.eventqldg.Sua("Sửa độc giả");
				suadg.ma = txtMaDocGia.getText();
				suadg.hienThi();
				suadg.showWindow();
				dtmDocGia.setRowCount(0);
				lietKeDocGia();
			}
		});
		
		tblDocGia.addMouseListener(new MouseListener() 
		{
			public void mouseClicked(MouseEvent e) 
			{
				int row = tblDocGia.rowAtPoint(e.getPoint());
				int col = tblDocGia.columnAtPoint(e.getPoint());
				int numcols = dtmDocGia.getColumnCount();

				for (int i = 0; i < numcols; i++) {
					String str = (String) dtmDocGia.getValueAt(row, i);
					if (i == 0)
						txtMaDocGia.setText(str);
					if (i == 1)
						txtTenDocGia.setText(str);
					if (i == 2)
						txtSDT.setText(str);
					if (i == 3)
						txtDiaChi.setText(str);
					if (i == 4)
						txtGioiTinh.setText(str);
					if (i == 5)
						txtLanMatSach.setText(str);
				}
				String ma = txtMaDocGia.getText();
				dtmPhieuMuon.setRowCount(0);
				lietKePhieuMuonTheoDocGia(ma);
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

		});
		btnThongTin.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String ma = "";
				int row = tblPhieuMuon.getSelectedRow();
				if (row == -1) 
				{
					JOptionPane.showMessageDialog(null, "Mời bạn chọn phiếu mượn");
					return;
				}
				ma = (String) dtmPhieuMuon.getValueAt(row, 0);
				uit.edu.vn.eventqldg.ChiTiet a = new uit.edu.vn.eventqldg.ChiTiet("Chi tiết phiếu mượn");
				a.ma = ma;
				a.hienThi();
				a.showWindow();
			}
		});
		
	}
	private void lietKeDocGia() 
	{
		try {
			String sql = "select * from docgia";
			PreparedStatement stat = conn.prepareStatement(sql);
			ResultSet result = stat.executeQuery(sql);
			while (result.next()) {
				String ma = result.getString(1);
				String ten = result.getString(2);
				String sdt = result.getString(3);
				String diachi = result.getString(4);
				String gioitinh = result.getString(5);
				String matsach = String.valueOf(result.getInt(6));

				Vector<Object> vec = new Vector<>();
				vec.add(ma);
				vec.add(ten);
				vec.add(sdt);
				vec.add(diachi);
				vec.add(gioitinh);
				vec.add(matsach);
				dtmDocGia.addRow(vec);
			}

		} 
		catch (Exception ex) 
		{
			ex.printStackTrace();
		}

		
	}
	void lietKePhieuMuonTheoDocGia(String ma) 
	{
		try 
		{
			String sql = "select * from phieumuon where madg=?";
			PreparedStatement pre=conn.prepareStatement(sql);
			pre.setString(1, ma);
			ResultSet result = pre.executeQuery();
			while (result.next()) 
			{
				String maphieu = result.getString("mapm");
				String soluongmuon = String.valueOf(result.getInt("soluongmuon"));
				
				Vector<String> vec = new Vector<String>();
				vec.add(maphieu);
				vec.add(soluongmuon);

				dtmPhieuMuon.addRow(vec);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void addControls() 
	{
		Container con= getContentPane();
		
		JPanel pnDocGia = new JPanel();
		pnDocGia.setLayout(new BorderLayout());
		con.add(pnDocGia);
		
		JPanel pnTieuDe = new JPanel();
		JLabel lblTieuDe= new JLabel("QUẢN LÝ ĐỘC GIẢ");
		pnTieuDe.add(lblTieuDe);
		pnDocGia.add(pnTieuDe, BorderLayout.NORTH);
		Font font1=new Font("SVN-Avo", Font.BOLD, 24); 
		lblTieuDe.setFont(font1);
		pnTieuDe.setBackground(new java.awt.Color(48, 51, 107));
		lblTieuDe.setForeground(Color.WHITE);
		
		JPanel pnLienHe = new JPanel();
		JLabel lblLienHe= new JLabel("THÔNG TIN TRỢ GIÚP - LIÊN HỆ: 0342565857");
		pnLienHe.add(lblLienHe);
		pnDocGia.add(pnLienHe, BorderLayout.SOUTH);
		pnLienHe.setBackground(new java.awt.Color(48, 51, 107));
		lblLienHe.setForeground(Color.WHITE);
		Font fontx= new Font("SVN-Avo", Font.BOLD, 13);
		lblLienHe.setFont(fontx);
		
		JPanel pnThongTin= new JPanel();
		pnThongTin.setLayout(new BorderLayout());
		pnDocGia.add(pnThongTin, BorderLayout.CENTER);
		
		JPanel pnHienThiChiTiet = new JPanel();
		pnHienThiChiTiet.setLayout(new BorderLayout());
		pnThongTin.add(pnHienThiChiTiet, BorderLayout.CENTER);
		
		JPanel pnThongTinChiTiet = new JPanel();
		pnThongTinChiTiet.setLayout(new BoxLayout(pnThongTinChiTiet, BoxLayout.Y_AXIS));
		pnHienThiChiTiet.add(pnThongTinChiTiet, BorderLayout.WEST);
		pnThongTinChiTiet.setPreferredSize(new Dimension(450,0));
		
		JPanel pnTieuDe1= new JPanel();
		JLabel lblTieuDe1= new JLabel("THÔNG TIN CHI TIẾT");
		pnTieuDe1.add(lblTieuDe1);
		pnThongTinChiTiet.add(pnTieuDe1, BorderLayout.NORTH);
		
		Font font2=new Font("SVN-Avo", Font.BOLD, 18); 
		lblTieuDe1.setFont(font2);
		pnTieuDe1.setBackground(new java.awt.Color(255, 177, 66));
		lblTieuDe1.setForeground(Color.WHITE);
		
		JPanel pnMaDocGia = new JPanel();
		pnMaDocGia.setLayout(new FlowLayout());
		pnThongTinChiTiet.add(pnMaDocGia);
		JLabel lblMaDocGia= new JLabel("Mã độc giả: ");
		txtMaDocGia= new JTextField();
		txtMaDocGia.setPreferredSize(new Dimension(240, 22));
		pnMaDocGia.add(lblMaDocGia);
		pnMaDocGia.add(txtMaDocGia);
		
		JPanel pnTenDG=new JPanel();
		pnTenDG.setLayout(new FlowLayout());
		pnThongTinChiTiet.add(pnTenDG);
		JLabel lblTenDG=new JLabel("Tên độc giả: ");
		pnTenDG.add(lblTenDG);
		txtTenDocGia=new JTextField();
		txtTenDocGia.setPreferredSize(new Dimension(240, 22));
		pnTenDG.add(txtTenDocGia);
		
		JPanel pnSoDienThoai = new JPanel();
		pnSoDienThoai.setLayout(new FlowLayout());
		pnThongTinChiTiet.add(pnSoDienThoai);
		JLabel lblSoDienThoai=new JLabel("Số điện thoại: ");
		pnSoDienThoai.add(lblSoDienThoai);
		txtSDT=new JTextField();
		txtSDT.setPreferredSize(new Dimension(240, 22));
		pnSoDienThoai.add(txtSDT);
		
		JPanel pnDiaChi = new JPanel();
		pnDiaChi.setLayout(new FlowLayout());
		pnThongTinChiTiet.add(pnDiaChi);
		JLabel lblDiaChi= new JLabel("Địa chỉ: ");
		txtDiaChi= new JTextField();
		txtDiaChi.setPreferredSize(new Dimension(240, 22));
		pnDiaChi.add(lblDiaChi);
		pnDiaChi.add(txtDiaChi);
		
		JPanel pnGioiTinh = new JPanel();
		pnGioiTinh.setLayout(new FlowLayout());
		pnThongTinChiTiet.add(pnGioiTinh);
		JLabel lblGioiTinh= new JLabel("Giới tính: ");
		txtGioiTinh= new JTextField();
		txtGioiTinh.setPreferredSize(new Dimension(240, 22));
		pnGioiTinh.add(lblGioiTinh);
		pnGioiTinh.add(txtGioiTinh);
		
		JPanel pnMatSach = new JPanel();
		pnMatSach.setLayout(new FlowLayout());
		pnThongTinChiTiet.add(pnMatSach);
		JLabel lblMatSach= new JLabel("Số lần mất sách: ");
		txtLanMatSach= new JTextField();
		txtLanMatSach.setPreferredSize(new Dimension(240, 22));
		pnMatSach.add(lblMatSach);
		pnMatSach.add(txtLanMatSach);
		
		JPanel pnThaoTac=new JPanel();
		pnThaoTac.setLayout(new BorderLayout());
		pnHienThiChiTiet.add(pnThaoTac, BorderLayout.CENTER);
		
		JPanel pnQuayLai = new JPanel();
		pnQuayLai.setLayout(new FlowLayout());
		btnQuayLai= new JButton("QUAY LẠI");
		btnQuayLai.setBackground(new java.awt.Color(255, 177, 66));
		Font font4= new Font("SVN-Avo", Font.BOLD, 15);
		btnQuayLai.setFont(font4);
		pnQuayLai.add(btnQuayLai);
		btnQuayLai.setForeground(Color.WHITE);
		pnQuayLai.setBackground(new java.awt.Color(255, 177, 66));
		pnThaoTac.add(pnQuayLai, BorderLayout.NORTH);
		
		JPanel pnChucNang= new JPanel();
		pnChucNang.setLayout(new BoxLayout(pnChucNang, BoxLayout.Y_AXIS));
		
		JPanel pnThem= new JPanel();
		pnThem.setLayout(new FlowLayout());
		btnThem= new JButton();
		pnThem.add(btnThem);
		btnThem.setBackground(new java.awt.Color(255, 177, 66));
		pnThem.setBackground(new java.awt.Color(255, 177, 66));
		
		/* JPanel pnTimKiem= new JPanel();
		pnTimKiem.setLayout(new FlowLayout());
		btnTimKiem= new JButton();
		btnTimKiem.setBackground(new java.awt.Color(255, 177, 66));
		pnTimKiem.add(btnTimKiem);
		pnTimKiem.setBackground(new java.awt.Color(255, 177, 66)); 
		*/
		
		JPanel pnXoa= new JPanel();
		pnXoa.setLayout(new FlowLayout());
		btnXoa= new JButton();
		btnXoa.setBackground(new java.awt.Color(255, 177, 66));
		pnXoa.add(btnXoa);
		pnXoa.setBackground(new java.awt.Color(255, 177, 66));
		
		JPanel pnSua= new JPanel();
		pnSua.setLayout(new FlowLayout());
		btnSua= new JButton();
		btnSua.setBackground(new java.awt.Color(255, 177, 66));
		pnSua.add(btnSua);
		pnSua.setBackground(new java.awt.Color(255, 177, 66));
		
		pnChucNang.add(pnThem);
		pnChucNang.add(pnXoa);
		pnChucNang.add(pnSua);
		
		pnThaoTac.add(pnChucNang, BorderLayout.CENTER);
		
		JPanel pnThongKePhieuMuon=new JPanel();
		pnThongKePhieuMuon.setLayout(new BorderLayout());
		pnHienThiChiTiet.add(pnThongKePhieuMuon, BorderLayout.EAST);
		
		JPanel pnTieuDe2=new JPanel();
		pnThongKePhieuMuon.add(pnTieuDe2,BorderLayout.NORTH);
		JLabel lblTieuDe2=new JLabel("DANH SÁCH PHIẾU MƯỢN");
		lblTieuDe2.setFont(font2);
		pnTieuDe2.setBackground(new java.awt.Color(255, 177, 66));
		lblTieuDe2.setForeground(Color.WHITE);
		pnTieuDe2.add(lblTieuDe2);
			
		dtmPhieuMuon=new DefaultTableModel();
		dtmPhieuMuon.addColumn("Mã phiếu");
		dtmPhieuMuon.addColumn("Số sách mượn");
		tblPhieuMuon=new JTable(dtmPhieuMuon);
		JScrollPane scPhieuMuon =new JScrollPane(tblPhieuMuon, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scPhieuMuon.setPreferredSize(new Dimension(450,300));
		pnThongKePhieuMuon.add(scPhieuMuon, BorderLayout.CENTER);
		
		JPanel pnChiTiet= new JPanel();
		pnChiTiet.setLayout(new FlowLayout());
		btnThongTin= new JButton("CHI TIẾT");
		pnChiTiet.add(btnThongTin);
		btnThongTin.setFont(font4);
		btnThongTin.setForeground(new java.awt.Color(255, 177, 66));
		btnThongTin.setBackground(new java.awt.Color(255, 255, 255));
		pnChiTiet.setBackground(new java.awt.Color(255, 255, 255));
		
		pnThongKePhieuMuon.add(pnChiTiet, BorderLayout.SOUTH);

		JPanel pnBangThongKe = new JPanel();
		pnBangThongKe.setLayout(new BorderLayout());
		
		dtmDocGia=new DefaultTableModel();
		dtmDocGia.addColumn("Mã độc giả");
		dtmDocGia.addColumn("Tên độc giả");
		dtmDocGia.addColumn("Số điện thoại");
		dtmDocGia.addColumn("Địa chỉ");
		dtmDocGia.addColumn("Giới tính");
		dtmDocGia.addColumn("Số lần mất sách");
		
		tblDocGia=new JTable(dtmDocGia);
		JScrollPane scDocGia=new JScrollPane(tblDocGia, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scDocGia.setPreferredSize(new Dimension(400, 350));
		scDocGia.setBackground(new java.awt.Color(255, 255, 255));
		//tblDocGia.setFont(font4);
		pnBangThongKe.add(scDocGia, BorderLayout.CENTER);
		
		JPanel pnTieuDe3= new JPanel();
		JLabel lblTieuDe3= new JLabel("DANH SÁCH ĐỘC GIẢ");
		pnTieuDe3.add(lblTieuDe3);
		pnBangThongKe.add(pnTieuDe3, BorderLayout.NORTH);
		lblTieuDe3.setFont(font2);
		pnTieuDe3.setBackground(new java.awt.Color(48, 51, 107));
		lblTieuDe3.setForeground(Color.WHITE);
		
		pnThongTin.add(pnBangThongKe, BorderLayout.SOUTH);
		
		btnThem.setIcon(new ImageIcon("Hinh/themmoi.png"));
		btnXoa.setIcon(new ImageIcon("Hinh/xoa.png"));
		btnSua.setIcon(new ImageIcon("Hinh/chinhsua.png"));
		btnThongTin.setBorder(BorderFactory.createLineBorder(new java.awt.Color(255, 177, 66)));
		btnQuayLai.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		btnThem.setBorder(null);
		btnXoa.setBorder(null);
		btnSua.setBorder(null); 
		
		btnQuayLai.setPreferredSize(new Dimension(200,30));
		btnThongTin.setPreferredSize(new Dimension(120,30));
		btnThem.setPreferredSize(new Dimension(210, 60));
		btnXoa.setPreferredSize(btnThem.getPreferredSize());
		btnSua.setPreferredSize(btnThem.getPreferredSize());
		
		Font font3=new Font("SVN-Avo", Font.BOLD, 14); 
		lblMaDocGia.setFont(font3);
		lblMatSach.setFont(font3);
		lblTenDG.setFont(font3);
		lblDiaChi.setFont(font3);
		lblGioiTinh.setFont(font3);
		lblSoDienThoai.setFont(font3);
		
		lblMaDocGia.setPreferredSize(lblMatSach.getPreferredSize());
		lblTenDG.setPreferredSize(lblMatSach.getPreferredSize());
		lblDiaChi.setPreferredSize(lblMatSach.getPreferredSize());
		lblGioiTinh.setPreferredSize(lblMatSach.getPreferredSize());
		lblSoDienThoai.setPreferredSize(lblMatSach.getPreferredSize());
		
		pnMaDocGia.setBackground(new java.awt.Color(255, 255, 255));
		pnTenDG.setBackground(new java.awt.Color(255, 255, 255));
		pnMatSach.setBackground(new java.awt.Color(255, 255, 255));
		pnSoDienThoai.setBackground(new java.awt.Color(255, 255, 255));
		pnDiaChi.setBackground(new java.awt.Color(255, 255, 255));
		pnGioiTinh.setBackground(new java.awt.Color(255, 255, 255));

		
		txtMaDocGia.setEditable(false);
		txtTenDocGia.setEditable(false);
		txtLanMatSach.setEditable(false);
		txtSDT.setEditable(false);
		txtGioiTinh.setEditable(false);
		txtDiaChi.setEditable(false);
		
	}
	public void showWindow()
	{
		this.setSize(1130,780);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
	}

}
