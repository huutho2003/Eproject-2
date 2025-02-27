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

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class Sua extends JDialog
{
	JTextField txtMaDocGia, txtHoTen, txtSDT, txtDiaChi, txtGioiTinh;
	JButton btnSua;
	JComboBox cb;
	Connection conn=uit.edu.vn.connect.ConnectMySQL.connect;
	public String ma="";
	
	public Sua(String tieude)
	{
		this.setTitle(tieude);
		addControls();
		addEvents();
		hienThi();
	}

	private void addControls() 
	{
		Container con = getContentPane();
		
		JPanel pnSuaDocGia = new JPanel();
		pnSuaDocGia.setLayout(new BorderLayout());
		con.add(pnSuaDocGia);
		
		JPanel pnTieuDe = new JPanel();
		JLabel lblTieuDe= new JLabel("QUẢN LÝ ĐỘC GIẢ");
		pnTieuDe.add(lblTieuDe);
		pnSuaDocGia.add(pnTieuDe, BorderLayout.NORTH);
		
		JPanel pnLienHe = new JPanel();
		JLabel lblLienHe= new JLabel("THÔNG TIN TRỢ GIÚP - LIÊN HỆ: 0342565857");
		pnLienHe.add(lblLienHe);
		pnSuaDocGia.add(pnLienHe, BorderLayout.SOUTH);
		
		JPanel pnHienThiSuaDocGia = new JPanel();
		pnHienThiSuaDocGia.setLayout(new BorderLayout());
		pnSuaDocGia.add(pnHienThiSuaDocGia, BorderLayout.CENTER);
		
		JPanel pnHinhAnh= new JPanel();
		pnHinhAnh.setLayout(new FlowLayout());
		JLabel lblHinhAnh= new JLabel();
		pnHinhAnh.setBackground(Color.WHITE);
		lblHinhAnh.setIcon(new ImageIcon("Hinh/suand.png"));
		pnHinhAnh.add(lblHinhAnh);
		pnHienThiSuaDocGia.add(pnHinhAnh, BorderLayout.WEST);
		
		JPanel pnHienThiChiTiet = new JPanel();
		pnHienThiChiTiet.setLayout(new BoxLayout(pnHienThiChiTiet, BoxLayout.Y_AXIS));
		pnHienThiSuaDocGia.add(pnHienThiChiTiet, BorderLayout.CENTER);
		
		JPanel pnTitle = new JPanel();
		pnTitle.setLayout(new FlowLayout());
		JLabel lblSuaDocGia= new JLabel("SỬA ĐỘC GIẢ");
		pnTitle.add(lblSuaDocGia);
		
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
		cb = new JComboBox();
		cb.addItem("Nam");
		cb.addItem("Nữ");
		pnGioiTinh.add(lblGioiTinh);
		pnGioiTinh.add(cb);
		
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
		lblSuaDocGia.setFont(font2);
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
		cb.setFont(font4);
		txtMaDocGia.setEditable(false);
		
		pnTieuDe.setBackground(new java.awt.Color(48, 51, 107));
		lblTieuDe.setForeground(Color.WHITE);
		pnLienHe.setBackground(new java.awt.Color(48, 51, 107));
		lblLienHe.setForeground(Color.WHITE);
		
		pnTitle.setBackground(new java.awt.Color(241, 242, 246));
		lblSuaDocGia.setForeground(new java.awt.Color(48, 51, 107));
		pnMaDG.setBackground(new java.awt.Color(241, 242, 246));
		pnDiaChi.setBackground(new java.awt.Color(241, 242, 246));
		pnGioiTinh.setBackground(new java.awt.Color(241, 242, 246));
		pnSoDienThoai.setBackground(new java.awt.Color(241, 242, 246));
		pnHoTen.setBackground(new java.awt.Color(241, 242, 246));
		pnHinhAnh.setBackground(new java.awt.Color(241, 242, 246));
		cb.setBackground(new java.awt.Color(241, 242, 246));
		cb.setForeground(Color.BLACK);
		
		
		JPanel pnThaoTac= new JPanel();
		pnThaoTac.setLayout(new FlowLayout());
		pnHienThiChiTiet.add(pnThaoTac);
		btnSua= new JButton("LƯU");
		btnSua.setPreferredSize(new Dimension(110,35));
		pnThaoTac.add(btnSua);
		pnThaoTac.setBackground(new java.awt.Color(241, 242, 246));
		
		btnSua.setFont(font5);
		
		btnSua.setBackground(new java.awt.Color(255, 177, 66));
		btnSua.setForeground(Color.white);
		btnSua.setBorder(BorderFactory.createLineBorder(new java.awt.Color(255, 177, 66)));
		//btnLuu.setBackground(new java.awt.Color(5, 196, 107));
		
		
		Border borderLogin= BorderFactory.createLineBorder(new java.awt.Color(48, 51, 107));
		TitledBorder titleLogin= new TitledBorder(borderLogin, "");
		titleLogin.setTitleJustification(TitledBorder.LEFT);
		titleLogin.setTitleColor(Color.BLUE);
		pnHienThiSuaDocGia.setBorder(titleLogin);
		
		lblMaDG.setPreferredSize(lblSoDienThoai.getPreferredSize());
		lblGioiTinh.setPreferredSize(lblSoDienThoai.getPreferredSize());
		lblHoTen.setPreferredSize(lblSoDienThoai.getPreferredSize());
		lblDiaChi.setPreferredSize(lblSoDienThoai.getPreferredSize());
		cb.setPreferredSize(txtDiaChi.getPreferredSize());
		
	}

	private void addEvents() 
	{
		btnSua.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				String ma = txtMaDocGia.getText();
				try {

					String sql = "update docgia set  tendg=?, sdt=?, diachi=?, gioitinh=? where madg=?";
					PreparedStatement pre = conn.prepareStatement(sql);
					pre.setString(1, txtHoTen.getText());
					pre.setString(2, txtSDT.getText());
					pre.setString(3, txtDiaChi.getText());
					pre.setString(4, (String) cb.getSelectedItem());
					pre.setString(5, txtMaDocGia.getText());
					
					int x = pre.executeUpdate();

					if (x > 0) {
						JOptionPane.showMessageDialog(null, "Sửa thành công");
						dispose();
					}

				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
	}

	public void hienThi() 
	{
		try
		{
			String sql="select * from docgia where madg=?";
			PreparedStatement pre=conn.prepareStatement(sql);
			pre.setString(1, ma);
			ResultSet rs=pre.executeQuery();
			while(rs.next())
			{
				txtMaDocGia.setText(rs.getString(1));
				txtHoTen.setText(rs.getString(2));
				txtSDT.setText(rs.getString(3));
				txtDiaChi.setText(rs.getString(4));
				if( rs.getString(5).length() == 2)
				{
					cb.setSelectedIndex(1);
				}
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		
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
