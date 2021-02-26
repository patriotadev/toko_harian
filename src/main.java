import java.awt.Color;
import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class main {
    public Statement st;
    public ResultSet rs;
    public DefaultTableModel tabModel;
    Connection cn = koneksi.Koneksi();
  
    public main() {
        initialize();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
    public static void main(String args[]) {
     EventQueue.invokeLater(() -> {
         try {
             main window;
             window = new main();
         } catch (Exception e) {
         }
     });
    }
    
    public final void initialize()
    {
        JFrame mainFrame = new JFrame("RIO STORE");
        mainFrame.getContentPane().setBackground(new Color(88, 179, 224));
        mainFrame.setSize(400,400);
        mainFrame.setResizable(false);
        mainFrame.setVisible(true);
        mainFrame.setLayout(null);
        
        JLabel namaProduk = new JLabel("RIO STORE MAIN MENU");
        namaProduk.setBounds(140,25,200,30);
        mainFrame.add(namaProduk);
        
        JLabel imgLabel = new JLabel(new ImageIcon("C:\\Users\\USER\\Pictures\\Saved Pictures\\toko_harian.jpg"));
        imgLabel.setBounds(50,60,300,220);
        mainFrame.add(imgLabel);
        
        JButton formBtn = new JButton("Form");
        formBtn.setBounds(100, 300, 80, 30);
        mainFrame.add(formBtn);
        
        JButton listBtn = new JButton("List");
        listBtn.setBounds(225, 300, 80, 30);
        mainFrame.add(listBtn);
        
        listBtn.addActionListener
        (
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {       
                    getTable();
                    getData();
                              
                }
            }
        );
         
        formBtn.addActionListener(
        
            new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {                
                   formData();
                }
            }
        );    
    }
    
    
    public void getTable()
    {
        JFrame listFrame = new JFrame("DAFTAR PRODUK");
        listFrame.getContentPane().setBackground(new Color(88, 179, 224));
        listFrame.setSize(400,600);
        listFrame.setVisible(true);
                 
        Object[] getData = {
            "Produk","Stok","Harga"
        };
                 
        JTable jt=new JTable();     
        
        tabModel = new DefaultTableModel(null, getData);
        jt.setModel(tabModel);
        jt.setBounds(30,40,200,300);          
                           JScrollPane sp=new JScrollPane(jt); 
                           listFrame.add(sp);    
    }
    
    public void getData()
    {
        String state = "";
        
        try
        {
            st = cn.createStatement();
            tabModel.getDataVector().removeAllElements();
            tabModel.fireTableDataChanged();
            
            rs = st.executeQuery("SELECT * FROM produk " + state);
          
        while(rs.next())
        {
            Object[] data ={
                rs.getString("nama"),
                rs.getString("stok"),
                rs.getString("Harga"),
            };
            
            tabModel.addRow(data);
        }
        
        
        } 
        catch(SQLException e)
        {
        }
    }
    
    
    public void formData()
    {
        
        JFrame formFrame = new JFrame("FORM DATA PRODUK");
                    formFrame.getContentPane().setBackground(new Color(88, 179, 224));
                    formFrame.setSize(600,600);
                    formFrame.setResizable(false);
                    formFrame.setVisible(true);
                    formFrame.setLayout(null);
                    
                    JLabel produkLabel = new JLabel("Input Produk :");
                    produkLabel.setBounds(50,25,200,30);
                    formFrame.add(produkLabel);
                    
                    JLabel searchLabel = new JLabel("Search product to edit or delete :");
                    searchLabel.setBounds(350,25,200,30);
                    formFrame.add(searchLabel);
//
                    JLabel stokLabel = new JLabel("Input Stok :");
                    stokLabel.setBounds(50,95,200,30);
                    formFrame.add(stokLabel);
                    
                    JLabel hargaLabel = new JLabel("Input Harga :");
                    hargaLabel.setBounds(50,165,200,30);
                    formFrame.add(hargaLabel);

                    JTextField produk = new JTextField();
                    produk.setBounds(50,50, 200,30);
                    formFrame.add(produk);
                    
                    JTextField search = new JTextField();
                    search.setBounds(350,50, 200,30);
                    formFrame.add(search);

                    JTextField stok = new JTextField();
                    stok.setBounds(50,120, 200,30);
                    formFrame.add(stok);
                    
                    JTextField harga = new JTextField();
                    harga.setBounds(50,190, 200,30);
                    formFrame.add(harga);
                    
                    JButton searchBtn = new JButton("Search");
                    searchBtn.setBounds(470,100, 80,30);
                    formFrame.add(searchBtn);

                    JButton addBtn = new JButton("Add");
                    addBtn.setBounds(50, 265, 80, 30);
                    formFrame.add(addBtn);
                    
                    JButton updateBtn = new JButton("Update");
                    updateBtn.setBounds(50, 315, 80, 30);
                    formFrame.add(updateBtn);
                    
                    JButton resetBtn = new JButton("Reset");
                    resetBtn.setBounds(150, 265, 80, 30);
                    formFrame.add(resetBtn);
                    
                    JButton deleteBtn = new JButton("Delete");
                    deleteBtn.setBounds(150, 315, 80, 30);
                    formFrame.add(deleteBtn);
                    
                    
        
 
                    
        addBtn.addActionListener
        (

                new ActionListener()
                    {
                        @Override
                        public void actionPerformed(ActionEvent e)
                        {                
                           try{

                           st = cn.createStatement();
                           st.executeUpdate("INSERT INTO produk (nama, stok, harga) VALUES ('" +produk.getText()+ "','" +stok.getText()+ "','" +harga.getText()+ "')");
                           System.out.println("Berhasil..");
         
                            JOptionPane.showMessageDialog(null, "Produk berhasil ditambahkan ke tabel!");
                            produk.setText("");
                            stok.setText("");
                            harga.setText("");  

                            }
                            catch(SQLException a)
                            {}
                        }
                    }

        );
        
        resetBtn.addActionListener
        (
               new ActionListener()
                    {
                        @Override
                        public void actionPerformed(ActionEvent e)
                        {                
                         produk.setText("");
                         stok.setText("");
                         harga.setText("");
                        }
                    }
        
        
        );
        
        searchBtn.addActionListener
        (
               new ActionListener()
                    {
                        @Override
                        public void actionPerformed(ActionEvent e)
                        {                
                        String getVal = search.getText();
                        String sql = "SELECT * FROM produk WHERE nama='"+getVal+"'";
                         try{
     
                            st = cn.createStatement();

                             rs = st.executeQuery(sql);
                             
                             while(rs.next())
                             {
                                  String getProduk = rs.getString("nama");
                                  String getStok = rs.getString("stok");
                                  String getHarga = rs.getString("harga");
                                  produk.setText(getProduk);
                                  stok.setText(getStok);
                                  harga.setText(getHarga);
                             }
                             
                           

                            }
                            catch(SQLException a)
                            {}
                        
                        }
                    }
        );
        
        updateBtn.addActionListener
        (
        
         new ActionListener()
                    {
                        @Override
                        public void actionPerformed(ActionEvent e)
                        {     
                            String getVal = search.getText();
                            try {
                                st = cn.createStatement();
                                st.executeUpdate("UPDATE produk  SET " + "nama='" + produk.getText() +"', "+ "stok='" + stok.getText() +"', "+ "harga='" + harga.getText() +
                                        "' WHERE nama='"+getVal+"'");
                                System.out.println("Ok..");
                             
                                JOptionPane.showMessageDialog(null, "Update Berhasil");
                            } catch (SQLException a) {
                              
                            }
                            
                        }
                    }
        
        
        );
        
        deleteBtn.addActionListener
        (
        
                new ActionListener()
                    {
                        @Override
                        public void actionPerformed(ActionEvent e)
                        {                
                            try
                            {
                                int answer;
                                String getVal = search.getText();
                                
                                if((answer = JOptionPane.showConfirmDialog(null, "Hapus data produk?","Konfirmasi",JOptionPane.YES_NO_OPTION)) == 0)
                                {
                                    st = cn.createStatement();
                                    st.executeUpdate("DELETE FROM produk WHERE nama='"+getVal+"'");
                                    System.out.println("Sip..");
                                }
                            }
                            catch(SQLException a)
                            {
                                
                            }
                        }
                    }
        
        
        
        );
        
        
        
        
                        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
