package kr.ac.kopo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.ui.LibUI;
import kr.ac.kopo.ui.LoginUI;
import kr.ac.kopo.util.ConnectionFactory;
import kr.ac.kopo.vo.BookVO;
import kr.ac.kopo.vo.MemberVO;
import kr.ac.kopo.vo.RentalBookVO;

public class LibDAO {

	public LibDAO() {

	}

	public void insertLibMember(MemberVO member) {

		StringBuilder sql = new StringBuilder();
		sql.append("insert into t_member(id, password, name, birth, email, phone) ");
		sql.append(" values(?, ?, ?, ?, ?, ? ) ");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {

			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getBirth());
			pstmt.setString(5, member.getEmail());
			pstmt.setString(6, member.getPhone());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public boolean equalsID(String id) {

		StringBuilder sql = new StringBuilder();
		String id1 = null;
		sql.append("select id from t_member ");
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				ResultSet rs = pstmt.executeQuery();) {
			while (rs.next()) {
				id1 = rs.getString("id");
				if (id1.equals(id)) {
					return true;

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean equalsEmail(String email) {

		StringBuilder sql = new StringBuilder();
		String email1 = null;
		sql.append("select email from t_member ");
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				ResultSet rs = pstmt.executeQuery();) {
			while (rs.next()) {
				email1 = rs.getString("email");
				if (email1.equals(email)) {
					return true;

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean equalsPhone(String phone) {

		StringBuilder sql = new StringBuilder();
		String phone1 = null;
		sql.append("select phone from t_member ");
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				ResultSet rs = pstmt.executeQuery();) {
			while (rs.next()) {
				phone1 = rs.getString("phone");
				if (phone1.equals(phone)) {
					return true;

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public int login(String id, String password) {

		StringBuilder sql = new StringBuilder();
		sql.append("select count(*) as cnt from t_member where id = ? and password = ?");

		try (
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				) {
			
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int cnt = rs.getInt("cnt");
				if(cnt > 0 ) {
					return 1;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;

	}

	public void updatePassword(String id, String password2) {

		StringBuilder sql = new StringBuilder();
		sql.append("update t_member set password = ? where id = ? ");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {

			pstmt.setString(1, password2);
			pstmt.setString(2, id);

			
			pstmt.executeUpdate(); // 집에서 수정함 확인필요
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteUser(String id) {
		
		StringBuilder sql = new StringBuilder();
		sql.append("delete from t_member where id = ? ");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {

			pstmt.setString(1, id);

			pstmt.executeUpdate(); // 집에서 수정함 확인필요
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void insertLibBook(BookVO book) {

		StringBuilder sql = new StringBuilder();
		sql.append("insert into t_book(no, name, writer, publisher ) ");
		sql.append(" values(seq_t_book_no.nextval, ?, ?, ? ) ");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {

			pstmt.setString(1, book.getName());
			pstmt.setString(2, book.getWriter());
			pstmt.setString(3, book.getPublisher());
			
			
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public List<BookVO> searchBook(String search, String detail) {

		List<BookVO> bookList = new ArrayList<>();

		StringBuilder sql = new StringBuilder();
		sql.append(
				"select * from t_book where instr(");
		sql.append(search);
		sql.append(", ?) != 0 ");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
				
				pstmt.setString(1, detail);
				ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int no = rs.getInt("no");
				String name = rs.getString("name");
				String writer = rs.getString("writer");
				String publisher = rs.getString("publisher");
				

				BookVO book = new BookVO(no, name, writer, publisher);


				bookList.add(book);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return bookList;
	}
	
	public LocalDate rentalBook(int no, LocalDate date) throws Exception {
		
		
		
		StringBuilder sql = new StringBuilder();
	    sql.append("insert into t_rental_list(rental_no, user_id, book_no, rental_date, return_date) ");
	    sql.append("values(seq_t_rental_list.nextval, '");
	    sql.append(LoginUI.userID);
	    sql.append("', ");
	    sql.append(no);
	    sql.append(", '");
	    sql.append(date);
	    sql.append("', '");
	    sql.append(date.plusWeeks(2));
	    sql.append("')");

	    try (Connection conn = new ConnectionFactory().getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
	        pstmt.executeUpdate();
	    } catch (Exception e) {
	    	System.out.println("------------------------------------------");
	    	System.out.println("\t   이미 대여중인 책입니다");
			System.out.println("------------------------------------------");
	        LibUI libui = new LibUI();
	        libui.execute();
	    }

	    return date.plusWeeks(2);
	}
	
	public List<RentalBookVO> rentalInfo(String id) {// 집에서 만듬 확인 필요

		List<RentalBookVO> bookList = new ArrayList<>();

		StringBuilder sql = new StringBuilder();
		sql.append("select no, name, writer, publisher, user_id, to_char(rental_date, 'yyyy-mm-dd') as rental_date, to_char(return_date, 'yyyy-mm-dd') as return_date from t_rental_list m1 join t_book m2 on m2.no = m1.book_no and user_id = ? ");
		
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
				
				pstmt.setString(1, id);
				ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int no = rs.getInt("no");
				String name = rs.getString("name");
				String writer = rs.getString("writer");
				String publisher = rs.getString("publisher");
				String rental_date = rs.getString("rental_date");
				String return_date = rs.getString("return_date");
				
				

				RentalBookVO rentalbook = new RentalBookVO(no, name, writer, publisher, rental_date, return_date);


				bookList.add(rentalbook);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return bookList;
	}
	
	public List<RentalBookVO> adminRentalInfo() {
		List<RentalBookVO> bookList = new ArrayList<>();

		StringBuilder sql = new StringBuilder();
		sql.append("select no, name, writer, publisher, user_id, to_char(rental_date, 'yyyy-mm-dd') as rental_date, to_char(return_date, 'yyyy-mm-dd') as return_date from t_rental_list m1 join t_book m2 on m2.no = m1.book_no  ");
		
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
				
				
				ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int no = rs.getInt("no");
				String name = rs.getString("name");
				String writer = rs.getString("writer");
				String publisher = rs.getString("publisher");
				String rental_date = rs.getString("rental_date");
				String return_date = rs.getString("return_date");
				String user_id = rs.getString("user_id");
				
				

				RentalBookVO rentalbook = new RentalBookVO(no, name, writer, publisher, rental_date, return_date, user_id);


				bookList.add(rentalbook);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return bookList;
	}
	
	public boolean deleteEqualsID(String id) {

		StringBuilder sql = new StringBuilder();
		String id1 = null;
		sql.append("select user_id from t_rental_list where user_id = ? ");
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				) {
				pstmt.setString(1, id);
				ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				id1 = rs.getString("user_id");
				if (id1.equals(id)) {
					return true;

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	

	public void returnBook(int no) {// 집에서 만듬 확인 필요
		
		StringBuilder sql = new StringBuilder();
		sql.append("delete from t_rental_list where book_no = ? ");
		
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {

			pstmt.setInt(1, no);

			pstmt.executeUpdate(); // 집에서 수정함 확인필요
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
