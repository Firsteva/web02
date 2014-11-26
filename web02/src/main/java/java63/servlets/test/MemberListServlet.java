package java63.servlets.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java63.servlets.test.dao.MemberDao;
import java63.servlets.test.domain.Member;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

@WebServlet("/test/member/list")
public class MemberListServlet extends GenericServlet {
  private static final long serialVersionUID = 1L;

  static final int PAGE_DEFAULT_SIZE = 3;

  SqlSessionFactory sqlSessionFactory;
  MemberDao memberDao;
  
  public MemberListServlet() {
    try {
      String resource = "java63/servlets/test/dao/mybatis-config.xml";
      InputStream inputStream = Resources.getResourceAsStream(resource);
      sqlSessionFactory = 
          new SqlSessionFactoryBuilder().build(inputStream);
      
      memberDao = new MemberDao();
      memberDao.setSqlSessionFactory(sqlSessionFactory);
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  @Override
  public void service(ServletRequest request, ServletResponse response)
      throws ServletException, IOException {
    int pageNo = 0;
    int pageSize = 0;
    
    if (request.getParameter("pageNo") != null) {
      pageNo = Integer.parseInt(request.getParameter("pageNo"));
      pageSize = PAGE_DEFAULT_SIZE;
    }
    
    if (request.getParameter("pageSize") != null) {
      pageSize = Integer.parseInt(request.getParameter("pageSize"));
    }
    
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<head>");
    out.println("<link rel='stylesheet'"); 
    out.println("      href='../../css/bootstrap.min.css'>");
    out.println("<link rel='stylesheet'"); 
    out.println("      href='../../css/bootstrap-theme.min.css'>");
    out.println("<link rel='stylesheet' href='../../css/common.css'>");
    out.println("</head>");
    out.println("<body>");
    out.println("<div class='container'>");
    out.println("<h1>제품 목록</h1>");
    out.println("<p><a href='member-form.html' class='btn btn-primary'>새주문자</a></p>");
    out.println("<table class='table table-hover'>");
    out.println("<tr>");
    out.println("  <th>#</th><th>주문자명</th><th>이메일</th>");
    out.println("</tr>");
    for (Member member : memberDao.selectList(pageNo, pageSize)) {
      out.println("<tr>");
      out.println("  <td>" + member.getId() + "</td>");
      out.println("  <td><a href='view?id=" + member.getId() + "'>" 
            + member.getName() + "</a></td>");
      out.println("  <td>" + member.getMail() + "</td>");
      out.println("</tr>");
    }
    out.println("</table>");
    out.println("</div>");
    
    out.println("<script src='../../js/jquery-1.11.1.js'></script>");
    
    out.println("</body>");
    out.println("</html>");
  }  
}
