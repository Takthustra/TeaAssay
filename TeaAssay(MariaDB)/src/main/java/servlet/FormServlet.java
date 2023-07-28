package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.DoneForm;
import model.Form;

/**
 * Servlet implementation class FormServlet
 */
@WebServlet("/FormServlet")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FormServlet() {
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

		//フォワード先
		String forwardPath = null;

		//サーブレットクラスの動作を決める「action」の値をリクエストパラメータから取得
		String action = request.getParameter("action");

		//「Formの呼び出し」をリクエストされた時の処理
		if (action == null) {
			//空のFormクラスのインスタンスを生成
			Form form = new Form();

			//セッションスコープに空のお問い合わせを登録
			HttpSession session = request.getSession();
			session.setAttribute("form", form);
			
			forwardPath = "jsp/form.jsp";
		}else if(action.equals("back")) {

			forwardPath = "jsp/form.jsp";
			
		}else if (action.equals("done")) {
			//セッションスコープに登録されたお問い合わせ内容を取得
			HttpSession session = request.getSession();
			Form form = (Form) session.getAttribute("form");

			//お問い合わせ投稿処理の呼び出し
			DoneForm doneForm = new DoneForm();
			doneForm.execute(form);

			//セッションスコープ内のインスタンスを削除
			session.removeAttribute("form");

			//登録後のフォワード先を設定
			forwardPath = "jsp/doneform.jsp";

		}
		//設定されたフォワード先にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

//		request.setCharacterEncoding("UTF-8");

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String title = request.getParameter("title");
		String textarea = request.getParameter("textarea");

		Form form = new Form(name, email, title, textarea);

		HttpSession session = request.getSession();
		session.setAttribute("form", form);

		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/checkform.jsp");
		dispatcher.forward(request, response);

	}

}
