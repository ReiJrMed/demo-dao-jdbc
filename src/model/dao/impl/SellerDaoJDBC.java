package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DBException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoJDBC implements SellerDao{

	private Connection conn;
	
	public SellerDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Seller seller) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Seller seller) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer Id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Seller findById(Integer Id) {
		
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			pst = conn.prepareStatement("select seller.*, department.Name as Department from seller inner join department "
					+ "on seller.DepartmentId = department.Id where seller.Id = ?");
			
			pst.setInt(1, Id);
			
			rs = pst.executeQuery();
			
			if(rs.next()) {
				Department dp = instantiateDepartment(rs);
				return instantiateSeller(rs, dp); 
			} else {
			   return null;
			}
		} catch (SQLException e) {
			throw new DBException(e.getMessage());
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(pst);
			//não fechar a conexão pois esse objeto pode servir para fazer mais de uma operação
		}			
	}

	private Seller instantiateSeller(ResultSet rs, Department dp) throws SQLException {
		return new Seller(rs.getInt("Id"), rs.getString("Name"),rs.getString("Email"),
				rs.getDate("BirthDate"),rs.getDouble("BaseSalary"), dp);
	}

	private Department instantiateDepartment(ResultSet rs) throws SQLException {
		return new Department(rs.getInt("DepartmentId"), rs.getString("Department"));
	}

	@Override
	public List<Seller> findAll() {
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			pst = conn.prepareStatement("select seller.*, department.Name as Department from seller inner join department "
					+ "on seller.DepartmentId = department.Id order by seller.Name");
			
		    rs = pst.executeQuery();
			
			List<Seller> seller = new ArrayList<>();
			
			Map<Integer, Department> departments = new HashMap<>();
			
			while(rs.next()) {
				Department dp = departments.get(rs.getInt("DepartmentId"));
				
				if(dp == null) {
					dp = instantiateDepartment(rs);
					departments.put(rs.getInt("DepartmentId"), dp);
				}
								
				seller.add(instantiateSeller(rs, dp)); 
			}
			
			return seller;
			
		} catch (SQLException e) {
			throw new DBException(e.getMessage());
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(pst);
			//não fechar a conexão pois esse objeto pode servir para fazer mais de uma operação
		}
	}

	@Override
	public List<Seller> findByDepartment(Department department) {
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			pst = conn.prepareStatement("select seller.*, department.Name as Department from seller inner join department "
					+ "on seller.DepartmentId = department.Id where seller.DepartmentId = ? order by seller.Name");
			
			pst.setInt(1, department.getId());
			
			rs = pst.executeQuery();
			
			List<Seller> seller = new ArrayList<>();
			
			Map<Integer, Department> departments = new HashMap<>();
			
			while(rs.next()) {
				Department dp = departments.get(rs.getInt("DepartmentId"));
				
				if(dp == null) {
					dp = instantiateDepartment(rs);
					departments.put(rs.getInt("DepartmentId"), dp);
				}
								
				seller.add(instantiateSeller(rs, dp)); 
			}
			
			return seller;
			
		} catch (SQLException e) {
			throw new DBException(e.getMessage());
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(pst);
			//não fechar a conexão pois esse objeto pode servir para fazer mais de uma operação
		}		
	}
	
}
