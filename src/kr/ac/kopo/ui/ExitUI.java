package kr.ac.kopo.ui;

public class ExitUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		LoginUI.isLogin = false;
		LoginUI.userID = "";
		System.out.println("------------------------------------------");
		System.out.println("로그아웃 후 도서관리 프로그램을 종료합니다");
		System.out.println("------------------------------------------");
		System.exit(0);
	}

}
