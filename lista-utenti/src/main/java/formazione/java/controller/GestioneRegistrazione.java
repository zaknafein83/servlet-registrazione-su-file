package formazione.java.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import formazione.java.model.Persona;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/registrazione")
public class GestioneRegistrazione extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("nome");
		String cognome = req.getParameter("cognome");
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		Persona persona = new Persona(nome, cognome, username, password);

		try {
			salvaPersonaSuFile(persona);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);

	}

	private void salvaPersonaSuFile(Persona persona) throws IOException, ClassNotFoundException {
		List<Persona> listaPersone = new ArrayList<Persona>();
		File file = new File("salvataggio.jvm");
		if (file.exists()) {
			FileInputStream fileInputStream = new FileInputStream(file);
			ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
			listaPersone = (List<Persona>) inputStream.readObject();
			inputStream.close();
			fileInputStream.close();
		}
		
		listaPersone.add(persona);

		FileOutputStream fileOutputStream = new FileOutputStream(file);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(listaPersone);

		objectOutputStream.close();
		fileOutputStream.close();

	}
}
