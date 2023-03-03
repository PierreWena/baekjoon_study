// 원글을 말한다.
// DTO를 할때는 select용 등등을 구분해야만 한다.

package jdbc.day05.board.Study3_3;

public class BoardDTO {  // BoardDTO 는 오라클의 tbl_board 테이블(tbl_member 테이블의 자식테이블)에 해당함.

	
	// field,  attribute,   property,  속성
	// 오라클에서 tbl_board 테이블 생성한 대로 가져와서 자바문법으로 변경 
	private int boardno;        //글번호
	private String fk_userid;   //작성자 아이디
	private String subject;     //글제목
	private String contents;    //글 내용
	private String writeday;    //작성일자 
	private int viewcount;      //조회수 
	private String boardpasswd; //글암호 
	
	////////////////////////////////////////////////////////////////////////////////////
	
	// select 용 //
	
	private MemberDTO member;   // tbl_board 테이블과 tbl_member 테이블을 JOIN 해오겠다.  글쓴이에 대한 모든 정보
								// MemberDTO member 은 오라클의 tbl_member 테이블(tbl_board 테이블의 부모테이블)에 해당함.
	
	// select 용 //
	// 조회수와 댓글의 개수는 다름
	// 원글에 달린 댓글의 개수를 보여주자 
	

	private int commentcnt;   // 원글에 달린 댓글의 개수
	
	/////////////////////////////////////////////////////////////////////////////////////
	// method, operation 기능 
	// getter, setter 부분 
	
	public int getBoardno() {
		return boardno;
	}

	public void setBoardno(int boardno) {
		this.boardno = boardno;
	}

	public String getFk_userid() {
		return fk_userid;
	}

	public void setFk_userid(String fk_userid) {
		this.fk_userid = fk_userid;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
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

	public int getViewcount() {
		return viewcount;
	}

	public void setViewcount(int viewcount) {
		this.viewcount = viewcount;
	}

	public String getBoardpasswd() {
		return boardpasswd;
	}

	public void setBoardpasswd(String boardpasswd) {
		this.boardpasswd = boardpasswd;
	}

	public MemberDTO getMember() {
		return member;
	}

	public void setMember(MemberDTO member) {
		this.member = member;
	}

	public int getCommentcnt() {
		return commentcnt;
	}

	public void setCommentcnt(int commentcnt) {
		this.commentcnt = commentcnt;
	}


	///////////////////////////////////////////////////////////////////////////////////
	
	// 게시판 글 목록보기 메소드 부분 
	public String showBoardTitle() {
		
		// 목표
		// 글번호\t글제목\t\t작성자명\t작성일자\t\t조회수
		
		if(subject != null && subject.length() > 10)   // subject 가 널이 아니고 10보다 크면은 실행한다.
		{
			// 글제목이 10 글자보다 크면 8 글자만 보여주고 뒤에 ".." 을 찍어준다.
			subject = subject.substring(0, 8) + "..";
			
		}
		
		if(commentcnt > 0)		// 댓글이 있다면은 
		{
			subject += "[" + commentcnt + "]";
		}
		
		String boardTitle = boardno + "\t" + subject + "\t\t" + member.getName() + "\t" + writeday + "\t" + viewcount;   // 전체를 출력하는 것을 boardTitle에 저장한다.
		
		return boardTitle;
	} // end of public String showBoarTitle() {

}
