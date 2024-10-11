package uit.edu.vn.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class QuanLyThuThu extends JFrame
{
	JButton btnQLDG, btnQLPM, btnQLPT, btnQLS, btnDoiMK, btnDangXuat;
	public String tentk="";
	public QuanLyThuThu(String title)
	{
		super(title);
		addControls();
		addEvents();
	}

	public void addEvents() 
	{
		btnDangXuat.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				DangNhap login=new DangNhap("Đăng nhập");
				login.showWindow();
				dispose();
			}
		});
		btnQLPM.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				QuanLyPhieuMuon qlpm= new QuanLyPhieuMuon("Quản lý phiếu mượn");
				qlpm.tentk=tentk;
				qlpm.showWindow();
				dispose();
			}
		});
		btnQLPT.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				QuanLyPhieuTra qlpt= new QuanLyPhieuTra("Quản lý phiếu trả");
				qlpt.tentk= tentk;
				qlpt.showWindow();
				dispose();
				
			}
		});
		btnQLDG.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				QuanLyDocGia qldg= new QuanLyDocGia("Quản lý độc giả");
				qldg.tentk= tentk;
				qldg.showWindow();
				dispose();
				
			}
		});
		
		btnQLS.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				QuanLySach qls= new QuanLySach("Quản lý sách");
				qls.tentk= tentk;
				qls.showWindow();
				dispose();
				
			}
		});
		btnDoiMK.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				DoiMatKhau dmk= new DoiMatKhau("Đổi mật khẩu");
				dmk.tentk= tentk;
				dmk.HienThi();
				dmk.showWindow();
				dispose();
				
			}
		});
		
	}

	public void addControls() 
	{
		Container con= getContentPane();
		
		JPanel pnTrangChu = new JPanel();
		pnTrangChu.setLayout(new BorderLayout());
		con.add(pnTrangChu);
		
		JPanel pnTieuDe = new JPanel();
		JLabel lblTieuDe= new JLabel("TRANG CHỦ: QUẢN LÝ THƯ VIỆN");
		pnTieuDe.add(lblTieuDe);
		pnTrangChu.add(pnTieuDe, BorderLayout.NORTH);
		
		JPanel pnLienHe = new JPanel();
		JLabel lblLienHe= new JLabel("THÔNG TIN TRỢ GIÚP - LIÊN HỆ: 0342565857");
		pnLienHe.add(lblLienHe);
		pnTrangChu.add(pnLienHe, BorderLayout.SOUTH);
		pnLienHe.setBackground(new java.awt.Color(48, 51, 107));
		lblLienHe.setForeground(Color.WHITE);
		Font fontx= new Font("SVN-Avo", Font.BOLD, 13);
		lblLienHe.setFont(fontx);
		
		
		JPanel pnQuanLy = new JPanel();
		pnQuanLy.setLayout(new BoxLayout(pnQuanLy, BoxLayout.Y_AXIS));
		
		JPanel pnHang1= new JPanel();
		pnHang1.setLayout(new FlowLayout());
		pnHang1.setBackground(Color.WHITE);
		btnQLS = new JButton();
		btnQLDG = new JButton();
		
		JPanel pnHang2= new JPanel();
		pnHang2.setLayout(new FlowLayout());
		pnHang2.setBackground(Color.WHITE);
		btnQLPM = new JButton();
		btnQLPT = new JButton();
		
		JPanel pnHang3= new JPanel();
		pnHang3.setLayout(new FlowLayout());
		pnHang3.setBackground(Color.WHITE);
		JLabel lblHinhAnh1 = new JLabel();
		lblHinhAnh1.setIcon(new ImageIcon("Hinh/anhnen.png"));
		pnHang3.add(lblHinhAnh1);
		
		btnQLS.setPreferredSize(new Dimension(270,150));
		btnQLPM.setPreferredSize(btnQLS.getPreferredSize());
		btnQLDG.setPreferredSize(btnQLS.getPreferredSize());
		btnQLPT.setPreferredSize(btnQLS.getPreferredSize());
		
		btnQLS.setBackground(new java.awt.Color(51, 217, 178));
		btnQLPM.setBackground(new java.awt.Color(37, 204, 247));
		btnQLPT.setBackground(new java.awt.Color(237, 76, 103));
		btnQLDG.setBackground(new java.awt.Color(204, 142, 53));
		
		
		btnQLS.setIcon(new ImageIcon("Hinh/sach.png"));
		btnQLPM.setIcon(new ImageIcon("Hinh/phieumuon.png"));
		btnQLDG.setIcon(new ImageIcon("Hinh/docgia.png"));
		btnQLPT.setIcon(new ImageIcon("Hinh/phieutra.png"));
		
		pnHang1.add(btnQLS);
		pnHang1.add(btnQLDG);
		pnHang2.add(btnQLPM);
		pnHang2.add(btnQLPT);
		
		pnQuanLy.add(pnHang1);
		pnQuanLy.add(pnHang2);
		pnQuanLy.add(pnHang3);
		
		pnTrangChu.add(pnQuanLy, BorderLayout.EAST);		
		 
	
		JPanel pnChucNang = new JPanel();
		pnChucNang.setLayout(new BoxLayout(pnChucNang, BoxLayout.Y_AXIS));
		
		JPanel pnHinhAnh= new JPanel();
		pnHinhAnh.setLayout(new FlowLayout());
		JLabel lblHinhAnh= new JLabel();
		pnHinhAnh.setBackground(Color.WHITE);
		lblHinhAnh.setIcon(new ImageIcon("Hinh/gd.png"));
		pnHinhAnh.add(lblHinhAnh);
		
		JPanel pnDoiMatKhau = new JPanel();
		pnDoiMatKhau.setLayout(new FlowLayout());
		btnDoiMK = new JButton("Đổi mật khẩu");
		pnDoiMatKhau.add(btnDoiMK);
		btnDoiMK.setPreferredSize(new Dimension(300,60));
		pnDoiMatKhau.setBackground(Color.WHITE);
		btnDoiMK.setBackground(new java.awt.Color(48, 51, 107));
		btnDoiMK.setForeground(Color.WHITE);
	
		JPanel pnDangXuat = new JPanel();
		pnDangXuat.setLayout(new FlowLayout());
		btnDangXuat = new JButton("Đăng xuất");
		pnDangXuat.add(btnDangXuat);
		btnDangXuat.setPreferredSize(new Dimension(300,60));
		pnDangXuat.setBackground(Color.WHITE);
		btnDangXuat.setBackground(new java.awt.Color(48, 51, 107));
		btnDangXuat.setForeground(Color.WHITE);
	
		
		Font font2= new Font("SVN-Avo", Font.BOLD, 25);
		btnDoiMK.setFont(font2);
		btnDangXuat.setFont(font2);
		
		
		pnChucNang.add(pnHinhAnh);
		pnChucNang.add(pnDoiMatKhau);
		pnChucNang.add(pnDangXuat);
		
		pnTrangChu.add(pnChucNang, BorderLayout.WEST);
		
		
		Font font1=new Font("SVN-Avo", Font.BOLD, 24); 
		lblTieuDe.setFont(font1);
		
		pnTieuDe.setBackground(new java.awt.Color(48, 51, 107));
		lblTieuDe.setForeground(Color.WHITE);
		
		btnQLDG.setBorder(null);
		btnQLPM.setBorder(null);
		btnQLPT.setBorder(null);
		btnQLS.setBorder(null);
		
	}
	public void showWindow()
	{
		this.setSize(888,600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
	}
}
