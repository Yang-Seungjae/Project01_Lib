package kr.ac.kopo;

import kr.ac.kopo.Service.LibService;

public class LibServiceFactory {

	private static LibService service = null;
	
	public static LibService getInstance() {
		
		if(service == null) {
			service = new LibService();
		}
		
		return service;
	}
}