package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.dao.ContatoDao;
import br.com.caelum.modelo.Contato;

@WebServlet("/adicionaContato")
public class AdicionaContatoServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// busca o writer

		PrintWriter out = response.getWriter();
		// buscando os parāmetros no request
		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String email = request.getParameter("email");
		Calendar dataNascimento = Calendar.getInstance();

		// monta um objeto contato
		Contato contato = new Contato();
		contato.setNome(nome);

		contato.setEndereco(endereco);
		contato.setEmail(email);
		contato.setDataNascimento(dataNascimento);
		// salva o contato
		ContatoDao dao = new ContatoDao();
		dao.adiciona(contato);
		// imprime o nome do contato que foi adicionado
		out.println("<html>");
		out.println("<body>");
		out.println("Contato " + contato.getNome() + " adicionado com sucesso");
		out.println("</body>");
		out.println("</html>");
	}
}
