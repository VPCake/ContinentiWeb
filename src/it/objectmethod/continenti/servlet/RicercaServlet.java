package it.objectmethod.continenti.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

public class RicercaServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Citta> citta = new ArrayList<Citta>();
		List<Nazione> nazioni = new ArrayList<Nazione>();

		String nomeRicerca = request.getParameter("name");
		String codiceRicerca = request.getParameter("code");

		ICittaDao ricercaDao = new CittaDaoImpl();
		citta = ricercaDao.getSearch(nomeRicerca, codiceRicerca);

		INazioneDao nazioniDao = new NazioneDaoImpl();
		nazioni = nazioniDao.getNations();

		request.setAttribute("nazioni", nazioni);
		request.setAttribute("city", citta);
		request.getRequestDispatcher("pages/ricerca.jsp").forward(request, response);
	}
}