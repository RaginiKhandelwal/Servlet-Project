package com.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import com.studentbean.StudentBean;

public class StudentCon {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	Statement st = null;
	StudentBean s = null;

	public Connection getConnection() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oct", "root", "root");

		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}

	public int insert(StudentBean s) {
		try {
			con = getConnection();
			ps = con.prepareStatement("insert into student values(?,?,?,?,?)");
			ps.setInt(1, s.getId());
			ps.setString(2, s.getName());
			ps.setString(3, s.getAddress());
			ps.setString(4, s.getEmail());
			ps.setString(5, s.getQual());

			int i = ps.executeUpdate();
			return i;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int delete(int id) {
		try {
			con = getConnection();
			String sql = "delete from student where id=?";

			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			return i;

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

	}

	public int update(StudentBean s) throws Exception {
		try {
			con = getConnection();

			String sql = "update student set name=? , address=? , email=? , qual=? where id=? ";

			ps = con.prepareStatement(sql);

			ps.setString(1, s.getName());
			ps.setString(2, s.getAddress());
			ps.setString(3, s.getEmail());
			ps.setString(4, s.getQual());
			ps.setInt(5, s.getId());

			int result = ps.executeUpdate();
			return result;

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public String[] select(int id) {
		try {
			con = getConnection();
			String sql = "select * from student where id=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();

			String[] stu = new String[5];
			if (rs.next()) {
				stu[0] = rs.getString(1);
				stu[1] = rs.getString(2);
				stu[2] = rs.getString(3);
				stu[3] = rs.getString(4);
				stu[4] = rs.getString(5);
			}
			return (stu);

		} catch (Exception e) {
			e.printStackTrace();
			return null;

		}
	}

}
