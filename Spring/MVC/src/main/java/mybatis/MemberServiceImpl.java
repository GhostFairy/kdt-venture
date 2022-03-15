package mybatis;

import java.util.List;

public class MemberServiceImpl implements MemberService {

	MemberDAO dao;

	public MemberServiceImpl() {

	}

	public MemberServiceImpl(MemberDAO dao) {
		this.dao = dao;
	}

	public void setDao(MemberDAO dao) {
		this.dao = dao;
	}

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
	public List<MemberDTO> pagingList(int startNum, int displayNum) {
		return dao.pagingList(startNum, displayNum);
	}

	@Override
	public List<MemberDTO> addressSearch(String[] address) {
		return addressSearch(address);
	}

}