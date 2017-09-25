package dao;

import java.util.List;

import entity.FinancingProduct;

public interface FinancingProductDao {
	
	void save(FinancingProduct financingProduct);
	List<FinancingProduct> findAll();
	List<FinancingProduct> findByCondition(String id, String risk);
}
