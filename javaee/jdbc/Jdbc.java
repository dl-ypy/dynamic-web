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
 * date:2017��8��24��16:43:41
 * @author ypy
 * target:����jdbc��ʵ��DML��DQL���ķ�װ����������ɾ���� �� ���ܲ�ѯ��
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
	 * �������ݿ�
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
	 * �ر����ݿ⣨DML��
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
	 * �ر����ݿ⣨DQL��
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
	 * DML����װ
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
	 * ���ܲ�ѯ(DQL����װ)
	 * @param sql sql���
	 * @param cls ʵ�����class
	 * @param params SQL����еĲ�������Σ�
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
			
			//��ȡ����
			int columnCount = rs.getMetaData().getColumnCount();
			while (rs.next()) {
				//�½�����
				Object instance = cls.newInstance();
				for (int i=1; i<=columnCount; i++) {
					//�õ�����
					Object obj = rs.getObject(i);
					//�жϵõ��������Ƿ�Ϊ��
					if (obj == null) {
						continue;
					}
					//�õ��ֶ���������ת��ΪСд
					String columnName = rs.getMetaData().getColumnName(i).toLowerCase();
					//�ж��Ƿ��и�����
					if (hasField(cls, columnName)) {
						//��������
						Field f = cls.getDeclaredField(columnName);
						//����Ȩ��
						f.setAccessible(true);
						if (rs.getMetaData().getColumnTypeName(i).equals("NUMBER")) {
							BigDecimal val = (BigDecimal) obj;
							if (f.getType().getName().equals("int")) {
								f.set(instance, val.intValue());
							} else {
								f.set(instance, val.doubleValue());
							}
						} else {
							//���õ����ݿ���������õ���Ӧ�����������
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
	 * �ж�cls�����Ƿ�������columnName
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
