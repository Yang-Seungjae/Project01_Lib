package kr.ac.kopo.ui;

import java.util.List;

import kr.ac.kopo.LibServiceFactory;
import kr.ac.kopo.Service.LibService;
import kr.ac.kopo.vo.RentalBookVO;

public class UserRentalUI extends LibUI {// 집에서 만듬 확인 필요

	private LibService libService;

	public UserRentalUI() {
		libService = LibServiceFactory.getInstance();
	}

	@Override
	public void execute() throws Exception {

		String id = LoginUI.userID;

		List<RentalBookVO> bookList = libService.rentalInfo(id);

		System.out.println("---------------------------------------------------------------------");
		System.out.printf("%-8s%-8s%-7s%-7s%-15s%-20s\n", "NO", "제목", "저자", "출판사", "대여일", "반납일");
		// 출력문 줄맞춤 나중에 수정하기
		System.out.println("---------------------------------------------------------------------");

		if (bookList == null || bookList.size() == 0) {
			System.out.println("\t\t 대여하신 책이 없습니다");
		} else {
			for (RentalBookVO book : bookList) {
				System.out.println(book.getNo() + "\t" + book.getName() + "\t" + book.getWriter() + "\t"
						+ book.getPublisher() + "\t" + book.getRental_date() + "\t" + book.getReturn_date());
			}
		}
		System.out.println("---------------------------------------------------------------------");
	}

}
