package jdbc.day05.board.Study3_3;

import java.sql.*;
import java.util.*;

public class BoardDAO implements InterBoardDAO {// 실제 구현하는 곳 

	
	// field, attribute, property, 속성
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	
	// method, operation, 기능
	
	// === 자원반납을 해주는 메소드 === //
	private void close() {
		try {
			if(rs != null) {
				rs.close();
				rs = null;
			}
			
			if(pstmt != null) {
				pstmt.close();
				pstmt = null;
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	// 게시판 글쓰기 (Transaction 처리 : tbl_board 테이블에 insert + tbl_member 테이블의 point 컬럼에 10씩 증가(update) 메소드 구현하기
	@Override
	public int write(BoardDTO bdto) {   
		
		int result = 0;
		
		try
		{
			conn = MyDBConnection.getConn();			//오라클과 자바를 연결 
			
			
			// 이때만 수동 커밋으로 전환하기 
			// !!!!!!!!! Transaction 처리를 위해서 수동 커밋(commit)으로 전환시킨다 !!!!!!!!
			conn.setAutoCommit(false);
			
			
			String sql = " insert into tbl_board(boardno, fk_userid, subject , contents , boardpasswd) "
					   + " values(seq_board.nextval, ?, ?, ?, ?) ";			// 4개의 위치 홀더 사용
			
			pstmt = conn.prepareStatement(sql);  // 우편배달부    
			
			// 매핑하기 
			pstmt.setString(1, bdto.getFk_userid() );
			pstmt.setString(2, bdto.getSubject() );
			pstmt.setString(3, bdto.getContents() );
			pstmt.setString(4, bdto.getBoardpasswd() );
			
			int n1 = pstmt.executeUpdate();   // DML문이므로 update를 사용
			
			if(n1 == 1)		// 결과가 있나 
			{
				sql = " update tbl_member set point = point + 10 "
					+ " where userid = ? ";
				
				pstmt = conn.prepareStatement(sql); // 우편배달부
				
				pstmt.setString(1, bdto.getFk_userid());
				
				int n2 = pstmt.executeUpdate();   // DML문이므로 update를 사용
				
				if(n2 == 1)    // 한 개 행만 바뀔꺼니까 1이 나올때
				{   
					conn.commit();     // 커밋을 해준다.
					result = 1;        // 결과가 있으므로 1을 저장한다.
				}
				
			}
			
		} 
		catch(SQLException e)   // 오류가 발생하면 무조건 rollback 을 해줘야 한다.
		{
			// e.printStackTrace();   // 개발 도중에만 사용하자 
			if(e.getErrorCode() == 2290)   // 2290번의 에러일때
			{
				System.out.println(">> 아이디 " + bdto.getFk_userid() + " 포인트는 30을 초과할 수 없기 때문에 오류가 발생하였습니다.<< \n");
			}
			else
			{
				// e.printStackTrace();   // 개발 도중에만 사용하자 
			}
			
			try
			{
				conn.rollback();   // 롤백을 해준다.
			}
			catch(SQLException e1)
			{
				
			}
			
			result = -1;
				
		}
		
		finally  // 자원 반납하기 
		{
			// 다시 자동 commit으로 복원시킨다. (수동 커밋이 필요한 곳만 제외하고 나머지를 위해서 자동 commit으로 변경)
			try 
			{
				conn.setAutoCommit(true); // auto 커밋으로 복원시킨다.!!!!
			} 
			catch (SQLException e) 
			{
				
				//e.printStackTrace();
			}
			
			close();  // 자원반납하기 
		}
		
		return result;
	}  // end of public int write(BoardDTO bdto) { 


	// 글목록보기 메소드 구현하기 
	@Override
	public List<BoardDTO> boardList() {
		
		List<BoardDTO> boardList = new ArrayList<>();  // ArrayList 사용한다. 값 저장 ==> select 되어진것을 BoardList에 담을 것이다.
														// boardList를 ArratyList로 만듬
		
		try {
			conn = MyDBConnection.getConn();  // 스테틱 되어진 것을 불러온다. 연결할 오라클을 받아옴 
			

			String sql = "select A.boardno \n"+
			"     , A.subject\n"+
			"     , A.NAME\n"+
			"     , A. writeday \n"+
			"     , A. viewcount \n"+
			"     , nvl(CNT.COMMENTCNT, 0) AS COMMENTCNT\n"+
			"from \n"+
			"(\n"+
			"    select B.boardno, B.subject, M.name, to_char(B.writeday, 'yyyy-mm-dd hh24:mi:ss') AS writeday, B.viewcount\n"+
			"    from tbl_member M join tbl_board B\n"+
			"    ON M.userid = B.fk_userid\n"+
			") A\n"+
			"LEFT JOIN\n"+
			"(\n"+
			"    select fk_boardno, count(*) AS COMMENTCNT \n"+
			"    from tbl_comment \n"+
			"    group by fk_boardno\n"+
			") CNT\n"+
			"ON A.boardno = CNT.fk_boardno\n"+
			"ORDER BY boardno desc";

					
			
			pstmt = conn.prepareStatement(sql);
			
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				//////////////////////////////////////////////////////////////////////////////////////////////////////////////
				BoardDTO bdto = new BoardDTO();    // BoardDTO의 boardList 에 넣어주기 위해 선언??  //반복문 안에 계속 selete 해주기 위해  
				
				// 보드 DTO에 있는 것들
				bdto.setBoardno(rs.getInt("BOARDNO"));   //값을 받아오기위해 
				bdto.setSubject(rs.getString("SUBJECT"));
				
				// 맴버 DTO에 있는 것들 
				MemberDTO member = new MemberDTO(); 
				member.setName(rs.getString("NAME"));		// 이름을 가져옴 
				//member.setPoint(rs.getString("POINT"));   // 포인트가 있으면 사용 
				
				bdto.setMember(member);   // selete에 보드맴버를 선언해왔기 때문에 가능하다.
				
				// 다시 보드 DTO에 있는것들 
				bdto.setWriteday(rs.getString("WRITEDAY"));   // 작성일자를 가져옴
				bdto.setViewcount(rs.getInt("VIEWCOUNT"));    // 조회수를 가져옴
				bdto.setCommentcnt(rs.getInt("COMMENTCNT"));  // 댓글 개수를 가져옴
				
				
				
				//////////////////////////////////////////////////////////////////////////////////////////////////////////////
				
				// 지금까지 받아온 값을 LIST에 담는다
				boardList.add(bdto);   //이렇게 단독으로 null이 초기 값이기 때문에 안된다. 
										  //그렇기에 List<BoardDTO> boardList = new ArrayList<>(); 를 써줘야 한다.
				
			} // end of while 
		
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(); // 자원반납
		}
		
		
		return boardList;
	} // end of public List<BoardDTO> boardList() {


	//글 내용보기 메소드 구현하기 
	@Override
	public BoardDTO viewContents(String boardno) {
		
		BoardDTO bdto = null;			// 초기값은 null값으로 설정 
		
		try {
			conn = MyDBConnection.getConn();  // 스테틱 되어진 것을 불러온다. 연결할 오라클을 받아옴 
			

			String sql = " select subject, contents, fk_userid, boardpasswd "+
						 " from tbl_board " +
						 " where boardno = ? ";
					
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardno);   // 첫번째 위치홀더에 값 대입함 
			
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {    // select 가 되어서 나왔다면 
				
				bdto = new BoardDTO();    // BoardDTO의 boardList 에 넣어주기 위해 선언??  //반복문 안에 계속 selete 해주기 위해  
				
				// 값들을 받아오자 
				bdto.setSubject(rs.getString("SUBJECT"));
				bdto.setContents(rs.getString("CONTENTS"));
				bdto.setFk_userid(rs.getString("FK_USERID"));
				bdto.setBoardpasswd(rs.getString("BOARDPASSWD"));
				
			} // end of if
			else			// 행이 없으면
			{
				System.out.println(">>글번호 "+ boardno + "은 글목록에 존재하지 않습니다 << \n");
			} // end of else
		
		}catch(SQLException e) {
			if(e.getErrorCode() == 1722)
			{
				System.out.println(">> 글 번호는 숫자만 가능합니다!! <<");
			}
			else
			{
				e.printStackTrace();
			}
			
		} finally {
			close(); // 자원반납
		}
		
		return bdto;
	} // end of public BoardDTO viewContents(String boardno) {


	// 조회수 1 증가 시키기 메소드 구현하기
	@Override
	public void updateViewContents(String boardno) {
		
		try
		{
			conn = MyDBConnection.getConn();			//오라클과 자바를 연결 
			
			String sql = " update tbl_board set viewCount = viewCount + 1 "
					   + " where boardno = ? ";			// 1개의 위치 홀더 사용
			
			pstmt = conn.prepareStatement(sql);  // 우편배달부    
			
			// 매핑하기 
			pstmt.setString(1, boardno);
			
			pstmt.executeUpdate();   // DML문이므로 update를 사용
			
		} 
		catch(SQLException e)   // 오류가 발생하면 무조건 rollback 을 해줘야 한다.
		{
			e.printStackTrace();
		}
		
		finally  // 자원 반납하기 
		{	
			close();  // 자원반납하기 
		}
		
	}

	//*** 원글에 대한 댓글을 가져오는것을 말한다 (특정 게시글 글 번호에 대한 tbl_comments 테이블과 tbl_member 테이블을 JOIN 해서 보여준다. *** //
	@Override
	public List<CommentDTO> commentList(String boardno) {
		
		List<CommentDTO> commentList = new ArrayList<>(); 
		
		try {
			conn = MyDBConnection.getConn();  // 스테틱 되어진 것을 불러온다. 연결할 오라클을 받아옴 
			

			String sql = " select A.contents, B.name, WRITEDAY " +
					" from " +
					" ( " +
					    " select fk_userid, contents, to_char(writeday, 'yyyy-mm-dd hh24:mi:ss') AS WRITEDAY " +
					    " from tbl_comment " + 
					    " where fk_boardNo = ? " + 
					" ) A " +
					" JOIN " +
					" ( " +
					    " select userid, name " + 
					    " from tbl_member " +
					" ) B " + 
					" ON A.fk_userid = B.userid ";

					
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardno);
			
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				//////////////////////////////////////////////////////////////////////////////////////////////////////////////
				CommentDTO cmtdto = new CommentDTO();    // CommentDTO의 cmtdto 에 넣어주기 위해 선언??  //반복문 안에 계속 selete 해주기 위해  
				
				// 보드 DTO에 있는 것들
				cmtdto.setContents(rs.getString("CONTENTS"));   //값을 받아오기위해 
				
				// 맴버 DTO에 있는 것들 
				MemberDTO mbrdto = new MemberDTO(); 
				mbrdto.setName(rs.getString("NAME"));		// 이름을 가져옴 
				
				cmtdto.setMember(mbrdto);   // selete에 보드맴버를 선언해왔기 때문에 가능하다.
				
				// 다시 보드 DTO에 있는것들 
				cmtdto.setWriteday(rs.getString("WRITEDAY"));   // 작성일자를 가져옴
				
				
				//////////////////////////////////////////////////////////////////////////////////////////////////////////////
				
				// 지금까지 받아온 값을 LIST에 담는다
				commentList.add(cmtdto);   //이렇게 단독으로 null이 초기 값이기 때문에 안된다. 
										  //그렇기에 List<CommentDTO> commentList = new ArrayList<>(); 를 써줘야 한다.
				
			} // end of while 
		
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(); // 자원반납
		}
		
		
		return commentList;
	} // end of public List<CommentDTO> commentList(String boardno) {

	
	// 댓글쓰기 메소드 구현하기 (Transaction 처리 : tbl_board 테이블에 insert + tbl_member 테이블의 point 컬럼에 5씩 증가 update
	// 사용자가 다른 사용자가 쓴 원글에 댓글쓰기를 하면 포인트 점수를 5점씩 증가하도록 하겠습니다.
	// bFlag의 값이 TRUE 이면 원글은 로그인한 사용자가 아닌 다른 사용자가 쓴 글임.
	// bFlag의 값이 False 이면 원글릉 로그인한 사용자가 쓴 글임 
	@Override
	public int writeComment(CommentDTO cmtdto, boolean bFlag) {
		
		int result = 0;
		try
		{
			conn = MyDBConnection.getConn();  // 스테틱 되어진 것을 불러온다. 연결할 오라클을 받아옴 
			
			// 이때만 수동 커밋으로 전환하기 
			// !!!!!!!!! Transaction 처리를 위해서 수동 커밋(commit)으로 전환시킨다 !!!!!!!!
			conn.setAutoCommit(false);
			
			String sql = " insert into tbl_comment(commentno, fk_boardno  ,fk_userid  ,Contents) "
					+ " values(userseq.nextval, ?, ?, ?) ";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, cmtdto.getFk_boardno());
			pstmt.setString(2, cmtdto.getFk_userid());
			pstmt.setString(3, cmtdto.getContents());
			
			int n1 = pstmt.executeUpdate();   // DML문이므로 update를 사용
			
			if(n1 == 1 && bFlag)		// 댓글쓰기에 있어서 남이 쓴 원글에 댓글을 쓴 경우
			{
				sql = " update tbl_member set point = point + 5 "
					+ " where userid = ? ";
				
				pstmt = conn.prepareStatement(sql); // 우편배달부
				
				pstmt.setString(1, cmtdto.getFk_userid());
				
				int n2 = pstmt.executeUpdate();   // DML문이므로 update를 사용
				
				if(n2 == 1)    // 한 개 행만 바뀔꺼니까 1이 나올때
				{   
					conn.commit();     // 커밋을 해준다.
					result = 1;        // 결과가 있으므로 1을 저장한다.
				}
				
			}
			
			else if(n1 == 1) // 댓글쓰기에 있어서 자신의 원글에 댓글을 쓴 경우 
			{
				conn.commit();     // 커밋을 해준다.
				result = 1;        // 결과가 있으므로 1을 저장한다.
			}
			
		} 
		catch(SQLException e)   // 오류가 발생하면 무조건 rollback 을 해줘야 한다.
		{
			e.printStackTrace();
			
			try
			{
				conn.rollback();   // 롤백을 해준다.
			}
			catch (SQLException e1) {}
			
			result = -1;
				
		}
		
		finally  // 자원 반납하기 
		{
			// 다시 자동 commit으로 복원시킨다. (수동 커밋이 필요한 곳만 제외하고 나머지를 위해서 자동 commit으로 변경)
			try 
			{
				conn.setAutoCommit(true); // auto 커밋으로 복원시킨다.!!!!
			} 
			catch (SQLException e) 
			{
				
				//e.printStackTrace();
			}
			
			close();  // 자원반납하기 
		}
		
		
		
		return result;
	} // end of public int writeComment(CommentDTO cmtdto) {


	// *** 글 수정하기 메소드 구현하기 *** // 
	@Override
	public int updateBoard(Map<String, String> paraMap) {
		
		int result = 0;
		
		try
		{
			conn = MyDBConnection.getConn();			//오라클과 자바를 연결 
			
			String sql = " update tbl_board set subject = ?, contents = ? "
					   + " where boardno = ? ";			// 1개의 위치 홀더 사용
			
			pstmt = conn.prepareStatement(sql);  // 우편배달부    
			
			// 매핑하기 
			pstmt.setString(1, paraMap.get("subject"));
			pstmt.setString(2, paraMap.get("contents"));
			pstmt.setString(3, paraMap.get("boardno"));

			
			result = pstmt.executeUpdate();   // DML문이므로 update를 사용
			// update 가 성공되어지면 result 에는 1이 들어간다.
		} 
		catch(SQLException e)   // 오류가 발생
		{
			result = -1;
			e.printStackTrace();
		}
		
		finally  // 자원 반납하기 
		{	
			close();  // 자원반납하기 
		}
	
		return result;
	}// end of public int updateBoard(Map<String, String> paraMap) {


	// *** 글 삭제하기 메소드 생성(구현)하기 *** //
	@Override
	public int deleteBoard(String boardno) {
		
		int result = 0;
		try
		{
			conn = MyDBConnection.getConn();			//오라클과 자바를 연결 
			
			String sql = " delete from tbl_board "
					   + " where boardno = ? ";			// 1개의 위치 홀더 사용
			
			pstmt = conn.prepareStatement(sql);  // 우편배달부    
			
			// 매핑하기 
			pstmt.setString(1, boardno);
			
			
			result = pstmt.executeUpdate();   // DML문이므로 update를 사용
			// delete 가 성공되어지면 result 에는 1이 들어간다.
		} 
		catch(SQLException e)   // 오류가 발생
		{
			result = -1;
			e.printStackTrace();
		}
		
		finally  // 자원 반납하기 
		{	
			close();  // 자원반납하기 
		}
		
		return result;
	}

	// 최근 1주일 내에 작성된 게시글 건수만 DB에서 가져온 결과물을 보여주는 메소드 구현하기 
	@Override
	public Map<String, Integer> StatisticsByweek() {
		
		Map<String, Integer> resultMap = new HashMap<>();
		
		try {
			conn = MyDBConnection.getConn();  // 스테틱 되어진 것을 불러온다. 연결할 오라클을 받아옴 
			

			String sql = " select count(writeday)   as TOTAL "                                                                                                       
					+ "  , sum (decode(to_date( to_char(sysdate, 'yyyy-mm-dd'), 'yyyy-mm-dd') - to_date( to_char(writeday , 'yyyy-mm-dd'),'yyyy-mm-dd'),6, 1, 0)) AS PREVIOUS6 "
					+ "  , sum (decode(to_date( to_char(sysdate, 'yyyy-mm-dd'), 'yyyy-mm-dd') - to_date( to_char(writeday , 'yyyy-mm-dd'),'yyyy-mm-dd'),5, 1, 0)) AS PREVIOUS5 "
					+ "  , sum (decode(to_date( to_char(sysdate, 'yyyy-mm-dd'), 'yyyy-mm-dd') - to_date( to_char(writeday , 'yyyy-mm-dd'),'yyyy-mm-dd'),4, 1, 0)) AS PREVIOUS4 "
					+ "  , sum (decode(to_date( to_char(sysdate, 'yyyy-mm-dd'), 'yyyy-mm-dd') - to_date( to_char(writeday , 'yyyy-mm-dd'),'yyyy-mm-dd'),3, 1, 0)) AS PREVIOUS3 "
					+ "  , sum (decode(to_date( to_char(sysdate, 'yyyy-mm-dd'), 'yyyy-mm-dd') - to_date( to_char(writeday , 'yyyy-mm-dd'),'yyyy-mm-dd'),2, 1, 0)) AS PREVIOUS2 "
					+ "  , sum (decode(to_date( to_char(sysdate, 'yyyy-mm-dd'), 'yyyy-mm-dd') - to_date( to_char(writeday , 'yyyy-mm-dd'),'yyyy-mm-dd'),1, 1, 0)) AS PREVIOUS1 "
					+ "  , sum (decode(to_date( to_char(sysdate, 'yyyy-mm-dd'), 'yyyy-mm-dd') - to_date( to_char(writeday , 'yyyy-mm-dd'),'yyyy-mm-dd'),0, 1, 0)) AS TODAY "
					+ " from tbl_board "
					+ " where to_date( to_char(sysdate, 'yyyy-mm-dd'), 'yyyy-mm-dd') - to_date( to_char(writeday , 'yyyy-mm-dd'),'yyyy-mm-dd') < 7 ";

			pstmt = conn.prepareStatement(sql);	
			
			rs = pstmt.executeQuery();
			
			rs.next();   // 커서를 한칸 내려보낸다.
			
			// 맵에 담는다.
			resultMap.put("TOTAL", rs.getInt(1));    //rs.getInt("TOTAL")    // rs.getInt(1)과 같음 
			resultMap.put("PREVIOUS6", rs.getInt(2));
			resultMap.put("PREVIOUS5", rs.getInt(3));
			resultMap.put("PREVIOUS4", rs.getInt(4));
			resultMap.put("PREVIOUS3", rs.getInt(5));
			resultMap.put("PREVIOUS2", rs.getInt(6));
			resultMap.put("PREVIOUS1", rs.getInt(7));
			resultMap.put("TODAY", rs.getInt(8));
		
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(); // 자원반납
		}
		
		
		return resultMap;
	}	// end of public Map<String, Integer> StatisticsByweek() {


	
	// 이번달 일자별 게시글 작성건수를 DB에서 가져온 결과물 메소드 구현하기 
	@Override
	public List<Map<String, String>> StatisticsByCurrentMonth() {
		
		List<Map<String, String>> mapList = new ArrayList<>();
		
		try {
			conn = MyDBConnection.getConn();  // 스테틱 되어진 것을 불러온다. 연결할 오라클을 받아옴 
			

			String sql = " select decode( grouping ( to_char(writeday, 'yyyy-mm-dd') ), 0, to_char(writeday, 'yyyy-mm-dd'), '전체' ) AS writeday "
					+ "         , count(*) AS CNT "
					+ "from tbl_board "
					+ "where to_char(writeday, 'yyyy-mm') = to_char(sysdate, 'yyyy-mm') "
					+ "group by rollup (to_char(writeday, 'yyyy-mm-dd')) ";

			pstmt = conn.prepareStatement(sql);	
			
			rs = pstmt.executeQuery();
			
			// 있는지 없는지 확인하기
			while(rs.next())
			{
				Map<String, String> map = new HashMap<>();
				
				map.put("writeday", rs.getString(1));
				map.put("CNT", String.valueOf(rs.getInt(2)));   // 스트링 타입으로 변경해서 담아준다.
				
				mapList.add(map); // List에  map을 저장시킨다.
				
				
			}// end of while(rs.next())
			
		
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(); // 자원반납
		}
		
		
		
		return mapList;
	} // end of public List<Map<String, String>> StatisticsByCurrentMonth() {


	@Override
	public Map<String, String> Board_pre_next(String boardno) {
		
		Map<String, String> resultMap = new HashMap<>(); 
		
		try {
			conn = MyDBConnection.getConn();  // 스테틱 되어진 것을 불러온다. 연결할 오라클을 받아옴 
			

			String sql = " select pre_no, pre_name, no, name, contents, next_no, next_name "
					+ " from "
					+ " ( "
					+ "    select lag(boardno, 1) over(order by boardno desc) AS pre_no "
					+ "          ,lag(subject, 1) over(order by boardno desc) AS pre_name "
					+ "          ,boardno AS no "
					+ "          ,subject AS name "
					+ "          ,contents AS contents "
					+ "          ,lead(boardno, 1) over(order by boardno desc) AS next_no "
					+ "          ,lead(subject, 1) over(order by boardno desc) AS next_name "
					+ "    from tbl_board "
					+ " ) "
					+ " where no = ? ";


			pstmt = conn.prepareStatement(sql);
			// 매핑하기 
			pstmt.setString(1, boardno);
				
			rs = pstmt.executeQuery();
			
			rs.next();   // 커서를 한칸 내려보낸다.
			
			// 맵에 담는다.
			resultMap.put("pre_no", String.valueOf(rs.getInt(1)));    //rs.getInt("TOTAL")    // rs.getInt(1)과 같음 
			resultMap.put("pre_name", rs.getString(2));
			resultMap.put("no", String.valueOf(rs.getInt(3)));
			resultMap.put("name", rs.getString(4));
			resultMap.put("contents", rs.getString(5));
			resultMap.put("next_no", String.valueOf(rs.getInt(6)));
			resultMap.put("next_name", rs.getString(7));
		
			
		}catch(SQLException e) {
			System.out.println(" 글이 없습니다. 글번호를 확인해 주세요 ");
			//e.printStackTrace();
		} finally {
			close(); // 자원반납
		}
		
		
		return resultMap;
	}

	
	
	
}
