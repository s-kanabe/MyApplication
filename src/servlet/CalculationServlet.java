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
import model.CalculationLogic;
import model.DrinkEntity;
import model.GlassEntity;
import model.RegisterMustWater;

@WebServlet("/CalculationServlet")
public class CalculationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		//アプリケーションスコープを取得
		ServletContext application = this.getServletContext();
		List<DrinkEntity> drinkList = (List<DrinkEntity>) application.getAttribute("drinkList");
		List<GlassEntity> glassList = (List<GlassEntity>) application.getAttribute("glassList");
		
		//アプリケーションスコープに酒と量のListが入っていないかをチェックし、入っていればスルー
		//入っていなければ、酒と量のDAOのfindAllメソッドをそれぞれ実行して、戻ったListをセットする。
		if( drinkList== null && glassList == null) {
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
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		//リクエストパラメータを取得
		String selectedDrinkId = request.getParameter("selectedDrink");   //1 
		String selectedGlassId = request.getParameter("selectedglass");   //1
		String selectedNumber = request.getParameter("number");
		
		//アプリケーションスコープからListを取得
		ServletContext application = this.getServletContext();
		List<DrinkEntity> drinkList = (List<DrinkEntity>) application.getAttribute("drinkList");
		List<GlassEntity> glassList = (List<GlassEntity>) application.getAttribute("glassList");
		
		//選択されたドリンクのアルコール濃度・グラスの容量を取得
		double selectedRecordAlcoholRate = drinkList.get(Integer.parseInt(selectedDrinkId)-1).getAlcoholRate();
		int selectedRecordAmount = glassList.get(Integer.parseInt(selectedGlassId)-1).getAmount();
		int number = Integer.parseInt(selectedNumber);
		
		//取得した値をもとにmustWaterを算出する
		CalculationLogic logic = new CalculationLogic();
		double mustWater = logic.excute(selectedRecordAlcoholRate,selectedRecordAmount,number);
		
		//計算結果をリクエストスコープに保存
		RegisterMustWater registerMustWater =  new RegisterMustWater();
		registerMustWater.setMustWater(mustWater);
		request.setAttribute("registerMustWater", registerMustWater);
		
		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
		dispatcher.forward(request,  response);
		
	}

}
