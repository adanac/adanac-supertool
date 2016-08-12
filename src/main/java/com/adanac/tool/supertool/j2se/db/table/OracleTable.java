package com.adanac.tool.supertool.j2se.db.table;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/***
 *  oracle数据库， 表结构查询 ，字段信息查询，字段注释查询 
 *  表字段查询 all_tab_columns
 *  表字段注释查询 all_col_comments
 */
public class OracleTable {
	private static final String DRIVER_CLASS = "oracle.jdbc.driver.OracleDriver";
	private static final String DATABASE_URL = "jdbc:oracle:thin:@192.168.1.10:1521:orcl";
	private static final String DATABASE_USER = "dev";
	private static final String DATABASE_PASSWORD = "dev";
	private static Connection con = null;

	public static Connection getConnection() {
		try {
			Class.forName(DRIVER_CLASS);
			con = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
			return con;
		} catch (Exception ex) {
			System.out.println("2:" + ex.getMessage());
		}
		return con;
	}

	/***
	 * 打印test
	 * @throws SQLException
	 */
	public static void sysoutStrTablePdmCloumns(String Table, String Owner) throws SQLException {
		getConnection();

		List<HashMap<String, String>> columns = new ArrayList<HashMap<String, String>>();

		try {
			Statement stmt = con.createStatement();

			String sql = "select " + "         comments as \"Name\"," + "         a.column_name \"Code\","
					+ "         a.DATA_TYPE as \"DataType\"," + "         b.comments as \"Comment\","
					+ "         decode(c.column_name,null,'FALSE','TRUE') as \"Primary\","
					+ "         decode(a.NULLABLE,'N','TRUE','Y','FALSE','') as \"Mandatory\","
					+ "         '' \"sequence\"" + "   from " + "       all_tab_columns a, "
					+ "       all_col_comments b," + "       (" + "        select a.constraint_name, a.column_name"
					+ "          from user_cons_columns a, user_constraints b"
					+ "         where a.constraint_name = b.constraint_name"
					+ "               and b.constraint_type = 'P'" + "               and a.table_name = '" + Table + "'"
					+ "       ) c" + "   where " + "     a.Table_Name=b.table_Name "
					+ "     and a.column_name=b.column_name" + "     and a.Table_Name='" + Table + "'"
					+ "     and a.owner=b.owner " + "     and a.owner='" + Owner + "'"
					+ "     and a.COLUMN_NAME = c.column_name(+)" + "  order by a.COLUMN_ID";
			System.out.println(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				HashMap<String, String> map = new HashMap<String, String>();
				map.put("Name", rs.getString("Name"));
				map.put("Code", rs.getString("Code"));
				map.put("DataType", rs.getString("DataType"));
				map.put("Comment", rs.getString("Comment"));
				map.put("Primary", rs.getString("Primary"));
				map.put("Mandatory", rs.getString("Mandatory"));
				columns.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
	}

	/**
	 * 获取数据库表的名字
	 */
	public void getTableNameByCon(Connection con) {
		try {
			DatabaseMetaData meta = con.getMetaData();
			ResultSet rs = meta.getTables(null, null, null, new String[] { "TABLE" });
			while (rs.next()) {
				System.out.println("表名：" + rs.getString(3));
				System.out.println("表所属用户名：" + rs.getString(2));
				System.out.println("------------------------------");
			}
			con.close();
		} catch (Exception e) {
			try {
				con.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}

	public static void test1(String[] args) {

		// 这里没有指定数据库
		String url = "jdbc:mysql://127.0.0.1:3306/";
		String user = "root";
		String pass = "";
		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conn = DriverManager.getConnection(url, user, pass);
			DatabaseMetaData metadata = conn.getMetaData();
			System.out.println("数据库已知的用户: " + metadata.getUserName());
			System.out.println("数据库的系统函数的逗号分隔列表: " + metadata.getSystemFunctions());
			System.out.println("数据库的时间和日期函数的逗号分隔列表: " + metadata.getTimeDateFunctions());
			System.out.println("数据库的字符串函数的逗号分隔列表: " + metadata.getStringFunctions());
			System.out.println("数据库供应商用于 'schema' 的首选术语: " + metadata.getSchemaTerm());
			System.out.println("数据库URL: " + metadata.getURL());
			System.out.println("是否允许只读:" + metadata.isReadOnly());
			System.out.println("数据库的产品名称:" + metadata.getDatabaseProductName());
			System.out.println("数据库的版本:" + metadata.getDatabaseProductVersion());
			System.out.println("驱动程序的名称:" + metadata.getDriverName());
			System.out.println("驱动程序的版本:" + metadata.getDriverVersion());

			System.out.println();
			System.out.println("数据库中使用的表类型");
			ResultSet rs = metadata.getTableTypes();
			while (rs.next()) {
				System.out.println(rs.getString(1));
			}
			rs.close();

			System.out.println();
			/**  
			 * 获取指定的数据库的所有表的类型,getTables()的第一个参数就是数据库名  
			 * 因为与MySQL连接时没有指定,这里加上,剩下的参数就可以为null了  
			 * 第二个参数是模式名称的模式,但是输出也是什么都没有。谁知道告诉我一声  
			 */
			System.out.println("获取指定的数据库的所有表的类型");
			ResultSet rs1 = metadata.getTables("ssi2bbs", null, null, null);
			while (rs1.next()) {
				System.out.println();
				System.out.println("数据库名:" + rs1.getString(1));
				System.out.println("表名: " + rs1.getString(3));
				System.out.println("类型: " + rs1.getString(4));
			}
			rs1.close();

			System.out.println();
			System.out.println("获取指定的数据库的表的主键");
			// 获取指定的数据库的表的主键，第二个参数也是模式名称的模式,使用null了
			ResultSet rs2 = metadata.getPrimaryKeys("mysql", null, "db");
			while (rs2.next()) {
				System.out.println("主键名称: " + rs2.getString(4));
			}
			rs2.close();

			System.out.println();
			System.out.println("DatabaseMetaData.getIndexInfo()方法返回信息:");
			ResultSet rs3 = metadata.getIndexInfo("ssi2bbs", null, "user", false, true);
			while (rs3.next()) {
				System.out.println("数据库名: " + rs3.getString(1));
				System.out.println("表模式: " + rs3.getString(2));
				System.out.println("表名称: " + rs3.getString(3));
				System.out.println("索引值是否可以不唯一: " + rs3.getString(4));
				System.out.println("索引类别: " + rs3.getString(5));
				System.out.println("索引名称: " + rs3.getString(6));
				System.out.println("索引类型: " + rs3.getString(7));
				System.out.println("索引中的列序列号: " + rs3.getString(8));
				System.out.println("列名称: " + rs3.getString(9));
				System.out.println("列排序序列: " + rs3.getString(10));
				System.out.println("TYPE为 tableIndexStatistic时它是表中的行数否则它是索引中唯一值的数量: " + rs3.getString(11));
				System.out.println("TYPE为 tableIndexStatisic时它是用于表的页数否则它是用于当前索引的页数: " + rs3.getString(12));
				System.out.println("过滤器条件: " + rs3.getString(13));
			}
			rs3.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws SQLException {
		sysoutStrTablePdmCloumns("CT_INFO_CONTRACT_BORROW", "DEV");
	}
}
