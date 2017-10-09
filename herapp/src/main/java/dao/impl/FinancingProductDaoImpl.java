package dao.impl;

import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

import dao.BaseDao;
import dao.FinancingProductDao;
import entity.FinancingProduct;

public class FinancingProductDaoImpl extends BaseDao implements FinancingProductDao {

	@Override
	public void save(FinancingProduct financingProduct) {
		super.execute("INSERT INTO FinancingProduct VALUES(?,?,?,?,?,?)", 
				financingProduct.getId(),
				financingProduct.getRisk(),
				financingProduct.getIncome(),
				financingProduct.getSaleStarting(),
				financingProduct.getSaleEnd(),
				financingProduct.getEnd());
	}

	@Override
	public List<FinancingProduct> findAll() {
		ResultSet rs = (ResultSet) super.execute("SELECT * FROM FinancingProduct");
		List<FinancingProduct> financingProducts = new ArrayList<>();
		if(rs != null) {
			try {
				while(rs.next()) {
					financingProducts.add(new FinancingProduct(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getDate(4), rs.getDate(5), rs.getDate(6)));	
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return financingProducts;
	}
	
	@Override
	public List<FinancingProduct> findByCondition(String id, String risk) {
		String sql = "SELECT * FROM FinancingProduct WHERE 1=1 ";
		List<FinancingProduct> financingProducts = new ArrayList<>();
		
		if(id == "" && risk == "") {
			return findAll();
		} else if(id != "" && risk != ""){
			sql += (" and id like '" + id + "%'") + (" and risk=" + risk);
			System.out.println(sql);
		} else if(id != "" && risk == "") {
			sql += (" and id like '" + id + "%'");
			System.out.println(sql);
		} else {
			sql += (" and risk=" + risk);
			System.out.println(sql);
		} 
		
		ResultSet rs = (ResultSet) super.execute(sql);
		if(rs != null) {
			try {
				while(rs.next()) {
					financingProducts.add(new FinancingProduct(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getDate(4), rs.getDate(5), rs.getDate(6)));	
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return financingProducts;
	}

}
