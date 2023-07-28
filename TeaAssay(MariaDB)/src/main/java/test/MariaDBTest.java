package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MariaDBTest {
	
	public static boolean MariaDB() {
		final String JDBC_URL = "jdbc:mariadb://localhost:3306/mydb";
    	final String DB_USER = "root";
    	final String DB_PASS = "password";
    	//JDBCドライバを読み込む
		try {
			Class.forName("org.mariadb.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			throw new IllegalStateException("JDBCドライバを読み込めませんでした。");
		}

		//データベースに接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {		
			
			//INSERT文の準備
			String sql = "insert into timely_access_log (created_at) values (default);";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//INSERT文を実行（resultには追加された行数が入る）
			int result = pStmt.executeUpdate();
			if (result != 1) {
				return false;

			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public static void main(String[] args) {
    	
    	if(MariaDB()) {
    		System.out.println("true");
    	}else {
    		System.out.println("false");
    	}
    }
}