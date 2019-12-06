package it.objectmethod.continenti.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.objectmethod.continenti.dao.INazioneDao;
import it.objectmethod.continenti.dao.impl.NazioneDaoImpl;

public class ContinentiServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<String> continenti = new ArrayList<>();

		INazioneDao continentiDao = new NazioneDaoImpl();

		continenti = continentiDao.getContinents();

		request.setAttribute("continenti", continenti);
		request.getRequestDispatcher("pages/continenti.jsp").forward(request, response);

	}
}
