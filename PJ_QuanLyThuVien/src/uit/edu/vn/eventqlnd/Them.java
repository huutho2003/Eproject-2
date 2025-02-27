package uit.edu.vn.eventqlnd;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class Them extends JDialog 
{
	JTextField txtTaiKhoan, txtHoTen, txtSDT, txtCMND;
	JRadioButton radAdmin, radThuThu;
	JPasswordField pwdMatKhau;
	JButton btnThem;
	ButtonGroup gr;
	Connection connect = uit.edu.vn.connect.ConnectMySQL.connect;

	public Them(String tieude)
	{
		this.setTitle(tieude);
		addControls();
		addEvents();
	}
	private void addEvents() 
	{
		btnThem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				int n=0;
				if(radAdmin.isSelected())
				{
					n=1;
				}
				if(radThuThu.isSelected())
				{
					n=2;
				}
				try
				{
					String sql="insert into taikhoan values (?,?,?,?,?,?)";
					PreparedStatement pre=connect.prepareStatement(sql);
					pre.setString(1, txtTaiKhoan.getText());
					pre.setString(2, pwdMatKhau.getText());
					pre.setInt(3,n);
					pre.setString(4, txtHoTen.getText());
					pre.setString(5, txtSDT.getText());
					pre.setString(6, txtCMND.getText());
					if(txtTaiKhoan.getText().length() == 0  || txtCMND.getText().length() == 0 || txtHoTen.getText().length() == 0 || txtSDT.getText().length() == 0 || pwdMatKhau.getText().length() == 0 || n==0)
					{
						JOptionPane.showMessageDialog(null, "Không được để trống");
						return;
					}
					int x=pre.executeUpdate();
					if(x>0)
					{
						JOptionPane.showMessageDialog(null, "Thêm thành công");
						txtHoTen.setText(null);
						txtCMND.setText(null);
						txtSDT.setText(null);
						txtTaiKhoan.setText(null);
						pwdMatKhau.setText(null);
						
					}
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null,ex.getMessage()); 
				}
			}
		});
		
	}
	private void addControls() 
	{
		Container con = getContentPane();
		
		JPanel pnThemNguoiDung= new JPanel();
		pnThemNguoiDung.setLayout(new BorderLayout());
		con.add(pnThemNguoiDung);
		
		JPanel pnTieuDe = new JPanel();
		JLabel lblTieuDe= new JLabel("QUẢN LÝ NGƯỜI DÙNG");
		pnTieuDe.add(lblTieuDe);
		pnThemNguoiDung.add(pnTieuDe, BorderLayout.NORTH);
		
		JPanel pnLienHe = new JPanel();
		JLabel lblLienHe= new JLabel("THÔNG TIN TRỢ GIÚP - LIÊN HỆ: 0342565857");
		pnLienHe.add(lblLienHe);
		pnThemNguoiDung.add(pnLienHe, BorderLayout.SOUTH);
		
		JPanel pnHienThiThemNguoiDung = new JPanel();
		pnHienThiThemNguoiDung.setLayout(new BorderLayout());
		pnThemNguoiDung.add(pnHienThiThemNguoiDung, BorderLayout.CENTER);
		
		
		JPanel pnHinhAnh= new JPanel();
		pnHinhAnh.setLayout(new FlowLayout());
		JLabel lblHinhAnh= new JLabel();
		pnHinhAnh.setBackground(Color.WHITE);
		lblHinhAnh.setIcon(new ImageIcon("Hinh/themnd.png"));
		pnHinhAnh.add(lblHinhAnh);
		pnHienThiThemNguoiDung.add(pnHinhAnh, BorderLayout.WEST);
		
		JPanel pnHienThiChiTiet = new JPanel();
		pnHienThiChiTiet.setLayout(new BoxLayout(pnHienThiChiTiet, BoxLayout.Y_AXIS));
		pnHienThiThemNguoiDung.add(pnHienThiChiTiet, BorderLayout.CENTER);
		
		JPanel pnTitle = new JPanel();
		pnTitle.setLayout(new FlowLayout());
		JLabel lblThemNguoiDung= new JLabel("THÊM NGƯỜI DÙNG");
		pnTitle.add(lblThemNguoiDung);
		
		JPanel pnTaiKhoan = new JPanel();
		pnTaiKhoan.setLayout(new FlowLayout());
		JLabel lblTaiKhoan = new JLabel("Tài khoản: ");
		txtTaiKhoan = new JTextField();
		txtTaiKhoan.setPreferredSize(new Dimension(340, 30));
		pnTaiKhoan.add(lblTaiKhoan);
		pnTaiKhoan.add(txtTaiKhoan);
		
		JPanel pnMatKhau = new JPanel();
		pnMatKhau.setLayout(new FlowLayout());
		JLabel lblMatKhau = new JLabel("Mật khẩu: ");
		pwdMatKhau = new JPasswordField();
		pwdMatKhau.setEchoChar((char)0);
		pwdMatKhau.setPreferredSize(new Dimension(340, 30));
		pnMatKhau.add(lblMatKhau);
		pnMatKhau.add(pwdMatKhau);
		
		JPanel pnHoTen = new JPanel();
		pnHoTen.setLayout(new FlowLayout());
		JLabel lblHoTen = new JLabel("Họ và tên: ");
		txtHoTen = new JTextField();
		txtHoTen.setPreferredSize(new Dimension(340, 30));
		pnHoTen.add(lblHoTen);
		pnHoTen.add(txtHoTen);
		
		JPanel pnSoDienThoai= new JPanel();
		pnSoDienThoai.setLayout(new FlowLayout());
		JLabel lblSoDienThoai = new JLabel("Số điện thoại: ");
		txtSDT = new JTextField();
		txtSDT.setPreferredSize(new Dimension(340, 30));
		pnSoDienThoai.add(lblSoDienThoai);
		pnSoDienThoai.add(txtSDT);
		
		JPanel pnCMND= new JPanel();
		pnCMND.setLayout(new FlowLayout());
		JLabel lblCMND = new JLabel("Số CMND: ");
		txtCMND = new JTextField();
		txtCMND.setPreferredSize(new Dimension(340, 30));
		pnCMND.add(lblCMND);
		pnCMND.add(txtCMND);
		
		JPanel pnPhanQuyen=new JPanel();
		pnPhanQuyen.setLayout(new FlowLayout());
		radAdmin=new JRadioButton("Admin");
		radThuThu=new JRadioButton("Thủ thư");		
		gr=new ButtonGroup();
		gr.add(radAdmin);
		gr.add(radThuThu);
		pnPhanQuyen.add(radAdmin);
		pnPhanQuyen.add(radThuThu);
		
		
		pnHienThiChiTiet.add(pnTitle);
		pnHienThiChiTiet.add(pnTaiKhoan);
		pnHienThiChiTiet.add(pnMatKhau);
		pnHienThiChiTiet.add(pnHoTen);
		pnHienThiChiTiet.add(pnSoDienThoai);
		pnHienThiChiTiet.add(pnCMND);
		pnHienThiChiTiet.add(pnPhanQuyen);
		
		
		Font font1= new Font("SVN-Avo", Font.BOLD, 24); 
		Font font2= new Font("SVN-Avo", Font.BOLD, 30);
		Font font3= new Font("SVN-Avo", Font.TRUETYPE_FONT, 15);
		Font font4= new Font("SVN-Avo", Font.BOLD, 15);
		Font font5= new Font("SVN-Avo", Font.BOLD, 13);
		lblTieuDe.setFont(font1);
		lblThemNguoiDung.setFont(font2);
		lblTaiKhoan.setFont(font4);
		lblSoDienThoai.setFont(font4);
		lblCMND.setFont(font4);
		lblHoTen.setFont(font4);
		lblMatKhau.setFont(font4);
		lblLienHe.setFont(font4);
		radAdmin.setFont(font4);
		radThuThu.setFont(font4);
		txtTaiKhoan.setFont(font4);
		txtCMND.setFont(font4);
		txtHoTen.setFont(font4);
		txtSDT.setFont(font4);
		pwdMatKhau.setFont(font4);
		
		pnTieuDe.setBackground(new java.awt.Color(48, 51, 107));
		lblTieuDe.setForeground(Color.WHITE);
		pnLienHe.setBackground(new java.awt.Color(48, 51, 107));
		lblLienHe.setForeground(Color.WHITE);
		
		pnTitle.setBackground(new java.awt.Color(241, 242, 246));
		lblThemNguoiDung.setForeground(new java.awt.Color(48, 51, 107));
		pnTaiKhoan.setBackground(new java.awt.Color(241, 242, 246));
		pnCMND.setBackground(new java.awt.Color(241, 242, 246));
		pnMatKhau.setBackground(new java.awt.Color(241, 242, 246));
		pnPhanQuyen.setBackground(new java.awt.Color(241, 242, 246));
		pnSoDienThoai.setBackground(new java.awt.Color(241, 242, 246));
		pnHoTen.setBackground(new java.awt.Color(241, 242, 246));
		pnHinhAnh.setBackground(new java.awt.Color(241, 242, 246));
		
		radAdmin.setBackground(new java.awt.Color(241, 242, 246));
		radThuThu.setBackground(new java.awt.Color(241, 242, 246));
		
		JPanel pnThaoTac= new JPanel();
		pnThaoTac.setLayout(new FlowLayout());
		pnHienThiChiTiet.add(pnThaoTac);
		btnThem= new JButton("THÊM");
		btnThem.setPreferredSize(new Dimension(110,35));
		pnThaoTac.add(btnThem);
		pnThaoTac.setBackground(new java.awt.Color(241, 242, 246));
		
		btnThem.setFont(font5);
		
		btnThem.setBackground(new java.awt.Color(255, 177, 66));
		btnThem.setForeground(Color.white);
		btnThem.setBorder(BorderFactory.createLineBorder(new java.awt.Color(255, 177, 66)));
		//btnLuu.setBackground(new java.awt.Color(5, 196, 107));
		
		
		Border borderLogin= BorderFactory.createLineBorder(new java.awt.Color(48, 51, 107));
		TitledBorder titleLogin= new TitledBorder(borderLogin, "");
		titleLogin.setTitleJustification(TitledBorder.LEFT);
		titleLogin.setTitleColor(Color.BLUE);
		pnHienThiThemNguoiDung.setBorder(titleLogin);
		
		lblTaiKhoan.setPreferredSize(lblSoDienThoai.getPreferredSize());
		lblMatKhau.setPreferredSize(lblSoDienThoai.getPreferredSize());
		lblHoTen.setPreferredSize(lblSoDienThoai.getPreferredSize());
		lblCMND.setPreferredSize(lblSoDienThoai.getPreferredSize());
		
		
	}
	public void showWindow()
	{
		this.setSize(900, 500);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setModal(true);
		this.setVisible(true);
		
	}

}
