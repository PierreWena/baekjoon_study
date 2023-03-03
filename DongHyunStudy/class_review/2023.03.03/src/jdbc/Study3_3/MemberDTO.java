// 회원 부분에 해당 

package jdbc.day05.board.Study3_3;

/*
	=== DTO(Data Transfer Object, 데이터전송(운반)객체)===
	쉽게 말해서 DTO는 테이블의 1개 행(ROW)을 말한다.
	어떤 테이블에 데이터를 insert 하고자 할때 DTO에 담아 보낸다.
	또한 어떤 테이블에서 데이터를 select 하고자 할때도 DTO에 담아서 읽어온다.
*/


public class MemberDTO {    // MemberDTO 는 
	                        // 오라클의 tbl_board 테이블과 tbl_comment 테이블의 부모테이블인 tbl_member 테이블에 해당함.

	// field, attribute, property, 속성
	// 오라클에서 tbl_member 을 자바 문법으로 변경해서 나타낸다.
	
	private int userseq;// 회원번호
	private String userid;       // 회원아이디
	private String passwd;       // 회원비밀번호
	private String name;         //회원명
	private String mobile;       //연락처
	private int point;        //포인트
	private String registerday;  //가입일자
	private int status;      //status 컬럼의 값이 1 이면 가입된 상태, 0 이면 탈퇴
	
	// method, operation, 기능
	public int getUserseq() {
		return userseq;
	}
	
	
	public void setUserseq(int userseq) {
		this.userseq = userseq;
	}
	
	
	public String getUserid() {
		return userid;
	}
	
	
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	
	public String getPasswd() {
		return passwd;
	}
	
	
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	
	public String getName() {
		return name;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getMobile() {
		return mobile;
	}
	
	
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	
	public int getPoint() {
		return point;
	}
	
	
	public void setPoint(int point) {
		this.point = point;
	}
	
	
	public String getRegisterday() {
		return registerday;
	}
	
	
	public void setRegisterday(String registerday) {
		this.registerday = registerday;
	}
	
	
	public int getStatus() {
		return status;
	}
	
	
	public void setStatus(int status) {
		this.status = status;
	}
	
	///////////////////////////////////////////////////////////////////
	
	// 4번 내 정보 보기 를 위해 작성 
	@Override
	public String toString() {  // 모든 클래스의 부모 클래스는 object
		
		return "=== 나의 정보 ===\n"
			 + "◇ 성명 : "+ name +"\n"
			 + "◇ 연락처 : "+ mobile +"\n"
			 + "◇ 포인트 : "+ point +"\n"
			 + "◇ 가입일자 : "+ registerday +"\n";
		
	}

}
