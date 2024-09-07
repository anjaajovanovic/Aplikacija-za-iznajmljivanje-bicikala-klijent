/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.klijent.controller;



import javax.swing.JFrame;

import rs.ac.bg.fon.ai.klijent.form.StatistikaForm;
import rs.ac.bg.fon.ai.klijent.form.model.StatistikaTableModel;

/**
 *
 * @author PC
 */
public class StatistikaController {
    
    private final StatistikaForm sf;

    public StatistikaController(StatistikaForm sf) {
        this.sf = sf;
    }
    
    public void openForm() {
        prepareForm();
        sf.setVisible(true);
        sf.setLocationRelativeTo(null);
        sf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void prepareForm() {
        sf.getTblOcene().setModel(new StatistikaTableModel());
    }
    
}
