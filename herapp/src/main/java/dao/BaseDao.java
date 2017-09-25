package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class BaseDao { // Base Data Access Object

	private static Connection getConnection() {

		try {
			Context context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/herapp");
			return dataSource.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static Object execute(String sql, Object... params) {
		try (Connection conn = getConnection();) {

			PreparedStatement pstat = conn.prepareStatement(sql);
			for (int i = 1; i <= params.length; i++) {
				pstat.setObject(i, params[i - 1]);
			}
			if (pstat.execute()) {
				RowSetFactory factory = RowSetProvider.newFactory();
				CachedRowSet crs = factory.createCachedRowSet();

				crs.populate(pstat.getResultSet());
				return crs;
			} else {
				return pstat.getUpdateCount();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

}
