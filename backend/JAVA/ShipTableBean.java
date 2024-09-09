package com.svm.sms;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author sureshkumarmani
 */
@Named(value = "shipTableBean")
@SessionScoped
public class ShipTableBean implements Serializable {
    private Integer ShipId;
    private String DeparturePort;
    private String ArrivalPort;
    private String DepartureDate;
    private String ArrivalDate;
    private String Status;

    private List<Ship> ShipList = new ArrayList<>();

    // Getters and Setters
    public Integer getShipId() {
        return ShipId;
    }

    public void setShipId(Integer ShipId) {
        this.ShipId = ShipId;
    }

    public String getDeparturePort() {
        return DeparturePort;
    }

    public void setDeparturePort(String DeparturePort) {
        this.DeparturePort = DeparturePort;
    }

    public String getArrivalPort() {
        return ArrivalPort;
    }

    public void setArrivalPort(String ArrivalPort) {
        this.ArrivalPort = ArrivalPort;
    }

    public String getDepartureDate() {
        return DepartureDate;
    }

    public void setDepartureDate(String DepartureDate) {
        this.DepartureDate = DepartureDate;
    }

    public String getArrivalDate() {
        return ArrivalDate;
    }

    public void setArrivalDate(String ArrivalDate) {
        this.ArrivalDate = ArrivalDate;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public List<Ship> getShipList() {
        return ShipList;
    }

    public void setShipList(List<Ship> ShipList) {
        this.ShipList = ShipList;
    }

    @PostConstruct
    public void init() {
        ShipList.add(new Ship(1, "Port of Singapore", "Port of Shenzhen", "25-07-2024", "29-07-2024", "Arrived"));
        ShipList.add(new Ship(2, "Port of Busan", "Port of Rotterdam", "21-08-2024", "05-09-2024", "In-Transit"));
        ShipList.add(new Ship(3, "Port of Jebel Ali", "Port of Singapore", "15-08-2024", "21-08-2024", "Unloading in Port"));
        ShipList.add(new Ship(4, "Port of Los Angeles", "Port of Hamburg", "19-08-2024", "28-08-2024", "Sailing in Ocean"));
    }

    public String addShip() {
        Ship addShip = new Ship(ShipId, DeparturePort, ArrivalPort, DepartureDate, ArrivalDate, Status);
        ShipList.add(addShip);
        
        ShipId = null;
        DeparturePort = "";
        ArrivalPort = "";
        DepartureDate = "";
        ArrivalDate = "";
        Status = "";
        
        return "shipPage.xhtml";
    }

    public void delShip(Ship ship) {
        addMessage("Ship has been deleted", "Record has been deleted.");
        ShipList.remove(ship);
    }

    private void addMessage(String summary, String detail) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail));
    }

    public String editShip(Integer idToEdit) {
        for (Ship ship : ShipList) {
            if (ship.getShipId().equals(idToEdit)) {
                this.ShipId = ship.getShipId();
                this.DeparturePort = ship.getDeparturePort();
                this.ArrivalPort = ship.getArrivalPort();
                this.DepartureDate = ship.getDepartureDate();
                this.ArrivalDate = ship.getArrivalDate();
                this.Status = ship.getStatus();
            }
        }
        return "updateShip.xhtml";
    }

    public String updateShip(Integer idToUpdate) {
        for (Ship ship : ShipList) {
            if (ship.getShipId().equals(idToUpdate)) {
                ship.setDepartureDate(DepartureDate);
                ship.setDeparturePort(DeparturePort);
                ship.setArrivalPort(ArrivalPort);
                ship.setArrivalDate(ArrivalDate);
                ship.setStatus(Status);
                
                ShipId = null;
                DeparturePort = "";
                ArrivalPort = "";
                DepartureDate = "";
                ArrivalDate = "";
                Status = "";
            }
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "ShipTable updated successfully!", "ShipTable with ID " + idToUpdate + " has been updated."));
        return "shipPage.xhtml";
    }
}
