package kr.ac.kopo.ui;

import kr.ac.kopo.LibServiceFactory;
import kr.ac.kopo.Service.LibService;

public class ReturnBookUI extends LibUI {
	
	private LibService libService;

	public ReturnBookUI() {
		libService = LibServiceFactory.getInstance();

	}

	@Override
	public void execute() throws Exception {
		
		int no = scanInt("반납할 책 번호를 입력하세요 : ");
		
		libService.returnBook(no);
		System.out.println("------------------------------------------");
		System.out.println(no + "번 책의 반납이 완료되었습니다");
		System.out.println("------------------------------------------");
	}

}
