/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.klijent.controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import rs.ac.bg.fon.ai.klijent.communication.Communication;
import rs.ac.bg.fon.ai.klijent.coordinator.Coordinator;
import rs.ac.bg.fon.ai.klijent.form.MainForm;
import rs.ac.bg.fon.ai.klijent.form.model.StavkaIznajmljivanjaTableModel;
import rs.ac.bg.fon.ai.zajednicki.domain.Bicikl;
import rs.ac.bg.fon.ai.zajednicki.domain.Iznajmljivanje;
import rs.ac.bg.fon.ai.zajednicki.domain.Korisnik;
import rs.ac.bg.fon.ai.zajednicki.domain.StavkaIznajmljivanja;
import rs.ac.bg.fon.ai.zajednicki.domain.Zaposleni;

/**
 *
 * @author PC
 */
public class MainFormController {
    
    private final MainForm mf;
    
    private Zaposleni zaposleni;
    private double ukupnaCena;

    public MainFormController(MainForm mf) {
        this.mf = mf;
        addActionListeners();
    }

    public void openForm() {
        prepateForm();
        mf.setVisible(true);
        mf.setLocationRelativeTo(null);
    }

    private void addActionListeners() {
        
        mf.addBtnAddStavkaActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                Bicikl b = (Bicikl) mf.getComboBoxBicikl().getSelectedItem();
                int brojSati = Integer.parseInt(mf.getTxtBrojSati().getText());
                double cena = Double.parseDouble(mf.getTxtCena().getText());
                
                StavkaIznajmljivanja si = new StavkaIznajmljivanja(null, -1, brojSati, cena, b);
                
                StavkaIznajmljivanjaTableModel tm = (StavkaIznajmljivanjaTableModel) mf.getTblStavke().getModel();
                tm.dodajStavku(si);
                
                ukupnaCena = tm.vratiUkupnuCenu();
                mf.getTxtUkupnaCena().setText(ukupnaCena + " RSD");
                
            }
        });
        
        mf.addBtnDeleteStavkaActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                int row = mf.getTblStavke().getSelectedRow();
                StavkaIznajmljivanjaTableModel tm = (StavkaIznajmljivanjaTableModel) mf.getTblStavke().getModel();
                
                tm.obrisiStavku(row);
                ukupnaCena = tm.vratiUkupnuCenu();
                mf.getTxtUkupnaCena().setText(ukupnaCena + " din");
            }
        });
        
        
        mf.addBtnSaveActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                try {
                    
                    Korisnik k = (Korisnik) mf.getComboBoxKorisnici().getSelectedItem();
                    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
                    
                    Date date = sf.parse(mf.getTxtDatum().getText());
                    
                    StavkaIznajmljivanjaTableModel tm = (StavkaIznajmljivanjaTableModel) mf.getTblStavke().getModel();
                    
                    Iznajmljivanje i = new Iznajmljivanje(-1, date, ukupnaCena, zaposleni, k, (ArrayList<StavkaIznajmljivanja>) tm.getStavke());
                    
                    Communication.getInstance().addNewIznajmljivanje(i);
                    refreshForm();
                    JOptionPane.showMessageDialog(mf, "Sistem је zapamtio iznajmljivanje");
        
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(mf, "Sistem ne moze da zapamti iznajmljivanje.", "Greska", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        mf.addBtnCalculateActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mf.getTxtBrojSati().getText().matches("\\d+")) {
                    int brojSati= Integer.parseInt(mf.getTxtBrojSati().getText());
                    Bicikl b = (Bicikl) mf.getComboBoxBicikl().getSelectedItem();
                    mf.getTxtCena().setText(String.valueOf(brojSati*b.getCenaPoSatu()));
                }
                else {
                    mf.getTxtBrojSati().setText("");
                    mf.getTxtCena().setText("");
                    JOptionPane.showMessageDialog(mf, "Unesite broj sati ciframa.", "Greska", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        mf.addMenuItemDodajKorisnikaActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Coordinator.getInstance().openKorisnikForm(FormaMod.ADD);
            }
        });
        
        
    }

    private void prepateForm() {
        zaposleni = Coordinator.getInstance().getLoggedIn();
        mf.getLblUser().setText(zaposleni.getIme()+" "+zaposleni.getPrezime());
        
        mf.getTxtDatum().setText(LocalDate.now().toString());
        
        prepareComboBoxes();
        
        mf.getTblStavke().setModel(new StavkaIznajmljivanjaTableModel());
        
        mf.getTxtCena().setEditable(false);
        mf.getTxtUkupnaCena().setEditable(false);
        mf.getTxtCena().setEditable(false);
    }

    public void prepareComboBoxes() {
        List<Korisnik> korisnici = Communication.getInstance().getAllKorisnici();
        mf.getComboBoxKorisnici().removeAllItems();
        for(Korisnik k : korisnici) {
            mf.getComboBoxKorisnici().addItem(k);
        }
        
        List<Bicikl> bicikle = Communication.getInstance().getAllBicikle();
        mf.getComboBoxBicikl().removeAllItems();
        for(Bicikl b : bicikle) {
            mf.getComboBoxBicikl().addItem(b);
        }
    }
    
    private void refreshForm() {
        mf.getTxtDatum().setText("");
        mf.getTxtBrojSati().setText("");
        mf.getTblStavke().setModel(new StavkaIznajmljivanjaTableModel());
        mf.getTxtBrojSati().setText("");
        mf.getTxtUkupnaCena().setText("");
    }

    
    
    
    
    
}
