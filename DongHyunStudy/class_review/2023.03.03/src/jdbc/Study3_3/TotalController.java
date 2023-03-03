package jdbc.day05.board.Study3_3;

import java.text.SimpleDateFormat;
import java.util.*;

import util.MyUtil;

public class TotalController implements InterTotalController {

	// field
	
	InterMemberDAO mdao = new MemberDAO();  // 인터페이스 로 가도록 // 회원부분
	InterBoardDAO bdao = new BoardDAO();    // 게시판 부분 
	
	
	
	//method
	
	
	
	// 시작 메뉴 메소드 구현(생성)하기 (재정의)
	@Override
	public void menu_Start(Scanner sc) {
		
		// == 시작메뉴를 보여주는 메소드 구현(생성)하기 ==
					
		MemberDTO member = null;
		
		String s_Choice = "";
		
		do {       							 // 3번이라면 탈출
			String loginName = "";
			String login_logout = "로그인";
			String menu_add = "";
			
			if(member != null) {						// 회원정보가 존재한다면 
				loginName = "["+ member.getName() +" 로그인중.. 포인트: "+ member.getPoint() +"점]";
				login_logout = "로그아웃";
				menu_add = "4.나의정보보기   5.게시판가기    ";
				
				if ("admin".equals(member.getUserid()))      // 아이디가 admin 이면 관리자 모드 실행한다. ( MemberDAO에 member.setUserid(rs.getString("USERID"));을 추가해야 한다.
				{
					menu_add += "6. 관리자전용(모든회원정보조회)";   // 메뉴에 추가한다. 
				}
			}
			
			System.out.println("\n>>> ----- 시작메뉴 "+loginName+" ----- <<<\n"
							  +"1. 회원가입	2."+login_logout+"		3. 프로그램종료\n"
							  + menu_add 
							  +"\n---------------------------------------------------------------------\n");
			System.out.print("▷ 메뉴번호 선택 : ");
			s_Choice = sc.nextLine();
			
			
			switch (s_Choice) {
			case "1": // 회원가입
				memberRegister(sc);
				break;
				
			case "2": // 로그인 OR 로그아웃
				if("로그인".equals(login_logout)){// 로그인 시도하기
					member = login(sc);
				}
				else{// 로그아웃 하기
					member = null;
					System.out.println(">>> 로그아웃 되었습니다. <<<\n");
				}
				break;
			case "3": // 프로그램 종료
				
				MyDBConnection.closeConnection();  //MyDBConnection 에 객체 자원 반납하기 메소드 실행 
				                                   // Connection 객체 자원반납 
				break;
				
			case "4": // 나의정보보기
				 if(member != null)
				 {
					 // System.out.println(member.toString());
					 // 또는
					 System.out.println(member);
					 break;
				 }
				
			case "5": // 게시판가기
				if(member != null)
				 {	 
					menu_Board(member, sc);    // 게시판 메뉴에 들어간다  현재 로그인 되어진 사란과 scanner를 넘긴다.
					
					break;
				 }
				
			case "6": // 관리자전용(모든회원정보조회)
				if(member != null && "admin".equals(member.getUserid()))
				 {
					 System.out.println("▷ 정렬 [1. 회원명의 오름차순  2.회원명의 내림차순  3. 가입일자의 오름차순  4. 가입일자의 내림차순]");
					 
					 System.out.print("정렬번호 선택 : ");
					 String sortChoice = sc.nextLine();     // 키보드로 받아온값 sortChoice 에 저장 
					 
					 showAllMember(sortChoice);
					 
					 break;
				 }
			 
			default:
				System.out.println(">>> 메뉴에 없는 번호 입니다. 다시 선택하세요!! <<<\n");
				break;
			}//end of switch
			
		}while(!("3".equals(s_Choice)));
		
	}  // end of public void menu_Start(Scanner sc) {


	// *** 회원가입 해주는 메소드 *** //
	private void memberRegister(Scanner sc) {
		
		System.out.println("\n >>> ----- 회원가입 ----- <<<");
		
		System.out.print("1. 아이디 : ");
		String userid = sc.nextLine();
		
		System.out.print("2. 비밀번호 : ");
		String passwd = sc.nextLine();
		
		System.out.print("3. 회원명 : ");
		String name = sc.nextLine();
		
		System.out.print("4. 연락처(휴대폰) : ");
		String mobile = sc.nextLine();
		
		MemberDTO member = new MemberDTO();
		member.setUserid(userid);
		member.setPasswd(passwd);
		member.setName(name);
		member.setMobile(mobile);
		
		
		String yn = "";
		
		do 
		{
			System.out.print(">> 정말로 회원가입을 하시겠습니까?[Y/N] : ");
			yn = sc.nextLine();
			
			if("y".equalsIgnoreCase(yn))			//y일때 
			{
				int n = mdao.memberRegister(member);   // 회원가입을 한다 
				
				if(n==1) {		// 정상적이라면 1이므로 회원가입 완료 
					System.out.println("\n >>>> 회원가입을 축하드립니다.<<<<");
				}
				else {
					System.out.println("\n >>>> 회원가입을 실패 되었습니다.<<<<");
				}
				
			}
			else if("n".equalsIgnoreCase(yn))		//n일때 
			{
				System.out.println(">> 회원가입을 취소하셨습니다. << \n");
			}
			else									//y,n이 아닐때 
			{
				System.out.println(">> Y 또는 N 만 입력하세요 !! << \n");
			}
			
		} while ( !("y".equalsIgnoreCase(yn) || "n".equalsIgnoreCase(yn)));  // y나 n이라면 탈출한다.
		
	}// end of private void memberRegister(Scanner sc)
	
	
	// *** 로그인 해주는 메소드 *** ///
	private MemberDTO login(Scanner sc) {
		
		
		MemberDTO member = null;
		
		System.out.println("\n >>> --- 로그인 --- <<<");
		
		System.out.print("1. 아이디 : ");
		String userid = sc.nextLine();
		
		System.out.print("2. 비밀번호 : ");
		String passwd = sc.nextLine();
		
		Map<String, String> paraMap = new HashMap<>();
		paraMap.put("userid", userid);
		paraMap.put("passwd", passwd);
		
		member = mdao.login(paraMap);   //DB에서 읽어온다.
		
		if(member != null) {
			System.out.println("\n>>> 로그인 성공 !!! <<<");
		}
		else {
			System.out.println("\n>>> 로그인 실패 ... <<<");
		}
		
		return member;
		
	} // end of private MemberDTO login(Scanner sc) {
	
	
	// *** 모든 회원을 조회해주는 메소드 *** //
	private void showAllMember(String sortChoice) {
		
		if("1".equals(sortChoice) || "2".equals(sortChoice) ||			// 1,2,3,4번을 입력했을때  
		   "3".equals(sortChoice) || "4".equals(sortChoice))
		{
			List<MemberDTO> memberList = mdao.showAllMember(sortChoice);  // 모든 회원을 가져온다.  리스트에 담아서 나타내줄것이다  DB에서 결과물을 땡겨온다.
			
			if(memberList.size() > 0)   // memberList 안에 정보가 1개라도 있다면 
			{
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("회원번호 아이디 회원명 연락처    포인트  가입일자      가입상태");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				
				StringBuilder sb = new StringBuilder();			// 스트링 빌더 사용 
			
				
				for(MemberDTO member : memberList)			// 확장 for문 
				{
					String status = (member.getStatus() == 1)?"가입중":"탈퇴";     // status의 경우 0과 1 만 나옴 )
					
					sb.append(member.getUserseq() + " " + 
							  member.getUserid() + " " + 
							  member.getName() + " " + 
							  member.getMobile() + " " + 
							  member.getPoint() + " " + 
							  member.getRegisterday() + " " + 
							  status + "\n");
				}
				System.out.println(sb.toString());
				
			}
			else			// memberList 안에 정보가 없으면 
			{
				System.out.println(">> 가입한 회원이 아무도 없습니다!! << \n");
			}
			
			
		}
		else      														// 1,2,3,4외 다른 번호를 입력했을때
		{
			System.out.println(">> 정렬에 없는 번호입니다 !! << \n");
		}
		
	} // end of private void showAllMember(String sortChoice) {
	
	
	
	// **** 게시판 메뉴 **** // 
	private void menu_Board(MemberDTO member, Scanner sc) {
		
		String s_menuNo = "";
		
		do {
			System.out.println("\n---------------- 게시판 메뉴 ["+ member.getName() + "님 로그인 중.. 포인트: "+ member.getPoint() +"점] ----------------\n"
								+ "1. 글목록보기   2. 글내용보기   3. 글쓰기   4.댓글쓰기  \n"
								+ "5. 글수정하기   6. 글삭제하기   7. 최근 1주일간 일자별 게시글 작성건수 \n"
								+ "8. 이번달 일자별 게시글 작성건수  9. 나가기 \n"
								+ "-------------------------------------------------------------------------------");
			
			System.out.print("▷ 메뉴번호 선택 : ");
			s_menuNo = sc.nextLine();
			
			switch (s_menuNo) {
			case "1":    // 글목록보기
				boardList();   //글 목록 을 조회하는 메소드 연결 
				break;  
				
			case "2":    // 글내용보기
				viewContents(member.getUserid(), sc);
				break;
				
			case "3":    // 글쓰기(tbl_board 테이블에 insert + tbl_member 테이블의 point 컬럼이 10점씩 증가 (update))
				/*
				  	글쓰기는 tbl_board 테이블에 insert가 성공되어지먄 
				  	tbl_member 테이블에서 글을 작성한 사용자의 point 컬럼의 값을 10씩 증가(update) 시켜주겠다.
				  	
				  	둘다 성공이 되어야만 commit이 되어야지 하나만 성공이라고 commmit 하면 오류가 발생하므로 
				  	하나라도 성공이 안된다면 rollback을 시켜애 한다.
				  	즉 Transaction(트랜잭션) 처리 해야한다. 
				  	
				  	
				  	-- *** Transaction(트랜잭션) 처리 *** --
                       --> Transaction(트랜잭션)이라 함은 관련된 일련의 DML로 이루어진 한꾸러미(한세트)를 말한다.
                       --> Transaction(트랜잭션)이라 함은 데이터베이스의 상태를 변환시키기 위하여 논리적 기능을 수행하는 하나의 작업단위를 말한다.        
                  
                  	Transaction(트랜잭션) 처리에서 가장 중요한 것은 
                                           모든 DML문이 성공해야만 최종적으로 모두 commit 을 해주고,
                       DML문중에 1개라도 실패하면 모두 rollback 을 해주어야 한다는 것이다.
                       
                       
                       그렇기 때문에 우리는 auto commit 을 사용하지 않고 수동 commit을 했다
				*/
				
				// 우리는 3번째 글은 못쓰게 해보겠다.
				
				// write 라는 메소드를 만들어서 사용하겠다. 
				// 파라미터 순서는 전혀 상관이 없다.
				int n =  write(member, sc);    //글쓴 사람도 알아야하고 직접 키보드로 입력을 해야 하므로 member, sc를 넣는다.

				if(n == 1)    // 글을 썼다면 
				{
					System.out.println(">> 글쓰기 성공!! << \n");
					member.setPoint( member.getPoint() + 10 );  // 포인트를 실시간으로 올리기 위해 사용한다.
					/////////////////// ~~~~~~~~~~~~~~~~~~~~~~~~~ 기억하자 ~~~~~~~~~~~~~~~~~~~~~~~ //////////////////
				}
				else if(n == 0)   // 글을 쓰다가 취소했다면 
				{
					System.out.println(">> 글쓰기 취소하셨습니다. << \n");
				}
				else if(n == -1)   // 글을 쓰고싶은데 check 제약때문에 실패했을때 
				{
					System.out.println(">> 글쓰기 실패!! << \n");
				}
				break;
				
			case "4":    // 댓글쓰기
				n = writeComment(member, sc);   // writeComment 메소드 생성 및 호출 // 식별자가 필요하기 때문에 member를 넘긴다. // n은 int 
				// 사용자가 다른 사용자가 쓴 원글에 댓글쓰기를 하면 포인트 점수를 5점씩 증가하도록 하겠습니다.
				
				if(n==1)
				{
					System.out.println(">> 댓글 쓰기 성공!!! << \n");
				}
				else
				{
					System.out.println(">> 댓글쓰기 실패 !! << \n");
				}
				
				break;
				
			case "5":    // 글수정하기
				n = updateBoard(member, sc);   // writeComment 메소드 생성 및 호출 // 식별자가 필요하기 때문에 member를 넘긴다. // n은 int 
				// 사용자가 다른 사용자가 쓴 원글에 댓글쓰기를 하면 포인트 점수를 5점씩 증가하도록 하겠습니다.
				
				if(n==1)
				{
					System.out.println(">> 글 수정 성공!!! << \n");
				}
				else
				{
					System.out.println(">> 글 수정 실패 !! << \n");
				}
				
				break;
				
			case "6":    // 글삭제하기 
				n = deleteBoard(member, sc);   // writeComment 메소드 생성 및 호출 // 식별자가 필요하기 때문에 member를 넘긴다. // n은 int 
				// 사용자가 다른 사용자가 쓴 원글에 댓글쓰기를 하면 포인트 점수를 5점씩 증가하도록 하겠습니다.
				
				if(n==1)
				{
					System.out.println(">> 글 삭제 성공!!! << \n");
				}
				else
				{
					System.out.println(">> 글 삭제 실패 !! << \n");
				}
				
				break;
				
			case "7":    // 최근 1주일간 일자별 게시글 작성건수
				
				StatisticsByweek();
				break;
				
			case "8":    // 이번달 일자별 게시글 작성건수 
				
				StatisticsByCurrentMonth();
				break;
				 
			case "9":    // 나가기
				
				break;

			default:     // 1~9 번 외에 다른 값을 받았을때 
				System.out.println(">> 메뉴에 없는 번호 입니다. << \n");
				break;
			} // end of switch
			
		} while( !("9".equals(s_menuNo) ));
		
		
		
		
	} // end of private void menu_Board(MemberDTO member, Scanner sc) {


	// **** 게시판 글쓰기 ( tbl_board 테이블에 insert + tbl_member 테이블에 point 컬럼에 10씩 update) **** //
					// ==== Transaction 처리 ==== //
	private int write(MemberDTO member, Scanner sc) {
		
		int result = 0;
		
		System.out.println("\n>>> 글쓰기 <<<");
		System.out.println("1. 작성자명 : " + member.getName());     // 작성자명에 지금 로그인 되어있는 사람을 나타냄
		
		System.out.print("2. 글제목 : ");
		String subject = sc.nextLine();
		
		System.out.print("3. 글내용 : ");
		String contents = sc.nextLine();
		
		System.out.print("4. 글암호 : ");
		String boardpasswd = sc.nextLine();
		
		String yn = "";
		
		do 
		{
			System.out.print(">> 정말로 글쓰기를 하시겠습니까?[Y/N] : ");
			yn = sc.nextLine();
			
			if("y".equalsIgnoreCase(yn))			//y일때 
			{
				//boardDTO로감
				BoardDTO bdto = new BoardDTO();
				
				bdto.setFk_userid(member.getUserid());
				bdto.setSubject(subject);		   // 글제목
				bdto.setContents(contents);   	   // 글내용
				bdto.setBoardpasswd(boardpasswd);  // 글비번
				
				
				result = bdao.write(bdto);  // 1 또눈 -1 
			
				
			}
			else if("n".equalsIgnoreCase(yn))		//n일때 
			{
				
			}
			else									//y,n이 아닐때 
			{
				System.out.println(">> Y 또는 N 만 입력하세요 !! << \n");
			}
			
		} while ( !("y".equalsIgnoreCase(yn) || "n".equalsIgnoreCase(yn)));  // y나 n이라면 탈출한다.
		
		
		
		return result;
	} // end of private int write(MemberDTO member, Scanner sc) {
	
	
	// **** 글 목록 보기 **** //
	private void boardList() {
		
		List<BoardDTO> boardList = bdao.boardList();    // 보드 리스트를 만들어줌  보여줄것은 BoardDTO 
		
		if(boardList.size() > 0)  // 게시물이 존재한다면 
		{
			System.out.println("\n---------------------------- [게시글 목록] -----------------------------");
			System.out.println("글번호\t글제목\t\t\t작성자명\t작성일자\t\t\t조회수");                           /// 정보는 보드 테이블에 있다.그리고 다른 정보는 member 테이블에 있으므로 join해야한다.
			System.out.println("---------------------------------------------------------------------");
			
			StringBuilder sb = new StringBuilder();
			
			for(int i = 0; i < boardList.size() ; i++)    // 기본 for문 사용
			{
				sb.append( boardList.get(i).showBoardTitle() + "\n");    //    showBoardTitle() 메소드 
				//boardList.get(i) 이것이 BoardDTO 이다. 
			}
			
			System.out.println(sb.toString());   // 출력하기위해 
		}
		else   // 게시글이 한개도 존재하지 않는 경우
		{
			System.out.println(">> 글목록이 없습니다. << \n");
		}
		
	} // end of private void boardList() { 

	
	// **** 글 내용 보기 **** //
	private void viewContents(String userid, Scanner sc) {
		System.out.println("\n>>> 글내용 보기 <<<");
		
		System.out.print("▷ 글번호 : ");
		String boardno = sc.nextLine();
		
		BoardDTO bdto =  bdao.viewContents(boardno);    // 메소드 이름을 똑같이 함 (한 행을 방아야 하므로 BoardDTO)를 리턴 값으로 한다. 
														// 이것은 null값이 올 수 있다. 
														// 글번호가 없는 부분이 오면 당연히 게시판 글은 없으므로 null 값을 받을 수 있다.
		
		
		if(bdto != null) 	// 받아온 값이 null 이 아니라면 // null인 경우는 받아오기전 처리를 모두 완료한 상태임
		{
			//존재하는 글번호를 입력한 경우
			System.out.println("[글내용] " + bdto.getContents() );  // 글내용을 보여주기 위해 사용 
			
			// 현재 로그인 되어진 사용자가 자신의 글이 아닌 다른 사용자가 쓴 글을 조회했을 경우에만 
			// 조회수 1증가 시킨다(update를 이용한다.)
			if( !(bdto.getFk_userid().equals(userid)))		// 로그인 되어있는 계정과 다른 작성자인 경우에만 글 조회수를 올리기 위해 설정
			{
				bdao.updateViewContents(boardno);   // 업데이트를 하기 위해 메소드 생성하기  
			}
		}  // end of if
		
		/////////////////////////////////////////////////////////////////////////////////
		
		System.out.println("[댓글]\n----------------------------------------------------------");
		
		List<CommentDTO> commentList =  bdao.commentList(boardno);   // 댓글을 보기 위해 설정한다.( 존재하는 글 번호만 넘어간다 // 즉 null은 없음)
		// CommentDTO에 모든것을 설정했으므로 CommentDTO로 넘김 
		//*** 원글에 대한 댓글을 가져오는것을 말한다 (특정 게시글 글 번호에 대한 tbl_comments 테이블과 tbl_member 테이블을 JOIN 해서 보여준다. *** //
		
		if(commentList.size() > 0)	// 넘어온값이 있다면 // 즉 댓글이 존재하는 원글인 경우 
		{
			System.out.println("댓글내용\t\t작성자명\t작성일자");
			System.out.println("-----------------------------------------------------");
			
			StringBuilder sb = new StringBuilder();
			
			for(CommentDTO cmtdto: commentList) // 확장 for문
			{
				sb.append(cmtdto.viewCommentInfo() + "\n");		// 메소드 생성해서 불러오고 값을 스트링 빌더에 저장
			}//end of for
			
			System.out.println(sb.toString());  // 출력하기 
		}
		else						// 댓글이 존재하지 않는 경우 
		{
			System.out.println(">> 댓글 내용 없음 << \n");
		}
		
		///////////////////////////////////////////////////////////////////////////////////
				
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("이전글번호   이전글제목  현재글번호 \t  현재글제목 \t  다음글번호 \t  다음글제목");
		System.out.println("-------------------------------------------------------------------------");
		
		Map<String, String> Board_pre_next_Map =  bdao.Board_pre_next(boardno);  
		
		String result = Board_pre_next_Map.get("pre_no") + "\t" +
		Board_pre_next_Map.get("pre_name") + "\t" +
		Board_pre_next_Map.get("no") + "\t" +
		Board_pre_next_Map.get("name") + "\t" +
		Board_pre_next_Map.get("contents") + "\t" +
		Board_pre_next_Map.get("next_no") + "\t" +	
		Board_pre_next_Map.get("next_name");	
		
		
		System.out.println(result);

	} // end of private void viewContents(String userid, Scanner sc) {

	
	
	//*** 댓글쓰기 ***///
	private int writeComment(MemberDTO member, Scanner sc) {
		
		int result = 0;
		
		System.out.println("\n>>> 댓글쓰기 <<<");
		
		System.out.println("1. 작성자명 : " + member.getName());
		
		boolean bFlag = false;
		// bFlag의 값이 TRUE 이면 원글은 로그인한 사용자가 아닌 다른 사용자가 쓴 글임.
		// bFlag의 값이 False 이면 원글릉 로그인한 사용자가 쓴 글임 
		
		
		int n_boardno = 0;
		do		// 잘못 입력된 것을 방지하기 위해 
		{
			System.out.print("2. 원글의 글번호 : ");
			
			String boardno = sc.nextLine();		// 변수에 담아줌 만약 "홍길동" 또는 "2345"(없는 글 번호) 이렇게 쓰면은 안된다.
												// 위와 같이 존재하지 않는 원글의 글번호를 입력할 수 있다.
												// "2" 는 올바른 것 
			try
			{
				n_boardno = Integer.parseInt(boardno);   // 정수일때만 나가자 
				BoardDTO bdto = bdao.viewContents(boardno);  // 글내용보기 !!!! null 이면은 반복문을 빠져나가지 못함
				if(bdto != null)		// 값이 있다면 
				{
					if(!(bdto.getFk_userid().equals(member.getUserid()))) 		// 지금 로그인 사람과 원글 작성자가 같지 않다면   	
					{															
						bFlag = true;			// 다른 서럼이면 남이 쓴 글임
					}
					break;
				}
				else
				{
					System.out.println(">>글번호 " + n_boardno + "은 존재하지 않습니다. !! << ");
				}
			}
			
			catch(NumberFormatException e)
			{
				System.out.println(">> [경고] 원글의 글번호는 정수로만 입력하셔야 합니다 !! << \n");
			}
		} while(true);
		
		String contents = "";
		
		do
		{
			System.out.print("3. 댓글내용 : ");
			
			contents= sc.nextLine();
			
			/*
				댓글에 내용을 입력할때 그냥 엔터
				또는 공백만으로 입력하거나 
				또는 tbl_comment 테이블의 contents 컬럼의 크기(100글자)보다 더 많은 글자를 입력할 경우 가 생기므로 
				유효성 검사가 꼭 필요하다.
			*/
			
			// -----------> 글쓰기 부분도 원래 이 유효성 검사가 필요하지만 생략을 하고 댓글쓰기에만 해왔다. <--------------//
			if(contents.trim().isEmpty())		// 그냥 엔터 또는 공백만 입력하였을 경우 
			{
				System.out.println(">>[경고} 댓글 내용은 필수로 입력하셔야 합니다. << \n");
			}
			else if (contents.length() > 100)	// 글자 길이가 100이 초과 되었다면 
			{
				System.out.println(">>[경고] 댓글 내용은 최대 100글자 이내이여야 합니다. << \n");
			}
			else
			{
				break;  // do-while 문 탈출 
			}
			
		} while(true);
		
		
		// 정말 글 쓸것인지 확인하는 작업 
		String yn = "";	
		
		do 
		{
			System.out.println(">> 정말로 댓글쓰기를 하시겠습니까? [Y/N]");
			yn = sc.nextLine();
			
			if("y".equalsIgnoreCase(yn))			// y이라면 
			{
				CommentDTO cmtdto = new CommentDTO();  // 생성되어진 CommentDTO
				
				cmtdto.setFk_boardno(n_boardno);		// 원글의 글번호 
				cmtdto.setFk_userid(member.getUserid()); // 댓글을 작성하는 사용자 id
				cmtdto.setContents(contents);			 // 댓글 내용 
				
				result = bdao.writeComment(cmtdto, bFlag);	// 보내준다.  / 두번째 파라미터는 내가썼냐 남이썼냐를 구분하는것이다
															// bFlag의 값이 TRUE 이면 원글은 로그인한 사용자가 아닌 다른 사용자가 쓴 글임.
															// bFlag의 값이 False 이면 원글릉 로그인한 사용자가 쓴 글임 
				// result 가 정상이라면 1 또는 실패라면 -1
				
				if(result == 1)
				{
					member.setPoint(member.getPoint() +5 );  /// !!!!!! 꼭 기억하기 !!!!!!!!//
				}
								
				break;
			}
			else if("n".equalsIgnoreCase(yn))			// n이라면 
			{
				System.out.println(">> 댓글쓰기를 취소하셨습니다. << \n");
				break;
			}
			else				// Y와 N이 아니라면 실행 
			{
				System.out.println(">> [경고] Y 또는 N 만 입력하세여 << \n");
			}
			
		} while (true);
		
		
		return result;
	} // end of private int writeComment(String userid, Scanner sc) {
	
	
	// *** 글 수정 메소드 ***//
	private int updateBoard(MemberDTO member, Scanner sc) {
		
		int result = 0;
		
		System.out.println(">>> 글 수정하기 <<<");
		
		String boardno = "";
		
		do
		{
			System.out.print("▷ 수정할 글번호 : ");
			boardno = sc.nextLine();
			
			try
			{
				Integer.parseInt(boardno);
				break;
			}
			catch(NumberFormatException e)
			{
				System.out.println(">> [경고] 수정할 글번호는 숫자로만 입력하세요!! << \n");
			}
			
		}while(true);
		
		BoardDTO bdto = bdao.viewContents(boardno);		// 리턴타입은 BoardDTO 목록에 있는것을 확인하는 것이다. (boardno입력값이 목록에 있는지 확인)
		
		if(bdto != null) 
		{
			// 수정할 글번호가 글목록에 존재하는 경우
			if( !bdto.getFk_userid().equals(member.getUserid()))		// 수정할 글 번호가 다른 사용자가 쓴 글인 경우
			{
				System.out.println(">> [경고] 다른 사용자의 글은 수정 불가합니다!! << \n");
			}
			else														// 수정할 글 번호가 자신이 쓴 글인 경우 
			{
				System.out.print("▷ 글암호 : ");
				String boardpasswd = sc.nextLine();
				
				if(bdto.getBoardpasswd().equals(boardpasswd))			// 내가 입력한 암호와 데이터 베이스에 있는 암호가 있다면 실행한다. 
				{
					System.out.println("--------------------------------------------------------------------");
					System.out.println("[수정전 글제목] " + bdto.getSubject());			// boardDTO에 있는 글 제목을 가져온다
					System.out.println("[수정전 글내용] " + bdto.getContents());		// boardDTO에 있는 글 내용을 가져온다
					System.out.println("--------------------------------------------------------------------");
					
					System.out.print("▷ 글제목[변경하지 않으려면 엔터] : ");
					String subject = sc.nextLine();
					
					if(subject.trim().isEmpty())		// 공백이나 엔터라면 
					{
						subject =  bdto.getSubject();	// 예전것을 그대로 넣는다.
					}
					
					System.out.print("▷ 글내용[변경하지 않으려면 엔터] : ");
					String contents = sc.nextLine();
					
					if(contents.trim().isEmpty())		// 공백이나 엔터라면 
					{
						contents =  bdto.getContents();	// 예전것을 그대로 넣는다.
					}
					
					if(subject.length() > 100 || contents.length() > 200)
					{
						System.out.println(">> [경고] 글제목은 최대 100글자 이며, 글내용은 최대 200글자 이내야 합니다.<< \n");
					}
					else
					{	// 글 수정하기 
						Map<String, String> paraMap = new HashMap<>();		// 맵에다가 저장할 것이다 . 잘 기억하기 !!!!!!!!!!!!!!
						
						paraMap.put("boardno", boardno);	// 글 번호
						paraMap.put("subject", subject);	// 글 제목
						paraMap.put("contents", contents);	// 글 내용
						
						result = bdao.updateBoard(paraMap);   //result에 글 수정하기 저장한다. 
						//         1 은 글 수정이 성공된 경우 또는 글 수정을 하려고 하나 SQLException이 발생해 실패한 경우에는 -1 
					}
					
				}
				else													// 내가 입력한 암호와 데이터 베이스에 있는 암호가 없다면 실행한다. 
				{
					System.out.println(">> [경고] 입력하신 글암호가 작성시 입력한 글암호와 일치하지 않으므로 수정 불가합니다!! << \n");
				}
				
			}
		}
		else
		{
			// 수정할 글번호가 글목록에 존재하지 않는 경우
			System.out.println(">> 글번호 " + boardno + "글은 존재하지 않습니다!! << \n");
		}
			
		return result;
	}
	
	
	// *** 글 삭제하기 *** //
	private int deleteBoard(MemberDTO member, Scanner sc) {
		
		int result = 0;
		
		System.out.println(">>> 글 삭제하기 <<<");
		
		String boardno = "";
		
		do
		{
			System.out.print("▷ 삭제할 글번호 : ");
			boardno = sc.nextLine();
			
			try
			{
				Integer.parseInt(boardno);
				break;
			}
			catch(NumberFormatException e)
			{
				System.out.println(">> [경고] 삭제할 글번호는 숫자로만 입력하세요!! << \n");
			}
			
		}while(true);
		
		BoardDTO bdto = bdao.viewContents(boardno);		// 리턴타입은 BoardDTO 목록에 있는것을 확인하는 것이다. (boardno입력값이 목록에 있는지 확인)
		
		if(bdto != null) 
		{
			// 삭제할 글번호가 글목록에 존재하는 경우
			if( !bdto.getFk_userid().equals(member.getUserid()))		// 삭제할 글 번호가 다른 사용자가 쓴 글인 경우
			{
				System.out.println(">> [경고] 다른 사용자의 글은 삭제 불가합니다!! << \n");
			}
			else														// 삭제할 글 번호가 자신이 쓴 글인 경우 
			{
				System.out.print("▷ 글암호 : ");
				String boardpasswd = sc.nextLine();
				
				if(bdto.getBoardpasswd().equals(boardpasswd))			// 내가 입력한 암호와 데이터 베이스에 있는 암호가 있다면 실행한다. 
				{
					System.out.println("--------------------------------------------------------------------");
					System.out.println("[글제목] " + bdto.getSubject());			// boardDTO에 있는 글 제목을 가져온다
					System.out.println("[글내용] " + bdto.getContents());		// boardDTO에 있는 글 내용을 가져온다
					System.out.println("--------------------------------------------------------------------");
					
					// 정말 글 쓸것인지 확인하는 작업 
					String yn = "";	
					
					do 
					{
						System.out.print("▷ 정말로 글을 삭제하시겠습니까?[Y/N] : ");
						yn = sc.nextLine();
						
						if("y".equalsIgnoreCase(yn) || "n".equalsIgnoreCase(yn))	// Y 또는 N 이라면 
						{
							break;
						}
						else				// Y와 N이 아니라면 실행 
						{
							System.out.println(">> [경고] Y 또는 N 만 입력하세요!! << \n");
						}
						
					} while (true);
					
					
					if("y".equalsIgnoreCase(yn))			// y 이면 실행 
					{
						result = bdao.deleteBoard(boardno);
					}
					else									// n 이면 실행 
					{
						System.out.println(">> 글 삭제 성공!! <<");
					}
					
					
				}
				else													// 내가 입력한 암호와 데이터 베이스에 있는 암호가 없다면 실행한다. 
				{
					System.out.println(">> [경고] 입력하신 글암호가 작성시 입력한 글암호와 일치하지 않으므로 삭제 불가합니다!! << \n");
				}
				
			}
		}
		else
		{
			// 삭제할 글번호가 글목록에 존재하지 않는 경우
			System.out.println(">> 글번호 " + boardno + "글은 존재하지 않습니다!! << \n");
		}
			
		return result;
	}
	
	// **** 최근 1주일간 일자별 게시글 작성건수 **** //
	private void StatisticsByweek() {
		
		// --- 타이틀 부분 --- //
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ [최근 1주일간 일자별 게시글 작성건수] ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ ");
		
		// 만약 오늘이 2023-03-02 일 이라면 
		// 전체  2023-02-24  2023-02-25   2023-02-26   2023-02-28  2023-03-01  2023-03-02 가 나오도록 만들어라
		
		String title = "전체\t";
		
		for(int i=0; i<7; i++)		// 7번 반복
		{
			title += MyUtil.addDay(i-6) + "   ";   // -6  -5   -4   -3   -2   -1  0 이런 순으로 나온다.
		}// end of for
		
		System.out.println(title);
		
		System.out.println("------------------------------------------------------------------------------------------------");
		
		
		
		// 최근 1주일 내에 작성된 게시글 건수만 DB에서 가져온 결과물 
		Map<String, Integer> resultMap = bdao.StatisticsByweek();
		// DTO를 굳이 쓸 필요 없을때는 MAP을 사용한다 (MAP도 한 행을 뜻한다.) 
		// 항 행이 여러개가 나온다면 
		//LIST<Map<String, Integer>> resultMap = bdao.StatisticsByweek();
		// 하고 list를 사용해야 한다.
		
		String result = resultMap.get("TOTAL") + "\t" +			// TOTAL은 전체 밑에 내려온다.
				        resultMap.get("PREVIOUS6") + "\t" +	
				        resultMap.get("PREVIOUS5") + "\t" +	
				        resultMap.get("PREVIOUS4") + "\t" +	
				        resultMap.get("PREVIOUS3") + "\t" +	
				        resultMap.get("PREVIOUS2") + "\t" +	
				        resultMap.get("PREVIOUS1") + "\t" +	
				        resultMap.get("TODAY");
		
		System.out.println(result);
	} // end of private void StatisticsByweek() {
	
	
	// 이번달 일자별 게시글 작성건수 
	private void StatisticsByCurrentMonth() {
		
		
		// 타이틀 부분 
		
		Calendar currentDate = Calendar.getInstance();	// 현재 날자와 시간을 얻어온다.
		
		SimpleDateFormat sdfmt = new SimpleDateFormat ("yyyy년 MM월");
		
		String currentMonth = sdfmt.format(currentDate.getTime());   // 캘린더가 DATE 형태로 변경됨
		
		
		System.out.println("\n>>>> [ " + currentMonth + " 일자별 게시물 작성건수] <<<<");
		System.out.println("-----------------------");
		System.out.println("작성일자\t\t작성건수");
		System.out.println("-----------------------");
		
		
		
		// 이번달 일자별 게시글 작성건수를 DB에서 가져온 결과물 
		
		List<Map<String, String>> mapList = bdao.StatisticsByCurrentMonth();  // bdao에서 만들었다 
		
		if(mapList.size() >0)	//map에 값이 있다면
		{
			StringBuilder sb = new StringBuilder();
			
			for(Map<String, String> map : mapList) // 확장for문
			{
				sb.append( map.get("writeday") + "\t" + map.get("CNT") + "\n" );
			}// end of for
			System.out.println(sb.toString());
		}
		else			// map에 값이 없다면 
		{
			System.out.println(" 작성된 게시글이 없습니다. ");
		}
		
		
		
	} // end of private void StatisticsByCurrentMonth()
	
	
}


