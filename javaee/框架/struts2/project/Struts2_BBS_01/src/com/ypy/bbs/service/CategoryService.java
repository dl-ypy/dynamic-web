package com.ypy.bbs.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ypy.bbs.model.Category;
import com.ypy.bbs.util.DB;

public class CategoryService {
	Connection conn = DB.createConn();
	
	public void add(Category c){
		String sql = "insert into _category values (null, ?, ?)";
		PreparedStatement ps = DB.prepare(conn, sql);
		try {
			ps.setString(1, c.getName());
			ps.setString(2, c.getDescription());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DB.close(conn);
		DB.close(ps);
	}
	
	public void delete(Category c){
		deleteById(c.getId());
	}
	
	//这个方便
	public void deleteById(int id){
		String sql = "delete from _category where id = ?";
		PreparedStatement ps = DB.prepare(conn, sql);
		try{
			ps.setInt(1, id);
			ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		DB.close(conn);
		DB.close(ps);
	}
	
	public void update(Category c){
		String sql = "update _category set name = ?, description = ? where id = ?";
		PreparedStatement ps = DB.prepare(conn, sql);
		try{
			ps.setString(1, c.getName());
			ps.setString(2, c.getDescription());
			ps.setInt(3, c.getId());
			ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		DB.close(conn);
		DB.close(ps);
	}
	
	public List<Category> select() throws SQLException{
		String sql = "select * from _category";
		PreparedStatement ps = DB.prepare(conn, sql);
		List<Category> list = new ArrayList<Category>();
		try{
			ResultSet rs = ps.executeQuery();
			while (rs.next()){
				Category c = new Category();
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setDescription(rs.getString("description"));
				list.add(c);
			}
		}catch(Exception e){
			e.printStackTrace();
			throw(e);//抛出异常
		}
		return list;
	}
	
	public Category loadById(int id){
		String sql = "select * from _category where id = ?";
		PreparedStatement ps = DB.prepare(conn, sql);
		Category c = null;
		try{
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()){
				c = new Category();
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setDescription(rs.getString("description"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return c;
	}
}
















