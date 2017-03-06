package com.nkart.shoppincart.testcase;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nkart.shoppingcart.dao.SupplierDAO;
import com.nkart.shoppingcart.domain.Supplier;

public class SupplierTestCase {
	@Autowired
	private static Supplier supplier;

	@Autowired
	private static SupplierDAO supplierDAO;

	@BeforeClass
	public static void initialize() {
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.nkart");
		context.refresh();

		supplier = (Supplier) context.getBean("supplier");
		supplierDAO = (SupplierDAO) context.getBean("supplierDAO");

	}

	@Test
	public void getAllSuppliersTestCase() {
		int sup = supplierDAO.getAllSuppliers().size();
		assertEquals("getAllSuppliersTestCase", 4, sup);
	}

	@Test
	public void createSupplierTestCase() {
		supplier.setId("06");
		supplier.setName("Sangeetha");
		supplier.setAddress("India");

		boolean flag = supplierDAO.createSupplier(supplier);
		assertEquals("createSupplierTestCase", true, flag);

	}

	@Test
	public void updateSupplierTestCase() {
		supplier.setId("02");
		supplier.setName("Nokia");
		supplier.setAddress("Mumbai,India");

		boolean flag = supplierDAO.updateSupplier(supplier);
		assertEquals("updateSupplierTestCase", true, flag);
	}

	@Test
	public void deleteSupplierTestCase() {
		supplier.setId("111");

		boolean flag = supplierDAO.deleteSupplier(supplier);
		assertEquals("deleteSupplierTestCase", true, flag);
	}

}