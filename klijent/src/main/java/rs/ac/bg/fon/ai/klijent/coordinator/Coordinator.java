/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.klijent.coordinator;

import rs.ac.bg.fon.ai.klijent.controller.DetaljiIznajmljivanjaController;
import rs.ac.bg.fon.ai.klijent.controller.FormaMod;
import rs.ac.bg.fon.ai.klijent.controller.KorisnikController;
import rs.ac.bg.fon.ai.klijent.controller.LoginController;
import rs.ac.bg.fon.ai.klijent.controller.MainFormController;
import rs.ac.bg.fon.ai.klijent.controller.PretragaKorisnikaController;
import rs.ac.bg.fon.ai.zajednicki.domain.Zaposleni;
import rs.ac.bg.fon.ai.klijent.controller.FormaMod;
import rs.ac.bg.fon.ai.klijent.controller.PretragaIznajmljivanjaController;
import rs.ac.bg.fon.ai.klijent.controller.StatistikaController;
import rs.ac.bg.fon.ai.klijent.form.DetaljiIznajmljivanjaForm;
import rs.ac.bg.fon.ai.klijent.form.KorisnikForm;
import rs.ac.bg.fon.ai.klijent.form.LoginForm;
import rs.ac.bg.fon.ai.klijent.form.MainForm;
import rs.ac.bg.fon.ai.klijent.form.PretragaIznajmljivanjaForm;
import rs.ac.bg.fon.ai.klijent.form.PretragaKorisnikaForm;
import rs.ac.bg.fon.ai.klijent.form.StatistikaForm;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author PC
 */
public class Coordinator {
    private static Coordinator instance;
    private Zaposleni loggedIn;
    private Map<String, Object> parametri;
    
    private LoginController loginController;
    private MainFormController mainFormController;
    private KorisnikController korisnikController;
    private PretragaKorisnikaController pretragaKorisnikaController;
    private PretragaIznajmljivanjaController pretragaIznajmljivanjaController;
    private DetaljiIznajmljivanjaController detaljiIznajmljivanjaController;
    private StatistikaController statistikaController;
    
    private Coordinator() {
        parametri = new HashMap<>();
    }
    
    public static Coordinator getInstance() {
        if (instance == null) {
            instance = new Coordinator();
        }
        return instance;
    }

    public void openLoginForm() {
        loginController = new LoginController(new LoginForm());
        loginController.openForm();
    }
    
    public void openMainForm() {
        mainFormController = new MainFormController(new MainForm());
        mainFormController.openForm();
    }

    public Zaposleni getLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(Zaposleni loggedIn) {
        this.loggedIn = loggedIn;
    }
    
    public void setParam(String s, Object o){
        parametri.put(s, o);
    }
    
    public Object getParam(String s) {
        return parametri.get(s);
    }

    public void openPretragaKorisnikaForm() {
        pretragaKorisnikaController = new PretragaKorisnikaController(new PretragaKorisnikaForm());
        pretragaKorisnikaController.openForm();
    }

    public void openKorisnikForm(FormaMod mod) {
        korisnikController = new KorisnikController(new KorisnikForm());
        korisnikController.openForm(mod);
    }

    public void openPretragaIznajmljivanjaForm() {
        pretragaIznajmljivanjaController = new PretragaIznajmljivanjaController(new PretragaIznajmljivanjaForm());
        pretragaIznajmljivanjaController.openForm();
    }

    public void openDetaljiIznajmljivanjaForm() {
        detaljiIznajmljivanjaController = new DetaljiIznajmljivanjaController(new DetaljiIznajmljivanjaForm());
        detaljiIznajmljivanjaController.openForm();
    }

    public void openStatistikaForm() {
        statistikaController = new StatistikaController(new StatistikaForm());
        statistikaController.openForm();
    }
    
}
