package kr.ac.kopo.ui;

import java.util.List;
import java.util.Scanner;

import kr.ac.kopo.LibServiceFactory;
import kr.ac.kopo.Service.LibService;
import kr.ac.kopo.vo.BookVO;

public class SearchBookUI extends LibUI {

	private LibService libService;
	private String search;
	private String detail;

	public SearchBookUI() {
		libService = LibServiceFactory.getInstance();
	}

	private int menu() {
		System.out.println("---------------------------------------------------------------------");
		System.out.println("\t\t도서검색 프로그램을 실행합니다");
		System.out.println("---------------------------------------------------------------------");
		System.out.println("1.제목으로 검색");
		System.out.println("2.저자로 검색");
		System.out.println("3.출판사로 검색");
		System.out.println("4.도서번호로 검색"); // 나중에 관리자쪽으로 빼기
		System.out.println("5.전체 도서 검색");
		System.out.println("0.이전화면으로");
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
			switch (type) {

			case 1:
				search = "name";
				detail = scanStr("검색할 제목을 입력하세요 : ");
				break;
			case 2:
				search = "writer";
				detail = scanStr("검색할 저자를 입력하세요 : ");
				break;
			case 3:
				search = "publisher";
				detail = scanStr("검색할 출판사를 입력하세요 : ");
				break;
			case 4: // 집에서 만듬 확인 필요
				search = "no";
				detail = scanStr("검색할 도서번호를 입력하세요 : ");
				break;
			case 5:
				search = "all";
				detail = "1";
				break;
			case 0:
				super.execute();
				break;

			}

			List<BookVO> bookList = libService.searchBook(search, detail);

			System.out.println("---------------------------------------------------------------------");
			System.out.printf("%-8s%-7s%-7s%-7s\n", "NO", "제목", "저자", "출판사");
			// 출력문 줄맞춤 나중에 수정하기
			System.out.println("---------------------------------------------------------------------");

			if (bookList == null || bookList.size() == 0) {
				System.out.println("\t\t검색하신 책이 존재하지 않습니다");
			} else {
				for (BookVO book : bookList) {
					System.out.println(book.getNo() + "     " + book.getName() + "\t" + book.getWriter() + "\t"
							+ book.getPublisher() + "\t");
				}
			}
			System.out.println("---------------------------------------------------------------------");
		}

	}

}
