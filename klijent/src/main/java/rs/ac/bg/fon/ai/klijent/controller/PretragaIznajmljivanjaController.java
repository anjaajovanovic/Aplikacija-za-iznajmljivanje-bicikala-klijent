/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.klijent.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import rs.ac.bg.fon.ai.klijent.communication.Communication;
import rs.ac.bg.fon.ai.klijent.coordinator.Coordinator;
import rs.ac.bg.fon.ai.klijent.form.PretragaIznajmljivanjaForm;
import rs.ac.bg.fon.ai.klijent.form.model.IznajmljivanjeTableModel;
import rs.ac.bg.fon.ai.zajednicki.domain.Iznajmljivanje;

/**
 *
 * @author PC
 */
public class PretragaIznajmljivanjaController {
    
    private final PretragaIznajmljivanjaForm pif;

    public PretragaIznajmljivanjaController(PretragaIznajmljivanjaForm pif) {
        this.pif = pif;
        addActionListeners();
    }

    private void addActionListeners() {
        pif.addBtnSearchActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String unos = pif.getTxtIznajmljivanje().getText().trim();
                
                if(unos.isEmpty()){
                    prepareForm();
                } else {
                    IznajmljivanjeTableModel tm = (IznajmljivanjeTableModel) pif.getTblIznajmljivanje().getModel();
                    tm.search(unos);
                }
            }
        });
        
        pif.addBtnDetailsActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = pif.getTblIznajmljivanje().getSelectedRow();
                try {
                    if(row > -1) {
                        IznajmljivanjeTableModel itm = (IznajmljivanjeTableModel) pif.getTblIznajmljivanje().getModel();
                        int id = itm.getIznajmljivanja().get(row).getId();
                        
                        Iznajmljivanje i = new Iznajmljivanje();
                        i.setId(id);
                        
                        i = Communication.getInstance().getIznajmljivanje(i);

                        Coordinator.getInstance().setParam("iznajmljivanje", i);

                        Coordinator.getInstance().openDetaljiIznajmljivanjaForm();
                    } else {
                        throw new Exception();
                    }
                    
                } catch (Exception ex){
                    JOptionPane.showMessageDialog(pif, "Sistem ne moze da ucita iznajmljivanje.", "Greska", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
    
    

    public void openForm() {
        prepareForm();
        pif.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void prepareForm() {
        pif.setVisible(true);
        pif.setLocationRelativeTo(null);
        List<Iznajmljivanje> iznajmljivanja = Communication.getInstance().getAllIznajmljivanja();
        IznajmljivanjeTableModel itm = new IznajmljivanjeTableModel(iznajmljivanja);
        pif.getTblIznajmljivanje().setModel(itm);
    }
    
    
    
    
    
}
