package kr.ac.kopo.ui;

import java.util.List;

import kr.ac.kopo.LibServiceFactory;
import kr.ac.kopo.Service.LibService;
import kr.ac.kopo.vo.RentalBookVO;

public class AdminRentalInfo extends LibUI {

	private LibService libService;

	public AdminRentalInfo() {
		libService = LibServiceFactory.getInstance();

	}

	@Override
	public void execute() throws Exception {

		List<RentalBookVO> bookList = libService.adminRentalInfo();

		System.out.println("---------------------------------------------------------------------");
		System.out.println("\t\t현재 대여중인 책 ");
		System.out.println("---------------------------------------------------------------------");
		System.out.println("---------------------------------------------------------------------");
		System.out.printf("%-7s%-4s%-10s%-7s%-7s%-15s%-20s\n", "ID", "NO", "제목", "저자", "출판사", "대여일", "반납일");
		// 출력문 줄맞춤 나중에 수정하기
		System.out.println("---------------------------------------------------------------------");

		if (bookList == null || bookList.size() == 0) {
			System.out.println("\t\t 대여중인 책이 없습니다");
		} else {
			for (RentalBookVO book : bookList) {
				System.out.printf("%-7s%-4s%-8s%-7s%-7s%-15s%-20s\n", book.getUser_id(), book.getNo(), book.getName(),
						book.getWriter(), book.getPublisher(), book.getRental_date(), book.getReturn_date());

			}
		}
		System.out.println("---------------------------------------------------------------------");
	}

}
