package gui;

import java.awt.Color;
import java.awt.Dialog.ModalityType;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import dao.RoomDAO;
import entity.Room;



public class pnRoom extends JPanel implements ActionListener, MouseListener {

	
	// Declare buttons as instance variables
    private JButton btnAdd, btnDelete,btndk, btnUpdate, btnRefresh,btnFind;
    private JTable table;
    private DefaultTableModel model;
    private JTextField txtRoom, txtTenp, txtLoaiPhong, txtGiap, txtTTP, txtSoluong,txtMess,txtfind,txtNgayLam;
    private JComboBox<String> TTPCombo,cboFilterLoaiPhong;
    private RoomDAO roomDAO;
    public pnRoom() {
    	roomDAO = new RoomDAO();
    
        setLayout(null);  
        setBounds(0, 0, 1550, 600)	; 
    	
        JPanel pnds = new JPanel();
        pnds.setLayout(null);
        pnds.setBounds(20, 20, 1500, 350);
        pnds.setBackground(new Color(240, 240, 240));
        pnds.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        
        JLabel lblds = new JLabel("Quản Lý 	Phòng Khách sạn");
        lblds.setFont(new Font("Arial", Font.BOLD, 20));
        lblds.setForeground(Color.BLACK);
        lblds.setBounds(650, 10, 500, 40);
        pnds.add(lblds);

        String[] columns = {"Mã Phòng","Tên Phòng" ,"Loại Phòng", "Gía Phòng", "Tình trạng phòng", "Số lượng người"};
      
        
        model = new DefaultTableModel(columns,0) {
        	public boolean isCellEditable(int row, int column) {
        		return false;
        	}
        };
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 50, 1480, 250);
        pnds.add(scrollPane);
        add(pnds);
        
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(null);
        infoPanel.setBounds(20, 400, 1100, 300);
        infoPanel.setBackground(new Color(240, 240, 240));
        infoPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        
        JLabel lblInfoTitle = new JLabel("Thông tin Phòng");
        lblInfoTitle.setFont(new Font("Arial", Font.BOLD, 20));
        lblInfoTitle.setForeground(Color.BLACK);
        lblInfoTitle.setBounds(450, 10, 200, 30);
        infoPanel.add(lblInfoTitle);

        JLabel lblRoom = new JLabel("Mã Phòng: ");
        lblRoom.setBounds(50, 50, 100, 25);
        infoPanel.add(lblRoom);
        txtRoom = new JTextField();
        txtRoom.setBounds(150, 50, 200, 25);
        txtRoom.setBorder(new LineBorder(Color.BLACK, 2));
        infoPanel.add(txtRoom);

        JLabel lblTenp = new JLabel("Tên phòng: ");
        lblTenp.setBounds(600, 50, 100, 25);
        infoPanel.add(lblTenp);
        txtTenp = new JTextField();
        txtTenp.setBounds(700, 50, 200, 25);
        txtTenp.setBorder(new LineBorder(Color.BLACK, 2));
        infoPanel.add(txtTenp);

        JLabel lblLoaiPhong = new JLabel("Loại Phòng: ");
        lblLoaiPhong.setBounds(50, 90, 100, 25);
        infoPanel.add(lblLoaiPhong);
        txtLoaiPhong = new JTextField();
        txtLoaiPhong.setBounds(150, 90, 200, 25);
        txtLoaiPhong.setBorder(new LineBorder(Color.BLACK, 2));
        infoPanel.add(txtLoaiPhong);

        JLabel lblGiap = new JLabel("Giá Phòng: ");
        lblGiap.setBounds(600, 90, 150, 25);
        infoPanel.add(lblGiap);
        txtGiap = new JTextField();
        txtGiap.setBounds(750, 90, 150, 25);
        txtGiap.setBorder(new LineBorder(Color.BLACK, 2));
        infoPanel.add(txtGiap);

        JLabel lblFilterLoaiPhong = new JLabel("Lọc theo loại phòng:");
        lblFilterLoaiPhong.setBounds(50, 170, 100, 25);
        infoPanel.add(lblFilterLoaiPhong);
        cboFilterLoaiPhong = new JComboBox<>(new String[]{"Tất cả", "VIP", "Thường", "Deluxe"});
        cboFilterLoaiPhong.setBounds(150, 170, 200, 25);
        infoPanel.add(cboFilterLoaiPhong);
        cboFilterLoaiPhong.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    filterRoomsByType();
                }
            }
        });

        JLabel lblTTP = new JLabel("Tình trạng phòng: ");
        lblTTP.setBounds(600, 130, 100, 25);
        infoPanel.add(lblTTP);
        TTPCombo = new JComboBox<>(new String[]{"Trống", "Đã Đặt","Bảo Trì"});
        TTPCombo.setBounds(700, 130, 200, 25);
        infoPanel.add(TTPCombo);

        JLabel lblSoluong = new JLabel("Số lượng người: ");
        lblSoluong.setBounds(50, 130, 100, 25);
        infoPanel.add(lblSoluong);
        txtSoluong = new JTextField();
        txtSoluong.setBounds(150, 130, 200, 25);
        txtSoluong.setBorder(new LineBorder(Color.BLACK, 2));
        infoPanel.add(txtSoluong);
        
        txtMess = new JTextField();
		txtMess.setEditable(false);
		txtMess.setBorder(null);
		txtMess.setForeground(Color.red);
		txtMess.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		txtMess.setBounds(50, 200, 500, 50);
		infoPanel.add(txtMess);
		
		
		JLabel lblfind = new JLabel("Tìm kiếm");
		lblfind.setBounds(50, 250, 100, 25);
        infoPanel.add(lblfind);
        txtfind = new JTextField();
        txtfind.setBounds(150, 250, 200, 25);
        txtfind.setBorder(new LineBorder(Color.BLACK, 2));
        infoPanel.add(txtfind);
        btnFind = new JButton("Tìm kiếm");
        btnFind.setBounds(400, 250, 200, 30);
        btnFind.setBackground(Color.LIGHT_GRAY);
        btnFind.setForeground(Color.BLACK);
        infoPanel.add(btnFind);
        add(infoPanel);

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(null);
        controlPanel.setBounds(1130, 400, 390, 300);
        controlPanel.setBackground(new Color(240, 240, 240));
        controlPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        
        JLabel lblControlTitle = new JLabel("Chỉnh sửa");
        lblControlTitle.setFont(new Font("Arial", Font.BOLD, 20));
        lblControlTitle.setForeground(Color.BLACK);
        lblControlTitle.setBounds(150, 10, 100, 30);
        controlPanel.add(lblControlTitle);

        btnAdd = new JButton("Thêm");
        btnAdd.setBounds(100, 50, 200, 30);
        btnAdd.setBackground(Color.LIGHT_GRAY);
        btnAdd.setForeground(Color.BLACK);
        controlPanel.add(btnAdd);

        btnRefresh = new JButton("Làm mới");
        btnRefresh.setBounds(100, 100, 200, 30);
        btnRefresh.setBackground(Color.LIGHT_GRAY);
        btnRefresh.setForeground(Color.BLACK);
        controlPanel.add(btnRefresh);

        btnUpdate = new JButton("Cập nhật");
        btnUpdate.setBounds(100, 150, 200, 30);
        btnUpdate.setBackground(Color.LIGHT_GRAY);
        btnUpdate.setForeground(Color.BLACK);
        controlPanel.add(btnUpdate);

        btnDelete = new JButton("Xóa");
        btnDelete.setBounds(100, 200, 200, 30);
        btnDelete.setBackground(Color.LIGHT_GRAY);
        btnDelete.setForeground(Color.BLACK);
        controlPanel.add(btnDelete);
        

        add(controlPanel);

        btnAdd.addActionListener(this);
        btnDelete.addActionListener(this);
        btnRefresh.addActionListener(this);
        btnUpdate.addActionListener(this);
        btnFind.addActionListener(this);
        table.addMouseListener(this);
        loadRooms();
        
        
    }
    
    public void loadRooms() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Xóa dữ liệu cũ
        RoomDAO roomDAO = new RoomDAO();
        List<Room> rooms = roomDAO.getRoomList();

        for (Room room : rooms) {
            model.addRow(new Object[]{
                room.getRoomCode(),
                room.getRoomName(),
                room.getRoomType(),
                String.valueOf(room.getRoomPrice()),
                room.getRoomStatus(),
                String.valueOf(room.getMaxPeople())
            });
        }
    }
    
    
	private void clearFields() {
        txtRoom.setText("");
        txtTenp.setText("");
        txtLoaiPhong.setText("");
        txtGiap.setText("");
        txtTTP.setText("");
        txtSoluong.setText("");
        TTPCombo.setSelectedIndex(0);
        txtRoom.requestFocus();
    }
	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
	    if (row != -1) {
	        txtRoom.setText(table.getValueAt(row, 0).toString());
	        txtTenp.setText(table.getValueAt(row, 1).toString());
	        txtGiap.setText(table.getValueAt(row, 3).toString());
	        TTPCombo.setSelectedItem(table.getValueAt(row, 4).toString());
	        txtLoaiPhong.setText(table.getValueAt(row, 2).toString());
	        txtSoluong.setText(table.getValueAt(row, 5).toString());
	    }
	}
    private void showMessage(String message, JTextField txt) {
		txt.requestFocus();
		txtMess.setText(message);
	}
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAdd) {
            Room room = new Room(txtRoom.getText(), txtTenp.getText(), txtLoaiPhong.getText(), Integer.parseInt(txtGiap.getText()), TTPCombo.getSelectedItem().toString(), Integer.parseInt(txtSoluong.getText()));
            roomDAO.addRoom(room);
            loadRooms();
        } else if (e.getSource() == btnDelete) {
            roomDAO.removeRoom(txtRoom.getText());
            loadRooms();
        } else if (e.getSource() == btnUpdate) {
            Room room = new Room(txtRoom.getText(), txtTenp.getText(), txtLoaiPhong.getText(), Integer.parseInt(txtGiap.getText()), TTPCombo.getSelectedItem().toString(), Integer.parseInt(txtSoluong.getText()));
            roomDAO.updateRoom(txtRoom.getText(), room);
            loadRooms();
        } else if (e.getSource() == btnRefresh ) {
        	txtRoom.setText("");;
        	txtTenp.setText("");
        	txtLoaiPhong.setText("");
        	txtGiap.setText("");
        	TTPCombo.setSelectedItem("");;
        	txtSoluong.setText("");
        }else if (e.getSource() == btnFind) {
            String roomCode = txtfind.getText().trim();
            Room room = roomDAO.findRoom(roomCode);
            if (room != null) {
                model.setRowCount(0);
                model.addRow(new Object[]{room.getRoomCode(), room.getRoomName(), room.getRoomType(), room.getRoomPrice(), room.getRoomStatus(), room.getMaxPeople()});
            } else {
                JOptionPane.showMessageDialog(this, "Không tìm thấy phòng", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    private void filterRoomsByType() {
        String selectedType = (String) cboFilterLoaiPhong.getSelectedItem();
        model.setRowCount(0);
        for (Room room : roomDAO.getRoomList()) {
            if ("Tất cả".equals(selectedType) || room.getRoomType().equals(selectedType)) {
                model.addRow(new Object[]{room.getRoomCode(), room.getRoomName(), room.getRoomType(), room.getRoomPrice(), room.getRoomStatus(), room.getMaxPeople()});
            }
        }
    }


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}