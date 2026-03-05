package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import model.DAO;
import model.JavaBeans;

@WebServlet(urlPatterns = { "/controller", "/main", "/insert", "/select", "/update", "/delete", "/report" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		if (action.equals("/main")) {
			contatos(request, response);
		} else if (action.equals("/insert")) {
			novoContato(request, response);
		} else if (action.equals("/select")) {
			listarContato(request, response);
		} else if (action.equals("/update")) {
			editarContato(request, response);
		} else if (action.equals("/delete")) {
			removerContato(request, response);
		} else if (action.equals("/report")) {
			reportar (request, response);
		}else {
			response.sendRedirect("index.html");
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

	}

	protected void contatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<JavaBeans> lista = dao.listarContatos();
		// Encaminhar a lista ao documento jsp
		request.setAttribute("contatos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("agenda.jsp");
		rd.forward(request, response);

	}

	protected void novoContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Corrigido o case do parâmetro email
		String nome = request.getParameter("nome");
		String fone = request.getParameter("fone");
		String email = request.getParameter("email"); // HTML agora também tem name="email"

		JavaBeans contato = new JavaBeans();
		contato.setNome(nome);
		contato.setFone(fone);
		contato.setEmail(email);

		dao.inserirContato(contato);

		response.sendRedirect("main");
	}

	// listar contatos
	protected void listarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// recebimento do id do contato que sera editado
		String idcon = request.getParameter("idcon");
	
		JavaBeans contato = new JavaBeans();
		contato.setIdcon(idcon);
		// executar o método da classe listarContato(DAO)
		dao.selecionarContato(contato);
		

		// setar o formulario com os atributos JavaBeans
		request.setAttribute("idcon", contato.getIdcon());
		request.setAttribute("nome", contato.getNome());
		request.setAttribute("fone", contato.getFone());
		request.setAttribute("email", contato.getEmail());
		// encaminhar ao documento jsp
		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);

	}

	// editar contatos
	protected void editarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		// setar as variaveis JavaBeans
		JavaBeans contato = new JavaBeans();
		contato.setIdcon(request.getParameter("idcon"));
		contato.setNome(request.getParameter("nome"));
		contato.setFone(request.getParameter("fone"));
		contato.setEmail(request.getParameter("email"));
		// executar o metodo alterar contato
		dao.alterarContato(contato);
		// redirecionar para o documento jsp (atualizando as alteraçoes)
		response.sendRedirect("main");

	}

	// remover contatos
	protected void removerContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// recebimento do id do contato a ser exluido (validador.js)
		String idcon = request.getParameter("idcon");
		// System.out.println(idcon);

		// setar a variavel idcon JavaBeans
		JavaBeans contato = new JavaBeans();
		contato.setIdcon(idcon);
		// executar o método deletarContato (DAO) passando objeto contato
		dao.deletarContato(contato);
		// redirecionar para o documento jsp (atualizando as alteraçoes)
		response.sendRedirect("main");
	}
	// reportar contatos 
	protected void reportar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Document documento = new Document();
		try {
			//tipo do documento
			response.setContentType("application/pdf");
			//nome do documento
			response.addHeader("Content-Disposition", "inline;filename=contatos.pdf");
			//criar documento
			PdfWriter.getInstance(documento, response.getOutputStream());
			// abrir documento -> conteudo 
			documento.open();
			documento.add( new Paragraph("Lista de Contatos: "));
			documento.add( new Paragraph(" "));
			//criar uma tabela
			PdfPTable tabela = new PdfPTable(3);
			//cabeçalho
			PdfPCell col1 = new PdfPCell (new Paragraph("Nome"));
			PdfPCell col2 = new PdfPCell (new Paragraph("Fone"));
			PdfPCell col3 = new PdfPCell (new Paragraph("Email"));
			tabela.addCell(col1);
			tabela.addCell(col2);
			tabela.addCell(col3);
			// popular a tabela com os contatos
			List<JavaBeans> lista  = dao.listarContatos();
			for (int i = 0; i < lista.size(); i++) {
				tabela.addCell(lista.get(i).getNome());
				tabela.addCell(lista.get(i).getFone());
				tabela.addCell(lista.get(i).getEmail());
			}	
			documento.add(tabela);
			documento.close();
		} catch (Exception e) {
			e.printStackTrace();
			documento.close();
		}
	}
}