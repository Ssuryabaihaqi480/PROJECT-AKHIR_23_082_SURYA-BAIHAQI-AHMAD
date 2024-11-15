
package modul5;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

public class tampilan1 extends javax.swing.JFrame {
    Connection conn;
    private DefaultTableModel model;
    private DefaultTableModel tabeljawaban;
    private DefaultTableModel nilaidosen;
    
    private JLabel dateLabel;
    
     public JComboBox<Integer> jComboBox11; 

   
        // ... 
      public void updateComboBox(int newIdMurid) {
        jComboBox11.addItem(newIdMurid);
    }  
    
    public tampilan1() {
        initComponents();
        conn = koneksi.getConnection(); // Periksa kelas 'koneksi'
        dateLabel = new JLabel();
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        dateLabel.setText(today.format(formatter));
        add(dateLabel);

        model = new DefaultTableModel();
        tabelsoal.setModel(model);
        model.addColumn("ID");
        model.addColumn("Soal");
        model.addColumn("Jawaban");
        model.addColumn("tahun bulan tanggal");
        loadsoal();
        
        tabeljawaban = new DefaultTableModel();
       hasiljawaban.setModel(tabeljawaban);
       tabeljawaban.addColumn("ID");
       tabeljawaban.addColumn("nama");
       tabeljawaban.addColumn("Soal");
       tabeljawaban.addColumn("Jawaban");
       tabeljawaban.addColumn("tahun bulan tanggal");
        loadjawaban();
        
       nilaidosen = new DefaultTableModel();
       tabelnilaiakhir.setModel(nilaidosen);
       nilaidosen.addColumn("ID");
       nilaidosen.addColumn("nama");
       nilaidosen.addColumn("Soal");      
       nilaidosen.addColumn("Jawaban");
       nilaidosen.addColumn("NILAI");
       
      
       jComboBox11 = new JComboBox<>();
       loadNilai() ;
    }

    private void loadsoal() {
        model.setRowCount(0);
        combonilai.removeAllItems();
        try {
            String sql = "SELECT * FROM guru"; // Sesuaikan dengan tabel yang benar
            String sqli = "SELECT id_murid, id_guru, soal, jawaban, hari FROM murid";
            
            PreparedStatement psi = conn.prepareStatement(sqli);
            ResultSet rsi = psi.executeQuery();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_guru"); // Sesuaikan dengan kolom yang benar
                String soal = rs.getString("soal");
                String jawaban = rs.getString("jawaban");
                String hari = rs.getString("hari"); // Pastikan kolom 'hari' ada di tabel
                Object[] rowData = {id, soal, jawaban, hari};
                model.addRow(rowData);
            }
            rs.close();
            ps.close();
            while (rsi.next()){
            String tampilan = String.format("%s",
                    rsi.getString("id_murid"),
                    rsi.getString("id_guru"),
                    rsi.getString("jawaban"),
                    rsi.getString("hari")
            );
            combonilai.addItem(tampilan);
            
            }
            rsi.close();
            psi.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error Save Data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
           
        }
    }

    private void loadjawaban() {
    tabeljawaban.setRowCount(0);
    try {
        String sql = "SELECT * FROM murid"; // Sesuaikan dengan tabel yang benar
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id_murid"); // Sesuaikan dengan kolom yang benar di tabel murid
            String nama = rs.getString("nama");
            String soal = rs.getString("soal");
            String jawaban = rs.getString("jawaban");
            String hari = rs.getString("hari"); // Pastikan kolom 'hari' ada di tabel murid
            Object[] rowData = {id,nama, soal, jawaban, hari};
            tabeljawaban.addRow(rowData); // Gunakan tabeljawaban di sini
        }
    } catch (SQLException e) {
        // Tampilkan pesan error yang lebih informatif
        JOptionPane.showMessageDialog(this, "Error Load Data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        
    }
}
    
    
private void loadNilai() {
    nilaidosen.setRowCount(0); 
    try {
        String sql = "SELECT n.id_nilai, m.nama, n.soal, n.jawaban, n.nilai " +
                "FROM nilai n " +
                "JOIN murid m ON n.id_murid = m.id_murid"; // Pastikan JOIN dan nama tabel benar
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int idNilai = rs.getInt("id_nilai"); 
            String nama = rs.getString("nama"); // Pastikan nama kolom 'nama' benar
            String soal = rs.getString("soal");
            String jawaban = rs.getString("jawaban");
            int nilai = rs.getInt("nilai");

            Object[] rowData = {idNilai, nama, soal, jawaban, nilai};
            nilaidosen.addRow(rowData); 
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error Load Data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
} 

      @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jTextField7 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        tabbedPaneCustom1 = new modul5.TabbedPaneCustom();
        jPanel19 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelsoal = new javax.swing.JTable();
        tambahsoal = new java.awt.Button();
        editsoal = new java.awt.Button();
        hapussoal = new java.awt.Button();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tf_soal = new javax.swing.JTextArea();
        tf_jawaban = new javax.swing.JTextField();
        button3 = new java.awt.Button();
        button4 = new java.awt.Button();
        jPanel21 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        hasiljawaban = new javax.swing.JTable();
        button2 = new java.awt.Button();
        combonilai = new javax.swing.JComboBox<>();
        button5 = new java.awt.Button();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelnilaiakhir = new javax.swing.JTable();
        button1 = new java.awt.Button();
        button6 = new java.awt.Button();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        button7 = new java.awt.Button();

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel1.setText("jLabel1");

        jButton4.setText("jButton4");

        jButton14.setText("jButton14");

        jTextField1.setText("jTextField1");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(jTable2);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(jTable3);

        jTextField7.setText("jTextField7");

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 153, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(51, 51, 255));

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel7.add(jPanel20);

        jLabel2.setFont(new java.awt.Font("Matura MT Script Capitals", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("selamat mengerjakan ");
        jPanel7.add(jLabel2);

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 70));

        jPanel19.setBackground(new java.awt.Color(204, 204, 255));

        tabelsoal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tabelsoal);

        tambahsoal.setFont(new java.awt.Font("Maiandra GD", 3, 14)); // NOI18N
        tambahsoal.setLabel("TAMBAH");
        tambahsoal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahsoalActionPerformed(evt);
            }
        });

        editsoal.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        editsoal.setLabel("EDIT");
        editsoal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editsoalActionPerformed(evt);
            }
        });

        hapussoal.setFont(new java.awt.Font("Ebrima", 3, 14)); // NOI18N
        hapussoal.setLabel("HAPUS");
        hapussoal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapussoalActionPerformed(evt);
            }
        });

        tf_soal.setColumns(20);
        tf_soal.setRows(5);
        jScrollPane6.setViewportView(tf_soal);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tf_jawaban, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_jawaban)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        button3.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        button3.setLabel("MURID");
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });

        button4.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        button4.setLabel("KEMBALI");
        button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(editsoal, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tambahsoal, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hapussoal, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(tambahsoal, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editsoal, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hapussoal, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tabbedPaneCustom1.addTab("GURU", jPanel19);

        jPanel21.setBackground(new java.awt.Color(204, 207, 227));

        hasiljawaban.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane8.setViewportView(hasiljawaban);

        button2.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        button2.setLabel("haspus");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        combonilai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combonilaiActionPerformed(evt);
            }
        });

        button5.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        button5.setLabel("simpan nilai");
        button5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button5ActionPerformed(evt);
            }
        });

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/pr_icon-removebg-preview__1_-removebg-preview.png"))); // NOI18N

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(combonilai, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button5, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(jLabel3)
                        .addGap(61, 61, 61))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(combonilai, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        tabbedPaneCustom1.addTab("HASIL", jPanel21);

        jPanel4.setBackground(new java.awt.Color(153, 153, 255));

        tabelnilaiakhir.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabelnilaiakhir);

        button1.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        button1.setLabel("EXIT");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        button6.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        button6.setLabel("BACK");
        button6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button6ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Serif", 3, 24)); // NOI18N
        jLabel4.setText("NILAI AKHIR MAHASISWA ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(208, 208, 208))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel4)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        button7.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        button7.setLabel("DELET");
        button7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(button6, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(button7, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap(15, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 724, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(button1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                    .addComponent(button7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        tabbedPaneCustom1.addTab("NILAI SISWA", jPanel4);

        jPanel1.add(tabbedPaneCustom1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 760, 550));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void hapussoalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapussoalActionPerformed
     try {
            int selectedRow = tabelsoal.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Pilih baris data yang ingin dihapus.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int id = Integer.parseInt(tabelsoal.getValueAt(selectedRow, 0).toString()); // Ambil ID dari tabel

            String sql = "DELETE FROM guru WHERE id_guru = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data berhasil dihapus!");
            loadsoal();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Pilih baris data yang valid.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error Delete Data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }    // TODO add your handling code here:
    }//GEN-LAST:event_hapussoalActionPerformed

    private void editsoalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editsoalActionPerformed
     try {
            int selectedRow = tabelsoal.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Pilih baris data yang ingin diedit.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int id = Integer.parseInt(tabelsoal.getValueAt(selectedRow, 0).toString()); // Ambil ID dari tabel
            String soal = tf_soal.getText();
            String jawaban = tf_jawaban.getText();
            LocalDate date = LocalDate.parse(dateLabel.getText(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            java.sql.Date sqlDate = java.sql.Date.valueOf(date);

            String sql = "UPDATE guru SET soal = ?, jawaban = ?, hari = ? WHERE id_guru = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, soal);
            ps.setString(2, jawaban);
            ps.setDate(3, sqlDate);
            ps.setInt(4, id);

            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data berhasil diedit!");
            loadsoal();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Pilih baris data yang valid.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error Edit Data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
       // TODO add your handling code here:
    }//GEN-LAST:event_editsoalActionPerformed

    
    private void tambahsoalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahsoalActionPerformed

        
 try {
        String sql = "INSERT INTO guru (soal, jawaban, hari) VALUES (?, ?, ?)";
        System.out.println("Query SQL: " + sql); // Cetak query SQL ke konsol

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, tf_soal.getText());
        System.out.println("Nilai Soal: " + tf_soal.getText()); // Cetak nilai soal
        ps.setString(2, tf_jawaban.getText());
        System.out.println("Nilai Jawaban: " + tf_jawaban.getText()); // Cetak nilai jawaban

        LocalDate date = LocalDate.parse(dateLabel.getText(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        java.sql.Date sqlDate = java.sql.Date.valueOf(date);
        ps.setDate(3, sqlDate);

        ps.executeUpdate();
        JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan!");
        loadsoal();
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Durasi pengerjaan harus berupa angka.", "Input Error", JOptionPane.ERROR_MESSAGE);
    } catch (SQLException e) {
        // Tampilkan pesan error yang lebih informatif
        JOptionPane.showMessageDialog(this, "Error Save Data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
     
    }


    }//GEN-LAST:event_tambahsoalActionPerformed

    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
       tampilan2 murid = new tampilan2();
       murid.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_button3ActionPerformed

    private void button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button4ActionPerformed
      Menu_login pertama = new Menu_login();
      pertama.setVisible(true);
      this.dispose();
// TODO add your handling code here:
    }//GEN-LAST:event_button4ActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
                                        
    try {
        int selectedRow = hasiljawaban.getSelectedRow(); // Asumsikan tabelHasilJawaban adalah nama JTable untuk tabel hasil jawaban
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Pilih baris data yang ingin dihapus.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int id = Integer.parseInt(hasiljawaban.getValueAt(selectedRow, 0).toString()); // Ambil ID dari tabel

        String sql = "DELETE FROM murid WHERE id_murid = ?"; // Hapus dari tabel murid
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);

        ps.executeUpdate();
        JOptionPane.showMessageDialog(this, "Data berhasil dihapus!");

        // Update tabel hasil jawaban
        loadjawaban(); // Panggil fungsi untuk memuat ulang data ke tabel hasil jawaban

        // Perbarui tabel guru di tampilan2 (jika diperlukan)
        // loadGuru(); 
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Pilih baris data yang valid.", "Error", JOptionPane.ERROR_MESSAGE);
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error Delete Data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }

    }//GEN-LAST:event_button2ActionPerformed
  
    private void combonilaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combonilaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combonilaiActionPerformed

    private void button5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button5ActionPerformed

        
  
    try {
        int selectedIdMurid = Integer.parseInt(combonilai.getSelectedItem().toString()); 
        int nilai = Integer.parseInt(jTextField2.getText()); 

        // Ambil data dari tabel murid
        String sqlMurid = "SELECT id_murid, nama, soal, jawaban FROM murid WHERE id_murid = ?";
        PreparedStatement psMurid = conn.prepareStatement(sqlMurid);
        psMurid.setInt(1, selectedIdMurid);
        ResultSet rsMurid = psMurid.executeQuery();

        String nama = "";
        String soal = "";
        String jawaban = "";
        if (rsMurid.next()) {
            nama = rsMurid.getString("nama");
            soal = rsMurid.getString("soal");
            jawaban = rsMurid.getString("jawaban");
        }

        // Simpan nilai ke database
        String sqlNilai = "INSERT INTO nilai (id_murid, nama, soal, jawaban, nilai) VALUES (?, ?, ?, ?, ?)"; 
        PreparedStatement psNilai = conn.prepareStatement(sqlNilai);
        psNilai.setInt(1, selectedIdMurid);
        psNilai.setString(2, nama); 
        psNilai.setString(3, soal);
        psNilai.setString(4, jawaban);
        psNilai.setInt(5, nilai);
        int rowsAffected = psNilai.executeUpdate(); // Gunakan executeUpdate()

        loadNilai(); 
        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(this, "Nilai berhasil disimpan!", "Sukses", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("path/ke/icon/sukses.png"));
        } else {
            JOptionPane.showMessageDialog(this, "Gagal menyimpan nilai.", "Error", JOptionPane.ERROR_MESSAGE, new ImageIcon("path/ke/icon/error.png"));
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error menyimpan nilai: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Pilih ID Murid dan masukkan nilai yang valid.", "Error", JOptionPane.ERROR_MESSAGE);
    } 


    }//GEN-LAST:event_button5ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
          int confirm = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin keluar?", "Konfirmasi Keluar", 
            JOptionPane.YES_NO_OPTION);    
        if (confirm == JOptionPane.YES_OPTION) {
            System.exit(0);
        }     // TODO add your handling code here:
    }//GEN-LAST:event_button1ActionPerformed

    private void button6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button6ActionPerformed
         Menu_login pertama = new Menu_login();
      pertama.setVisible(true);
      this.dispose();    // TODO add your handling code here:
    }//GEN-LAST:event_button6ActionPerformed

    private void button7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button7ActionPerformed
                                          
   // menghapus jawaban murid di tabble periksa jawaban    
try {
        int selectedRow = tabelnilaiakhir.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Pilih baris data yang ingin dihapus.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int id = Integer.parseInt(tabelnilaiakhir.getValueAt(selectedRow, 0).toString()); // Ambil ID dari tabel

        String sql = "DELETE FROM nilai WHERE id_nilai = ?"; // Hapus dari tabel nilai
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);

        ps.executeUpdate();
        JOptionPane.showMessageDialog(this, "Data berhasil dihapus!");

        // Muat ulang tabel nilai akhir
        loadNilai(); // Asumsikan loadNilaiAkhir() memuat ulang tabel nilai akhir

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Pilih baris data yang valid.", "Error", JOptionPane.ERROR_MESSAGE);
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error Delete Data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } // TODO add your handling code here:
    }//GEN-LAST:event_button7ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(tampilan1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tampilan1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tampilan1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tampilan1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tampilan1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button1;
    private java.awt.Button button2;
    private java.awt.Button button3;
    private java.awt.Button button4;
    private java.awt.Button button5;
    private java.awt.Button button6;
    private java.awt.Button button7;
    private javax.swing.JComboBox<String> combonilai;
    private java.awt.Button editsoal;
    private java.awt.Button hapussoal;
    private javax.swing.JTable hasiljawaban;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField7;
    private modul5.TabbedPaneCustom tabbedPaneCustom1;
    private javax.swing.JTable tabelnilaiakhir;
    private javax.swing.JTable tabelsoal;
    private java.awt.Button tambahsoal;
    private javax.swing.JTextField tf_jawaban;
    private javax.swing.JTextArea tf_soal;
    // End of variables declaration//GEN-END:variables
}
