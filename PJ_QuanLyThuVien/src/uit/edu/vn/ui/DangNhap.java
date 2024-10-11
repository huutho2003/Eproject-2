package uit.edu.vn.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import uit.edu.vn.connect.ConnectMySQL;
import uit.edu.vn.connect.TaiKhoanService;
import uit.edu.vn.model.TaiKhoan;

public class DangNhap extends JFrame {
	JButton btnDangNhap, btnThoat;
	JTextField txtTaiKhoan;
	JPasswordField pwdMatKhau;
	Connection connect=ConnectMySQL.connect;
	
	
	public DangNhap(String title)
	{
		super(title);
		addControls();
		addEvents();
	}
	private void addEvents() {
		
		btnThoat.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				System.exit(0);
				
			}
		});
		txtTaiKhoan.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				txtTaiKhoan.setText(null);

			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				txtTaiKhoan.setText(null);
				
			}
		});
		pwdMatKhau.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				pwdMatKhau.setEchoChar('*');
				pwdMatKhau.setText(null);
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				pwdMatKhau.setEchoChar('*');
				pwdMatKhau.setText(null);
				
			}
		});
		btnDangNhap.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				TaiKhoanService tksv= new TaiKhoanService();
				ArrayList<TaiKhoan> dstk= new ArrayList<TaiKhoan>();
				dstk= tksv.layTaiKhoan();
				if(txtTaiKhoan.getText().length() == 0)
				{
					JOptionPane.showMessageDialog(null, "Tài khoản không được để trống");
					return;
				}
				if(pwdMatKhau.getText().length() == 0)
				{
					JOptionPane.showMessageDialog(null, "Mật khẩu không được để trống");
					return;
				}
				for(TaiKhoan tk: dstk)
				{
					if(txtTaiKhoan.getText().equals(tk.getUser()) && pwdMatKhau.getText().equals(tk.getPass()) && tk.getPhanQuyen() == 1)
					{
						QuanLyAdmin qlad=new QuanLyAdmin("Trang Chủ Phần Mềm Quản Lý Thư Viện");				
						qlad.tentk=txtTaiKhoan.getText();
						qlad.showWindow();
						dispose();
						return;
					}
					if(txtTaiKhoan.getText().equals(tk.getUser()) && pwdMatKhau.getText().equals(tk.getPass()) && tk.getPhanQuyen() == 2)
					{
						QuanLyThuThu ql=new QuanLyThuThu("Thủ thư");
						ql.tentk=txtTaiKhoan.getText();
						ql.showWindow();
						dispose();
						return;
					}
				}		
					JOptionPane.showMessageDialog(null, "Sai tài khoản hoặc mật khẩu. Vui lòng nhập lại");
					txtTaiKhoan.setText(null);
					pwdMatKhau.setText(null);
				
			}
		});
		txtTaiKhoan.addKeyListener(new KeyListener() 
		{
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_TAB)
				{
					pwdMatKhau.setEchoChar('*');
					pwdMatKhau.setText(null);
				}
				// TODO Auto-generated method stub
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					TaiKhoanService tksv=new TaiKhoanService();
					ArrayList<TaiKhoan> dstk = new ArrayList<TaiKhoan>();
					dstk = tksv.layTaiKhoan();
					if(txtTaiKhoan.getText().length() == 0)
					{
						JOptionPane.showMessageDialog(null, "Tài khoản không được để trống");
						return;
					}
					if(pwdMatKhau.getText().length() == 0)
					{
						JOptionPane.showMessageDialog(null, "Mật khẩu không được để trống");
						return;
					}
					for(TaiKhoan ac: dstk)
					{
						if(txtTaiKhoan.getText().equals(ac.getUser()) && pwdMatKhau.getText().equals(ac.getPass()) && ac.getPhanQuyen() == 1)
						{
							QuanLyAdmin ql=new QuanLyAdmin("Trang Chủ Phần Mềm Quản Lý Thư Viện");				
							ql.tentk=txtTaiKhoan.getText();
							ql.showWindow();
							dispose();
							return;
						}
						if(txtTaiKhoan.getText().equals(ac.getUser()) && pwdMatKhau.getText().equals(ac.getPass()) && ac.getPhanQuyen() == 2)
						{
							QuanLyThuThu ql = new QuanLyThuThu("Thủ thư");
							ql.tentk=txtTaiKhoan.getText();
							ql.showWindow();
							dispose();
							return;
						}
					}		
						JOptionPane.showMessageDialog(null, "Sai tài khoản hoặc mật khẩu. Vui lòng Nhập lại");
						txtTaiKhoan.setText(null);
						pwdMatKhau.setText(null);
				}
			}
		});
		pwdMatKhau.addKeyListener(new KeyListener() 
		{
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					TaiKhoanService tksv=new TaiKhoanService();
					ArrayList<TaiKhoan> dstk = new ArrayList<TaiKhoan>();
					dstk = tksv.layTaiKhoan();
					if(txtTaiKhoan.getText().length() == 0)
					{
						JOptionPane.showMessageDialog(null, "Tài khoản không được để trống");
						return;
					}
					if(pwdMatKhau.getText().length() == 0)
					{
						JOptionPane.showMessageDialog(null, "Mật khẩu không được để trống");
						return;
					}
					for(TaiKhoan ac: dstk)
					{
						if(txtTaiKhoan.getText().equals(ac.getUser()) && pwdMatKhau.getText().equals(ac.getPass()) && ac.getPhanQuyen() == 1)
						{
							QuanLyAdmin ql=new QuanLyAdmin("Trang Chủ Phần Mềm Quản Lý Thư Viện");				
							ql.tentk=txtTaiKhoan.getText();
							ql.showWindow();
							dispose();
							return;
						}
						if(txtTaiKhoan.getText().equals(ac.getUser()) && pwdMatKhau.getText().equals(ac.getPass()) && ac.getPhanQuyen() == 2)
						{
							QuanLyThuThu ql = new QuanLyThuThu("Thủ thư");
							ql.tentk=txtTaiKhoan.getText();
							ql.showWindow();
							dispose();
							return;
						}
					}		
						JOptionPane.showMessageDialog(null, "Sai tài khoản hoặc mật khẩu. Vui lòng Nhập lại");
						txtTaiKhoan.setText(null);
						pwdMatKhau.setText(null);
				}
			}
		});
	}

	private void addControls() 
	{
		Container con = getContentPane();
		
		JPanel pnDangNhap = new JPanel();
		pnDangNhap.setLayout(new BorderLayout());
		con.add(pnDangNhap);
		
		JPanel pnTieuDe = new JPanel();
		JLabel lblTieuDe= new JLabel("PHẦN MỀM QUẢN LÝ THƯ VIỆN");
		pnTieuDe.add(lblTieuDe);
		pnDangNhap.add(pnTieuDe, BorderLayout.NORTH);
		
		JPanel pnLogin = new JPanel();
		pnLogin.setLayout(new BoxLayout(pnLogin, BoxLayout.Y_AXIS));
		
		JPanel pnTitle = new JPanel();
		pnTitle.setLayout(new FlowLayout());
		JLabel lblLogin= new JLabel("ĐĂNG NHẬP");
		pnTitle.add(lblLogin);
		
		JPanel pnTaiKhoan = new JPanel();
		pnTaiKhoan.setLayout(new FlowLayout());
		//JLabel lblTaiKhoan = new JLabel("TÀI KHOẢN  ");
		txtTaiKhoan = new JTextField("User name");
		txtTaiKhoan.setPreferredSize(new Dimension(350, 30));
		//pnTaiKhoan.add(lblTaiKhoan);
		pnTaiKhoan.add(txtTaiKhoan);
		
		JPanel pnMatKhau = new JPanel();
		pnMatKhau.setLayout(new FlowLayout());
		//JLabel lblMatKhau = new JLabel("MẬT KHẨU  ");
		pwdMatKhau = new JPasswordField("Password");
		pwdMatKhau.setEchoChar((char)0);
		pwdMatKhau.setPreferredSize(new Dimension(350, 30));
		//pnMatKhau.add(lblMatKhau);
		pnMatKhau.add(pwdMatKhau);
		
		JPanel pnThaoTac= new JPanel();
		pnThaoTac.setLayout(new FlowLayout());
		btnDangNhap= new JButton("Đăng nhập");
		btnThoat= new JButton("Thoát");
		btnDangNhap.setPreferredSize(new Dimension(130,35));
		pnThaoTac.add(btnDangNhap);
		pnThaoTac.add(btnThoat);
		
		JPanel pnLienHe = new JPanel();
		JLabel lblLienHe= new JLabel("THÔNG TIN TRỢ GIÚP - LIÊN HỆ: 0342565857");
		pnLienHe.add(lblLienHe);
		pnDangNhap.add(pnLienHe, BorderLayout.SOUTH);
		Font fontx= new Font("SVN-Avo", Font.BOLD, 13);
		lblLienHe.setFont(fontx);
		
		pnLogin.add(pnTitle);
		pnLogin.add(pnTaiKhoan);
		pnLogin.add(pnMatKhau);
		pnLogin.add(pnThaoTac);
		pnDangNhap.add(pnLogin, BorderLayout.CENTER);
		
		
		Font font1=new Font("SVN-Avo", Font.BOLD, 24); 
		Font font2= new Font("SVN-Avo", Font.TRUETYPE_FONT, 30);
		Font font3= new Font("SVN-Avo", Font.TRUETYPE_FONT, 15);
		Font font4= new Font("SVN-Avo", Font.BOLD, 15);
		Font font5= new Font("SVN-Avo", Font.BOLD, 10);
		lblTieuDe.setFont(font1);
		lblLogin.setFont(font1);
		//lblTaiKhoan.setFont(font3);
		//lblMatKhau.setFont(font3);
		txtTaiKhoan.setFont(font4);
		pwdMatKhau.setFont(font4);
		btnThoat.setFont(font5);
		btnDangNhap.setFont(font5);
		
		btnDangNhap.setIcon(new ImageIcon("Hinh/lock.png"));
		btnThoat.setIcon(new ImageIcon("Hinh/close.png"));
		
		pnTieuDe.setBackground(new java.awt.Color(48, 51, 107));
		lblTieuDe.setForeground(Color.WHITE);
		pnLienHe.setBackground(new java.awt.Color(48, 51, 107));
		lblLienHe.setForeground(Color.WHITE);
		
		pnTitle.setBackground(new java.awt.Color(241, 242, 246));
		lblLogin.setForeground(new java.awt.Color(48, 51, 107));
		pnTaiKhoan.setBackground(new java.awt.Color(241, 242, 246));
		pnMatKhau.setBackground(new java.awt.Color(241, 242, 246));
		pnThaoTac.setBackground(new java.awt.Color(241, 242, 246));
		
		btnDangNhap.setBackground(new java.awt.Color(48, 51, 107));
		btnDangNhap.setForeground(Color.white);
		btnThoat.setBackground(new java.awt.Color(48, 51, 107));
		btnThoat.setForeground(Color.white);
		
		
		btnThoat.setPreferredSize(btnDangNhap.getPreferredSize());
		//lblMatKhau.setPreferredSize(lblTaiKhoan.getPreferredSize() );
		
		Border borderLogin= BorderFactory.createLineBorder(new java.awt.Color(48, 51, 107));
		TitledBorder titleLogin= new TitledBorder(borderLogin, "");
		titleLogin.setTitleJustification(TitledBorder.LEFT);
		titleLogin.setTitleColor(Color.BLUE);
		pnLogin.setBorder(titleLogin);
		
	}
	public void showWindow()
	{
		this.setSize(540, 350);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
		
	}

}
