package it.objectmethod.continenti.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.objectmethod.continenti.dao.INazioneDao;
import it.objectmethod.continenti.dao.impl.NazioneDaoImpl;
import it.objectmethod.continenti.domain.Nazione;

public class NazioniServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Nazione> nazioni = new ArrayList<Nazione>();
		HttpSession session = request.getSession();

		String nomeContinente = request.getParameter("nomeContinenti");
		if (nomeContinente == null) {
			nomeContinente = (String) session.getAttribute("continente");
		} else {
			session.setAttribute("continente", nomeContinente);
		}
		INazioneDao nazioniDao = new NazioneDaoImpl();
		nazioni = nazioniDao.getNationByContinent(nomeContinente);
		request.setAttribute("nazioni", nazioni);
		request.getRequestDispatcher("pages/nazioni.jsp").forward(request, response);
	}
}
