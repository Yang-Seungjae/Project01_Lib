package kr.ac.kopo.ui;

import kr.ac.kopo.Service.LibService;
import kr.ac.kopo.vo.BookVO;

public class AddNewBookUI extends LibUI {

	private LibService libService;

	public AddNewBookUI() {
		libService = new LibService();

	}

	@Override
	public void execute() throws Exception {

		String name = scanStr("등록할 책 제목을 입력하세요 : ");
		String writer = scanStr("글쓴이를 입력하세요 : ");
		String publisher = scanStr("출판사를 입력하세요 : ");

		BookVO book = new BookVO();
		book.setName(name);
		book.setWriter(writer);
		book.setPublisher(publisher);

		libService.insertLibBook(book);

		System.out.println("새책 등록이 완료했습니다");

	}

}
