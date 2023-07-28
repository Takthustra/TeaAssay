package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.TakutoShiotani;

/**
 * Servlet implementation class InfoServlet
 */
@WebServlet("/IntroServlet")
public class IntroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IntroServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		//リクエストスコープに保存するインスタンスを保存
		TakutoShiotani ts = new TakutoShiotani();
		
//		System.out.print(ts.)
		
		HttpSession session = request.getSession();
		session.setAttribute("ts", ts);
		
		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/intro.jsp");
		dispatcher.forward(request, response);
	}

}
