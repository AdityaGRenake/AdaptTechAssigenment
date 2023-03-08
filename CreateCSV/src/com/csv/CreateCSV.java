package com.csv;

import java.io.File;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.protocol.Resultset;

public class CreateCSV {
	public static void main(String[] args) {
		try {
			PrintWriter printWriter=new PrintWriter(new File("D:\\csv\\top10p.csv"));
			StringBuilder sb=new StringBuilder();
			Connection connection=null;
			DBConnection connection2=new DBConnection();
			connection=connection2.getConnection();
			ResultSet rs=null;
			sb.append("id");
			sb.append(",");
			sb.append("productname");
			sb.append(",");
			sb.append("iproductprice");
			sb.append(",");
			sb.append("iitem_number");
			sb.append(",");
			sb.append("modelnumber");
			sb.append(",");
			sb.append("modelnumber");
			sb.append(",");
			sb.append("productcategory");
			sb.append(",");
			sb.append("productlink");
			sb.append("\r\n");
			String query="select * from assigenment";
			PreparedStatement ps=connection.prepareStatement(query);
			rs=ps.executeQuery();
			while(rs.next()) {
				sb.append(rs.getInt("id"));
				sb.append(",");
				sb.append(rs.getString("productname"));
				sb.append(",");
				sb.append(rs.getDouble("productprice"));
				sb.append(",");
				sb.append(rs.getInt("item_number"));
				sb.append(",");
				sb.append(rs.getString("modelnumber"));
				sb.append(",");
				sb.append(rs.getString("productcategory"));
				sb.append(",");
				sb.append(rs.getString("productdescription"));
				sb.append(",");
				sb.append(rs.getString("productlink"));
				sb.append("\r\n");
			}
			printWriter.write(sb.toString());
			printWriter.close();
			System.out.println("finished");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}