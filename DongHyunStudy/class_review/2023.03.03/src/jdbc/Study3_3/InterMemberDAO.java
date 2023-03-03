//DAO는 오라클 문을 처리해 주는 클래스이다.

package jdbc.day05.board.Study3_3;

import java.util.List;
import java.util.Map;

public interface InterMemberDAO {
	
	
	// 회원가입(insert) 메소드
	int memberRegister(MemberDTO member);
	
	// 로그인처리(select) 메소드 
	MemberDTO login(Map<String, String> paraMap);

	// 회원탈퇴(update) 메소드
	int deleteMember(int userseq);

	// 회원정보조회(select) 메소드
	List<MemberDTO> showAllMember(String sortChoice);
	
	// 회원명으로조회조회(select) 메소드
	List<MemberDTO> searchMemberByName(String searchName);

}
