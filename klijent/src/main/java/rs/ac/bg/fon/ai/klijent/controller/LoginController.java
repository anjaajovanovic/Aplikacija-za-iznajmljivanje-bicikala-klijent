/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.klijent.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import rs.ac.bg.fon.ai.klijent.communication.Communication;
import rs.ac.bg.fon.ai.klijent.coordinator.Coordinator;
import rs.ac.bg.fon.ai.klijent.form.LoginForm;
import rs.ac.bg.fon.ai.zajednicki.domain.Zaposleni;

/**
 *
 * @author PC
 */
public class LoginController {
    private final LoginForm lf;

    public LoginController(LoginForm lf) {
        this.lf = lf;
        addActionListeners();
    }

    private void addActionListeners() {
        
        lf.loginAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = lf.getTxtUsername().getText().trim();
                String pass = String.valueOf(lf.getPasswordField().getPassword());
                
                Communication.getInstance().connection();
                Zaposleni loggedIn = Communication.getInstance().login(user, pass);
                
                if (loggedIn == null){
                    JOptionPane.showMessageDialog(lf, "Neuspesna prijava, molimo Vas pokusajte ponovo.", "GRESKA", JOptionPane.ERROR_MESSAGE);
                } else {
                    Coordinator.getInstance().setLoggedIn(loggedIn);
                    JOptionPane.showMessageDialog(lf, "Uspesna prijava.", "USPESNO", JOptionPane.INFORMATION_MESSAGE);
                    Coordinator.getInstance().openMainForm();
                    lf.dispose();
                }
            }
        });
    }

    public void openForm() {
        lf.setVisible(true);
        lf.setLocationRelativeTo(null);
    }
    
}
