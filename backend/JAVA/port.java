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
@Named(value = "port")
@Dependent
public class port {
    private Integer portId;
    private String Name;
    private String City;
    private String PortFunction;
    private String PortSize;

    public port(Integer portId, String Name, String City, String PortFunction, String PortSize) {
        this.portId = portId;
        this.Name = Name;
        this.City = City;
        this.PortFunction = PortFunction;
        this.PortSize = PortSize;
    }

    // Getters and Setters

    public Integer getPortId() {
        return portId;
    }

    public void setPortId(Integer portId) {
        this.portId = portId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getPortFunction() {
        return PortFunction;
    }

    public void setPortFunction(String PortFunction) {
        this.PortFunction = PortFunction;
    }

    public String getPortSize() {
        return PortSize;
    }

    public void setPortSize(String PortSize) {
        this.PortSize = PortSize;
    }

}
