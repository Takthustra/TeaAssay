package test;

import model.AccessCountLogic;

public class AccessCountLogicTest {
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		testAccessCountLogic();

	}
	
	public static void testAccessCountLogic() {
		AccessCountLogic bo = new AccessCountLogic();
		int accessCount = bo.getAccessCount();
		System.out.print(accessCount);
//		if(bo.addTimelyLog()) {
//			System.out.print("success");
//		}else {
//			System.out.print("failure");
//		}
	}
}
