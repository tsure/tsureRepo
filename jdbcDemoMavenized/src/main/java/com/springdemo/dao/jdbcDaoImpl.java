package com.springdemo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import com.mysql.jdbc.PreparedStatement;
import com.springjdbc.model.Circle;
@Component
@Service("jdbcDaoImpl")
public class jdbcDaoImpl {
	
	@Autowired
	private DataSource dataSource;
	
	public Circle getCircle(int circleId) {
		Connection conn = null;
		try {
			
			conn = dataSource.getConnection();
			java.sql.PreparedStatement ps = conn.prepareStatement("SELECT * FROM circle where id=?");
			ps.setInt(1, circleId);
			Circle circle = null;
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				circle = new Circle(circleId, rs.getString("name"));
			}
			ps.close();
			rs.close();
			return circle;
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

}
