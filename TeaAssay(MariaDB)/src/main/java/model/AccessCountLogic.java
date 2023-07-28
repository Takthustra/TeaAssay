package model;

import dao.AccessCountDAO;

public class AccessCountLogic {
	public int getAccessCount() {
		/*
		 * 本日のアクセス回数を取得するメソッド
		 */

		//DAOから本日のアクセス回数を取得
		AccessCountDAO dao = new AccessCountDAO();
		int todayCount = dao.getTodayCount();

		//アクセス回数が1以上の場合、アクセス回数に+1してデータベースを更新
		//0の場合、データベースに本日のデータを追加
		if (todayCount >= 1) {

			todayCount++;
			dao.setTodayCount(todayCount);
		} else {
			dao.insertDailyLog();
			todayCount = dao.getTodayCount();

		}
		
		//日時毎のアクセスログに追加
		dao.insertTimelyLog();

		//本日のアクセス回数を返す
		return todayCount;
	}
}
