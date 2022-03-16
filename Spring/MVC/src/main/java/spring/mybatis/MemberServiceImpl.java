package spring.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("MyBatisService")
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDAO dao;

	@Override
	public int insertMember(MemberDTO dto) {
		return dao.insertMember(dto);
	}

	@Override
	public int updateMember(MemberDTO dto) {
		return dao.updateMember(dto);
	}

	@Override
	public int deleteMember(String id) {
		return dao.deleteMember(id);
	}

	@Override
	public MemberDTO selectMember(String id) {
		return dao.selectMember(id);
	}

	@Override
	public List<MemberDTO> memberList() {
		return dao.memberList();
	}

	@Override
	public List<MemberDTO> memberList(int startNum, int displayNum) {
		return dao.memberList(startNum, displayNum);
	}

	@Override
	public List<String> memberList(String[] address) {
		return dao.memberList(address);
	}

}