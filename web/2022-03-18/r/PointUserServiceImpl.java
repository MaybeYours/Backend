package xyz.itwill10.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.itwill10.dao.PointUserDAO;
import xyz.itwill10.dto.PointUser;

@Service
public class PointUserServiceImpl implements PointUserService {
	@Autowired
	private PointUserDAO pointUserDAO;

	//����� ������ ���޹޾� POINTUSER ���̺��� �����Ͽ� �����ϰ� ����� ����� ������
	//�˻��Ͽ� ��ȯ�ϴ� �޼ҵ�
	@Override
	public PointUser addPointUser(PointUser user) {
		if(pointUserDAO.selectPointUser(user.getId())!=null) {//���̵� �ߺ�
			throw new RuntimeException("�̹� ������� ���̵��Դϴ�.");
		}
		pointUserDAO.insertPointUser(user);
		return pointUserDAO.selectPointUser(user.getId());
	}
	
	
}