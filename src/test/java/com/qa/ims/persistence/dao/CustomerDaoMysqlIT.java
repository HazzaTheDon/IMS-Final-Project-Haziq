package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.qa.ims.persistence.domain.Customer;

public class CustomerDaoMysqlIT {

	@Test
	public void testDatabaseHasValues() {
		CustomerDaoMysql customerDaoMysql = new CustomerDaoMysql("root", "root");
		List<Customer> customers = customerDaoMysql.readAll();
		assertTrue(customers.size()>0);
	}
}
