package servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.ArrayList;

import dao.DrinkDAO;
import dao.GlassDAO;
import model.DrinkEntity;
import model.GlassEntity;

@WebServlet("/MakeRecordServlet")
public class MakeRecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		//アプリケーションスコープに酒と量のListが入っていないかをチェックし、入っていればスルー
		if( !=null) {
			
		}
		
		//入っていなければ、酒と量のDAOのfindAllメソッドをそれぞれ実行して、戻ったListをセットする。
		DrinkDAO drinkDAO = new DrinkDAO();
		GlassDAO glassDAO = new GlassDAO();
		
		List<DrinkEntity> drinkList = drinkDAO.findAll();
		List<GlassEntity> glassList = glassDAO.findAll();
		
		//アプリケーションスコープにレコードを保存
		
		
		//計算ページのjspにフォワードさせる。
		RequestDispatcher dispatcher = request.getRequestDispatcher("");    //フォワード先を入力
		dispatcher.forward(request,  response);

	}

}
