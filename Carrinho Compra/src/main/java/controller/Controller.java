package controller;

import java.io.IOException;
import java.util.ArrayList;

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

// Recebimento de requisicoes

@WebServlet(urlPatterns = { "/Controller", "/main", "/insert", "/select", "/update", "/delete", "/report"})
public class Controller extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// criar objetos para acessar o metodos publicos das classes JAVABEANS e DAO

	JavaBeans javabeans = new JavaBeans();
	DAO dao = new DAO();

	public Controller() {
		super();
	}

	/**
	 * Metodo principal do Servlet
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// teste de conexao com o banco de dados
		dao.testarConexao();
		// Encaminhamento das requisicoes
		String action = request.getServletPath(); // armazena a requisicao atual
		System.out.println("Requisição: " + action);
		if (action.equals("/main")) {
			item(request, response);
		} else if (action.equals("/insert")) {
			novoItem(request, response);
		} else if (action.equals("/select")) {
			listarItem(request, response);
		} else if (action.equals("/update")) {
		alterarItem(request, response);
	}	 else if (action.equals("/delete")) {
			 excluirItem(request, response);
		}else if (action.equals("/report")) {
			 gerarRelatorio(request, response);

		
		}
	}

	// Adicionar contato
	protected void novoItem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// teste de recebimento dos dados do formulario
////			
//			System.out.println(request.getParameter("item"));
//			System.out.println(request.getParameter("quantidade"));
//		System.out.println(request.getParameter("preco"));

		// Receber os dados do formulario e armazenar temporarimente nas variaveis
		// javabeans
		javabeans.setItem(request.getParameter("item"));
		javabeans.setQuantidade(request.getParameter("quantidade"));
		javabeans.setPreco(request.getParameter("preco"));

		// executar o metodo inserirContato (DAO) passando javabeans
		dao.inserirItem(javabeans);

		response.sendRedirect("main");

	}

	// Listar contatos
	protected void item(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<JavaBeans> lista = dao.listarItem();
		request.setAttribute("itens", lista);
		RequestDispatcher rd = request.getRequestDispatcher("carrinho.jsp");
		rd.forward(request, response);
//	
	}

	protected void listarItem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String codigo = request.getParameter("codigo");
		// teste de recebimento de parametro

		// setar a variavel idcon no javabeans
		// passo 2
		javabeans.setCodigo(codigo);
//		//executar o metodo selecionarContato (DAO)
		dao.selecionarItem(javabeans);
//		System.out.println(javabeans.getCodigo());
//		System.out.println(javabeans.getItem());
//		System.out.println(javabeans.getQuantidade());
//		System.out.println(javabeans.getPreco());

		// Despachar os dados das variaveis JavaBeans para editar.jsp

		request.setAttribute("codigo", javabeans.getCodigo());
		request.setAttribute("item", javabeans.getItem());
		request.setAttribute("quantidade", javabeans.getQuantidade());
		request.setAttribute("preco", javabeans.getPreco());
//		
//		
		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);

	}

	protected void alterarItem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		javabeans.setCodigo(request.getParameter("codigo"));
		javabeans.setItem(request.getParameter("item"));
		javabeans.setQuantidade(request.getParameter("quantidade"));
		javabeans.setPreco(request.getParameter("preco"));
		dao.alterarItem(javabeans);
		response.sendRedirect("main");
	}
	

	protected void excluirItem(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	String codigo = request.getParameter("codigo");
//	System.out.println(codigo);
   	javabeans.setCodigo(codigo);
//	
//
 	dao.deletarItem(javabeans);
	response.sendRedirect("main");
}
	protected void gerarRelatorio(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	 Document documento = new Document ();
	 try {
		 // tipo de conteudo
		 response.setContentType("application/pdf");
		 // nome do documento
		 response.addHeader("Content-Disposition", "inline; filename=" + "itens.pdf");
		 PdfWriter.getInstance(documento, response.getOutputStream());
		// abrir o documento para gerar conteudo
		 documento.open();
		 documento.add(new Paragraph("Lista de itens"));
		 documento.add(new Paragraph("  "));
		//criar tabela
		 PdfPTable  tabela = new PdfPTable (4);
		 PdfPCell col1 = new PdfPCell(new Paragraph("Codigo"));
		 PdfPCell col2 = new PdfPCell(new Paragraph("Item"));
		 PdfPCell col3 = new PdfPCell(new Paragraph("Quantidade"));
		 PdfPCell col4 = new PdfPCell(new Paragraph("Preco"));
		 tabela.addCell(col1);
		 tabela.addCell(col2);
		 tabela.addCell(col3);
		 tabela.addCell(col4);
		
		 //preencher a tabela com os itens
		 ArrayList<JavaBeans> lista = dao.listarItem();
		 for (int i = 0; i < lista.size(); i++) {
			 tabela.addCell(lista.get(i).getCodigo());
			 tabela.addCell(lista.get(i).getItem());
			 tabela.addCell(lista.get(i).getQuantidade());
			 tabela.addCell(lista.get(i).getPreco());
			 
			 
			 
		 }
		 documento.add(tabela);
		 documento.close();
	} catch (Exception e) {
		System.out.println(e);
		documento.close();
	}
	}
	 
}