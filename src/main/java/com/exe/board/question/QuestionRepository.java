package com.exe.Board.question;
//������ ó���� ���ؼ��� ���� �����ͺ��̽��� �����ϴ�
//JPA�� Repository�� �ʿ��ϴ�
//��ƼƼ�� ���� ������ �����ͺ��̽� ���̺� �����ϴ� �޼ҵ带 ����ϱ� ���� �������̽�
//ex) findAll,save
//CRUD(Create,Read,Update,Delete)�� �����ϴ� ����

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer>{
	
	//findBy + ��ƼƼ��
	Question findBySubject(String subject);
	Question findBySubjectAndContent(String subject, String content);
	//List<Question> findBySubjectAndContent(String subject, String content);
	List<Question> findBySubjectLike(String subject);
	
	//Pageable�� �Է¹޾� Page<Question>Ÿ���� ��ü�� ���� 
	Page<Question> findAll(Pageable pageable);
	
}
