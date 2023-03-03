// 댓글 부분에 해당 

package jdbc.day05.board.Study3_3;

public class CommentDTO {  // CommentDTO 는 오라클의 tbl_comment 테이블(tbl_member 테이블과 tbl_board 테이블의 자식테이블)에 해당함.

	// field,  attribute,   property,  속성
	// 오라클에서 tbl_comment 테이블 생성한 대로 가져와서 자바문법으로 변경 
	private int commentno;          //댓글번호
	private int fk_boardno;      //원글의 글번호
	private String fk_userid;       //작성자 아이디 
	private String contents ;       //댓글 내용
	private String writeday;        //작성일자 
	
	
	// select 용 //
	private MemberDTO member;   // tbl_comment 테이블과 tbl_member 테이블을 JOIN 해오겠다.  글쓴이에 대한 모든 정보
								// MemberDTO member 은 오라클의 tbl_member 테이블(tbl_comment 테이블의 부모테이블)에 해당함.

	
	//////////////////////////////////////////////////////////////////////////////////////////
	// method, operation 기능 
	// getter, setter


	public int getCommentno() {
		return commentno;
	}


	public void setCommentno(int commentno) {
		this.commentno = commentno;
	}


	public int getFk_boardno() {
		return fk_boardno;
	}


	public void setFk_boardno(int fk_boardno) {
		this.fk_boardno = fk_boardno;
	}


	public String getFk_userid() {
		return fk_userid;
	}


	public void setFk_userid(String fk_userid) {
		this.fk_userid = fk_userid;
	}


	public String getContents() {
		return contents;
	}


	public void setContents(String contents) {
		this.contents = contents;
	}


	public String getWriteday() {
		return writeday;
	}


	public void setWriteday(String writeday) {
		this.writeday = writeday;
	}


	public MemberDTO getMember() {
		return member;
	}


	public void setMember(MemberDTO member) {
		this.member = member;
	}


	///////////////////////////////////////////////////////////////////////
	// 댓글내용 등을 나타내는 메소드 
	public String viewCommentInfo() {
		// 댓글내용\t\t작성자명\t작성일자

		return contents + "\t\t" + member.getName() + "\t" + writeday;
	}

	////////////////////////////////////////////////////////////////////////////
	
	
	
	
}
