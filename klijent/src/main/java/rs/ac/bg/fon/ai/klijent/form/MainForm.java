/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package rs.ac.bg.fon.ai.klijent.form;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import javax.swing.JTextField;

import rs.ac.bg.fon.ai.klijent.coordinator.Coordinator;
import rs.ac.bg.fon.ai.zajednicki.domain.Bicikl;

/**
 *
 * @author PC
 */
public class MainForm extends javax.swing.JFrame {

    /**
     * Creates new form MainForm
     */
    public MainForm() {
        initComponents();
    }

    public JComboBox<Object> getComboBoxBicikl() {
        return comboBoxBicikl;
    }

    public JComboBox<Object> getComboBoxKorisnici() {
        return comboBoxKorisnici;
    }

    

    public JTable getTblStavke() {
        return tblStavke;
    }

    public JTextField getTxtBrojSati() {
        return txtBrojSati;
    }

    public JTextField getTxtCena() {
        return txtCena;
    }

    public JTextField getTxtDatum() {
        return txtDatum;
    }

    public JTextField getTxtUkupnaCena() {
        return txtUkupnaCena;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem3 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        comboBoxKorisnici = new javax.swing.JComboBox<>();
        txtDatum = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        comboBoxBicikl = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtBrojSati = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtCena = new javax.swing.JTextField();
        btnAddStavka = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblStavke = new javax.swing.JTable();
        btnDeleteStavka = new javax.swing.JButton();
        btnCalculatePrice = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtUkupnaCena = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuItemNoviKorisnik = new javax.swing.JMenuItem();
        menuItemPretragaKorisnika = new javax.swing.JMenuItem();
        menuItemStatistika = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuItemPretragaIznajmljivanja = new javax.swing.JMenuItem();
        menuItem = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        jMenuItem3.setText("jMenuItem3");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jMenuItem1.setText("jMenuItem1");

        jMenuItem5.setText("jMenuItem5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Ulogovani zaposleni:");

        lblUser.setText("jLabel2");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Unos iznajmljivanja");

        jLabel3.setText("Korisnik:");

        jLabel4.setText("Datum iznajmljivanja:");

        txtDatum.setText("18.6.2024.");
        txtDatum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDatumActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Unos stavki iznajmljivanja");

        jLabel6.setText("Bicikl:");

        jLabel7.setText("Broj sati:");

        jLabel8.setText("Cena:");

        btnAddStavka.setText("Dodaj stavku");

        tblStavke.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblStavke);

        btnDeleteStavka.setText("Obrisi stavku");

        btnCalculatePrice.setText("Izracunaj cenu");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 638, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(comboBoxBicikl, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtBrojSati)
                                    .addComponent(txtCena, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCalculatePrice))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(btnAddStavka)
                        .addGap(44, 44, 44)
                        .addComponent(btnDeleteStavka, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxBicikl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBrojSati, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(btnCalculatePrice))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddStavka)
                    .addComponent(btnDeleteStavka))
                .addGap(50, 50, 50)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel9.setText("Ukupna cena:");

        txtUkupnaCena.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        btnSave.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnSave.setText("Sacuvaj");

        jMenu1.setText("Korisnik");

        menuItemNoviKorisnik.setText("Novi korisnik");
        menuItemNoviKorisnik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemNoviKorisnikActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemNoviKorisnik);

        menuItemPretragaKorisnika.setText("Pretraga korisnika");
        menuItemPretragaKorisnika.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemPretragaKorisnikaActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemPretragaKorisnika);

        menuItemStatistika.setText("Statistika");
        menuItemStatistika.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemStatistikaActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemStatistika);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Iznajmljivanje");

        menuItemPretragaIznajmljivanja.setText("Pretraga iznajmljivanja");
        menuItemPretragaIznajmljivanja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemPretragaIznajmljivanjaActionPerformed(evt);
            }
        });
        jMenu2.add(menuItemPretragaIznajmljivanja);

        jMenuBar1.add(jMenu2);

        menuItem.setText("Odjava");

        jMenuItem2.setText("Odjava sa sistema");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        menuItem.add(jMenuItem2);

        jMenuBar1.add(menuItem);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(lblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboBoxKorisnici, 0, 222, Short.MAX_VALUE)
                            .addComponent(txtDatum)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(278, 278, 278)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtUkupnaCena, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(351, 351, 351)
                        .addComponent(btnSave)))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblUser))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comboBoxKorisnici, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtUkupnaCena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addComponent(btnSave)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemPretragaKorisnikaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemPretragaKorisnikaActionPerformed
        Coordinator.getInstance().openPretragaKorisnikaForm();
    }//GEN-LAST:event_menuItemPretragaKorisnikaActionPerformed

    private void menuItemNoviKorisnikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemNoviKorisnikActionPerformed
//        Coordinator.getInstance().openKorisnikForm(FormaMod.ADD);
    }//GEN-LAST:event_menuItemNoviKorisnikActionPerformed


    
    
    
    
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
       // Coordinator.getInstance().openAddStudentInGroupForm();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void txtDatumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDatumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDatumActionPerformed

    private void menuItemPretragaIznajmljivanjaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemPretragaIznajmljivanjaActionPerformed
        Coordinator.getInstance().openPretragaIznajmljivanjaForm();
    }//GEN-LAST:event_menuItemPretragaIznajmljivanjaActionPerformed

    private void menuItemStatistikaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemStatistikaActionPerformed
        Coordinator.getInstance().openStatistikaForm();
    }//GEN-LAST:event_menuItemStatistikaActionPerformed

    private void txtBrojSatiKeyReleased(java.awt.event.KeyEvent evt) {                                        
        
        if (txtBrojSati.getText().matches("\\d+")) {
            int brojSati= Integer.parseInt(txtBrojSati.getText());
            Bicikl b = (Bicikl) comboBoxBicikl.getSelectedItem();
            txtCena.setText(String.valueOf(brojSati*b.getCenaPoSatu()));
        }
        else {
            txtBrojSati.setText("");
            txtCena.setText("");
            System.out.println("Nije dobar broj sati");
        } 
    } 

    public JButton getBtnCalculatePrice() {
        return btnCalculatePrice;
    }
    
    public void addBtnCalculateActionListener(ActionListener actionListener) {
        btnCalculatePrice.addActionListener(actionListener);
    }
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddStavka;
    private javax.swing.JButton btnCalculatePrice;
    private javax.swing.JButton btnDeleteStavka;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<Object> comboBoxBicikl;
    private javax.swing.JComboBox<Object> comboBoxKorisnici;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblUser;
    private javax.swing.JMenu menuItem;
    private javax.swing.JMenuItem menuItemNoviKorisnik;
    private javax.swing.JMenuItem menuItemPretragaIznajmljivanja;
    private javax.swing.JMenuItem menuItemPretragaKorisnika;
    private javax.swing.JMenuItem menuItemStatistika;
    private javax.swing.JTable tblStavke;
    private javax.swing.JTextField txtBrojSati;
    private javax.swing.JTextField txtCena;
    private javax.swing.JTextField txtDatum;
    private javax.swing.JTextField txtUkupnaCena;
    // End of variables declaration//GEN-END:variables

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public JLabel getLblUser() {
        return lblUser;
    }

    public JButton getBtnAddStavka() {
        return btnAddStavka;
    }

    public JButton getBtnSave() {
        return btnSave;
    }

    public JButton getBtnDeleteStavka() {
        return btnDeleteStavka;
    }
    
    public void addBtnDeleteStavkaActionListener(ActionListener actionListener) {
        btnDeleteStavka.addActionListener(actionListener);
    }
    
    public void addMenuItemDodajKorisnikaActionListener(ActionListener actionListener) {
        menuItemNoviKorisnik.addActionListener(actionListener);
    }
    
    public void addMenuItemPretragaKorisnikaActionListener(ActionListener actionListener) {
        menuItemPretragaKorisnika.addActionListener(actionListener);
    }
    
    public void addBtnAddStavkaActionListener(ActionListener actionListener) {
        btnAddStavka.addActionListener(actionListener);
    }
    
    public void addBtnSaveActionListener(ActionListener actionListener) {
        btnSave.addActionListener(actionListener);
    }


}
