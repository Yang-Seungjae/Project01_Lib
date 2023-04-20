package kr.ac.kopo.vo;

public class RentalBookVO {
	
	private int no;
	private String name;
	private String writer;
	private String publisher;
	private String rental_date;
	private String return_date;
	private String user_id;
	
	
	
	public RentalBookVO(int no, String name, String writer, String publisher, String rental_date, String return_date) {
		super();
		this.no = no;
		this.name = name;
		this.writer = writer;
		this.publisher = publisher;
		this.rental_date = rental_date;
		this.return_date = return_date;
	}
	public RentalBookVO(int no, String name, String writer, String publisher, String rental_date, String return_date,
			String user_id) {
		super();
		this.no = no;
		this.name = name;
		this.writer = writer;
		this.publisher = publisher;
		this.rental_date = rental_date;
		this.return_date = return_date;
		this.user_id = user_id;
	}
	/**
	 * @return the user_id
	 */
	public String getUser_id() {
		return user_id;
	}
	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	/**
	 * @return the no
	 */
	public int getNo() {
		return no;
	}
	/**
	 * @param no the no to set
	 */
	public void setNo(int no) {
		this.no = no;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the writer
	 */
	public String getWriter() {
		return writer;
	}
	/**
	 * @param writer the writer to set
	 */
	public void setWriter(String writer) {
		this.writer = writer;
	}
	/**
	 * @return the publisher
	 */
	public String getPublisher() {
		return publisher;
	}
	/**
	 * @param publisher the publisher to set
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	/**
	 * @return the rental_date
	 */
	public String getRental_date() {
		return rental_date;
	}
	/**
	 * @param rental_date the rental_date to set
	 */
	public void setRental_date(String rental_date) {
		this.rental_date = rental_date;
	}
	/**
	 * @return the return_date
	 */
	public String getReturn_date() {
		return return_date;
	}
	/**
	 * @param return_date the return_date to set
	 */
	public void setReturn_date(String return_date) {
		this.return_date = return_date;
	}
	
	public RentalBookVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
