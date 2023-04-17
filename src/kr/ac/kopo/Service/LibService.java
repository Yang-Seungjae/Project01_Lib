package kr.ac.kopo.Service;

import kr.ac.kopo.dao.LibDAO;
import kr.ac.kopo.vo.MemberVO;


public class LibService {
	
	private LibDAO libdao;
	
	public LibService() {
		libdao = new LibDAO();
	}
	
	public void insertLibMember(MemberVO member) {
		
		libdao.insertLibMember(member);
	}
	
	
}
