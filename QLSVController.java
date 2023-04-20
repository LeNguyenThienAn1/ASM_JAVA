package controller;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;

import javax.swing.Action;
import javax.swing.JOptionPane;

import model.ThiSinh;
import model.Tinh;
import view.QLSVView;

public class QLSVController implements Action {
	public QLSVView view;
	
	
	public QLSVController(QLSVView view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cm = e.getActionCommand();
//		JOptionPane.showMessageDialog(view, "Bạn có chắn chắn muốn: "+cm);
		if(cm.equals("Thêm")) {
			this.view.xoaForm();
			this.view.model.setLuaChon("Thêm");
		}else if(cm.equals("Lưu")) {
			try {				
			this.view.thucHienThemThiSinh();
				
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ các thông tin trước khi nhấn lưu!");
			}
		}else if(cm.equals("Cập Nhật")) {
			try {
			this.view.hienThiThongTinThiSinhDaChon();
			}catch(Exception e2) {
				JOptionPane.showMessageDialog(null, "Vui lòng chọn mục mà bạn muốn cập nhật!");
			}
		}else if(cm.equals("Xóa")) {
			try {
			this.view.thucHienXoa();
			}catch(Exception e2) {
				JOptionPane.showMessageDialog(null, "Hãy chọn mục mà bạn muốn xóa!");
			}
		}else if(cm.equals("Hủy bỏ")) {
			this.view.xoaForm();
		}else if(cm.equals("Tìm")) {
		this.view.thucHienTim();
		}else if(cm.equals("Hủy")) {
			this.view.thucHienTaiLaiDuLieu();
		}else if(cm.equals("About Me")) {
			this.view.hienThiAbout();
		}else if(cm.equals("Exit")) {
			this.view.thoatKhoiChuongTrinh();
		}else if(cm.equals("Save")) {
			this.view.thucHienSaveFile();
		}else if(cm.equals("Open")) {
			this.view.thucHienOpenFile();
		}}
	
	@Override
	public Object getValue(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void putValue(String key, Object value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEnabled(boolean b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub
		
	}

}
