package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.AccessCountLogic;

/**
 * Servlet implementation class AcsessCountServlet
 */
@WebServlet("/TopServlet")
public class TopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TopServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//アクセス回数の取得
		AccessCountLogic bo = new AccessCountLogic();
		int cnt = bo.getAccessCount();
		
		//セッションスコープにアクセス回数を保存
		ServletContext application = this.getServletContext();
		application.setAttribute("cnt", cnt);
		
		//DAILY_ACCESS_LOGから本日の記録を取得 

//		//アプリケーションスコープに保存されたアクセス回数を増加
//		ServletContext application = this.getServletContext();
//		Integer cnt = (Integer) application.getAttribute("cnt");
//		cnt++;
//
//		application.setAttribute("cnt", cnt);

		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/top.jsp");
		dispatcher.forward(request, response);
	}

}
