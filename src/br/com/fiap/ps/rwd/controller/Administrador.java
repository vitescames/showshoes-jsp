package br.com.fiap.ps.rwd.controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.ps.rwd.bean.Pagina;
import br.com.fiap.ps.rwd.bean.ProdutoBean;
import br.com.fiap.ps.rwd.bean.Usuario;
import br.com.fiap.ps.rwd.bo.ProdutoBO;
import br.com.fiap.ps.rwd.bo.UsuarioBO;

@WebServlet("/admin")
public class Administrador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public Administrador() {
		super();
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String idParam = null;
		
		HttpSession session = request.getSession();

		idParam = request.getParameter("id");
		int id = 1;		
		
		if(idParam != null) {
			id = Integer.parseInt(idParam);
		}
			
			switch (id) {
			case 1:
				
				try {
					exibicaoProdutos(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				break;
			case 2:
				
				try {
					selecao(request,response);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				break;
			case 3:
				
				String user = request.getParameter("user");
				String password = request.getParameter("pass");
				
				try {
					
					if(session.getAttribute("login") == null) {					
						login(request, response, user, password, session);
					} else {
						logout(request, response, session);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				break;
			case 4:
				
				try {
					filtrarProdutos(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				break;
			default:
				break;
			}

	}

	private void selecao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NumberFormatException, ClassNotFoundException, SQLException  {
		
		request.setAttribute("selProd", ProdutoBO.pesquisa(Integer.parseInt(request.getParameter("idProd"))));
		request.getRequestDispatcher("produto-view.jsp").forward(request, response);

	}
	
	private void login(HttpServletRequest request, HttpServletResponse response, String user, String password, HttpSession session) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException, ServletException, IOException {
				
		Usuario usuario = new Usuario();
		usuario.setPassword(password);
		usuario.setUser(user);
		
		Usuario userLogged = UsuarioBO.login(usuario);
		
		if(userLogged != null) {
			session.setAttribute("login", true);
			session.setAttribute("user", userLogged.getUser());
			
			exibicaoProdutos(request, response);
		}
		
	}
	
	private void logout(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException, ServletException, IOException {
				
		session.invalidate();
		
		exibicaoProdutos(request, response);
		
	}
	
	private void filtrarProdutos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		listagem(request, response, 6);
		
		request.getRequestDispatcher("filtro.jsp").forward(request, response);
		
	}
	
	private void exibicaoProdutos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		listagem(request, response, 3);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

	private void listagem(HttpServletRequest request, HttpServletResponse response, int prodQuantidade) throws ServletException, IOException, SQLException, ClassNotFoundException {
		
		Pattern pattern = Pattern.compile("(\\s)");	
		
		List<ProdutoBean> listaProduto =  ProdutoBO.pesquisa();
		List<Pagina> listaPagina = new ArrayList<Pagina>();
		
		int indexPagina = 1;
		
		for (int i = 0; i < listaProduto.size(); i+=prodQuantidade) {
			Pagina pagina = new Pagina();
			pagina.setIndex(indexPagina);
			listaPagina.add(pagina);
			indexPagina++;
		}
		
		for (ProdutoBean produtoBean : listaProduto) {
	
			Matcher matcher = pattern.matcher(produtoBean.getInfo());
			
			int index = 0;
			
			while(matcher.find()) {
				index = matcher.end();
				
				if(index >= 100) {
					break;
				}
			}
			
			produtoBean.setInfo(produtoBean.getInfo().replace(produtoBean.getInfo().substring(index, produtoBean.getInfo().length()), "..."));
			
			for (Pagina pagina : listaPagina) {
				if(pagina.getListaProdutos().size() == prodQuantidade) {
					continue;
				} else {
					pagina.getListaProdutos().add(produtoBean);
					break;
				}
			}
			
		}
		
		request.setAttribute("listaPagina", listaPagina);
		request.setAttribute("quant", listaPagina.size());

	}

}
