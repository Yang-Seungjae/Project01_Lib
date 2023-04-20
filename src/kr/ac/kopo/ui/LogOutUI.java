package kr.ac.kopo.ui;

public class LogOutUI extends LibUI {

	@Override
	public void execute() throws Exception {
		
		LoginUI.isLogin = false;
		LoginUI.userID = "";
		super.execute();

	}

}
