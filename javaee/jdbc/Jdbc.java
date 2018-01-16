package jdbc;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * date:2017年8月24日16:43:41
 * @author ypy
 * target:连接jdbc，实现DML与DQL语句的封装（万能增、删、改 和 万能查询）
 */
public class Jdbc {
	private static final String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String user = "ypy";
	private static final String password = "ypy";
	private static Connection conn = null;
	private static PreparedStatement ps = null;
	private static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String sql = "select * from emp where deptno = ?";
		List<Object> list = selectAll(sql, Emp.class, 20);
		for (Object object : list) {
			System.out.println(object);
		}
	}
	
	/**
	 * 连接数据库
	 * @return
	 */
	public static Connection getConnection() {
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * 关闭数据库（DML）
	 * @param conn
	 * @param ps
	 */
	public static void closeDriver(Connection conn, PreparedStatement ps) {
		try {
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 关闭数据库（DQL）
	 * @param conn
	 * @param ps
	 * @param rs
	 */
	public static void closeDriver(Connection conn, PreparedStatement ps, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * DML语句封装
	 * @param sql
	 * @param params
	 * @return
	 */
	public static int DML(String sql, Object...params) {
		int n = 0;
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			if (params.length != 0) {
				for (int i = 0; i < params.length; i++) {
					ps.setObject(i+1, params[i]);
				}
			}
			n = ps.executeUpdate();
			return n;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDriver(conn, ps);
		}
		return -1;
	}
	
	/**
	 * 万能查询(DQL语句封装)
	 * @param sql sql语句
	 * @param cls 实体类的class
	 * @param params SQL语句中的参数（变参）
	 * @return
	 */
	public static <T> List<T> selectAll(String sql, @SuppressWarnings("rawtypes") Class cls, Object...params) {
		ResultSet rs = null;
		List<Object> list = new ArrayList<>();
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			if (params.length != 0) {
				for (int i = 0; i < params.length; i++) {
					ps.setObject(i+1, params[i]);
				}
			}
			rs = ps.executeQuery();
			
			//获取列数
			int columnCount = rs.getMetaData().getColumnCount();
			while (rs.next()) {
				//新建对象
				Object instance = cls.newInstance();
				for (int i=1; i<=columnCount; i++) {
					//得到数据
					Object obj = rs.getObject(i);
					//判断得到的数据是否为空
					if (obj == null) {
						continue;
					}
					//得到字段名并将其转换为小写
					String columnName = rs.getMetaData().getColumnName(i).toLowerCase();
					//判断是否有该属性
					if (hasField(cls, columnName)) {
						//设置属性
						Field f = cls.getDeclaredField(columnName);
						//设置权限
						f.setAccessible(true);
						if (rs.getMetaData().getColumnTypeName(i).equals("NUMBER")) {
							BigDecimal val = (BigDecimal) obj;
							if (f.getType().getName().equals("int")) {
								f.set(instance, val.intValue());
							} else {
								f.set(instance, val.doubleValue());
							}
						} else {
							//将得到数据库的数据设置到对应对象的属性中
							f.set(instance, obj);
						}
					}
				}
				list.add(instance);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDriver(conn, ps, rs);
		}
		return (List<T>) list;
	}

	/**
	 * 判断cls类中是否有属性columnName
	 * @param cls
	 * @param columnName
	 * @return
	 */
	private static boolean hasField(@SuppressWarnings("rawtypes") Class cls, String columnName) {
		Field[] fields = cls.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			if (fields[i].getName().equals(columnName)) {
				return true;
			}
		}
		return false;
	}
}
