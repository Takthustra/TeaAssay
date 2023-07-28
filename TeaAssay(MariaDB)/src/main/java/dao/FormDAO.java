package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Form;

public class FormDAO {

	private final String JDBC_URL = "jdbc:mariadb://localhost:3306/mydb";
	private final String DB_USER = "***";
	private final String DB_PASS = "***";

	public boolean insert(Form form) {

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
			String sql = "insert into form(name,email,title,textarea) values(?,?,?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//INSERT文中の「？」に使用する値を設定してSQL文を完成
			pStmt.setString(1, form.getName());
			pStmt.setString(2, form.getEmail());
			pStmt.setString(3, form.getTitle());
			pStmt.setString(4, form.getTextArea());

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
