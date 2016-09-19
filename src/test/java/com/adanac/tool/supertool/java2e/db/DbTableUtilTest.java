package com.adanac.tool.supertool.java2e.db;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.testng.Assert;

import com.adanac.tool.supertool.j2se.db.MySql;
import com.adanac.tool.supertool.j2se.db.table.DbTableUtil;

public class DbTableUtilTest {

	@Test
	public void testGetTableInfoByName() {
		String tableName = "tab_common";
		List<Map<String, Object>> list = DbTableUtil.getTableInfoByName(tableName);
		Assert.assertTrue(list.size() > 0);
	}

	@Test
	public void testGetColNamesByTableName() {
		String tableName = "tab_common";
		List<String> names = DbTableUtil.getColNamesByTableName(tableName);
		System.out.println(names.size());
		Assert.assertTrue(names.size() > 0);
	}

	@Test
	public void testGetTabNamesBydbName() {
		// open connection
		MySql mysql = new MySql();
		Connection conn = mysql.getConn();
		List<String> tabNames = DbTableUtil.getTabNamesBydbName(conn);
		System.out.println(tabNames.size());
		Assert.assertTrue(tabNames.size() > 0);
		mysql.closeConn(conn);
	}

	@Test
	public void testGetColumnCommentByTableName() throws Exception {
		String tableName = "tab_common";
		List<String> tableNameList = new ArrayList<String>();
		tableNameList.add(tableName);
		Map<String, Object> map = DbTableUtil.getColumnCommentByTableName(tableNameList);
		Assert.assertNotNull(map);
	}

}
