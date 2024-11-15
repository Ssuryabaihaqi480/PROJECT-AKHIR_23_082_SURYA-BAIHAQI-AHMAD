package modul5;

import com.mysql.cj.xdevapi.Statement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

public class tampilan2 extends javax.swing.JFrame {
     
        // ... inisialisasi komponen ...
    
    Connection conn;
    private DefaultTableModel tabelsiswa1;
    private DefaultTableModel jawaban;
    private JComboBox<Integer> jComboBox; // Deklarasikan di sini
    public tampilan2() {
        initComponents();
        conn = (Connection) koneksi.getConnection(); // Pastikan koneksi.getConnection() berfungsi

        tabelsiswa1 = new DefaultTableModel();
        tabelsiswa.setModel(tabelsiswa1);
        // Menambahkan kolom ke tabelsoal1
        tabelsiswa1.addColumn("id_soal"); // Sesuaikan dengan kolom id di tabel guru
        tabelsiswa1.addColumn("soal"); // Sesuaikan dengan kolom soal di tabel guru
        tabelsiswa1.addColumn("tanggal"); // Sesuaikan dengan kolom hari di tabel guru
        
        jComboBox = new JComboBox<>(); // Inisialisasi di sini
        
            jawaban = new DefaultTableModel();
        periksajawaban.setModel(jawaban);
       jawaban.addColumn("ID");
      jawaban.addColumn("nama");
       jawaban.addColumn("Soal");
       jawaban.addColumn("Jawaban");
       jawaban.addColumn("tahun bulan tanggal");
        loadjawaban();
        loadComboBoxIdGuru();
        loadData();
        // Panggil fungsi loadData() di konstruktor
    }

    private void loadData() {
        tabelsiswa1.setRowCount(0);

        try {
            String sql = "SELECT * FROM guru LIMIT 10"; // Mengubah query untuk mengambil data dari tabel guru
            System.out.println("Query SQL: " + sql); // Cetak query SQL ke konsol
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                // Menambahkan baris ke dalam model tabel
                tabelsiswa1.addRow(new Object[]{
                    rs.getInt("id_guru"), // Sesuaikan dengan kolom id di tabel guru
                    rs.getString("soal"), // Sesuaikan dengan kolom soal di tabel guru
                    rs.getString("hari") // Sesuaikan dengan kolom hari di tabel guru
                });
            }
        } catch (SQLException e) {
            // Tampilkan pesan error yang lebih informatif
            JOptionPane.showMessageDialog(this, "Error Load Data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            // Atau, catat error ke log file
            // Logger.getLogger(tampilan2.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    // load tampilin id soal dari guru 

    private void loadComboBoxIdGuru() {
        try {
            String sql = "SELECT id_guru FROM guru LIMIT 10";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idGuru = rs.getInt("id_guru");
                jComboBox1.addItem(String.valueOf(idGuru)); // Konversi int ke String
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error Load ComboBox: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    


private void loadjawaban() {
    jawaban.setRowCount(0);
    try {
        String sql = "SELECT * FROM murid"; // Sesuaikan dengan tabel yang benar
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id_murid"); // Sesuaikan dengan kolom yang benar di tabel murid
            String nama = rs.getString("nama"); // Ambil nama dari kolom "nama"
            String soal = rs.getString("soal");
            String jawaban1 = rs.getString("jawaban");
            String hari = rs.getString("hari"); // Pastikan kolom 'hari' ada di tabel murid
            Object[] rowData = {id, nama, soal, jawaban1, hari}; // Tambahkan nama ke rowData
            jawaban.addRow(rowData); // Gunakan tabeljawaban di sini
        }
    } catch (SQLException e) {
        // Tampilkan pesan error yang lebih informatif
        JOptionPane.showMessageDialog(this, "Error Load Data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        
    }
}    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        button2 = new java.awt.Button();
        jProgressBar1 = new javax.swing.JProgressBar();
        tabbedPaneCustom1 = new modul5.TabbedPaneCustom();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelsiswa = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox<>();
        button1 = new java.awt.Button();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelsoal = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
        button3 = new java.awt.Button();
        jLabel2 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        periksajawaban = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jTextField4 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        button7 = new java.awt.Button();
        button6 = new java.awt.Button();
        button8 = new java.awt.Button();
        button4 = new java.awt.Button();
        button5 = new java.awt.Button();

        jTextField1.setText("jTextField1");

        button2.setLabel("button2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        tabelsiswa.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabelsiswa);

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        button1.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        button1.setLabel("Lihat Soal");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        tabelsoal.setColumns(20);
        tabelsoal.setRows(5);
        jScrollPane2.setViewportView(tabelsoal);

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        button3.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        button3.setLabel("SIMPAN");
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });
        jPanel5.add(button3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, 320, 40));

        jLabel2.setFont(new java.awt.Font("Serif", 3, 18)); // NOI18N
        jLabel2.setText("Nama :");
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, 90, -1));

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jPanel5.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, 240, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/download.jfifsemangat-removebg-preview.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        jPanel5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 95, -1, 180));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/download.jfifsemangat-removebg-preview.png"))); // NOI18N
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, 100));

        jLabel4.setFont(new java.awt.Font("Serif", 3, 24)); // NOI18N
        jLabel4.setText("Selamat Mengerjakan ");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(222, 222, 222)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel4)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTextField2)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tabbedPaneCustom1.addTab("siwa", jPanel1);

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Serif", 3, 24)); // NOI18N
        jLabel1.setText("silahkan chek kembali jawaban anda  ");
        jLabel1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                jLabel1ComponentHidden(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        periksajawaban.setModel(new javax.swing.table.DefaultTableModel(
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
        periksajawaban.setCellSelectionEnabled(true);
        jScrollPane3.setViewportView(periksajawaban);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 510, 90));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/11zon_resized-removebg-preview.png"))); // NOI18N
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 0, -1, 110));

        button7.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        button7.setLabel("SIMPAN");
        button7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button7ActionPerformed(evt);
            }
        });

        button6.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        button6.setLabel("EDIT");
        button6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button6ActionPerformed(evt);
            }
        });

        button8.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        button8.setLabel("HAPUS");
        button8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button8ActionPerformed(evt);
            }
        });

        button4.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        button4.setLabel("EXIT");
        button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button4ActionPerformed(evt);
            }
        });

        button5.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        button5.setLabel("LOGIN");
        button5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button8, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button6, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button7, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button5, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(11, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(button6, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button8, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button7, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button4, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button5, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tabbedPaneCustom1.addTab("Hasil ujian", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabbedPaneCustom1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tabbedPaneCustom1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
        try {
        int selectedIdGuru = Integer.parseInt(jComboBox1.getSelectedItem().toString()); 
        String soal = tabelsoal.getText(); // Ambil soal dari jTextArea1
        String jawaban = jTextField2.getText(); // Ambil jawaban dari jTextField2
        String nama = jTextField3.getText(); // Ambil nama dari JTextField

        // Simpan nama ke tabel murid
        String sql = "INSERT INTO murid (id_guru, nama, soal, jawaban, hari) VALUES (?, ?, ?, ?, NOW())"; 
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, selectedIdGuru);
        ps.setString(2, nama);
        ps.setString(3, soal);
        ps.setString(4, jawaban);
        int rowsAffected = ps.executeUpdate();

        loadjawaban(); // Muat ulang tabel periksajawaban setelah menyimpan
        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(this, "Jawaban berhasil disimpan!", "Sukses", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("path/ke/icon/sukses.png"));
        } else {
            JOptionPane.showMessageDialog(this, "Gagal menyimpan jawaban.", "Error", JOptionPane.ERROR_MESSAGE, new ImageIcon("path/ke/icon/error.png"));
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error menyimpan jawaban: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Pilih ID Guru terlebih dahulu.", "Error", JOptionPane.ERROR_MESSAGE);
    }

    
    }//GEN-LAST:event_button3ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
                                      
    try {
        int selectedIdGuru = Integer.parseInt(jComboBox1.getSelectedItem().toString()); 

        String sql = "SELECT soal FROM guru WHERE id_guru = ?"; 
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, selectedIdGuru);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            String soal = rs.getString("soal"); 
            tabelsoal.setText(soal); 
        } else {
            JOptionPane.showMessageDialog(this, "Tidak ada soal untuk guru ini.", "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error Load Soal: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Pilih ID Guru terlebih dahulu.", "Error", JOptionPane.ERROR_MESSAGE);
    } 


    tabelsoal.setEditable(false);
    }//GEN-LAST:event_button1ActionPerformed

    private void button7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button7ActionPerformed
 try {
        int selectedRow = periksajawaban.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Pilih baris data yang ingin disimpan.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int id = Integer.parseInt(periksajawaban.getValueAt(selectedRow, 0).toString()); // Ambil ID dari tabel
        String nama = periksajawaban.getValueAt(selectedRow, 1).toString(); // Ambil nama dari tabel
        String soal = periksajawaban.getValueAt(selectedRow, 2).toString(); // Ambil soal dari tabel
        String jawaban = periksajawaban.getValueAt(selectedRow, 3).toString(); // Ambil jawaban dari tabel

        // Simpan data yang diedit ke database
        String sql = "UPDATE murid SET jawaban = ?, nama = ?, soal = ? WHERE id_murid = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, jawaban);
        ps.setString(2, nama);
        ps.setString(3, soal);
        ps.setInt(4, id);

        ps.executeUpdate();
        JOptionPane.showMessageDialog(this, "Data berhasil disimpan!");

        // Muat ulang tabel jawaban (tab pertama)
        loadjawaban(); // Panggil loadjawaban() setelah menyimpan
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Pilih baris data yang valid.", "Error", JOptionPane.ERROR_MESSAGE);
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error Edit Data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }  // TODO add your handling code here:
    }//GEN-LAST:event_button7ActionPerformed

    
    
    
    // LOAD PERIKSA JAWABAN UNTUK MENGHAPUS JAWABAN   
    private void loadPeriksa() {
    DefaultTableModel modelPeriksa = (DefaultTableModel) periksajawaban.getModel();
    try {
        String sql = "SELECT * FROM murid"; // Mengambil data dari tabel murid
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            modelPeriksa.addRow(new Object[]{
                rs.getInt("id_guru"),
                rs.getString("soal"),
                rs.getString("jawaban"),
                rs.getDate("hari")
            });
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error Load Data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
    private void button8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button8ActionPerformed
   // menghapus jawaban murid di tabble periksa jawaban    
   try {
        int selectedRow = periksajawaban.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Pilih baris data yang ingin dihapus.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int id = Integer.parseInt(periksajawaban.getValueAt(selectedRow, 0).toString()); // Ambil ID dari tabel

        String sql = "DELETE FROM murid WHERE id_murid = ?"; // Hapus dari tabel murid
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1,id);

        ps.executeUpdate();
        JOptionPane.showMessageDialog(this, "Data berhasil dihapus!");

        // Update tabel periksajawaban
        loadPeriksa(); // Panggil fungsi untuk memuat ulang data ke tabel periksajawaban

        // Perbarui tabel murid di tampilan2
        loadjawaban(); 
        
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Pilih baris data yang valid.", "Error", JOptionPane.ERROR_MESSAGE);
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error Delete Data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    } 
    }//GEN-LAST:event_button8ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button4ActionPerformed
              int confirm = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin keluar?", "Konfirmasi Keluar", 
            JOptionPane.YES_NO_OPTION);    
        if (confirm == JOptionPane.YES_OPTION) {
            System.exit(0);
        }     // TODO add your handling code here:
    }//GEN-LAST:event_button4ActionPerformed

    private void button6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button6ActionPerformed
try {
        int selectedRow = periksajawaban.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Pilih baris data yang ingin diedit.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int id = Integer.parseInt(periksajawaban.getValueAt(selectedRow, 0).toString()); // Ambil ID dari tabel
        String nama = periksajawaban.getValueAt(selectedRow, 1).toString(); // Ambil nama dari tabel
        String soal = periksajawaban.getValueAt(selectedRow, 2).toString(); // Ambil soal dari tabel
        String jawaban = jTextField4.getText(); // Ambil jawaban dari jTextField4

        // Update data di tabel periksajawaban secara visual
        periksajawaban.setValueAt(jawaban, selectedRow, 3); // Perbarui kolom 'Jawaban'
        // Anda mungkin perlu memperbarui kolom lain jika diperlukan
        
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Pilih baris data yang valid.", "Error", JOptionPane.ERROR_MESSAGE);
    
    }


// try {
//        int selectedRow = periksajawaban.getSelectedRow();
//        if (selectedRow == -1) {
//            JOptionPane.showMessageDialog(this, "Pilih baris data yang ingin diedit.", "Error", JOptionPane.ERROR_MESSAGE);
//            return;
//        }
//
//        int id = Integer.parseInt(periksajawaban.getValueAt(selectedRow, 0).toString()); // Ambil ID dari tabel
//        String nama = periksajawaban.getValueAt(selectedRow, 1).toString(); // Ambil nama dari tabel
//        String soal = periksajawaban.getValueAt(selectedRow, 2).toString(); // Ambil soal dari tabel
//        String jawaban = jTextField4.getText(); // Ambil jawaban dari jTextField4
//
//        // Update data di tabel murid
//        String sql = "UPDATE murid SET jawaban = ?, nama = ?, soal = ? WHERE id_murid = ?";
//        PreparedStatement ps = conn.prepareStatement(sql);
//        ps.setString(1, jawaban);
//        ps.setString(2, nama);
//        ps.setString(3, soal);
//        ps.setInt(4, id); // Perbaiki indeks parameter ke 4
//
//        ps.executeUpdate();
//        JOptionPane.showMessageDialog(this, "Data berhasil diedit!");
//
//        // Muat ulang tabel periksajawaban
//        loadjawaban(); 
//    } catch (NumberFormatException e) {
//        JOptionPane.showMessageDialog(this, "Pilih baris data yang valid.", "Error", JOptionPane.ERROR_MESSAGE);
//    } catch (SQLException e) {
//        JOptionPane.showMessageDialog(this, "Error Edit Data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//    }
    // TODO add your handling code here:
    }//GEN-LAST:event_button6ActionPerformed

    private void jLabel1ComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jLabel1ComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1ComponentHidden

    private void button5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button5ActionPerformed
     Menu_login pertama = new Menu_login();
      pertama.setVisible(true);
      this.dispose();    // TODO add your handling code here:
    }//GEN-LAST:event_button5ActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tampilan2().setVisible(true);
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
    private java.awt.Button button8;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTable periksajawaban;
    private modul5.TabbedPaneCustom tabbedPaneCustom1;
    private javax.swing.JTable tabelsiswa;
    private javax.swing.JTextArea tabelsoal;
    // End of variables declaration//GEN-END:variables
}
