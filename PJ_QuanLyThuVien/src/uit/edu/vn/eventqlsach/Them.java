package uit.edu.vn.eventqlsach;

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
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import uit.edu.vn.connect.SachService;
import uit.edu.vn.model.Sach;

public class Them extends JDialog {
	JTextField txtMaSach, txtTenSach, txtTenTG, txtNhaXB, txtTheLoai, txtSoLuong, txtGia;
	JButton btnThem;
	Connection conn=uit.edu.vn.connect.ConnectMySQL.connect;
	public String ma="";
	
	public Them(String tieude)
	{
		this.setTitle(tieude);
		addControls();
		addEvents();
	}
	public int DemSach()
	{
		int SoLuongSach=0;
		SachService sv=new SachService();
		ArrayList<Sach> ds= sv.layToanBoSach();
		for(Sach s:ds)
		{
			SoLuongSach++;
		}
		return SoLuongSach;
	}
	private void addEvents() 
	{
		btnThem.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				int flag = 1;
				try 
				{

					String sql = "select * from sach where masach=?";
					PreparedStatement pre = conn.prepareStatement(sql);
					pre.setString(1, txtMaSach.getText());
					ResultSet rs = pre.executeQuery();

					if (rs.next()) 
					{
						flag = 0;
					}
				} 
				catch (Exception ex) 
				{
					ex.printStackTrace();
				}

				if (flag == 0) 
				{
					JOptionPane.showMessageDialog(null, "Mã sách đã tồn tại!");
					return;
				}

				if (txtMaSach.getText().length() == 0)
				{
					JOptionPane.showMessageDialog(null, "Mã sách không được để trống");
					return;
				}

				try 
				{

					String sql = "insert into sach values (?,?,?,?,?,?,?)";
					PreparedStatement pre = conn.prepareStatement(sql);
					pre.setString(1, txtMaSach.getText());
					pre.setString(2, txtTenSach.getText());
					pre.setString(3, txtTenTG.getText());
					pre.setString(4, txtNhaXB.getText());
					pre.setString(5, txtTheLoai.getText());
					pre.setInt(6, Integer.parseInt(txtSoLuong.getText()));
					pre.setInt(7, Integer.parseInt(txtGia.getText()));
					int x = pre.executeUpdate();
					if (x > 0) 
					{
						JOptionPane.showMessageDialog(null, "Thêm thành công");
					}

				} 
				catch (Exception ex)
				{
					ex.printStackTrace();
				}
			}
		});
		
	}

	private void addControls() 
	{
		int kqs=DemSach() + 1;
		Container con = getContentPane();
		
		JPanel pnThemSach = new JPanel();
		pnThemSach.setLayout(new BorderLayout());
		con.add(pnThemSach);
		
		JPanel pnTieuDe = new JPanel();
		JLabel lblTieuDe= new JLabel("QUẢN LÝ SÁCH");
		pnTieuDe.add(lblTieuDe);
		pnThemSach.add(pnTieuDe, BorderLayout.NORTH);
		
		JPanel pnLienHe = new JPanel();
		JLabel lblLienHe= new JLabel("THÔNG TIN TRỢ GIÚP - LIÊN HỆ: 0342565857");
		pnLienHe.add(lblLienHe);
		pnThemSach.add(pnLienHe, BorderLayout.SOUTH);
		
		JPanel pnHienThiThemSach = new JPanel();
		pnHienThiThemSach.setLayout(new BorderLayout());
		pnThemSach.add(pnHienThiThemSach, BorderLayout.CENTER);
		
		JPanel pnHinhAnh= new JPanel();
		pnHinhAnh.setLayout(new FlowLayout());
		JLabel lblHinhAnh= new JLabel();
		pnHinhAnh.setBackground(Color.WHITE);
		lblHinhAnh.setIcon(new ImageIcon("Hinh/book.png"));
		pnHinhAnh.add(lblHinhAnh);
		pnHienThiThemSach.add(pnHinhAnh, BorderLayout.WEST);
		
		JPanel pnHienThiChiTiet = new JPanel();
		pnHienThiChiTiet.setLayout(new BoxLayout(pnHienThiChiTiet, BoxLayout.Y_AXIS));
		pnHienThiThemSach.add(pnHienThiChiTiet, BorderLayout.CENTER);
		
		JPanel pnTitle = new JPanel();
		pnTitle.setLayout(new FlowLayout());
		JLabel lblThemSach= new JLabel("THÊM SÁCH");
		pnTitle.add(lblThemSach);
		
		JPanel pnMaSach = new JPanel();
		pnMaSach.setLayout(new FlowLayout());
		JLabel lblMaSach = new JLabel("Mã sách: ");
		txtMaSach= new JTextField("MS"+kqs);
		txtMaSach.setPreferredSize(new Dimension(340, 30));
		pnMaSach.add(lblMaSach);
		pnMaSach.add(txtMaSach);
		txtMaSach.setEditable(false);
		
		JPanel pnTenSach = new JPanel();
		pnTenSach.setLayout(new FlowLayout());
		JLabel lblTenSach = new JLabel("Tên sách: ");
		txtTenSach = new JTextField();
		txtTenSach.setPreferredSize(new Dimension(340, 30));
		pnTenSach.add(lblTenSach);
		pnTenSach.add(txtTenSach);
		
		JPanel pnTenTG = new JPanel();
		pnTenTG.setLayout(new FlowLayout());
		JLabel lblTenTG = new JLabel("Tên tác giả: ");
		txtTenTG = new JTextField();
		txtTenTG.setPreferredSize(new Dimension(340, 30));
		pnTenTG.add(lblTenTG);
		pnTenTG.add(txtTenTG);
		
		JPanel pnNhaXB= new JPanel();
		pnNhaXB.setLayout(new FlowLayout());
		JLabel lblNhaXB = new JLabel("Nhà xuất bản: ");
		txtNhaXB = new JTextField();
		txtNhaXB.setPreferredSize(new Dimension(340, 30));
		pnNhaXB.add(lblNhaXB);
		pnNhaXB.add(txtNhaXB);
		
		JPanel pnTheLoai = new JPanel();
		pnTheLoai.setLayout(new FlowLayout());
		JLabel lblTheLoai = new JLabel("Thể loại: ");
		txtTheLoai = new JTextField();
		txtTheLoai.setPreferredSize(new Dimension(340, 30));
		pnTheLoai.add(lblTheLoai);
		pnTheLoai.add(txtTheLoai);
		
		JPanel pnSoLuong= new JPanel();
		pnSoLuong.setLayout(new FlowLayout());
		JLabel lblSoLuong = new JLabel("Số lượng: ");
		txtSoLuong = new JTextField();
		txtSoLuong.setPreferredSize(new Dimension(340, 30));
		pnSoLuong.add(lblSoLuong);
		pnSoLuong.add(txtSoLuong);
		
		JPanel pnGia = new JPanel();
		pnGia.setLayout(new FlowLayout());
		JLabel lblGia = new JLabel("Giá tiền: ");
		txtGia = new JTextField();
		txtGia.setPreferredSize(new Dimension(340, 30));
		pnGia.add(lblGia);
		pnGia.add(txtGia);
		
		
		pnHienThiChiTiet.add(pnTitle);
		pnHienThiChiTiet.add(pnMaSach);
		pnHienThiChiTiet.add(pnTenSach);
		pnHienThiChiTiet.add(pnTenTG);
		pnHienThiChiTiet.add(pnNhaXB);
		pnHienThiChiTiet.add(pnTheLoai);
		pnHienThiChiTiet.add(pnSoLuong);
		pnHienThiChiTiet.add(pnGia);
		
		Font font1= new Font("SVN-Avo", Font.BOLD, 24); 
		Font font2= new Font("SVN-Avo", Font.BOLD, 30);
		Font font3= new Font("SVN-Avo", Font.TRUETYPE_FONT, 15);
		Font font4= new Font("SVN-Avo", Font.BOLD, 15);
		Font font5= new Font("SVN-Avo", Font.BOLD, 13);
		lblTieuDe.setFont(font1);
		lblThemSach.setFont(font2);
		lblGia.setFont(font4);
		lblMaSach.setFont(font4);
		lblTenSach.setFont(font4);
		lblTenTG.setFont(font4);
		lblNhaXB.setFont(font4);
		lblSoLuong.setFont(font4);
		lblTheLoai.setFont(font4);
		lblLienHe.setFont(font4);
		
		txtMaSach.setFont(font4);
		txtTenSach.setFont(font4);
		txtTenTG.setFont(font4);
		txtNhaXB.setFont(font4);
		txtSoLuong.setFont(font4);
		txtTheLoai.setFont(font4);
		txtGia.setFont(font4);
		
		pnTieuDe.setBackground(new java.awt.Color(48, 51, 107));
		lblTieuDe.setForeground(Color.WHITE);
		pnLienHe.setBackground(new java.awt.Color(48, 51, 107));
		lblLienHe.setForeground(Color.WHITE);
		
		pnTitle.setBackground(new java.awt.Color(241, 242, 246));
		lblThemSach.setForeground(new java.awt.Color(48, 51, 107));
		pnMaSach.setBackground(new java.awt.Color(241, 242, 246));
		pnTenSach.setBackground(new java.awt.Color(241, 242, 246));
		pnTenTG.setBackground(new java.awt.Color(241, 242, 246));
		pnNhaXB.setBackground(new java.awt.Color(241, 242, 246));
		pnSoLuong.setBackground(new java.awt.Color(241, 242, 246));
		pnTheLoai.setBackground(new java.awt.Color(241, 242, 246));
		pnGia.setBackground(new java.awt.Color(241, 242, 246));
		pnHinhAnh.setBackground(new java.awt.Color(241, 242, 246));		
		
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
		
		
		Border borderLogin= BorderFactory.createLineBorder(new java.awt.Color(48, 51, 107));
		TitledBorder titleLogin= new TitledBorder(borderLogin, "");
		titleLogin.setTitleJustification(TitledBorder.LEFT);
		titleLogin.setTitleColor(Color.BLUE);
		pnHienThiThemSach.setBorder(titleLogin);
		
		lblMaSach.setPreferredSize(lblNhaXB.getPreferredSize());
		lblTenSach.setPreferredSize(lblNhaXB.getPreferredSize());
		lblTenTG.setPreferredSize(lblNhaXB.getPreferredSize());
		lblSoLuong.setPreferredSize(lblNhaXB.getPreferredSize());
		lblTheLoai.setPreferredSize(lblNhaXB.getPreferredSize());
		lblGia.setPreferredSize(lblNhaXB.getPreferredSize());
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
