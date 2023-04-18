package view;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.QLSVModel;
import model.ThiSinh;
import model.Tinh;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;

import javax.swing.Action;
import javax.swing.Box;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import controller.QLSVController;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.Color;
import javax.swing.SwingConstants;

public class QLSVView extends JFrame {

	private JPanel contentPane;
	public QLSVModel model;
	public JTextField textField_MaThiSinh_TimKiem;
	public JTable table;
	public JTextField textField_ID;
	public JTextField textField_HoVaTen;
	public JTextField textField_NgaySinh;
	public JTextField textField_Mon1;
	public JTextField textField_Mon2;
	public JTextField textField_Mon3;
	public ButtonGroup btn_gioitinh;
	public JComboBox comboBox_queQuan;
	public JRadioButton rdbtnMale;
	public JRadioButton rdbtnFemale;
	public JComboBox comboBox_queQuan_timKiem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLSVView frame = new QLSVView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public QLSVView() {
		this.model = new QLSVModel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 725, 557);
		
		Action action = new QLSVController(this); 
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuFile = new JMenu("File");
		menuFile.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(menuFile);
		
		JMenuItem menuOpen = new JMenuItem("Open");
		menuOpen.addActionListener(action);
		menuOpen.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuFile.add(menuOpen);
		
		JMenuItem menuSave = new JMenuItem("Save");
		menuSave.addActionListener(action);
		menuSave.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuFile.add(menuSave);
		
		JSeparator separator = new JSeparator();
		menuFile.add(separator);
		
		JMenuItem menuExit = new JMenuItem("Exit");
		menuExit.addActionListener(action);
		menuExit.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuFile.add(menuExit);
		
		JMenu menuAbout = new JMenu("About");
		menuAbout.addActionListener(action);
		menuAbout.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		menuBar.add(menuAbout);
		
		JMenuItem menuAboutMe = new JMenuItem("About Me");
		menuAboutMe.addActionListener(action);
		menuAboutMe.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuAbout.add(menuAboutMe);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblQuQun = new JLabel("Place");
		lblQuQun.setFont(new Font("Source Sans Pro Black", Font.PLAIN, 20));
		lblQuQun.setBounds(534, 336, 66, 35);
		contentPane.add(lblQuQun);
		
		JLabel lblId_1 = new JLabel("ID");
		lblId_1.setFont(new Font("Source Sans Pro Black", Font.PLAIN, 20));
		lblId_1.setBounds(534, 261, 36, 35);
		contentPane.add(lblId_1);
		
		textField_MaThiSinh_TimKiem = new JTextField();
		textField_MaThiSinh_TimKiem.setBounds(534, 291, 94, 35);
		contentPane.add(textField_MaThiSinh_TimKiem);
		textField_MaThiSinh_TimKiem.setColumns(10);
		
		JButton btnTim = new JButton("Tìm");
		btnTim.addActionListener(action);
		btnTim.setFont(new Font("Viner Hand ITC", Font.BOLD, 18));
		btnTim.setBounds(639, 277, 72, 35);
		contentPane.add(btnTim);
		
		comboBox_queQuan_timKiem = new JComboBox();
		ArrayList<Tinh> listTinh = Tinh.getDSTinh();
		comboBox_queQuan_timKiem.addItem("");
	for (Tinh tinh : listTinh) {
		comboBox_queQuan_timKiem.addItem(tinh.getTenTinh());
	}
		comboBox_queQuan_timKiem.setBounds(534, 372, 94, 35);
		contentPane.add(comboBox_queQuan_timKiem);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(7, 45, 691, 2);
		contentPane.add(separator_1);
		
		JLabel lblDanhSchTh = new JLabel("Danh sách thí sinh");
		lblDanhSchTh.setForeground(new Color(128, 128, 0));
		lblDanhSchTh.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDanhSchTh.setBounds(10, 47, 194, 28);
		contentPane.add(lblDanhSchTh);
		
		table = new JTable();
		table.setFont(new Font("Source Sans Pro Black", Font.PLAIN, 15));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 Th\u00ED Sinh", "H\u1ECD t\u00EAn", "Qu\u00EA qu\u00E1n", "Ngày Sinh", "Gi\u1EDBi Tinh", "Java", "Security", "Vovinam 3"
			}
		));
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(5, 77, 691, 163);
		contentPane.add(scrollPane);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(4, 243, 691, 2);
		contentPane.add(separator_1_1);
		
		JLabel lblThngT = new JLabel("Student Information");
		lblThngT.setForeground(new Color(0, 0, 255));
		lblThngT.setFont(new Font("Tempus Sans ITC", Font.BOLD, 20));
		lblThngT.setBounds(213, 245, 214, 26);
		contentPane.add(lblThngT);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblId.setBounds(49, 277, 36, 19);
		contentPane.add(lblId);
		
		textField_ID = new JTextField();
		textField_ID.setColumns(10);
		textField_ID.setBounds(101, 277, 96, 19);
		contentPane.add(textField_ID);
		
		JLabel lblFullName = new JLabel("Full name");
		lblFullName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFullName.setBounds(17, 301, 97, 19);
		contentPane.add(lblFullName);
		
		table.setRowHeight(30);
		
		textField_HoVaTen = new JTextField();
		textField_HoVaTen.setColumns(10);
		textField_HoVaTen.setBounds(101, 302, 96, 19);
		contentPane.add(textField_HoVaTen);
		
		JLabel lblPlaceOfBirth = new JLabel("Place ");
		lblPlaceOfBirth.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPlaceOfBirth.setBounds(38, 346, 50, 26);
		contentPane.add(lblPlaceOfBirth);
		
		comboBox_queQuan = new JComboBox();
			comboBox_queQuan.addItem("");
		for (Tinh tinh : listTinh) {
			comboBox_queQuan.addItem(tinh.getTenTinh());
		}
		
		comboBox_queQuan.setBounds(102, 349, 94, 21);
		contentPane.add(comboBox_queQuan);
		
		JLabel lblDateOfBirth = new JLabel("Date of birth");
		lblDateOfBirth.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDateOfBirth.setBounds(1, 328, 98, 19);
		contentPane.add(lblDateOfBirth);
		
		textField_NgaySinh = new JTextField();
		textField_NgaySinh.setBounds(101, 326, 96, 19);
		contentPane.add(textField_NgaySinh);
		textField_NgaySinh.setColumns(10);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setForeground(new Color(0, 128, 0));
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblGender.setBounds(210, 292, 74, 19);
		contentPane.add(lblGender);
		
		rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setForeground(new Color(0, 0, 255));
		rdbtnMale.setFont(new Font("Tahoma", Font.BOLD, 15));
		rdbtnMale.setBounds(202, 318, 103, 21);
		contentPane.add(rdbtnMale);
		
		rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setForeground(new Color(255, 0, 128));
		rdbtnFemale.setFont(new Font("Tahoma", Font.BOLD, 15));
		rdbtnFemale.setBounds(202, 341, 103, 21);
		contentPane.add(rdbtnFemale);
		
		btn_gioitinh = new ButtonGroup();
		btn_gioitinh.add(rdbtnMale);
		btn_gioitinh.add(rdbtnFemale);
		
		JLabel lblJava = new JLabel("Java");
		lblJava.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblJava.setBounds(9, 399, 66, 19);
		contentPane.add(lblJava);
		
		JLabel lblSecurity = new JLabel("Security");
		lblSecurity.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSecurity.setBounds(355, 399, 66, 19);
		contentPane.add(lblSecurity);
		
		JLabel lblVovinam = new JLabel("Vovinam 3");
		lblVovinam.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblVovinam.setBounds(171, 399, 92, 19);
		contentPane.add(lblVovinam);
		
		textField_Mon1 = new JTextField();
		textField_Mon1.setColumns(10);
		textField_Mon1.setBounds(60, 400, 96, 19);
		contentPane.add(textField_Mon1);
		
		textField_Mon2 = new JTextField();
		textField_Mon2.setColumns(10);
		textField_Mon2.setBounds(421, 399, 96, 19);
		contentPane.add(textField_Mon2);
		
		textField_Mon3 = new JTextField();
		textField_Mon3.setColumns(10);
		textField_Mon3.setBounds(254, 398, 96, 19);
		contentPane.add(textField_Mon3);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(action);
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnThem.setBounds(10, 453, 96, 26);
		contentPane.add(btnThem);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setForeground(new Color(255, 0, 0));
		btnXoa.addActionListener(action);
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnXoa.setBounds(131, 453, 80, 26);
		contentPane.add(btnXoa);
		
		JButton btnCapNhap = new JButton("Cập Nhật");
		btnCapNhap.addActionListener(action);
		btnCapNhap.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCapNhap.setBounds(271, 453, 159, 26);
		contentPane.add(btnCapNhap);
		
		JButton btnLuu = new JButton("Lưu");
		btnLuu.addActionListener(action);
		btnLuu.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnLuu.setBounds(472, 453, 80, 26);
		contentPane.add(btnLuu);
		
		JButton btnHuyBo = new JButton("Hủy bỏ");
		btnHuyBo.setForeground(new Color(255, 0, 0));
		btnHuyBo.addActionListener(action);
		btnHuyBo.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnHuyBo.setBounds(573, 453, 103, 26);
		contentPane.add(btnHuyBo);
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setBounds(10, 437, 691, 2);
		contentPane.add(separator_1_2);
		
		JButton btnHuyTim = new JButton("Hủy");
		btnHuyTim.setForeground(new Color(255, 0, 0));
		btnHuyTim.addActionListener(action);
		btnHuyTim.setFont(new Font("Source Sans Pro", Font.BOLD, 18));
		btnHuyTim.setBounds(639, 345, 72, 35);
		contentPane.add(btnHuyTim);
		
		JLabel lblNewLabel = new JLabel("Student Score Management");
		lblNewLabel.setFont(new Font("Vivaldi", Font.BOLD, 29));
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setBounds(194, 0, 354, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("subject score:");
		lblNewLabel_1.setFont(new Font("Source Sans Pro", Font.BOLD, 18));
		lblNewLabel_1.setBounds(7, 377, 159, 19);
		contentPane.add(lblNewLabel_1);
		
		
		this.setVisible(true);
	}

	public void xoaForm() {
		textField_ID.setText("");
		textField_HoVaTen.setText("");
		textField_MaThiSinh_TimKiem.setText("");
		textField_NgaySinh.setText("");
		textField_Mon1.setText("");
		textField_Mon2.setText("");
		textField_Mon3.setText("");
		comboBox_queQuan.setSelectedIndex(-1);
		btn_gioitinh.clearSelection();	
	}
	public void themThiSinhVaoTable(ThiSinh ts) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		model_table.addRow(
				new Object[] {
						ts.getMaThiSinh()+"", 
						ts.getTenThiSinh(),
						ts.getQueQuan().getTenTinh(),
						ts.getNgaySinh().getDate()+"/"+(ts.getNgaySinh().getMonth()+1)+"/"+(ts.getNgaySinh().getYear()+1900),
						(ts.isGioiTinh()?"Nam":"Nữ"),
						ts.getDiemMon1()+"",
						ts.getDiemMon2()+"",
						ts.getDiemMon3()+""
						});
	}
	public void themHoacCapNhatThiSinh(ThiSinh ts) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		if(!this.model.kiemTraTonTai(ts)) {
		this.model.insert(ts);
		this.themThiSinhVaoTable(ts);
		}else {
			this.model.update(ts);
			int soLuongDong = model_table.getRowCount();
			for (int i = 0; i < soLuongDong; i++) {
				String id = model_table.getValueAt(i, 0)+"";
				if (id.equals(ts.getMaThiSinh() + "")) {
					model_table.setValueAt(ts.getMaThiSinh() + "", i, 0);
					model_table.setValueAt(ts.getTenThiSinh() + "", i, 1);
					model_table.setValueAt(ts.getQueQuan().getTenTinh() + "", i, 2);
					model_table.setValueAt(ts.getNgaySinh().getDate() + "/" + (ts.getNgaySinh().getMonth() + 1) + "/"
							+ (ts.getNgaySinh().getYear() + 1900) + "", i, 3);
					model_table.setValueAt((ts.isGioiTinh() ? "Nam" : "Nữ"), i, 4);
					model_table.setValueAt(ts.getDiemMon1() + "", i, 5);
					model_table.setValueAt(ts.getDiemMon2() + "", i, 6);
					model_table.setValueAt(ts.getDiemMon3() + "", i, 7);
				}
			}
		}
	}

	
	public ThiSinh getThiSinhDangChon() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();

		int maThiSinh = Integer.valueOf(model_table.getValueAt(i_row, 0)+"");
		String tenThiSinh = model_table.getValueAt(i_row, 1)+"";
		Tinh tinh = Tinh.getTinhByTen(model_table.getValueAt(i_row, 2)+"");
		String s_ngaySinh = model_table.getValueAt(i_row, 3)+"";
		Date ngaySinh = new Date(s_ngaySinh);		
		String textGioiTinh = model_table.getValueAt(i_row, 4)+"";
		boolean gioiTinh = textGioiTinh.equals("Nam");
		float diemMon1 = Float.valueOf(model_table.getValueAt(i_row, 5)+"");
		float diemMon2 = Float.valueOf(model_table.getValueAt(i_row, 6)+"");
		float diemMon3 = Float.valueOf(model_table.getValueAt(i_row, 7)+"");
		
		ThiSinh ts = new ThiSinh(maThiSinh, tenThiSinh, tinh, ngaySinh, gioiTinh, diemMon1, diemMon2, diemMon3);
		return ts;
	}
	public void hienThiThongTinThiSinhDaChon() {
		ThiSinh ts = getThiSinhDangChon();
		
		this.textField_ID.setText(ts.getMaThiSinh()+"");
		this.textField_HoVaTen.setText(ts.getTenThiSinh()+"");
		this.comboBox_queQuan.setSelectedItem(ts.getQueQuan().getTenTinh());
		String s_ngaySinh = ts.getNgaySinh().getDate() + "/" + (ts.getNgaySinh().getMonth() + 1) + "/"
				+ (ts.getNgaySinh().getYear() + 1900);
		this.textField_NgaySinh.setText(s_ngaySinh+"");
		if(ts.isGioiTinh()) {
			rdbtnMale.setSelected(true);
		}else {
			rdbtnFemale.setSelected(true);
		}
		this.textField_Mon1.setText(ts.getDiemMon1()+"");
		this.textField_Mon2.setText(ts.getDiemMon2()+"");
		this.textField_Mon3.setText(ts.getDiemMon3()+"");
	}

	public void thucHienXoa() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		int luaChon = JOptionPane.showConfirmDialog(this, "Bạn đã chọn dòng này!Bạn có chắc chắn muốn xóa không?");
		if(luaChon==JOptionPane.YES_OPTION) {
			ThiSinh ts = getThiSinhDangChon();
			this.model.delete(ts);
			model_table.removeRow(i_row);
		}
	}

	public void thucHienThemThiSinh() {
		//get du lieu
		int maThiSinh = Integer.valueOf(this.textField_ID.getText());
		String tenThiSinh = this.textField_HoVaTen.getText();
		int queQuan = this.comboBox_queQuan.getSelectedIndex()-1;
		Tinh tinh = Tinh.getTinhById(queQuan);
		Date ngaySinh = new Date(this.textField_NgaySinh.getText());				 
		boolean gioiTinh = true;					
		if(this.rdbtnMale.isSelected()) {
			gioiTinh = true;
		}else if(this.rdbtnFemale.isSelected()) {
			gioiTinh = false;
		}
		float diemMon1 = Float.valueOf(this.textField_Mon1.getText());
		float diemMon2 = Float.valueOf(this.textField_Mon2.getText());
		float diemMon3 = Float.valueOf(this.textField_Mon3.getText());
	
	
	ThiSinh ts = new ThiSinh(maThiSinh, tenThiSinh, tinh, ngaySinh, gioiTinh, diemMon1, diemMon2, diemMon3);
	this.themHoacCapNhatThiSinh(ts); 	
	}

	public void thucHienTim() {
		// Goi ham huy tim truoc
		this.thucHienTaiLaiDuLieu();
		//thuc hien tim kiem
		int queQuan = this.comboBox_queQuan_timKiem.getSelectedIndex()-1;		
		String maThiSinhTimKiem = this.textField_MaThiSinh_TimKiem.getText();
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int soLuongDong = model_table.getRowCount();
		
		Set<Integer> idCuaThiSinhCanXoa = new TreeSet<Integer>();
		if(queQuan>=0) {
			Tinh tinhDaChon = Tinh.getTinhById(queQuan);
		for (int i = 0; i < soLuongDong; i++) {
			String tenTinh = model_table.getValueAt(i, 2)+"";
			String id = model_table.getValueAt(i, 0)+"";	
			if (!tenTinh.equals(tinhDaChon.getTenTinh())) {
				idCuaThiSinhCanXoa.add(Integer.valueOf(id));
			}
		}
		}
		if(maThiSinhTimKiem.length()>0) {
			for (int i = 0; i < soLuongDong; i++) {
				String maThiSinhTrongTable = model_table.getValueAt(i, 0)+"";
				String id = model_table.getValueAt(i, 0)+"";	
				if (!id.equals(maThiSinhTimKiem)) {
					idCuaThiSinhCanXoa.add(Integer.valueOf(id));
				}
			}
		}
		for (Integer idCanXoa : idCuaThiSinhCanXoa) {
			soLuongDong = model_table.getRowCount();
			for (int i = 0; i < soLuongDong; i++) {
				String idTrongTable = model_table.getValueAt(i, 0)+"";	
				if (idTrongTable.equals(idCanXoa.toString())) {
					try {
					model_table.removeRow(i);
					}catch (Exception e) {
						e.printStackTrace();
					}
					break;
				}
		}}
	}
	

	public void thucHienTaiLaiDuLieu() {
		while(true) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int soLuongDong = model_table.getRowCount();
		if(soLuongDong==0)
			break;
		else
			try {
				model_table.removeRow(0);
			} catch (Exception e) {
				e.printStackTrace();
			}		
		}
		for (ThiSinh ts : this.model.getDsThiSinh()) {
			this.themThiSinhVaoTable(ts);
		}
	}

	public void hienThiAbout() {
		JOptionPane.showMessageDialog(this, "Student management software 102");
	}

	public void thoatKhoiChuongTrinh() {
		int luaChon = JOptionPane.showConfirmDialog(
				this,
				"Thoát Khỏi Chương Trình?",
				"Exit",
				JOptionPane.YES_NO_OPTION);
		if(luaChon==JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	public void saveFile(String path) {
		try {
			this.model.setTenFile(path);
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (ThiSinh ts : this.model.getDsThiSinh()) {
				oos.writeObject(ts);
			}
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void thucHienSaveFile() {
		if(this.model.getTenFile().length()>0) {
			saveFile(this.model.getTenFile());
		}else {
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showSaveDialog(this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				saveFile(file.getAbsolutePath());
			} 
		}
	}
	public void openFile(File file) {
		ArrayList<ThiSinh> ds = new ArrayList<ThiSinh>();
		try {
			this.model.setTenFile(file.getAbsolutePath());
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			ThiSinh ts = null;
			while((ts = (ThiSinh) ois.readObject())!=null) {
				ds.add(ts);
			}
			ois.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		this.model.setDsThiSinh(ds);
	}
	public void thucHienOpenFile() {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			openFile(file);
			thucHienTaiLaiDuLieu();
		} 
	}
}
