package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MakeRecordServlet")
public class MakeRecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		//アプリケーションスコープに酒と量のListが入っていないかをチェックし、（nullかどうか）入っていればスルー
		if( !=null) {
			throw;
		}
		
		//入っていなければ、酒と量のDAOのfindAllメソッドをそれぞれ実行して、戻ったListをセットする。
		
		
		
		//計算ページのjspにフォワードさせる。
		RequestDispatcher dispatcher = request.getRequestDispatcher("");    //フォワード先を入力
		dispatcher.forward(request,  response);

	}

}
