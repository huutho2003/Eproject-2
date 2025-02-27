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

public class DoiMatKhau extends JFrame {
	JButton btnLuu, btnQuayLai, btnLamLai;
	JPasswordField pwdMatKhauCu, pwdMatKhauMoi, pwdNhapLaiMKM;
	Connection connect=ConnectMySQL.connect;
	JTextField txtTaiKhoan, txtMatKhauCu, txtMatKhauMoi, txtNhapLaiMKM;
	public String tentk="";
	Connection con=ConnectMySQL.connect; 
	
	
	public DoiMatKhau (String tieude)
	{
		super(tieude);
		addControls();
		addEvents();
		if(tentk.length() != 0)
		{
			HienThi();
		}
	}
	public void HienThi() 
	{
		txtTaiKhoan.setText(tentk);
	}

	public void addEvents() 
	{
		btnQuayLai.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int phanquyen=0;
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
					QuanLyAdmin ql = new QuanLyAdmin("Admin");
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
		
		pwdMatKhauCu.addMouseListener(new MouseListener() 
		{
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
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
			public void mouseClicked(MouseEvent e) 
			{
				pwdMatKhauCu.setEchoChar('*');
				pwdMatKhauCu.setText(null);
				
			}
		});
		
		pwdMatKhauMoi.addMouseListener(new MouseListener() 
		{
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
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
			public void mouseClicked(MouseEvent e) 
			{
				pwdMatKhauMoi.setEchoChar('*');
				pwdMatKhauMoi.setText(null);
				
			}
		});
		
		pwdNhapLaiMKM.addMouseListener(new MouseListener() 
		{
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
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
			public void mouseClicked(MouseEvent e) 
			{
				pwdNhapLaiMKM.setEchoChar('*');
				pwdNhapLaiMKM.setText(null);
				
			}
		});
		btnLamLai.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				pwdMatKhauCu.setText(null);
				pwdMatKhauMoi.setText(null);
				pwdNhapLaiMKM.setText(null);
				
			}
		});
		
		btnLuu.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				// TODO Auto-generated method stub
				TaiKhoanService tksv = new TaiKhoanService();
				ArrayList<TaiKhoan> dstk=new ArrayList<TaiKhoan>();
				dstk= tksv.layTaiKhoan();
				for(TaiKhoan tk: dstk)
				{
					if(txtTaiKhoan.getText().equals(tk.getUser()) && pwdMatKhauCu.getText().equals(tk.getPass()))
					{
						if(pwdMatKhauMoi.getText().equals(pwdNhapLaiMKM.getText()))
						{
							try
							{
								String sql="Update taikhoan set password=? where user=?";
								PreparedStatement pre=con.prepareStatement(sql);
								pre.setString(1, pwdNhapLaiMKM.getText());
								pre.setString(2, txtTaiKhoan.getText());
								int x=pre.executeUpdate();
								if(x>0)
								{
									JOptionPane.showMessageDialog(null,"Đổi mật khẩu thành công");
									pwdMatKhauCu.setText(null);
									pwdMatKhauMoi.setText(null);
									pwdNhapLaiMKM.setText(null);
									return;
								}
							}
							catch(Exception ex)
							{
								ex.printStackTrace();
							}
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Mật khẩu mới chưa trùng khớp");
							pwdMatKhauMoi.setText(null);
							pwdNhapLaiMKM.setText(null);
							return;
						}
					}
				}
				JOptionPane.showMessageDialog(null, "Mật khẩu cũ chưa đúng. Mời nhập lại!");
				pwdMatKhauCu.setText(null);
				pwdMatKhauMoi.setText(null);
				pwdNhapLaiMKM.setText(null);
			}
			
		});
	}

	private void addControls() 
	{
		Container con = getContentPane();
		
		JPanel pnDoiMatKhau= new JPanel();
		pnDoiMatKhau.setLayout(new BorderLayout());
		con.add(pnDoiMatKhau);
		
		JPanel pnTieuDe = new JPanel();
		JLabel lblTieuDe= new JLabel("PHẦN MỀM QUẢN LÝ THƯ VIỆN");
		pnTieuDe.add(lblTieuDe);
		pnDoiMatKhau.add(pnTieuDe, BorderLayout.NORTH);
		
		JPanel pnLienHe = new JPanel();
		JLabel lblLienHe= new JLabel("THÔNG TIN TRỢ GIÚP - LIÊN HỆ: fn anh an");
		pnLienHe.add(lblLienHe);
		pnDoiMatKhau.add(pnLienHe, BorderLayout.SOUTH);
		
		JPanel pnHienThiDoiMatKhau = new JPanel();
		pnHienThiDoiMatKhau.setLayout(new BorderLayout());
		pnDoiMatKhau.add(pnHienThiDoiMatKhau, BorderLayout.CENTER);
		
		JPanel pnHinhAnh= new JPanel();
		pnHinhAnh.setLayout(new FlowLayout());
		JLabel lblHinhAnh= new JLabel();
		pnHinhAnh.setBackground(Color.WHITE);
		lblHinhAnh.setIcon(new ImageIcon("Hinh/doimatkhau.png"));
		pnHinhAnh.add(lblHinhAnh);
		pnHienThiDoiMatKhau.add(pnHinhAnh, BorderLayout.WEST);
		
		JPanel pnHienThiChiTiet = new JPanel();
		pnHienThiChiTiet.setLayout(new BoxLayout(pnHienThiChiTiet, BoxLayout.Y_AXIS));
		pnHienThiDoiMatKhau.add(pnHienThiChiTiet, BorderLayout.CENTER);
		
		JPanel pnTitle = new JPanel();
		pnTitle.setLayout(new FlowLayout());
		JLabel lblDoiMatKhau= new JLabel("ĐỔI MẬT KHẨU");
		pnTitle.add(lblDoiMatKhau);
		
		JPanel pnTaiKhoan = new JPanel();
		pnTaiKhoan.setLayout(new FlowLayout());
		txtTaiKhoan = new JTextField();
		txtTaiKhoan.setPreferredSize(new Dimension(340, 30));
		pnTaiKhoan.add(txtTaiKhoan);
		txtTaiKhoan.setEditable(false);
		
		JPanel pnMatKhauCu = new JPanel();
		pnMatKhauCu.setLayout(new FlowLayout());
		pwdMatKhauCu = new JPasswordField("Mật khẩu cũ");
		pwdMatKhauCu.setEchoChar((char)0);
		pwdMatKhauCu.setPreferredSize(new Dimension(340, 30));
		pnMatKhauCu.add(pwdMatKhauCu);
		
		JPanel pnMatKhauMoi = new JPanel();
		pnMatKhauMoi.setLayout(new FlowLayout());
		pwdMatKhauMoi = new JPasswordField("Mật khẩu mới");
		pwdMatKhauMoi.setEchoChar((char)0);
		pwdMatKhauMoi.setPreferredSize(new Dimension(340, 30));
		pnMatKhauMoi.add(pwdMatKhauMoi);
		
		JPanel pnNhapLaiMKM = new JPanel();
		pnNhapLaiMKM.setLayout(new FlowLayout());
		pwdNhapLaiMKM= new JPasswordField("Nhập lại mật khẩu mới");
		pwdNhapLaiMKM.setEchoChar((char)0);
		pwdNhapLaiMKM.setPreferredSize(new Dimension(340, 30));
		pnNhapLaiMKM.add(pwdNhapLaiMKM);
		
		pnHienThiChiTiet.add(pnTitle);
		pnHienThiChiTiet.add(pnTaiKhoan);
		pnHienThiChiTiet.add(pnMatKhauCu);
		pnHienThiChiTiet.add(pnMatKhauMoi);
		pnHienThiChiTiet.add(pnNhapLaiMKM);
		
		JPanel pnThaoTac= new JPanel();
		pnThaoTac.setLayout(new FlowLayout());
		pnHienThiChiTiet.add(pnThaoTac);
		btnLuu= new JButton("LƯU");
		btnLamLai= new JButton("LÀM LẠI");
		btnQuayLai= new JButton("TRANG CHỦ");
		btnQuayLai.setPreferredSize(new Dimension(110,35));
		pnThaoTac.add(btnLamLai);
		pnThaoTac.add(btnLuu);
		pnThaoTac.add(btnQuayLai);
		
		Font font1=new Font("SVN-Avo", Font.BOLD, 24); 
		Font font2= new Font("SVN-Avo", Font.BOLD, 30);
		Font font3= new Font("SVN-Avo", Font.TRUETYPE_FONT, 15);
		Font font4= new Font("SVN-Avo", Font.BOLD, 15);
		Font font5= new Font("SVN-Avo", Font.BOLD, 13);
		lblTieuDe.setFont(font1);
		lblDoiMatKhau.setFont(font2);
		txtTaiKhoan.setFont(font4);
		pwdMatKhauCu.setFont(font4);
		pwdNhapLaiMKM.setFont(font4);
		pwdMatKhauMoi.setFont(font4);
		lblLienHe.setFont(font4);
		
		btnLamLai.setFont(font5);
		btnQuayLai.setFont(font5);
		btnLuu.setFont(font5);
		
		/*btnDangNhap.setIcon(new ImageIcon("Hinh/lock.png"));
		btnThoat.setIcon(new ImageIcon("Hinh/close.png"));  */
		
		pnTieuDe.setBackground(new java.awt.Color(48, 51, 107));
		lblTieuDe.setForeground(Color.WHITE);
		pnLienHe.setBackground(new java.awt.Color(48, 51, 107));
		lblLienHe.setForeground(Color.WHITE);
		
		pnTitle.setBackground(new java.awt.Color(241, 242, 246));
		lblDoiMatKhau.setForeground(new java.awt.Color(48, 51, 107));
		pnTaiKhoan.setBackground(new java.awt.Color(241, 242, 246));
		pnMatKhauCu.setBackground(new java.awt.Color(241, 242, 246));
		pnMatKhauMoi.setBackground(new java.awt.Color(241, 242, 246));
		pnNhapLaiMKM.setBackground(new java.awt.Color(241, 242, 246));
		pnThaoTac.setBackground(new java.awt.Color(241, 242, 246));
		pnHinhAnh.setBackground(new java.awt.Color(241, 242, 246));
		
		btnLamLai.setBackground(new java.awt.Color(255, 177, 66));
		btnLamLai.setForeground(Color.white);
		btnLamLai.setBorder(BorderFactory.createLineBorder(new java.awt.Color(255, 177, 66)));
		btnQuayLai.setBackground(new java.awt.Color(255, 177, 66));
		btnQuayLai.setBorder(BorderFactory.createLineBorder(new java.awt.Color(255, 177, 66)));
		btnQuayLai.setForeground(Color.white);
		btnLuu.setBackground(new java.awt.Color(5, 196, 107));
		btnLuu.setForeground(Color.white);
		btnLuu.setBorder(BorderFactory.createLineBorder(new java.awt.Color(5, 196, 107)));
		
		
		btnLuu.setPreferredSize(btnQuayLai.getPreferredSize());
		btnLamLai.setPreferredSize(btnQuayLai.getPreferredSize());
		//lblMatKhau.setPreferredSize(lblTaiKhoan.getPreferredSize() ); */
		
		Border borderLogin= BorderFactory.createLineBorder(new java.awt.Color(48, 51, 107));
		TitledBorder titleLogin= new TitledBorder(borderLogin, "");
		titleLogin.setTitleJustification(TitledBorder.LEFT);
		titleLogin.setTitleColor(Color.BLUE);
		pnHienThiDoiMatKhau.setBorder(titleLogin);
		
	}
	
	public void showWindow()
	{
		this.setSize(780, 430);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
	}
	
	

}
