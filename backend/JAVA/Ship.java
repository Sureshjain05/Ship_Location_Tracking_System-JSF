/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.svm.sms;

import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author sureshkumarmani
 */
@Named(value = "ship")
@Dependent
public class Ship {
    private Integer ShipId;
    private String DeparturePort;
    private String ArrivalPort;
    private String DepartureDate;
    private String ArrivalDate;
    private String Status;

    public Ship(Integer ShipId, String DeparturePort, String ArrivalPort, String DepartureDate, String ArrivalDate, String Status) {
        this.ShipId = ShipId;
        this.DeparturePort = DeparturePort;
        this.ArrivalPort = ArrivalPort;
        this.DepartureDate = DepartureDate;
        this.ArrivalDate = ArrivalDate;
        this.Status = Status;
    }

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

}
