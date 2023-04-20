package kr.ac.kopo.ui;

import java.time.LocalDate;

import kr.ac.kopo.LibServiceFactory;
import kr.ac.kopo.Service.LibService;

public class RentalBookUI extends LibUI {

	private LibService libService;

	public RentalBookUI() {
		libService = LibServiceFactory.getInstance();

	}

	@Override
	public void execute() throws Exception {

		LocalDate date = LocalDate.now();
		int no = scanInt("대여할 책 번호를 입력하세요 : ");

		LocalDate returndate = libService.rentalBook(no, date);
		System.out.println("대여 완료\t" + returndate + "까지 반납해주세요");

	}
}
