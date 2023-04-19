package kr.ac.kopo.ui;

import java.util.Scanner;

public class LibUI extends BaseUI {

	private int menu() {
		System.out.println("------------------------------------------");
		System.out.println("\t도서관리 프로그램 메뉴를 실행합니다");
		System.out.println("------------------------------------------");
		if(LoginUI.isLogin == false) {
		System.out.println("1.회원가입");
		System.out.println("2.로그인");
		}
		else {
		System.out.println("3.마이페이지");
		System.out.println("4.도서검색");
		System.out.println("5.도서대여");
		System.out.println("6.도서반납");
		System.out.println("7.도서등록"); // 나중에 관리자쪽으로 빼기
		}
		System.out.println("0.로그아웃 및 프로그램 종료");
		System.out.print("원하는 항목을 선택하세요 : ");
		Scanner sc = new Scanner(System.in);
		int type = sc.nextInt();
		sc.nextLine();

		return type;

	}

	@Override
	public void execute() throws Exception {

		while (true) {
			int type = menu();
			ILibUI ui = null;
			switch (type) {
			case 1:
				ui = new AddMemberUI();
				break;
			case 2:
				ui = new LoginUI();
				break;
			case 3:
				ui = new MyPageUI();
				break;
			case 4:
				ui = new SearchBookUI();
				break;
			case 5:
				ui = new RentalBookUI();
				break;
			case 6:
				ui = new ReturnBookUI();
				break;
			case 7:
				ui = new AddNewBookUI();
				break;
			case 0:
				ui = new ExitUI();
				break;

			}
			if(ui != null) {
				ui.execute();
			}else {
				System.out.println("잘못입력하셨습니다");
			}

		}

	}
}
