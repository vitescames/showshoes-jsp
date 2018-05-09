package br.com.fiap.ps.rwd.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import br.com.fiap.ps.rwd.bean.Endereco;
import br.com.fiap.ps.rwd.bean.LinhaItem;
import br.com.fiap.ps.rwd.bean.Pagina;
import br.com.fiap.ps.rwd.bean.Pedido;
import br.com.fiap.ps.rwd.bean.ProdutoBean;
import br.com.fiap.ps.rwd.bean.Usuario;
import br.com.fiap.ps.rwd.bo.LinhaItemBO;
import br.com.fiap.ps.rwd.bo.PedidoBO;
import br.com.fiap.ps.rwd.bo.ProdutoBO;
import br.com.fiap.ps.rwd.bo.UsuarioBO;
import br.com.fiap.ps.rwd.dao.ProdutoDAO;
import br.com.ss.ws.service.CepService;

@WebServlet("/admin")
public class Administrador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public Administrador() {
		super();
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String idParam = null;
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("carrinho") == null) {
			session.setAttribute("quantCarrinho", null);
		}

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
			case 5:
				
				exibirCarrinho(request, response, session);
				
				break;
			case 6:
				
				try {
					selecionarItem(request, response, session);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				break;
			case 7:
				
				try {
					comprar(request, response, session);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				break;
			case 8:
				
				try {
					exibirPedidos(request, response, session);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				break;
				
			case 9:
				
				try {
					pesquisarPorParametros(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				break;
				
			case 10:
				
				try {
					cadastrarNovoUsuario(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				break;
				
			case 11:
				
				try {
					buscarCep(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				break;
			default:
				break;
			}

	}
	
	private void buscarCep(HttpServletRequest request, HttpServletResponse response) throws IOException, org.json.simple.parser.ParseException {
		
	    response.setContentType("application/json");
	    String cep = request.getParameter("cep");
	    
	    if(cep != null) {
	    
		    JSONObject jobj = new JSONObject();
		    PrintWriter out = response.getWriter();
		    
		    CepService cepService = new CepService();
		    
		    Endereco endereco = cepService.buscarCep(cep);
		    
		    jobj.put("logradouro", endereco.getLogradouro());
		    jobj.put("estado", endereco.getEstado());
		    jobj.put("cidade", endereco.getCidade());
		    jobj.put("bairro", endereco.getBairro());
	
		    out.print(jobj.toString());
	    
	    }
		
	}

	private void cadastrarNovoUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, org.json.simple.parser.ParseException{
		
		request.getRequestDispatcher("cadastro.jsp").forward(request, response);
		
	}

	private void pesquisarPorParametros(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {
		
		Map<String, String> params = new HashMap<String, String>();
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		
		if(request.getParameter("marca") != null) {
			params.put("paramMarca", request.getParameter("marca"));			
		}
		
		if(request.getParameter("preco") != null) {
			params.put("paramPreco", request.getParameter("preco"));
		}
		
		request.setAttribute("marcaSelecionada", request.getParameter("marca"));
		
		listagem(request, response, 6, params);
		request.getRequestDispatcher("filtro.jsp").forward(request, response);
		
	}

	private void selecao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NumberFormatException, ClassNotFoundException, SQLException  {
		
		request.setAttribute("selProd", ProdutoBO.pesquisa(Integer.parseInt(request.getParameter("idProd"))));
		request.getRequestDispatcher("produto-view.jsp").forward(request, response);

	}
	
	private void exibirPedidos(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ClassNotFoundException, ParseException, SQLException, ServletException, IOException {
		
		List<Pedido> listaPedidos = new ArrayList<Pedido>();
		
		if(session.getAttribute("login") == null) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {
			request.setAttribute("listaPedidos", PedidoBO.selecionaPorUsuario((int) session.getAttribute("idUsuario")));
			request.getRequestDispatcher("pedido.jsp").forward(request, response);
		}
	}
	
	private void comprar(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		if(session.getAttribute("login") == null) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
			session.setAttribute("loginToBuy", true);
		} else {			
			
			Date dt = new Date();
			Timestamp dateSQL = new Timestamp(dt.getTime());
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			
			Pedido pedido = new Pedido();
			pedido.setDate(dateSQL);
			pedido.setUsuario(UsuarioBO.trazUsuario((int) session.getAttribute("idUsuario")));
			pedido.setValor((float) session.getAttribute("precoTotal")); 
			
			List<LinhaItem> listaLinhaItens = (ArrayList<LinhaItem>) session.getAttribute("carrinho");
			
			if(listaLinhaItens != null && !listaLinhaItens.isEmpty()) {
				PedidoBO.adicionarPedido(pedido);			

				for (LinhaItem linhaItem : listaLinhaItens) {
					linhaItem.setPedido(PedidoBO.selecionaUltimoPedido().getId());
					LinhaItemBO.adicionaLinhaItem(linhaItem);
				}
				
				session.setAttribute("quantCarrinho", 0);
				session.setAttribute("carrinho", null);
				request.getRequestDispatcher("admin?id=8").forward(request, response);	
			} else {
				request.getRequestDispatcher("erro404.jsp").forward(request, response);
			}			
		
		}
		
	}
	
	private void login(HttpServletRequest request, HttpServletResponse response, String user, String password, HttpSession session) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException, ServletException, IOException {
				
		Usuario usuario = new Usuario();
		usuario.setPassword(password);
		usuario.setUser(user);
		
		Usuario userLogged = UsuarioBO.login(usuario);
		
		if(userLogged != null) {
			session.setAttribute("login", true);
			session.setAttribute("idUsuario", userLogged.getId());
			session.setAttribute("user", userLogged.getUser());
			
			if(session.getAttribute("loginToBuy") == null) {
				exibicaoProdutos(request, response);
			} else {
				request.getRequestDispatcher("admin?id=5").forward(request, response);
			}
		}
		
	}
	
	private void logout(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException, ServletException, IOException {
				
		session.invalidate();
		
		exibicaoProdutos(request, response);
		
	}
	
	private void filtrarProdutos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		listagem(request, response, 6, null);
		
		request.getRequestDispatcher("filtro.jsp").forward(request, response);
		
	}
	
	private void exibicaoProdutos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		listagem(request, response, 3, null);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}
	
	private void exibirCarrinho(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
		
		List<LinhaItem> listaLinhaItens = (ArrayList<LinhaItem>) session.getAttribute("carrinho");
		request.setAttribute("listaLinhas", listaLinhaItens);
		request.getRequestDispatcher("carrinho.jsp").forward(request, response);
	}
	
	private void selecionarItem(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ClassNotFoundException, SQLException, ServletException, IOException {
						
		List<LinhaItem> listaLinhaItens = (ArrayList<LinhaItem>) session.getAttribute("carrinho");
		
		int idProd = Integer.parseInt(request.getParameter("idProd"));	
		ProdutoBean produtoSelecionado = ProdutoBO.pesquisa(idProd);
		boolean existe = false;			
			
		if(listaLinhaItens != null) {
			
			for (LinhaItem linhaItem : listaLinhaItens) {
				if(linhaItem.getProduto().getDesc().equals(produtoSelecionado.getDesc())) {
					if(request.getParameter("quant") == null) {
						linhaItem.setQuantidade(linhaItem.getQuantidade() + 1);
					} else {
						linhaItem.setQuantidade(Integer.parseInt(request.getParameter("quant")));
					}
					session.setAttribute("carrinho", listaLinhaItens);	
					existe = true;
					break;
				} else {
					existe = false;						
				}				
			}
			
		}
		
		if(listaLinhaItens == null || existe == false) {			
			
			if(listaLinhaItens == null) {
				listaLinhaItens = new ArrayList<LinhaItem>();
			}
			
			LinhaItem linhaItem = new LinhaItem();
			linhaItem.setQuantidade(1);
			linhaItem.setProduto(produtoSelecionado);
			listaLinhaItens.add(linhaItem);
			session.setAttribute("carrinho", listaLinhaItens);
			
		}
		
		float total = 0;
		
		for (LinhaItem linhaItem : listaLinhaItens) {
			total += linhaItem.getProduto().getValor() * linhaItem.getQuantidade();
		}
				
		session.setAttribute("precoTotal", total);
		session.setAttribute("quantCarrinho", listaLinhaItens.size());
		response.sendRedirect("carrinho.jsp");		
		
	}

	private void listagem(HttpServletRequest request, HttpServletResponse response, int prodQuantidade, Map<String, String> params) throws ServletException, IOException, SQLException, ClassNotFoundException {
		
		Pattern pattern = Pattern.compile("(\\s)");	
		
		List<ProdutoBean> listaProduto = null;
		
		if(params == null || params.isEmpty()) {
			listaProduto =  ProdutoBO.pesquisa();
		} else {
			listaProduto =  ProdutoBO.pesquisaPorParams(params);
		}
		
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
