package it.objectmethod.continenti.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.objectmethod.continenti.dao.ICittaDao;
import it.objectmethod.continenti.dao.impl.CittaDaoImpl;
import it.objectmethod.continenti.domain.Citta;

public class CittaServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String codiceNazione = request.getParameter("CountryCode");

		List<Citta> cities = new ArrayList<Citta>();

		ICittaDao citta = new CittaDaoImpl();

		cities = citta.getCityByCountryCode(codiceNazione);

		request.setAttribute("citta", cities);
		request.getRequestDispatcher("pages/citta.jsp").forward(request, response);

	}
}
