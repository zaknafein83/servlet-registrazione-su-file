package formazione.java.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

import formazione.java.model.Persona;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/redirect")
public class GestioneRedirect extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String scelta = req.getParameter("scelta");
		
		if("ListaUtenti".equalsIgnoreCase(scelta)) {
			
			try {
				req.setAttribute("listaPersone", leggiPersoneDaFile());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			getServletContext().getRequestDispatcher("/listaUtenti.jsp").forward(req, resp);

		} else {
			getServletContext().getRequestDispatcher("/registrazione.jsp").forward(req, resp);
		}
	}

	private List<Persona> leggiPersoneDaFile() throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		FileInputStream fileInputStream = new FileInputStream(new File("salvataggio.jvm"));
		ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
		List<Persona> listaPersone = (List<Persona>) inputStream.readObject();
		inputStream.close();
		fileInputStream.close();
		return listaPersone;
	}
}
