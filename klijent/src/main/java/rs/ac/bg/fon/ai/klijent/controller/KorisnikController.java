/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.klijent.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import rs.ac.bg.fon.ai.klijent.communication.Communication;
import rs.ac.bg.fon.ai.klijent.coordinator.Coordinator;
import rs.ac.bg.fon.ai.klijent.form.KorisnikForm;
import rs.ac.bg.fon.ai.zajednicki.domain.Korisnik;

/**
 *
 * @author PC
 */
public class KorisnikController {
    
    private final KorisnikForm kf;
    private Korisnik k;

    public KorisnikController(KorisnikForm kf) {
        this.kf = kf;
        addActionListeners();
    }
    
    public void openForm(FormaMod mod) {
        prepareForm(mod);
        kf.setVisible(true);
        kf.setLocationRelativeTo(null);
        kf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void addActionListeners() {
        kf.addAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ime = kf.getTxtIme().getText().trim();
                String prezime = kf.getTxtPrezime().getText().trim();
                String email = kf.getTxtEmail().getText().trim();
                
                Korisnik k = new Korisnik(-1, ime, prezime, email);
                
                try {
                    Communication.getInstance().addKorisnik(k);
                    JOptionPane.showMessageDialog(kf, "Sistem je zapamtio korisnika.", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
                    
                    kf.dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(kf, "Sistem ne moze da zapamti korisnika.", "Greska", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        kf.editAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(kf.getLblId().getText());
                String ime = kf.getTxtIme().getText().trim();
                String prezime = kf.getTxtPrezime().getText().trim();
                String email = kf.getTxtEmail().getText().trim();
                
                Korisnik k1 = new Korisnik(id, ime, prezime, email);
                
                try {
                    Communication.getInstance().editKorisnik(k1);
                    JOptionPane.showMessageDialog(kf, "Sistem je zapamtio korisnika.", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
                    kf.dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(kf, "Sistem ne moze da zapamti korisnika.", "Greska", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        kf.deleteAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Communication.getInstance().deleteKorisnik(k);
                    JOptionPane.showMessageDialog(kf, "Sistem je obrisao korisnika", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
                    prepareForm(FormaMod.ADD);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(kf, "Sistem ne moze da obrise korisnika.", "Greska", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        
    }

    private void prepareForm(FormaMod mod) {
        if (mod == FormaMod.ADD) {
            kf.getBtnEdit().setVisible(false);
            kf.getBtnDelete().setVisible(false);
            kf.getBtnAdd().setVisible(true);
            kf.getLblNaslov().setText("Kreiranje novog korisnika");
            kf.getLblId().setText("");
        } else {
            kf.getBtnEdit().setVisible(true);
            kf.getBtnDelete().setVisible(true);
            kf.getBtnAdd().setVisible(false);
            kf.getLblNaslov().setText("Detalji o korisniku");
            
            k = (Korisnik) Coordinator.getInstance().getParam("korisnik");
            kf.getTxtIme().setText(k.getIme());
            kf.getTxtPrezime().setText(k.getPrezime());
            kf.getTxtEmail().setText(k.getEmail());
            kf.getLblId().setText(k.getId()+"");
        }
    }
    
    
    
    
    
    
    
    
}
