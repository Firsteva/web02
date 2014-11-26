package java63.servlets.test.dao;

import java.util.HashMap;
import java.util.List;
import java63.servlets.test.domain.Member;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberDao {
  @Autowired
  SqlSessionFactory sqlSessionFactory;
  
  public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  public MemberDao() {}

  public Member selectOne(String id) {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    try {
      return sqlSession.selectOne(
        "java02.test.dao.MemberDao.selectOne", id);
    } finally {
      sqlSession.close();
    }
  }
  
  public void update(Member member) {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
      sqlSession.update(
        "java02.test19.dao.MemberDao.update", member);
      sqlSession.commit();
    } finally {
      sqlSession.close();
    }
  }
  
  public void delete(String id) {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
      sqlSession.delete(
        "java02.test.dao.MemberDao.delete", id);
      sqlSession.commit();
    } finally {
      sqlSession.close();
    }
  }
  
  public List<Member> selectList(int pageNo, int pageSize) {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    
    HashMap<String,Object> paramMap = new HashMap<>();
    paramMap.put("startIndex", ((pageNo - 1) * pageSize));
    paramMap.put("pageSize", pageSize);
    
    try {
      return sqlSession.selectList(
        "java02.test.dao.MemberDao.selectList", 
        paramMap);
    } finally {
      sqlSession.close();
    }
  }
  
  public void insert(Member member) {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
      sqlSession.insert(
        "java02.test.dao.MemberDao.insert", member);
      sqlSession.commit();
    } finally {
      sqlSession.close();
    }
  }
}