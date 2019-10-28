package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DrinkDAO;
import dao.GlassDAO;
import model.DrinkEntity;
import model.GlassEntity;

@WebServlet("/MakeRecordServlet")
public class MakeRecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		//アプリケーションスコープを取得
		ServletContext application = this.getServletContext();
		List<DrinkEntity> drinkList = (List<DrinkEntity>) application.getAttribute("drinkList");
		List<GlassEntity> glassList = (List<GlassEntity>) application.getAttribute("glassList");
		
		//アプリケーションスコープに酒と量のListが入っていないかをチェックし、入っていればスルー
		//入っていなければ、酒と量のDAOのfindAllメソッドをそれぞれ実行して、戻ったListをセットする。
		if( drinkList!= null && glassList == null) {
			DrinkDAO drinkDAO = new DrinkDAO();
			GlassDAO glassDAO = new GlassDAO();
			
			drinkList = drinkDAO.findAll();
			glassList = glassDAO.findAll();
			
			//アプリケーションスコープにレコードを保存
			application.setAttribute("drinkList", drinkList);
			application.setAttribute("glassList", glassList);
		}
				
		//計算ページのjspにフォワードさせる。
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/select.jsp");    //フォワード先を入力
		dispatcher.forward(request,  response);

	}

}
