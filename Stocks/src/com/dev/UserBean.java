package com.dev;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.check.Manager;
import com.login.DataConnect;

@ManagedBean(name = "adminBean")
@SessionScoped
public class UserBean {

	public List<Manager> getUserList() {
		System.out.println("in user List");
		List<Manager> list = new ArrayList<Manager>();
		PreparedStatement ps = null;
		Connection con = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DataConnect.getConnection();
			String sql = "select * from tempmanagers";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Manager usr = new Manager();
				usr.setFirstname(rs.getString("firstname"));
				usr.setLastname(rs.getString("lastname"));
				usr.setManagername(rs.getString("managername"));
				usr.setPasswordm(rs.getString("passwordm"));
				usr.setAddress(rs.getString("address"));
				usr.setPhonenumber(rs.getInt("phonenumber"));
				usr.setEmail(rs.getString("email"));

				list.add(usr);
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
		return list;
	}

	public List<Manager> getManagerList() {
		System.out.println("in user List");
		List<Manager> list = new ArrayList<Manager>();
		PreparedStatement ps = null;
		Connection con = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DataConnect.getConnection();
			String sql = "select * from managers";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Manager usr = new Manager();
				usr.setFirstname(rs.getString("firstname"));
				usr.setLastname(rs.getString("lastname"));
				usr.setManagername(rs.getString("managername"));
				usr.setAddress(rs.getString("address"));
				usr.setPhonenumber(rs.getInt("phonenumber"));
				usr.setEmail(rs.getString("email"));

				list.add(usr);
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
		return list;
	}

	public List<Manager> getRelationList() {
		System.out.println("in user List");
		List<Manager> list = new ArrayList<Manager>();
		PreparedStatement ps = null;
		Connection con = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DataConnect.getConnection();
			String sql = "select * from relation";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Manager usr = new Manager();
				usr.setFirstname(rs.getString("firstname"));
				usr.setLastname(rs.getString("lastname"));
				usr.setManagername(rs.getString("managername"));
				usr.setAddress(rs.getString("address"));
				usr.setPhonenumber(rs.getInt("phonenumber"));
				usr.setEmail(rs.getString("email"));

				list.add(usr);
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
		return list;
	}
	
}