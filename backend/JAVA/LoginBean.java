package com.svm.sms;

import javax.inject.Named;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.context.ExternalContext;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
 
/**
* Managed Bean for handling user login.
*/
@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {
 
    @Size(min = 5, max = 8, message = "Username must be between 5 and 8 characters long.")
    @Pattern(regexp = "^[a-zA-Z]{3}[0-9]{3}$", 
            message = "Invalid username format")
    private String userName;
 
    @Size(min = 8, max = 12, message = "Password must be between 8 and 12 characters long.")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
            message = "Invalid password format")
    private String passWord;

    public String getUserName() {
        return userName;
    }
 
    public void setUserName(String userName) {
        this.userName = userName;
    }
 
    public String getPassWord() {
        return passWord;
    }
 
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
 
    public String login() {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext externalContext = context.getExternalContext();
 
        // Validate credentials
        if ("SMI214".equals(userName) && "Suresh@0509".equals(passWord)) {
            // Store success message in Flash scope
            externalContext.getFlash().setKeepMessages(true);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Login Successfully", "You have successfully logged in."));
            return "home1.xhtml"; 
        } else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid credentials", "Invalid username or password"));
            return ""; 
        }
    }
}