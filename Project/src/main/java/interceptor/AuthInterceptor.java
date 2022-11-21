package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter {
   private static final Logger logger =
         LoggerFactory.getLogger(AuthInterceptor.class);
   
   @Override
   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
         throws Exception {
      logger.info("===== preHandle ȣ��");
      
      // �α��� ���� (���� ���� ) : mapping�� url�� ��Ʈ�ѷ� �޼ҵ� ����
      // �α׾ƿ� ����(���� ����) : login url�� �̵�. ��ǥ url����
      HttpSession session = request.getSession();
      String userId = (String) session.getAttribute("userId");
      if (userId != null) {
		logger.info("�α��� ���� -> controller method ����");
		return true;
	} else {
		logger.info("�α׾ƿ� ���� -> controller method ����ȵ�");
		// ��ǥ url ���ǿ� ����(���� request parameter�� �����ϸ� ���� ����)
		saveDestination(request);
		response.sendRedirect("/musinsa/user/login");
		return false;
	}
     
   } // end preHandle()

private void saveDestination(HttpServletRequest request) {
	logger.info("saveDestination()  ȣ��");
	
	String uri = request.getRequestURI();
	logger.info("��û URI : " + uri);
	
	String contextRoot = request.getContextPath(); 
	
	uri = uri.replace(contextRoot, "");
	
	String queryString = request.getQueryString();
	logger.info("���� ��Ʈ�� : " + queryString);
	
	String targetURL = "";
	if (queryString == null) {
		targetURL = uri;
	} else {
		targetURL = uri + "?" + queryString;
	} 
	logger.info("targetURL : " + targetURL);
	request.getSession().setAttribute("targetURL", targetURL);
	}

} // end AuthInterceptor