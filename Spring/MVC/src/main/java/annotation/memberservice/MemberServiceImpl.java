package annotation.memberservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// @Service: Service 역할의 클래스에 Component 대신 사용
@Service("service")
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDAO dao;

	@Override
	public void registerMember() {
		if (!dao.selectMember()) {
			dao.insertMember();
		}
	}

	@Override
	public void login() {
		if (dao.selectMember()) {
			System.out.println("정상적으로 로그인되었습니다.");
		} else {
			System.out.println("로그인에 실패했습니다.");
		}
	}

}
