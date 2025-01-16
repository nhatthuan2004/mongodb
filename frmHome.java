package gui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class frmHome extends JFrame implements ActionListener {
	private JMenuItem menuItemExit;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
    public frmHome(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Giao diện trang chủ");
        this.setSize(1550, 850);
        this.setResizable(true);

        this.setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        
        JLabel lblHeader = new JLabel("Hệ Thống Quản Lý Khách sạn - Nhân Viên");
        lblHeader.setForeground(Color.WHITE);
        lblHeader.setBackground(Color.DARK_GRAY);
        lblHeader.setOpaque(true);
        lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
        lblHeader.setFont(new Font("Times New Roman", Font.PLAIN, 27));
        lblHeader.setBounds(10, 10, 1516, 28);
        getContentPane().add(lblHeader);
        
        JPanel panelSystem = new JPanel();
        panelSystem.setBackground(Color.LIGHT_GRAY);
        panelSystem.setBounds(10, 42, 226, 57);
        getContentPane().add(panelSystem);
        
        JLabel lblSystemIcon = new JLabel("");
        lblSystemIcon.setIcon(new ImageIcon("img\\icons8-system-50.png"));
        panelSystem.add(lblSystemIcon);
        
        JMenuBar systemMenuBar = new JMenuBar();
        panelSystem.add(systemMenuBar);
        
        JMenu menuSystem = new JMenu("Hệ thống");
        menuSystem.setBackground(Color.CYAN);
        menuSystem.setFont(new Font("Times New Roman", Font.PLAIN, 40));
        systemMenuBar.add(menuSystem);
        
        JMenuItem menuItemHome = new JMenuItem("Trang chủ");
        menuItemHome.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        menuItemHome.setIcon(new ImageIcon("img\\icons8-home-32.png"));
        menuSystem.add(menuItemHome);
        
        
        
        
        menuItemExit = new JMenuItem("Thoát");
        menuItemExit.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        menuItemExit.setIcon(new ImageIcon("img\\icons8-exit-24.png"));
        menuSystem.add(menuItemExit);
        
        JPanel panelImage = new JPanel();
        panelImage.setBounds(10, 100, 1550, 700);
        getContentPane().add(panelImage);
        


        ImageIcon originalIcon = new ImageIcon("img\\giaodienchinh.jpg");
        Image originalImage = originalIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(1550, 700, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        panelImage.setLayout(new CardLayout(0, 0));
        
        JLabel lblStoreImage = new JLabel("");
        lblStoreImage.setIcon(scaledIcon);
        panelImage.add(lblStoreImage, "name_27699725428600");
        
        JPanel panelManagement = new JPanel();
        panelManagement.setBackground(Color.LIGHT_GRAY);
        panelManagement.setBounds(245, 42, 226, 57);
        getContentPane().add(panelManagement);
        
        JLabel lblManagementIcon = new JLabel("");
        lblManagementIcon.setIcon(new ImageIcon("img\\icons8-manager-50.png"));
        panelManagement.add(lblManagementIcon);
        
        JMenuBar managementMenuBar = new JMenuBar();
        panelManagement.add(managementMenuBar);
        
        JMenu menuManagement = new JMenu("Quản lí");
        menuManagement.setFont(new Font("Times New Roman", Font.PLAIN, 40));
        managementMenuBar.add(menuManagement);
        
        JMenuItem menuItemRoom = new JMenuItem("Phòng");
        menuItemRoom.setIcon(new ImageIcon("img\\icons8-home-32.png"));
        menuItemRoom.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        menuManagement.add(menuItemRoom);
        menuItemRoom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelImage.removeAll();

                pnRoom room = new pnRoom();
                
                room.setBounds(0, 0, panelImage.getWidth(), panelImage.getHeight());
                panelImage.add(room);
                
                panelImage.revalidate();
                panelImage.repaint();
            }
        });
        
        JMenu menuProductSupplier = new JMenu("Dịch vụ");
        menuProductSupplier.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        menuManagement.add(menuProductSupplier);

        JMenuItem menuItemProduct = new JMenuItem("Sản phẩm");
        menuItemProduct.setIcon(new ImageIcon("img\\icons8-product-32.png"));
        menuItemProduct.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        menuProductSupplier.add(menuItemProduct);

        JMenuItem menuItemSupplier = new JMenuItem("Nhà cung cấp");
        menuItemSupplier.setIcon(new ImageIcon("img\\icons8-supplier-32.png"));
        menuItemSupplier.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        menuProductSupplier.add(menuItemSupplier);
        
        
        JMenuItem menuItemEmployee = new JMenuItem("Nhân Viên");
        menuItemEmployee.setIcon(new ImageIcon("E:\\JAVA_BAITAPLON_NHOM5\\JAVA\\img\\icons8-employee-32.png"));
        menuItemEmployee.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        menuManagement.add(menuItemEmployee);
        
  
        JMenuItem menuItemCustomer = new JMenuItem("Khách hàng");
        menuItemCustomer.setIcon(new ImageIcon("img\\icons8-customer-32.png"));
        menuItemCustomer.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        menuManagement.add(menuItemCustomer);
       
        
        menuItemHome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelImage.removeAll(); 
                lblStoreImage.setIcon(scaledIcon); 
                panelImage.add(lblStoreImage); 
                panelImage.revalidate(); 
                panelImage.repaint(); 
            }
        });
        
        JPanel panelProcess = new JPanel();
        panelProcess.setBackground(Color.LIGHT_GRAY);
        panelProcess.setBounds(481, 42, 226, 57);
        getContentPane().add(panelProcess);
        
        JLabel lblProcessIcon = new JLabel("");
        lblProcessIcon.setIcon(new ImageIcon("E:\\JAVA_BAITAPLON_NHOM5\\JAVA\\img\\icons8-process-50_1.png"));
        panelProcess.add(lblProcessIcon);
        
        JMenuBar processMenuBar = new JMenuBar();
        panelProcess.add(processMenuBar);
        
        JMenu menuProcess = new JMenu("Xử lý");
        menuProcess.setFont(new Font("Times New Roman", Font.PLAIN, 40));
        processMenuBar.add(menuProcess);
        
        JMenuItem menuItemCart = new JMenuItem("Đặt phòng");
        menuItemCart.setIcon(new ImageIcon("E:\\JAVA_BAITAPLON_NHOM5\\JAVA\\img\\icons8-shopping-cart-32.png"));
        menuItemCart.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        menuProcess.add(menuItemCart);
        

        
        JMenuItem menuItemPayment = new JMenuItem("Quản lí hóa đơn");
        menuItemPayment.setIcon(new ImageIcon("img\\icons8-pay-32.png"));
        menuItemPayment.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        menuProcess.add(menuItemPayment);
        
        
        JPanel panelReport = new JPanel();
        panelReport.setBackground(Color.LIGHT_GRAY);
        panelReport.setBounds(719, 42, 226, 57);
        getContentPane().add(panelReport);
        
        JLabel lblReportIcon = new JLabel("");
        lblReportIcon.setIcon(new ImageIcon("img\\icons8-report-40.png"));
        panelReport.add(lblReportIcon);
        
        JMenuBar reportMenuBar = new JMenuBar();
        panelReport.add(reportMenuBar);
        
        JMenu menuReport = new JMenu("Báo cáo");
        menuReport.setFont(new Font("Times New Roman", Font.PLAIN, 40));
        reportMenuBar.add(menuReport);
        
        JMenuItem menuItemYearlyRevenue = new JMenuItem("Doanh thu theo năm");
        menuItemYearlyRevenue.setIcon(new ImageIcon("img\\icons8-report-32.png"));
        menuItemYearlyRevenue.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        menuReport.add(menuItemYearlyRevenue);
        

        
        JMenuItem menuItemProductRevenue = new JMenuItem("Doanh thu theo SP");
        menuItemProductRevenue.setIcon(new ImageIcon("img\\icons8-product-knowledge-32.png"));
        menuItemProductRevenue.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        menuReport.add(menuItemProductRevenue);

        
        JPanel pnHelp = new JPanel();
        pnHelp.setBackground(Color.LIGHT_GRAY);
        pnHelp.setBounds(951, 42, 226, 57);
        getContentPane().add(pnHelp);
        
        JLabel lblHelpIcon = new JLabel("");
        lblHelpIcon.setIcon(new ImageIcon("img\\icons8-help-50.png"));
        pnHelp.add(lblHelpIcon);
        
        JMenuBar helpMenuBar = new JMenuBar();
        pnHelp.add(helpMenuBar);
        
        JMenu menuHelp = new JMenu("Trợ giúp");
        menuHelp.setFont(new Font("Times New Roman", Font.PLAIN, 40));
        helpMenuBar.add(menuHelp);
        
        JMenuItem menuItemFeedback = new JMenuItem("Hướng dẫn sử dụng");
        menuItemFeedback.setIcon(new ImageIcon("img\\icons8-customer-feedback-32.png"));
        menuItemFeedback.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        menuHelp.add(menuItemFeedback);
        
        
        JLabel lblClock = new JLabel("");
        lblClock.setHorizontalAlignment(SwingConstants.CENTER);
        lblClock.setBounds(1187, 48, 328, 42);
        lblClock.setFont(new Font("Times New Roman", Font.BOLD, 30));
        getContentPane().add(lblClock);
        
        // Timer to update the clock every second
        Timer clockTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
                Date currentTime = new Date();
                lblClock.setText(timeFormat.format(currentTime));
            }
        });
        clockTimer.start();
        
        menuItemExit.addActionListener(this);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
    	Object o = e.getSource();
    	if(o == menuItemExit) {
    		System.exit(0);
    	}
    }
}
