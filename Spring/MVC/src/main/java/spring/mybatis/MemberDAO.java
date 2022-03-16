package spring.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("MyBatisDAO")
public class MemberDAO {

	@Autowired
	SqlSession session;

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

	public List<MemberDTO> memberList(int startNum, int displayNum) {
		return session.selectList("paginglist", new int[] { startNum, displayNum });
	}

	public List<String> memberList(String[] address) {
		return session.selectList("addresssearch", address);
	}

}