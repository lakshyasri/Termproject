package com.authenticate;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.login.DataConnect;
import java.sql.*;

public class Accept {
	
	public static void main(String[] args)
	  {
	    try
	    {
            //System.out.println("symbol: " + this.symbol + ", price: " + this.price + "\n");
            //System.out.println("qty: " + this.qty + ", amt: " + this.amt + "\n");

            Connection conn = DataConnect.getConnection();
            Statement statement = conn.createStatement();
            
            String query = "SELECT * FROM tempmanagers";
            
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next())
            {
              int uid = rs.getInt("uid");
              String firstname = rs.getString("firstname");
              String lastname = rs.getString("lastname");
              String managername = rs.getString("managername");
              String passwordm = rs.getString("passwordm");
              
              // print the results
              System.out.format("%s, %s, %s, %s, %s, %s\n", uid, firstname, lastname,managername,passwordm);
            }
            st.close();
	    }
            catch (Exception e)
            {
              System.err.println("Got an exception! ");
              System.err.println(e.getMessage());
            }
          }
        }