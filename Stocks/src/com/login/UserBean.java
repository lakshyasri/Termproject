package com.login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class UserBean {

    private String username;
    private String lastname;
    private String lastnamem;
   	private String managername;
    private String passwordm;
	private String password;
	private String passwordnewm;
	private String adminusername;
	private String adminpassword;  
	private String address;
	private String addressm;
	public String getLastnamem() {
		return lastnamem;
	}

	public void setLastnamem(String lastnamem) {
		this.lastnamem = lastnamem;
	}

	public String getPasswordnewm() {
		return passwordnewm;
	}

	public void setPasswordnewm(String passwordnewm) {
		this.passwordnewm = passwordnewm;
	}

	public String getAddressm() {
		return addressm;
	}

	public void setAddressm(String addressm) {
		this.addressm = addressm;
	}
	private String passwordnew;
	
	public String getPasswordnew() {
		return passwordnew;
	}

	public void setPasswordnew(String passwordnew) {
		this.passwordnew = passwordnew;
	}
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	private String email;
	private String emailm;
	
	 public String getEmailm() {
		return emailm;
	}

	public void setEmailm(String emailm) {
		this.emailm = emailm;
	}

	public String getLastname() {
			return lastname;
		}

		public void setLastname(String lastname) {
			this.lastname = lastname;
		}
	
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
	public String updatePassword() {
		int i = 0;
		PreparedStatement ps = null;
		Connection con = null;
		try {
			con = DataConnect.getConnection();
			if (con != null) {
				String sql = "UPDATE users set password = ? WHERE username = ?";
				ps = con.prepareStatement(sql);
				ps.setString(1, passwordnew);
				ps.setString(2, username);
				i = ps.executeUpdate();
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				con.close();
				ps.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (i > 0) {
			return "index1";
		} else
			return "index";
	}
	
	public String updateEmail() {
		int i = 0;
		PreparedStatement ps = null;
		Connection con = null;
		try {
			con = DataConnect.getConnection();
			if (con != null) {
				String sql = "UPDATE users set email = ? WHERE username = ?";
				ps = con.prepareStatement(sql);
				ps.setString(1, email);
				ps.setString(2, username);
				i = ps.executeUpdate();
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				con.close();
				ps.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (i > 0) {
			return "index1";
		} else
			return "index";
	}
	public String updateAddress() {
		int i = 0;
		PreparedStatement ps = null;
		Connection con = null;
		try {
			con = DataConnect.getConnection();
			if (con != null) {
				String sql = "UPDATE users set address = ? WHERE username = ?";
				ps = con.prepareStatement(sql);
				ps.setString(1, address);
				ps.setString(2, username);
				i = ps.executeUpdate();
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				con.close();
				ps.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (i > 0) {
			return "index";
		} else
			return "index";
	}
	public String updateLastName() {
		int i = 0;
		PreparedStatement ps = null;
		Connection con = null;
		try {
			con = DataConnect.getConnection();
			if (con != null) {
				String sql = "UPDATE users set lastname = ? WHERE username = ?";
				ps = con.prepareStatement(sql);
				ps.setString(1, lastname);
				ps.setString(2, username);
				i = ps.executeUpdate();
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				con.close();
				ps.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (i > 0) {
			return "index";
		} else
			return "index";
	}
	
	
	public String updateMpassword() {
		int i = 0;
		PreparedStatement ps = null;
		Connection con = null;
		try {
			con = DataConnect.getConnection();
			if (con != null) {
				String sql = "UPDATE managers set password = ? WHERE managername = ?";
				ps = con.prepareStatement(sql);
				ps.setString(1, passwordnewm);
				ps.setString(2, managername);
				i = ps.executeUpdate();
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				con.close();
				ps.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (i > 0) {
			return "managerindex";
		} else
			return "index";
	}
	
	public String updateMemail() {
		int i = 0;
		PreparedStatement ps = null;
		Connection con = null;
		try {
			con = DataConnect.getConnection();
			if (con != null) {
				String sql = "UPDATE managers set email = ? WHERE managername = ?";
				ps = con.prepareStatement(sql);
				ps.setString(1, emailm);
				ps.setString(2, managername);
				i = ps.executeUpdate();
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				con.close();
				ps.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (i > 0) {
			return "managerindex";
		} else
			return "index";
	}
	public String updateMaddress() {
		int i = 0;
		PreparedStatement ps = null;
		Connection con = null;
		try {
			con = DataConnect.getConnection();
			if (con != null) {
				String sql = "UPDATE managers set address = ? WHERE managername = ?";
				ps = con.prepareStatement(sql);
				ps.setString(1, addressm);
				ps.setString(2, managername);
				i = ps.executeUpdate();
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				con.close();
				ps.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (i > 0) {
			return "managerindex";
		} else
			return "index";
	}
	public String updateMlastName() {
		int i = 0;
		PreparedStatement ps = null;
		Connection con = null;
		try {
			con = DataConnect.getConnection();
			if (con != null) {
				String sql = "UPDATE managers set lastname = ? WHERE managername = ?";
				ps = con.prepareStatement(sql);
				ps.setString(1, lastnamem);
				ps.setString(2, managername);
				i = ps.executeUpdate();
				System.out.println("hello");
				System.out.println("last name , manager name" + this.lastnamem + this.managername);
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				con.close();
				ps.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (i > 0) {
			return "managerindex";
		} else
			return "index";
	}
	
	
	
}
