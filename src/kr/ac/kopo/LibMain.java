package kr.ac.kopo;

import kr.ac.kopo.ui.LibUI;

public class LibMain {

	public static void main(String[] args) throws Exception {

		try {
			new LibUI().execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
