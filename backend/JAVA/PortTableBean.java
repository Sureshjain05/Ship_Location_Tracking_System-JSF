package com.svm.sms;

import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named(value = "portTableBean")
@SessionScoped
public class PortTableBean implements Serializable {
    private Integer portId;
    private String Name;
    private String City;
    private String PortFunction;
    private String PortSize;
    
    private List<port> PortList = new ArrayList<>();

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

    public List<port> getPortList() {
        return PortList;
    }

    public void setPortList(List<port> PortList) {
        this.PortList = PortList;
    }
    
    // Adding elements into the list
    @PostConstruct
    public void init() {
        PortList.add(new port(1, "Port of Shanghai", "China", "Goods and Cargo", "191 berths"));
        PortList.add(new port(2, "Port of Singapore", "Singapore", "Passenger and Cargo", "82 berths"));
        PortList.add(new port(3, "Port of Ningbo-Zhoushan", "China", "Cargos", "191 berths"));
        PortList.add(new port(4, "Port of Los Angeles", "United States", "Passenger and Goods", "175 berths"));
        PortList.add(new port(5, "Port of Shenzhen", "China", "Goods and Cargo", "170 berths"));
        PortList.add(new port(6, "Port of Busan", "South Korea", "Passenger and Cargo", "169 berths"));
        PortList.add(new port(7, "Port of Rotterdam", "Netherlands", "Goods and Chemicals", "150 berths"));
        PortList.add(new port(8, "Port of Jebel Ali", "UAE", "Goods and Cargo", "67 berths"));
        PortList.add(new port(9, "Port of Hamburg", "Germany", "Passenger and Cargo", "35 berths"));
    }
    
    // Add method to add port to the datatable
    public String addPort() {
        port addPort = new port(portId, Name, City, PortFunction, PortSize);
        PortList.add(addPort);
        
        // Reset fields
        portId = null;
        Name = "";
        City = "";
        PortFunction = "";
        PortSize = "";
        
        return "portPage.xhtml";
    }
    
    // Delete method to delete the port from the datatable
    public void delPort(port port) {
        addMessage("Port has been deleted", "Record has been deleted.");
        PortList.remove(port);
    }

    private void addMessage(String summary, String detail) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail));
    }
    
    // Edit method to edit the Port Details
    public String editPort(Integer idToEdit) {
        for (port port : PortList) {
            if (port.getPortId().equals(idToEdit)) {
                this.portId = port.getPortId();
                this.Name = port.getName();
                this.City = port.getCity();
                this.PortFunction = port.getPortFunction();
                this.PortSize = port.getPortSize();
            }
        }
        return "updatePort.xhtml";
    }
    
    // Update the Port Details in the datatable
    public String updatePort(Integer idToUpdate) {
        for (port port : PortList) {
            if (port.getPortId().equals(idToUpdate)) {
                port.setName(Name);
                port.setCity(City);
                port.setPortFunction(PortFunction);
                port.setPortSize(PortSize);
                
                // Reset fields
                portId = null;
                Name = "";
                City = "";
                PortFunction = "";
                PortSize = "";
            }
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Port updated successfully!", "Port with ID " + idToUpdate + " has been updated."));
        return "portPage.xhtml";
    }
}
