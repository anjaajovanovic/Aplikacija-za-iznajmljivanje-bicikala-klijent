/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.klijent.form.model;

import rs.ac.bg.fon.ai.klijent.communication.Communication;
import rs.ac.bg.fon.ai.zajednicki.domain.Statistika;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author PC
 */
public class StatistikaTableModel extends AbstractTableModel {
    
    private List<Statistika> lista;
    private String[] columns = {"Id", "Ocena", "Korisnik", "Bicikl"};

    public StatistikaTableModel() {
        lista = Communication.getInstance().getAllStatistika();
    }
    
    

    @Override
    public int getRowCount() {
        return lista.size();
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
        Statistika s = lista.get(rowIndex);
        
        switch (columnIndex) {
            case 0:
                return s.getId();
            case 1:
                return s.getOcena();
            case 2:
                return s.getKorisnik().getIme() + " " + s.getKorisnik().getPrezime();
            case 3:
                return s.getBicikl().getNaziv();

            default:
                return "N/A";
        }
    }
    
}
