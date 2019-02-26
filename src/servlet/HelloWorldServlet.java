package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorldServlet
 */
@WebServlet("/helloworld")
public class HelloWorldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String message;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HelloWorldServlet() {
		super();
	}

	@Override
	public void init() throws ServletException {
		super.init();
		message = "hello, world";
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get请求的参数限制长度为1024个字符
		response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();
		String data = "<h1>" + message + "</h1>";

		// get请求获取url中的参数，eg：http://localhost:8080/helloworld?name=hello&age=world
		String name = request.getParameter("name");
		String age = request.getParameter("age");

		data = data + "</br>";
		data = data + name;
		data = data + "</br>";
		data = data + age;

		printWriter.println(data);
		printWriter.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
