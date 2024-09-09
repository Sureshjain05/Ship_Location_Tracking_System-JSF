/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.svm.sms;

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
@Named(value = "detailsTableBean")
@SessionScoped
public class DetailsTableBean implements Serializable {
       private Integer shipId;
       private String PackageType;
       private Integer NumberofPackage;
       private double TotalWeight;
       private String DepartureCity;
       private String ArrivalCity;
       
       private List<Details> detailList = new ArrayList<>();

    // Getters and Setters
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

    public List<Details> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<Details> DetailList) {
        this.detailList = DetailList;
    }
     
    // Adding element to the List
    @PostConstruct
    public void init(){
        detailList.add(new Details(1,"Container",150,10000.00,"Singapore","China"));
        detailList.add(new Details(2,"Crate",300,12450.00,"South Korea","Netherlands"));
        detailList.add(new Details(3,"Boxes",400,9500.00,"UAE","Singapore"));
        detailList.add(new Details(4,"Container",200,15370.00,"United States","Germany"));
        
    }
    
    // addDetail page to add the details in the data table
    public String addDetail(){
         Details addDetail = new Details(shipId,PackageType,NumberofPackage,TotalWeight,DepartureCity,ArrivalCity);
         detailList.add(addDetail);
         
         shipId=null;
         PackageType="";
         NumberofPackage=null;
         TotalWeight=0.0;
         DepartureCity="";
         ArrivalCity="";
         
         return "ShipDetails.xhtml";
       }
    
    // Delete the Details from the data table
    public void delDetails(Details DetailsTableBean){
        addMessage("Details has been deleted","Record has been deleted.");
        detailList.remove(DetailsTableBean);
    }

    private void addMessage(String summary, String detail) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail));
    }
    
    //Edit the details
     public String editDetail(Integer idToEdit){
        for(Details detail :detailList){
            if(detail.getShipId().equals(idToEdit)){
                this.shipId = detail.getShipId();
                this.PackageType=detail.getPackageType();
                this.NumberofPackage=detail.getNumberofPackage();
                this.TotalWeight=detail.getTotalWeight();
                this.DepartureCity=detail.getDepartureCity();
                this.ArrivalCity=detail.getArrivalCity();
            }
        }
        return "updateDetails.xhtml";
    }
    
     // Update the details in the data table which have been edited. 
    public String updateDetail(Integer idToUpdate){
        for(Details detail :detailList){
            if(detail.getShipId().equals(idToUpdate)){
                detail.setPackageType(PackageType);
                detail.setNumberofPackage(NumberofPackage);
                detail.setTotalWeight(TotalWeight);
                detail.setDepartureCity(DepartureCity);
                detail.setArrivalCity(ArrivalCity);
                
                shipId=null;
                PackageType="";
                NumberofPackage=null;
                TotalWeight=0.0;
                DepartureCity="";
                ArrivalCity="";
                
            }
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "ShipDetail updated successfully!", "ShipTable with ID " + idToUpdate + " has been updated."));
        return "ShipDetails.xhtml";
    }

    
}


      