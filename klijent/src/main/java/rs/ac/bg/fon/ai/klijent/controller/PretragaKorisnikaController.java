/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.klijent.controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import rs.ac.bg.fon.ai.klijent.coordinator.Coordinator;
import rs.ac.bg.fon.ai.klijent.communication.Communication;
import rs.ac.bg.fon.ai.klijent.form.PretragaKorisnikaForm;
import rs.ac.bg.fon.ai.klijent.form.model.KorisniciTableModel;
import rs.ac.bg.fon.ai.zajednicki.domain.Korisnik;

/**
 *
 * @author PC
 */
public class PretragaKorisnikaController {
    
    private final PretragaKorisnikaForm pkf;

    public PretragaKorisnikaController(PretragaKorisnikaForm pkf) {
        this.pkf = pkf;
        addActionListeners();
    }
    
    

    public void openForm() {
        prepareForm();
        pkf.setVisible(true);
        pkf.setLocationRelativeTo(null);
        pkf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void addActionListeners() {
        
        pkf.pretraziAddActionListeners(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ime = pkf.getTxtIme().getText().trim();
                String prezime = pkf.getTxtPrezime().getText().trim();
                String email = pkf.getTxtEmail().getText().trim();
                
                KorisniciTableModel ktm = (KorisniciTableModel) pkf.getjTable1().getModel();
                try {
                    ktm.searct(ime, prezime, email);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(pkf, "Sistem ne moze da nadje korisnike po zadatoj vrednosti.", "Greska", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        pkf.addBtnResetSearchActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prepareForm();
            }
        });
        
        pkf.detailsAddActionListeners(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = pkf.getjTable1().getSelectedRow();
                if(row == -1) {
                    JOptionPane.showMessageDialog(pkf, "Sistem ne moze da ucita korisnika!", "Greska", JOptionPane.ERROR_MESSAGE);
                } else {
                    KorisniciTableModel ktm = (KorisniciTableModel) pkf.getjTable1().getModel();
                    int id = ktm.getKorisnici().get(row).getId();
                    
                    Korisnik k = new Korisnik();
                    k.setId(id);

                    k = Communication.getInstance().getKorisnik(k);
                    
                    Coordinator.getInstance().setParam("korisnik", k);
                    
                    Coordinator.getInstance().openKorisnikForm(FormaMod.EDIT);
                }
            }
        });
        
    }

    private void prepareForm() {
        List<Korisnik> korisnici = Communication.getInstance().getAllKorisnici();
        KorisniciTableModel ktm = new KorisniciTableModel(korisnici);
        pkf.getjTable1().setModel(ktm);
    }
    
}
