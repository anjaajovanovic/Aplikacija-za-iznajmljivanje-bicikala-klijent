/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.klijent.form.model;

import rs.ac.bg.fon.ai.zajednicki.domain.Iznajmljivanje;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author PC
 */
public class IznajmljivanjeTableModel extends AbstractTableModel {
    
    private List<Iznajmljivanje> iznajmljivanja;
    private String[] columns = {"Id", "Datum", "Ukupna cena", "Korisnik"};

    public IznajmljivanjeTableModel(List<Iznajmljivanje> iznajmljivanja) {
        this.iznajmljivanja = iznajmljivanja;
    }

    @Override
    public int getRowCount() {
        return iznajmljivanja.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }
    
    @Override
    public String getColumnName(int i) {
        return columns[i];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Iznajmljivanje i = iznajmljivanja.get(rowIndex);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
       
        switch (columnIndex) {
            case 0:
              return  i.getId();
            case 1:
                return sdf.format(i.getDatum());
            case 2:
                return i.getUkupnaCena();
            case 3:
                return i.getKorisnik();
            default:
                return "N/A";
        }
    }

    public List<Iznajmljivanje> getIznajmljivanja() {
        return iznajmljivanja;
    }

    public void search(String unos) {
        ArrayList<Iznajmljivanje>  filteredIznajmljivanja = (ArrayList<Iznajmljivanje>) iznajmljivanja.stream()
                .filter(i -> (unos == null || unos.isEmpty() || i.getKorisnik().getIme().toLowerCase().contains(unos.toLowerCase())) || 
                        i.getKorisnik().getPrezime().toLowerCase().contains(unos.toLowerCase()))
                .collect(Collectors.toList());
        this.iznajmljivanja = filteredIznajmljivanja;
        fireTableDataChanged();
        if(filteredIznajmljivanja.size() == 0){
            JOptionPane.showMessageDialog(null, "Sistem ne moze da nadje iznajmljivanja po zadatoj vrednosti.", "Greska", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    
    
}
