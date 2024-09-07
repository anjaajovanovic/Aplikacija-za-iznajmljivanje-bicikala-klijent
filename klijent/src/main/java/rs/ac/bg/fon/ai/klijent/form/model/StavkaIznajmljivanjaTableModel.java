/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.klijent.form.model;

import rs.ac.bg.fon.ai.klijent.communication.Communication;
import rs.ac.bg.fon.ai.zajednicki.domain.Iznajmljivanje;
import rs.ac.bg.fon.ai.zajednicki.domain.StavkaIznajmljivanja;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author PC
 */
public class StavkaIznajmljivanjaTableModel extends AbstractTableModel {

    private List<StavkaIznajmljivanja> stavke;
    private String[] columns = {"Rb", "Naziv", "Model", "Godina proizvodnje", "Cena po satu", "Broj sati"};
    private int rb = 0;
    
    public StavkaIznajmljivanjaTableModel() {
        stavke = new ArrayList<>();
    }

    public StavkaIznajmljivanjaTableModel(List<StavkaIznajmljivanja> stavke) {
        this.stavke = stavke;
    }
    
    
    
    public StavkaIznajmljivanjaTableModel(Iznajmljivanje i) {
        try {
            stavke = Communication.getInstance().getAllStavkeIznajmljivanja(i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public int getRowCount() {
        return stavke.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int column) {
       return columns[column];
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        StavkaIznajmljivanja st = stavke.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return st.getStavkaRB();
            case 1:
                return st.getBicikl().getNaziv();
            case 2:
                return st.getBicikl().getModel();
            case 3:
                return st.getBicikl().getGodinaProizvodnje();
            case 4:
                return st.getBicikl().getCenaPoSatu();
            case 5:
                return st.getBrojSati();
            default:
                return "N/A";
        }
    }
    
    public void dodajStavku(StavkaIznajmljivanja st) {
        rb = stavke.size();
        st.setStavkaRB(rb);
        stavke.add(st);
        fireTableDataChanged();
    }
    
    public void obrisiStavku(int row) {
        stavke.remove(row);
        
        rb = 0;
        for(StavkaIznajmljivanja st : stavke) {
            st.setStavkaRB(++rb);
        }
        
        fireTableDataChanged();
    }
    
    public double vratiUkupnuCenu() {
        double ukupnaCena = 0;
        for (StavkaIznajmljivanja st : stavke) {
            ukupnaCena += st.getCenaStavke();
        }
        return ukupnaCena;
    }

    public List<StavkaIznajmljivanja> getStavke() {
        return stavke;
    }
    
    
    
    
}
