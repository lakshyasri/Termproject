package com.register;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.login.DataConnect;

@ManagedBean(name = "manager")
@SessionScoped
public class Manager {

	private String firstname;
	private String lastname;
	private String managername;
	private String passwordm;
	private String address;
	private String phonenumber;
	private String email;
	private String dbPassword;
	private String dbName;
	DataSource ds;
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getmanagername() {
		return managername;
	}

	public void setmanagername(String managername) {
		this.managername = managername;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getDbPassword() {
		return dbPassword;
	}

	public String getDbName() {
		return dbName;
	}

	public String getPasswordm() {
		return passwordm;
	}

	public void setPasswordm(String passwordm) {
		this.passwordm = passwordm;
	}

	boolean isLoginPage = (FacesContext.getCurrentInstance().getViewRoot()
			.getViewId().lastIndexOf("login.xhtml") > -1);

	public Manager() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/database");
			System.out.println("In user constructor");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	

	public String add() {
		int i = 0;
		if (firstname != null) {
			PreparedStatement ps = null;
			Connection con = null;
			try {
				con = DataConnect.getConnection();
				if (con != null) {
					String sql = "INSERT INTO managers(firstname, lastname, address, email, phonenumber, passwordm, managername) VALUES(?,?,?,?,?,?,?)";
					ps = con.prepareStatement(sql);
					ps.setString(1, firstname);
					ps.setString(2, lastname);
					ps.setString(3, address);
					ps.setString(4, email);
					ps.setString(5, passwordm);
					ps.setString(6, phonenumber);
					ps.setString(7, managername);
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
		}
		if (i > 0) {
			return "purchase";
		} else
			return "index";
	}

	public void dbData(String uName) {
		if (uName != null) {
			PreparedStatement ps = null;
			Connection con = null;
			ResultSet rs = null;

			if (ds != null) {
				try {
					con = ds.getConnection();
					if (con != null) {
						String sql = "select name,password from user where name = '"
								+ uName + "'";
						ps = con.prepareStatement(sql);
						rs = ps.executeQuery();
						rs.next();
						dbName = rs.getString("name");
						dbPassword = rs.getString("password");
					}
				} catch (SQLException sqle) {
					sqle.printStackTrace();
				}
			}
		}
	}

}