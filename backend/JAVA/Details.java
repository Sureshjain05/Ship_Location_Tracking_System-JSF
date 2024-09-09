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
@Named(value = "details")
@Dependent
public class Details {
       private Integer shipId;
       private String PackageType;
       private Integer NumberofPackage;
       private double TotalWeight;
       private String DepartureCity;
       private String ArrivalCity;

    public Details(Integer shipId, String PackageType, Integer NumberofPackage, double TotalWeight, String DepartureCity, String ArrivalCity) {
        this.shipId = shipId;
        this.PackageType = PackageType;
        this.NumberofPackage = NumberofPackage;
        this.TotalWeight = TotalWeight;
        this.DepartureCity = DepartureCity;
        this.ArrivalCity = ArrivalCity;
    }

    public Integer getShipId() {
        return shipId;
    }

    public void setShipId(Integer shipId) {
        this.shipId = shipId;
    }

    public String getPackageType() {
        return PackageType;
    }

    public void setPackageType(String PackageType) {
        this.PackageType = PackageType;
    }

    public Integer getNumberofPackage() {
        return NumberofPackage;
    }

    public void setNumberofPackage(Integer NumberofPackage) {
        this.NumberofPackage = NumberofPackage;
    }

    public double getTotalWeight() {
        return TotalWeight;
    }

    public void setTotalWeight(double TotalWeight) {
        this.TotalWeight = TotalWeight;
    }

    public String getDepartureCity() {
        return DepartureCity;
    }

    public void setDepartureCity(String DepartureCity) {
        this.DepartureCity = DepartureCity;
    }

    public String getArrivalCity() {
        return ArrivalCity;
    }

    public void setArrivalCity(String ArrivalCity) {
        this.ArrivalCity = ArrivalCity;
    }
    
}
