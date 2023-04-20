package kr.ac.kopo.ui;

import kr.ac.kopo.Service.LibService;

public class DeleteBookUI extends LibUI {

	private LibService libService;

	public DeleteBookUI() {
		libService = new LibService();
		
	}

	@Override
	public void execute() throws Exception {

		int no = scanInt("삭제할 책 번호를 입력하세요 : ");
		
		libService.deleteLibBook(no);

		System.out.println("책 삭제를 완료했습니다.");

	}
}
