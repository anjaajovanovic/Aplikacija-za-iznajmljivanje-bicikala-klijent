/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.ai.klijent.communication;

import rs.ac.bg.fon.ai.zajednicki.domain.*;
import rs.ac.bg.fon.ai.zajednicki.communication.*;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class Communication {

    private Socket socket;
    private Sender sender;
    private Receiver receiver;
    private static Communication instance;
    
    private Communication(){
    }
    
    public static Communication getInstance(){
        if(instance == null){
            instance = new Communication();
        }
        return instance;
    }
    
    public void connection() {
        try {
            socket = new Socket("localhost", 9000);
            sender = new Sender(socket);
            receiver = new Receiver(socket);
        } catch (IOException ex) {
            System.out.println("Server nije povezan: " + ex.getMessage());
        }
    } 
    
    
    public Zaposleni login(String user, String pass) {
        Zaposleni z = new Zaposleni();
        z.setPassword(pass);
        z.setUsername(user);
        Request request = new Request(Operation.LOGIN, z);
        sender.send(request);
        Response res = (Response) receiver.receive();
        z = (Zaposleni) res.getResult();
        return z;
    }


    public void addKorisnik(Korisnik k) throws Exception {
        Request request = new Request(Operation.ADD_KORISNIK, k);
        sender.send(request);
        Response res = (Response) receiver.receive();
        if(res.getResult() == null) {
            System.out.println("Korisnik uspesno dodat!");
        } else {
            System.out.println("Greska prilikom dodavanja korisnika.");
            ((Exception) res.getResult()).printStackTrace();
            throw new Exception("GRESKA prilikom dodavanja korisnika");
        }
    }

    public List<Korisnik> getAllKorisnici() {
        Request request = new Request(Operation.GET_ALL_KORISNICI, null);
        List<Korisnik> korisnici = new ArrayList<>();
        sender.send(request);
        Response res = (Response) receiver.receive();
        korisnici = (List<Korisnik>) res.getResult();
        return korisnici;
    }

    public void deleteKorisnik(Korisnik k) throws Exception {
        Request request = new Request(Operation.DELETE_KORISNIK, k);
        sender.send(request);
        Response res = (Response) receiver.receive();
        if (res.getResult() == null) {
            System.out.println("Korisnik uspesno obrisan!");
        } else {
            System.out.println("GRESKA prilikom brisanja korisnika:");
            ((Exception) res.getResult()).printStackTrace();
            throw new Exception("GRESKA prilikom brisanja korisnika");
        }
    }

    public void editKorisnik(Korisnik k1) throws Exception {
        Request request = new Request(Operation.EDIT_KORISNIK, k1);
        sender.send(request);
        Response res = (Response) receiver.receive();
        if(res.getResult() == null) {
            System.out.println("Korisnik uspesno azuriran!");
        } else {
            System.out.println("Greska prilikom azuriranja korisnika.");
            ((Exception) res.getResult()).printStackTrace();
            throw new Exception("GRESKA prilikom azuriranja korisnika");
        }
    }

    public List<Bicikl> getAllBicikle() {
        Request request = new Request(Operation.GET_ALL_BICIKLE, null);
        List<Bicikl> bicikle = new ArrayList<>();
        sender.send(request);
        Response res = (Response) receiver.receive();
        bicikle = (List<Bicikl>) res.getResult();
        return bicikle;
    }

    public List<StavkaIznajmljivanja> getAllStavkeIznajmljivanja(Iznajmljivanje i) {
        Request request = new Request(Operation.GET_ALL_STAVKE_IZNAJMLJIVANJA, i);
        List<StavkaIznajmljivanja> stavke = new ArrayList<>();
        sender.send(request);
        Response res = (Response) receiver.receive();
        stavke = (List<StavkaIznajmljivanja>) res.getResult();
        return stavke;
    }

    public void addNewIznajmljivanje(Iznajmljivanje i) throws Exception {
        Request request = new Request(Operation.ADD_NEW_IZNAJMLJIVANJE, i);
        sender.send(request);
        Response res = (Response) receiver.receive();
        if(res.getResult() == null) {
            System.out.println("Iznajmljivanje uspesno dodato!");
        } else {
            System.out.println("Greska prilikom dodavanja novog iznajmljivanja.");
            ((Exception) res.getResult()).printStackTrace();
            throw new Exception("GRESKA prilikom brisanja iznajmljivanja");
        }
    }

    public List<Iznajmljivanje> getAllIznajmljivanja() {
        Request request = new Request(Operation.GET_ALL_IZNAJMLJIVANJA, null);
        List<Iznajmljivanje> iznajmljivanja = new ArrayList<>();
        sender.send(request);
        Response res = (Response) receiver.receive();
        iznajmljivanja = (List<Iznajmljivanje>) res.getResult();
        return iznajmljivanja;
    }

    public void deleteIznajmljivanje(Iznajmljivanje i) throws Exception {
        Request request = new Request(Operation.DELETE_IZNAJMLJIVANJE, i);
        sender.send(request);
        Response res = (Response) receiver.receive();
        if (res.getResult() == null) {
            System.out.println("Iznajmljivanje uspesno obrisano!");
        } else {
            System.out.println("GRESKA prilikom brisanja iznajmljivanja:");
            ((Exception) res.getResult()).printStackTrace();
            throw new Exception("GRESKA prilikom brisanja iznajmljivanja");
        }
    }

    public void editIznajmljivanje(Iznajmljivanje i) throws Exception {
        Request request = new Request(Operation.EDIT_IZNAJMLJIVANJE, i);
        sender.send(request);
        Response res = (Response) receiver.receive();
        if(res.getResult() == null) {
            System.out.println("Iznajmljivanje uspesno azurirano!");
        } else {
            System.out.println("Greska prilikom azuriranja iznajmljivanja.");
            ((Exception) res.getResult()).printStackTrace();
            throw new Exception("GRESKA prilikom azuriranja iznajmljivanja");
        }
    }

    public List<Statistika> getAllStatistika() {
        Request request = new Request(Operation.GET_ALL_STATISTIKA, null);
        List<Statistika> statistike = new ArrayList<>();
        sender.send(request);
        Response res = (Response) receiver.receive();
        statistike = (List<Statistika>) res.getResult();
        return statistike;
    }

    public Korisnik getKorisnik(Korisnik k) {
        Request request = new Request(Operation.GET_KORISNIK, k);
        sender.send(request);
        Response res = (Response) receiver.receive();
        Korisnik korisnik =  (Korisnik) res.getResult();
        return korisnik;
    }

    public Iznajmljivanje getIznajmljivanje(Iznajmljivanje i) {
        Request request = new Request(Operation.GET_IZNAJMLJIVANJE, i);
        sender.send(request);
        Response res = (Response) receiver.receive();
        Iznajmljivanje iznajmljivanje = (Iznajmljivanje) res.getResult();
        return iznajmljivanje;
    }
    
    
    
    
    
    
}
