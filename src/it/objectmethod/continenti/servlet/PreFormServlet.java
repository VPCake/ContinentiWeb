package it.objectmethod.continenti.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.objectmethod.continenti.dao.ICittaDao;
import it.objectmethod.continenti.dao.INazioneDao;
import it.objectmethod.continenti.dao.impl.CittaDaoImpl;
import it.objectmethod.continenti.dao.impl.NazioneDaoImpl;
import it.objectmethod.continenti.domain.Citta;
import it.objectmethod.continenti.domain.Nazione;

public class PreFormServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("ID"));
		Citta citta = new Citta();
		if (id != 0) {

			ICittaDao cittaDao = new CittaDaoImpl();
			citta = cittaDao.getCityById(id);
		} else {
			citta.setId(id);
		}
		List<Nazione> nazioni = new ArrayList<Nazione>();
		INazioneDao nazioniDao = new NazioneDaoImpl();
		nazioni = nazioniDao.getNations();

		request.setAttribute("nazioni", nazioni);
		request.setAttribute("city", citta);
		request.getRequestDispatcher("pages/form-preparazione.jsp").forward(request, response);
	}
}