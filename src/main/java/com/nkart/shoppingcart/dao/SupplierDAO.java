package com.nkart.shoppingcart.dao;

import java.util.List;

import com.nkart.shoppingcart.domain.Supplier;

public interface SupplierDAO
{

	public List<Supplier> getAllSuppliers();
	
	public boolean createSupplier(Supplier supplier);
	
	public boolean deleteSupplier(Supplier supplier);
	
	public boolean updateSupplier(Supplier supplier);
	
	public Supplier getSupplierById(int id);
	
	public Supplier getSupplierByName(int name);
	
}
