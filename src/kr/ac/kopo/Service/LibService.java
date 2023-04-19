package kr.ac.kopo.Service;

import java.time.LocalDate;
import java.util.List;

import kr.ac.kopo.dao.LibDAO;
import kr.ac.kopo.vo.BookVO;
import kr.ac.kopo.vo.MemberVO;


public class LibService {
	
	private LibDAO libdao;
	
	public LibService() {
		libdao = new LibDAO();
	}

	public void insertLibMember(MemberVO member) {

		libdao.insertLibMember(member);
	}

	public void insertLibBook(BookVO book) {

		libdao.insertLibBook(book);
	}

	public int login(String id , String password) {
		
		return libdao.login(id, password);
		
	}
	
	public void updatePassword(String id, String password2) {
		
		libdao.updatePassword(id, password2);
	}
	
	public void deleteUser(String id) {
		
		libdao.deleteUser(id);
		
	}
	
	public List<BookVO> searchBook(String search, String detail) {
		
		List<BookVO> bookList = libdao.searchBook(search, detail);
		return bookList;
		
	}
	
	public LocalDate rentalBook(int no, LocalDate date) throws Exception {
		
		return libdao.rentalBook(no, date);
		
		
	}
	public List<BookVO> rentalInfo(String id){// 집에서 만듬 확인 필요
		
		return libdao.rentalInfo(id);
		
	}
	
	public void returnBook(int no) {
		
		libdao.returnBook(no);
	}
	

	
	
}
