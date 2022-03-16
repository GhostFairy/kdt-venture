package spring.mybatis;

import java.util.List;

public interface MemberService {

	public int insertMember(MemberDTO dto);
	
	public int updateMember(MemberDTO dto);
	
	public int deleteMember(String id);
	
	public MemberDTO selectMember(String id);

	public List<MemberDTO> memberList();

	public List<MemberDTO> memberList(int startNum, int displayNum);

	public List<String> memberList(String[] address);
	
}
