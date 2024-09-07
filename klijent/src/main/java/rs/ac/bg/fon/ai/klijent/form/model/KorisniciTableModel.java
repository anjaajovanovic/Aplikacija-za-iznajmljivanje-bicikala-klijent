/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.klijent.form.model;

import rs.ac.bg.fon.ai.zajednicki.domain.Korisnik;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author PC
 */
public class KorisniciTableModel extends AbstractTableModel {
    
    List<Korisnik> korisnici;
    String[] columns = {"Id", "Ime", "Prezime", "Email"};

    public KorisniciTableModel(List<Korisnik> korisnici) {
        this.korisnici = korisnici;
    }
    
    

    @Override
    public int getRowCount() {
        return korisnici.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }
    
    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    public List<Korisnik> getKorisnici() {
        return korisnici;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Korisnik k = korisnici.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return k.getId();
            case 1:
                return k.getIme();
            case 2:
                return k.getPrezime();
            case 3:
                return k.getEmail();
            default:
                return "N/A";
        }
    }
    
    public void searct(String ime, String prezime, String email) throws Exception {
        List<Korisnik> filteredKorisnici = korisnici.stream()
                .filter(k -> (ime == null || ime.isEmpty() || k.getIme().toLowerCase().contains(ime.toLowerCase())))
                .filter(k -> (prezime == null || prezime.isEmpty() || k.getPrezime().toLowerCase().contains(prezime.toLowerCase())))
                .filter(k -> (email == null || email.isEmpty() || k.getEmail().toLowerCase().contains(email.toLowerCase())))
                .collect(Collectors.toList());
        this.korisnici = filteredKorisnici;
        
        if(filteredKorisnici.size() == 0) {
            throw new Exception();
        }
        
        fireTableDataChanged();
    }
    
}
