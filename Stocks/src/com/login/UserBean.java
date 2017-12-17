package com.login;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class UserBean {

    private String username;
    private String managername;
    private String passwordm;
	private String password;
	private String adminusername;
	private String adminpassword;
    
    public String getAdminusername() {
		return adminusername;
	}

	public void setAdminusername(String adminusername) {
		this.adminusername = adminusername;
	}

	public String getAdminpassword() {
		return adminpassword;
	}

	public void setAdminpassword(String adminpassword) {
		this.adminpassword = adminpassword;
	}

	public String getManagername() {
		return managername;
	}

	public void setManagername(String managername) {
		this.managername = managername;
	}

	public String getPasswordm() {
		return passwordm;
	}

	public void setPasswordm(String passwordm) {
		this.passwordm = passwordm;
	}
	
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String validateUser() {
        boolean valid = LoginDAO.validate(username, password);
        if (valid == true) {

            return "userhome?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN, "Incorrect Username and Passowrd. Please enter correct username and Password",""));
            return "login";
        }
    }
    public String validateManager() {
        boolean valid = LoginDAO.validatem(managername, passwordm);
        if (valid == true) {

            return "managerhome?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN, "Incorrect Username and Passowrd. Please enter correct username and Password",""));
            return "login";
        }
    }
       
    public String validateAdmin() {
        boolean valid = LoginDAO.validatea(adminusername, adminpassword);
        if (valid == true) {

            return "admin?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN, "Incorrect Username and Passowrd. Please enter correct username and Password",""));
            return "login";
        }
    }

    // logout event, invalidate session
    public void logout() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
    }
}
