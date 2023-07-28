package test;

import dao.AccessCountDAO;

public class AccessCountDAOTest {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		testAccessCountDAO();

	}

	public static void testAccessCountDAO() {
		
		AccessCountDAO dao = new AccessCountDAO();
		int todayCount = dao.getTodayCount();
		
		if(todayCount > 0) {
			
			todayCount++;
			if(dao.setTodayCount(todayCount)) {
				System.out.println("testAccessCountDAO3:"+ "[success]");
			}else {
				System.out.println("testAccessCountDAO3:"+ "[failure]");
			}
			
			
		}else {
			
			if(dao.insertDailyLog()) {
				todayCount = dao.getTodayCount();
				System.out.println("testAccessCountDAO2:"+ "[success]" + "本日のデータが無かったので生成しました。アクセス数は"+ todayCount);
			}else {
				System.out.println("testAccessCountDAO2:"+ "[failure]");
			}
			
			
		}
		
		if(dao.insertTimelyLog()) {
			System.out.println("testAccessCountDAO4:"+ "[success]");
		}else {
			System.out.println("testAccessCountDAO4:"+ "[failure]");
		}

	}

}
