package com.check;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import java.sql.*;

import com.login.DataConnect;

@ManagedBean(name = "managerm")
@RequestScoped
public class Manager {

	private String firstname;
	private String lastname;
	private String managername;
	private String passwordm;
	private String address;
	private String email;
	private int phonenumber;

	public int getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(int phonenumber) {
		this.phonenumber = phonenumber;
	}

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

	public void delete(int phonenumber) {
		PreparedStatement ps = null;
		Connection con = null;
		if (phonenumber != 0) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DataConnect.getConnection();
				String sql = "DELETE FROM tempmanagers WHERE phonenumber="
						+ phonenumber;
				ps = con.prepareStatement(sql);
				int i = ps.executeUpdate();
				if (i > 0) {
					System.out.println("Row deleted successfully");
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					con.close();
					ps.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	
	public String insertto( String firstname, String lastname, String address, String managername, String email, int phonenumber, String passwordm) {
		int i = 0;
		PreparedStatement ps = null;
		Connection con = null;
		try {
			con = DataConnect.getConnection();
			if (con != null) {
				String sql = "INSERT INTO managers(firstname, lastname, address, email, passwordm, phonenumber, managername) VALUES(?,?,?,?,?,?,?)";
				ps = con.prepareStatement(sql);
				ps.setString(1, firstname);
				ps.setString(2, lastname);
				ps.setString(3, address);
				ps.setString(4, email);
				ps.setString(5, passwordm);
				ps.setInt(6, phonenumber);
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
		return "admin";
	}


}
