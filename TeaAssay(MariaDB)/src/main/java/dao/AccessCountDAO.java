package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccessCountDAO {
	private final String JDBC_URL = "jdbc:mariadb://localhost:3306/mydb";
	private final String DB_USER = "***";
	private final String DB_PASS = "***";

	public boolean insertTimelyLog() {
		/*
		 * timely_access_logにアクセス日時を記録するメソッド
		 */
		
		
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

	public int getTodayCount() {
		/**
		 *  daily_access_logのテーブルから本日のアクセス数を取得するメソッド
		 */
		
		int todayCount = 0;
		//JDBCドライバを読み込む
		try {
			Class.forName("org.mariadb.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			throw new IllegalStateException("JDBCドライバを読み込めませんでした。");
		}

		//データベースに接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			//SELECT文の準備
			String sql = "select access_count from daily_access_log where date = CURDATE();";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SELECTを実行、結果表を取得
			ResultSet rs = pStmt.executeQuery();

			//結果表に格納された本日のアクセス数を取得
			if (rs.next()) {
				todayCount = rs.getInt("access_count");
			}

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		return todayCount;
	}

	public boolean insertDailyLog() {
		/**
		 *  daily_access_logのテーブルに本日のデータとアクセス数:1のレコードを入れるメソッド
		 */
		
		//JDBCドライバを読み込む
		try {
			Class.forName("org.mariadb.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			throw new IllegalStateException("JDBCドライバを読み込めませんでした。");
		}

		//データベースに接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			//SELECT文の準備
			String sql = "insert into daily_access_log (date,access_count) values (curdate(),1);";
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
	
	public boolean setTodayCount(int accessCount) {
		/**
		 *  daily_access_logのテーブルの本日のアクセス数を更新するメソッド
		 */
		
		//JDBCドライバを読み込む
		try {
			Class.forName("org.h2.Driver");

		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			throw new IllegalStateException("JDBCドライバを読み込めませんでした。");
		}

		//データベースに接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			//SELECT文の準備
			String sql = "update daily_access_log set access_count = ? where date = CURDATE();";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			//INSERT文中の「？」に使用する値を設定してSQL文を完成
			pStmt.setInt(1, accessCount);
			

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
}
