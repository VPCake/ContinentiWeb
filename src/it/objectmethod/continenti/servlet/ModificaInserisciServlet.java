package it.objectmethod.continenti.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.objectmethod.continenti.dao.ICittaDao;
import it.objectmethod.continenti.dao.impl.CittaDaoImpl;

public class ModificaInserisciServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("modificaID"));
		String nome = request.getParameter("modificaNome");
		String codice = request.getParameter("modificaCodice");
		String conferma;
		int check;

		ICittaDao cityDao = new CittaDaoImpl();
		if (id != 0) {
			check = cityDao.modifica(nome, id, codice);
			conferma = "Modifica avvenuta correttamente";
		} else {
			check = cityDao.inserisci(nome, id, codice);
			conferma = "Inserimento avvenuto correttamente";
		}

		if (check != 1) {
			conferma = "Qualcosa e' andato storto";
		}

		request.setAttribute("conferma", conferma);
		request.getRequestDispatcher("pages/conferma-modifica.jsp").forward(request, response);

	}
}
