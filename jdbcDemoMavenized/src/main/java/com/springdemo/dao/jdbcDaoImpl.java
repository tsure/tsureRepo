package com.springdemo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


import com.mysql.jdbc.PreparedStatement;
import com.springjdbc.model.Circle;
//@Component
@Repository
@Service("jdbcDaoImpl")
public class jdbcDaoImpl {
	
	//@Autowired
	private DataSource dataSource;
	
	private JdbcTemplate jdbcTemplate;// = getJdbcTemplate();//= new JdbcTemplate();
	
	
//	public Circle getCircle(int circleId) {
//		Connection conn = null;
//		try {
//			
//			conn = dataSource.getConnection();
//			java.sql.PreparedStatement ps = conn.prepareStatement("SELECT * FROM circle where id=?");
//			ps.setInt(1, circleId);
//			Circle circle = null;
//			ResultSet rs = ps.executeQuery();
//			if(rs.next()) {
//				circle = new Circle(circleId, rs.getString("name"));
//			}
//			ps.close();
//			rs.close();
//			return circle;
//		}catch(Exception e) {
//			throw new RuntimeException(e);
//		}
//		finally {
//			try {
//				conn.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//	}
	
	public int getCircleCount() {
		String sql = "SELECT COUNT(*) FROM CIRCLE";
		//jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate.queryForInt(sql);
	}
	
	public String getCircleName(int circleId) {
		String sql = "SELECT NAME FROM CIRCLE WHERE ID = ?";
		return jdbcTemplate.queryForObject(sql, new Integer[] {circleId},String.class);
		
	}
	
	public Circle getCircleForId(int circleId) {
		String sql = "SELECT * FROM CIRCLE WHERE ID = ?";
		return jdbcTemplate.queryForObject(sql, new Integer[] {circleId}, new CircleMapper());
		 
	}
	
	public List<Circle> getAllCircles() {
		String sql = "SELECT * FROM CIRCLE";
		return jdbcTemplate.query(sql, new CircleMapper());
	}
	
	public void insertCircle(Circle circle) {
		String sql = "INSERT INTO CIRCLE(ID,NAME) VALUES(?, ?)";
		jdbcTemplate.update(sql, new Object[]{circle.getId(), circle.getName()});
		
	}
	
	public void createTriangleTable() {
		String sql = "CREATE TABLE TRIANGLE (ID INTEGER, NAME VARCHAR(20))";
		jdbcTemplate.execute(sql);
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		//this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	/**
	 * Our own implementation of RowMapper
	 * @author Owner
	 *
	 */
	
	private static final class CircleMapper implements RowMapper<Circle> {

		@Override
		public Circle mapRow(ResultSet rs, int rowNum) throws SQLException {
			Circle circle = new Circle();
			circle.setId(rs.getInt("ID"));
			circle.setName(rs.getString("NAME"));
			return circle;
		}
		
	}

}
