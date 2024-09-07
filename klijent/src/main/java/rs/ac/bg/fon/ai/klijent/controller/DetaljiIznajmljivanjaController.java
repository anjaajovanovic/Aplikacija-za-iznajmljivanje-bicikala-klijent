/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.klijent.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import rs.ac.bg.fon.ai.klijent.communication.Communication;
import rs.ac.bg.fon.ai.klijent.coordinator.Coordinator;
import rs.ac.bg.fon.ai.klijent.form.DetaljiIznajmljivanjaForm;
import rs.ac.bg.fon.ai.klijent.form.model.StavkaIznajmljivanjaTableModel;
import rs.ac.bg.fon.ai.zajednicki.domain.Bicikl;
import rs.ac.bg.fon.ai.zajednicki.domain.Iznajmljivanje;
import rs.ac.bg.fon.ai.zajednicki.domain.StavkaIznajmljivanja;

/**
 *
 * @author PC
 */
public class DetaljiIznajmljivanjaController {
    
    private final DetaljiIznajmljivanjaForm dif;
    private Iznajmljivanje i;
    private double ukupnaCena;

    public DetaljiIznajmljivanjaController(DetaljiIznajmljivanjaForm dif) {
        this.dif = dif;
        addActionListeners();
    }
    
    

    public void openForm() {
        prepareForm();
        dif.setVisible(true);
        dif.setLocationRelativeTo(null);
        dif.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void addActionListeners() {
        
        dif.addBtnIzracunajCenuActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dif.getTxtBrojSati().getText().matches("\\d+")) {
                    int brojSati= Integer.parseInt(dif.getTxtBrojSati().getText());
                    Bicikl b = (Bicikl) dif.getComboBoxBicikle().getSelectedItem();
                    dif.getTxtCena().setText(String.valueOf(brojSati*b.getCenaPoSatu()));
                }
                else {
                    dif.getTxtBrojSati().setText("");
                    dif.getTxtCena().setText("");
                    JOptionPane.showMessageDialog(dif, "Unesite broj sati ciframa.", "Greska", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        dif.addBtnAddStavkaActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                Bicikl b = (Bicikl) dif.getComboBoxBicikle().getSelectedItem();
                System.out.println(b.getId());
                int brojSati = Integer.parseInt(dif.getTxtBrojSati().getText());
                double cena = Double.parseDouble(dif.getTxtCena().getText());
                
                StavkaIznajmljivanja si = new StavkaIznajmljivanja(i, -1, brojSati, cena, b);
                
                StavkaIznajmljivanjaTableModel tm = (StavkaIznajmljivanjaTableModel) dif.getTblStavke().getModel();
                tm.dodajStavku(si);
                
                ukupnaCena = tm.vratiUkupnuCenu();
                dif.getTxtUkupnaCena().setText(ukupnaCena + " RSD");
                
            }
        });
        
        dif.addBtnDeleteStavkaActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = dif.getTblStavke().getSelectedRow();
                if(row > -1) {
                    StavkaIznajmljivanjaTableModel tm = (StavkaIznajmljivanjaTableModel) dif.getTblStavke().getModel();
                    tm.obrisiStavku(row);
                    ukupnaCena = tm.vratiUkupnuCenu();
                    dif.getTxtUkupnaCena().setText(ukupnaCena + " RSD");
                }
            }
        });
        
        dif.addBtnOtkaziActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(dif, "Da li ste sigurni da zelite da otkazete iznajmljivanje?", "Otkazivanje", JOptionPane.YES_NO_OPTION);
                
                if(result == JOptionPane.NO_OPTION) {
                    return;
                }
                
                if(result == JOptionPane.YES_OPTION) {
                    try {
                        StavkaIznajmljivanjaTableModel tm = (StavkaIznajmljivanjaTableModel) dif.getTblStavke().getModel();
                        i.setStavkaIznajmljivanja((ArrayList<StavkaIznajmljivanja>) tm.getStavke());
                        
                        Communication.getInstance().deleteIznajmljivanje(i);
                        Coordinator.getInstance().openPretragaIznajmljivanjaForm();
                        JOptionPane.showMessageDialog(dif, "Sistem je obrisao iznajmljivanje");
                        dif.dispose();
                    } catch (Exception ex) {
                        System.out.println("Greska prilikom otkazivanja iznajmljvanja:");
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(dif, "Sistem ne moze da obrise iznajmljivanje.", "Greska", JOptionPane.ERROR_MESSAGE);
                    
                    }
                }
            }
        });
        
        dif.addBtnIzmeniActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
                    Date datum = sf.parse(dif.getTxtDatum().getText());
                    StavkaIznajmljivanjaTableModel tm = (StavkaIznajmljivanjaTableModel) dif.getTblStavke().getModel();
                    i.setDatum(datum);
                    i.setStavkaIznajmljivanja((ArrayList<StavkaIznajmljivanja>) tm.getStavke());
                    i.setUkupnaCena(ukupnaCena);
                    
                    for(StavkaIznajmljivanja si : i.getStavkaIznajmljivanja()) {
                        System.out.println(si);
                    }
                    
                    Communication.getInstance().editIznajmljivanje(i);
                    Coordinator.getInstance().openPretragaIznajmljivanjaForm();
                    JOptionPane.showMessageDialog(dif, "Sistem je zapamtio iznajmljivanje");
                    dif.dispose();
                    
                } catch (Exception ex) {
                    System.out.println("Greska prilikom izmene iznajmljivanja:");
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(dif, "Sistem ne moze da zapamti iznajmljivanje.", "Greska", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        dif.addBtnZatvoriActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dif.dispose();
            }
        });
        
    }

    private void prepareForm() {
        i = (Iznajmljivanje) Coordinator.getInstance().getParam("iznajmljivanje");
        dif.getTxtDatum().setText(String.valueOf(i.getDatum()));
        dif.getLblKorisnik().setText(i.getKorisnik().getIme() + " " + i.getKorisnik().getPrezime());
        
        System.out.println(i.getKorisnik().getIme());
        
        StavkaIznajmljivanjaTableModel tm = new StavkaIznajmljivanjaTableModel(i);
        List<StavkaIznajmljivanja> stavke = tm.getStavke();
        for(StavkaIznajmljivanja s : stavke) {
            System.out.println(s);
        }
        dif.getTblStavke().setModel(tm);
        dif.getTxtUkupnaCena().setText(i.getUkupnaCena() + "");
        
        dif.getTxtCena().setText(stavke.get(0).getCenaStavke() + " RSD");
        
        // Popuni comboBox
        List<Bicikl> bicikle = Communication.getInstance().getAllBicikle();
        dif.getComboBoxBicikle().removeAllItems();
        for(Bicikl b : bicikle) {
            dif.getComboBoxBicikle().addItem(b);
        }
        
        dif.getTxtUkupnaCena().setEditable(false);
        dif.getTxtCena().setEditable(false);
        
        
    }
    
}
