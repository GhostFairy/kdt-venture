package mybatis;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MemberMain {

	public static void main(String[] args) throws IOException {
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

		// FactoryBuilder가 설정 파일의 내용대로 Session을 만들어주는 Factory를 생성
		SqlSessionFactory factory = builder.build(Resources.getResourceAsReader("mybatis/mybatis-config.xml"));

		// Factory가 설정 파일의 내용에 맞는 Session을 생성
		// 매개변수가 없거나 false면 DML을 즉시 반영하지 않음(별도의 적용 명령 필요)
		SqlSession session = factory.openSession(true);

		MemberDAO dao = new MemberDAO(session);
		MemberService service = new MemberServiceImpl(dao);

		MemberDTO dto = new MemberDTO();
		dto.setId("mybatis2");
		dto.setPassword("mybatis2");
		dto.setName("바티스2");
		dto.setPhone("011-222-2222");
		dto.setEmail("my@batis2.com");
		dto.setAddress("마이바티스");
		// System.out.println(service.insertMember(dto) + "개의 행 입력 완료");
		// dto.setAddress("마이바티스2");
		// System.out.println(service.updateMember(dto) + "개의 행 수정 완료");
		// System.out.println(service.deleteMember(dto) + "개의 행 삭제 완료");

		// MemberDTO oneDto = service.selectMember("mybatis");
		// System.out.println(oneDto.getId() + " : " + oneDto.getName() + " : " +
		// oneDto.getAddress());

		// List<MemberDTO> list = service.memberList();
		// List<MemberDTO> list = service.pagingList(5, 6);
		List<MemberDTO> list = service.addressSearch(new String[] { "서울", "제주" });
		for (MemberDTO d : list) {
			System.out.println(d.getId() + " : " + d.getName() + " : " + d.getAddress());
		}

	}

}
