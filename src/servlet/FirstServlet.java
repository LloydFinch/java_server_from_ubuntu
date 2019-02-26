/**
 * 
 */
package servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lloydfinch my first servlet, study lifecycle
 */
public class FirstServlet implements Servlet {

	@Override
	public void destroy() {
		// 仅仅销毁的时候调用
		System.out.println("destroy");
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// 仅仅初始化的时候调用
		System.out.println("init......");

		// 获取初始化属性

		// web.xml里面的servlet-name
		String name = config.getServletName();
		System.out.println("name = " + name);

		// 获取web.xml里面的init-param
		String value = config.getInitParameter("name");
		System.out.println("init parameter: " + value);

		// 获取context
		ServletContext servletContext = config.getServletContext();
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {

		// 每次请求都调用
		System.out.println("hello, servlet");

		HttpServletResponse response = (HttpServletResponse) arg1;
		response.getWriter().write("hello servlet");
	}

}
