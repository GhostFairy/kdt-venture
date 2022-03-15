package mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class MemberDAO {

	SqlSession session;

	public MemberDAO() {

	}

	MemberDAO(SqlSession session) {
		this.session = session;
	}

	public void setSession(SqlSession session) {
		this.session = session;
	}

	public int insertMember(MemberDTO dto) {
		int insertRow = session.insert("insertmember", dto);
		return insertRow;
	}

	public int updateMember(MemberDTO dto) {
		int updateRow = session.update("updatemember", dto);
		return updateRow;
	}

	public int deleteMember(String id) {
		int deleteRow = session.delete("deletemember", id);
		return deleteRow;
	}

	public MemberDTO selectMember(String id) {
		return session.selectOne("member", id);
	}

	public List<MemberDTO> memberList() {
		return session.selectList("memberlist");
	}

	public List<MemberDTO> pagingList(int startNum, int displayNum) {
		return session.selectList("paginglist", new int[] { startNum, displayNum });
	}

	public List<MemberDTO> addressSearch(String[] address) {
		return session.selectList("addresssearch", address);
	}

}