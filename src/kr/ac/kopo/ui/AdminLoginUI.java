package kr.ac.kopo.ui;

import kr.ac.kopo.Service.LibService;

public class AdminLoginUI extends LibUI {

private LibService libService;
	
	
	public AdminLoginUI() {
		libService = new LibService();
		
	}
	
	@Override
	public void execute() throws Exception {
		
		while(true) {
			String id = "admin";
			String password = scanStr("비밀번호를 입력하세요 :");
			int no = libService.login(id, password);
			
			
			if( no == 0 ) { 
				System.out.println("잘못입력하셨습니다 다시입력하세요");
			} else {
				
				System.out.println("로그인 되었습니다");
				LoginUI.isLogin = true;
				LoginUI.userID = "admin";

				break;
			}
		}
		
		super.execute();
		
		
		
	}

}
