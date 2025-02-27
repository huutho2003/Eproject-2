package uit.edu.vn.eventqldg;

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
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import uit.edu.vn.connect.TaiKhoanService;
import uit.edu.vn.model.TaiKhoan;

public class Xoa extends JDialog 
{
	JTextField txtMaDocGia, txtHoTen, txtSDT, txtDiaChi, txtGioiTinh;
	JButton btnXoa;
	public String machon="";
	Connection connect = uit.edu.vn.connect.ConnectMySQL.connect;

	public Xoa(String tieude)
	{
		this.setTitle(tieude);
		addControls();
		addEvents();
		hienThi();
	}

	public void hienThi() 
	{
		try
		{
			String sql="select * from docgia where madg=?";
			PreparedStatement pre=connect.prepareStatement(sql);
			pre.setString(1, machon);
			ResultSet rs=pre.executeQuery();
			while(rs.next())
			{
				txtMaDocGia.setText(rs.getString(1));
				txtHoTen.setText(rs.getString(2));
				txtSDT.setText(rs.getString(3));
				txtDiaChi.setText(rs.getString(4));
				txtGioiTinh.setText(rs.getString(5));
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

	private void addEvents() 
	{
		btnXoa.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String ma = txtMaDocGia.getText();
				int flag = 1;
				try {

					String sql = "select * from phieumuon where madg=?";
					PreparedStatement pre = connect.prepareStatement(sql);
					pre.setString(1, ma);
					ResultSet rs = pre.executeQuery();

					if (rs.next()) {
						flag = 0;
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				if (flag == 0) {
					JOptionPane.showMessageDialog(null, "Đọc giả còn tồn tại phiếu mượn");
					return;
				}
				try {

					String sql = "delete from docgia where madg=?";
					PreparedStatement pre = connect.prepareStatement(sql);
					pre.setString(1, ma);
					int x = pre.executeUpdate();
					if (x > 0) 
					{
						JOptionPane.showMessageDialog(null, "Xóa thành công");
						dispose();
					}

				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
	}

	private void addControls() 
	{
		Container con = getContentPane();
		
		JPanel pnThemDocGia = new JPanel();
		pnThemDocGia.setLayout(new BorderLayout());
		con.add(pnThemDocGia);
		
		JPanel pnTieuDe = new JPanel();
		JLabel lblTieuDe= new JLabel("QUẢN LÝ ĐỘC GIẢ");
		pnTieuDe.add(lblTieuDe);
		pnThemDocGia.add(pnTieuDe, BorderLayout.NORTH);
		
		JPanel pnLienHe = new JPanel();
		JLabel lblLienHe= new JLabel("THÔNG TIN TRỢ GIÚP - LIÊN HỆ: 0342565857");
		pnLienHe.add(lblLienHe);
		pnThemDocGia.add(pnLienHe, BorderLayout.SOUTH);
		
		JPanel pnHienThiXoaDocGia = new JPanel();
		pnHienThiXoaDocGia.setLayout(new BorderLayout());
		pnThemDocGia.add(pnHienThiXoaDocGia, BorderLayout.CENTER);
		
		
		JPanel pnHinhAnh= new JPanel();
		pnHinhAnh.setLayout(new FlowLayout());
		JLabel lblHinhAnh= new JLabel();
		pnHinhAnh.setBackground(Color.WHITE);
		lblHinhAnh.setIcon(new ImageIcon("Hinh/xoand.png"));
		pnHinhAnh.add(lblHinhAnh);
		pnHienThiXoaDocGia.add(pnHinhAnh, BorderLayout.WEST);
		
		JPanel pnHienThiChiTiet = new JPanel();
		pnHienThiChiTiet.setLayout(new BoxLayout(pnHienThiChiTiet, BoxLayout.Y_AXIS));
		pnHienThiXoaDocGia.add(pnHienThiChiTiet, BorderLayout.CENTER);
		
		JPanel pnTitle = new JPanel();
		pnTitle.setLayout(new FlowLayout());
		JLabel lblXoaDocGia= new JLabel("XÓA ĐỘC GIẢ");
		pnTitle.add(lblXoaDocGia);
		
		JPanel pnMaDG = new JPanel();
		pnMaDG.setLayout(new FlowLayout());
		JLabel lblMaDG = new JLabel("Mã độc giả: ");
		txtMaDocGia = new JTextField();
		txtMaDocGia.setPreferredSize(new Dimension(340, 30));
		pnMaDG.add(lblMaDG);
		pnMaDG.add(txtMaDocGia);
		
		JPanel pnHoTen = new JPanel();
		pnHoTen.setLayout(new FlowLayout());
		JLabel lblHoTen = new JLabel("Tên độc giả: ");
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
		
		JPanel pnDiaChi = new JPanel();
		pnDiaChi.setLayout(new FlowLayout());
		JLabel lblDiaChi = new JLabel("Địa chỉ: ");
		txtDiaChi = new JTextField();
		txtDiaChi.setPreferredSize(new Dimension(340, 30));
		pnDiaChi.add(lblDiaChi);
		pnDiaChi.add(txtDiaChi);
		
		JPanel pnGioiTinh= new JPanel();
		pnGioiTinh.setLayout(new FlowLayout());
		JLabel lblGioiTinh = new JLabel("Giới tính: ");
		txtGioiTinh = new JTextField();
		txtGioiTinh.setPreferredSize(new Dimension(340, 30));
		pnGioiTinh.add(lblGioiTinh);
		pnGioiTinh.add(txtGioiTinh);
		
		
		pnHienThiChiTiet.add(pnTitle);
		pnHienThiChiTiet.add(pnMaDG);
		pnHienThiChiTiet.add(pnHoTen);
		pnHienThiChiTiet.add(pnSoDienThoai);
		pnHienThiChiTiet.add(pnDiaChi);
		pnHienThiChiTiet.add(pnGioiTinh);
		
		
		Font font1= new Font("SVN-Avo", Font.BOLD, 24); 
		Font font2= new Font("SVN-Avo", Font.BOLD, 30);
		Font font3= new Font("SVN-Avo", Font.TRUETYPE_FONT, 15);
		Font font4= new Font("SVN-Avo", Font.BOLD, 15);
		Font font5= new Font("SVN-Avo", Font.BOLD, 13);
		lblTieuDe.setFont(font1);
		lblXoaDocGia.setFont(font2);
		lblMaDG.setFont(font4);
		lblSoDienThoai.setFont(font4);
		lblDiaChi.setFont(font4);
		lblHoTen.setFont(font4);
		lblGioiTinh.setFont(font4);
		lblLienHe.setFont(font4);
		txtMaDocGia.setFont(font4);
		txtDiaChi.setFont(font4);
		txtHoTen.setFont(font4);
		txtSDT.setFont(font4);
		txtGioiTinh.setFont(font4);
		
		pnTieuDe.setBackground(new java.awt.Color(48, 51, 107));
		lblTieuDe.setForeground(Color.WHITE);
		pnLienHe.setBackground(new java.awt.Color(48, 51, 107));
		lblLienHe.setForeground(Color.WHITE);
		
		pnTitle.setBackground(new java.awt.Color(241, 242, 246));
		lblXoaDocGia.setForeground(new java.awt.Color(48, 51, 107));
		pnMaDG.setBackground(new java.awt.Color(241, 242, 246));
		pnDiaChi.setBackground(new java.awt.Color(241, 242, 246));
		pnGioiTinh.setBackground(new java.awt.Color(241, 242, 246));
		pnSoDienThoai.setBackground(new java.awt.Color(241, 242, 246));
		pnHoTen.setBackground(new java.awt.Color(241, 242, 246));
		pnHinhAnh.setBackground(new java.awt.Color(241, 242, 246));
		
		
		JPanel pnThaoTac= new JPanel();
		pnThaoTac.setLayout(new FlowLayout());
		pnHienThiChiTiet.add(pnThaoTac);
		btnXoa= new JButton("XÓA");
		btnXoa.setPreferredSize(new Dimension(110,35));
		pnThaoTac.add(btnXoa);
		pnThaoTac.setBackground(new java.awt.Color(241, 242, 246));
		
		btnXoa.setFont(font5);
		
		btnXoa.setBackground(new java.awt.Color(255, 177, 66));
		btnXoa.setForeground(Color.white);
		btnXoa.setBorder(BorderFactory.createLineBorder(new java.awt.Color(255, 177, 66)));
		//btnLuu.setBackground(new java.awt.Color(5, 196, 107));
		
		
		Border borderLogin= BorderFactory.createLineBorder(new java.awt.Color(48, 51, 107));
		TitledBorder titleLogin= new TitledBorder(borderLogin, "");
		titleLogin.setTitleJustification(TitledBorder.LEFT);
		titleLogin.setTitleColor(Color.BLUE);
		pnHienThiXoaDocGia.setBorder(titleLogin);
		
		lblMaDG.setPreferredSize(lblSoDienThoai.getPreferredSize());
		lblGioiTinh.setPreferredSize(lblSoDienThoai.getPreferredSize());
		lblHoTen.setPreferredSize(lblSoDienThoai.getPreferredSize());
		lblDiaChi.setPreferredSize(lblSoDienThoai.getPreferredSize());
		
		
		txtMaDocGia.setEditable(false);
		txtHoTen.setEditable(false);
		txtSDT.setEditable(false);
		txtDiaChi.setEditable(false);
		txtGioiTinh.setEditable(false);
		
		
		
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
