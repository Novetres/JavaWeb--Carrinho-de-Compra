package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
	// Parametros de conexao
	/* Conexao */
	/* CRUD CREATE */
	/* CRUD READ */
	/* CRUD UPDATE */
	/* CRUD DELETE */

	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://192.168.0.241:3306/dbmycar?useTimezone=true&serverTimezone=UTC";
	private String user = "dba";
	private String password = "123@Senha";

	public Connection conectar() {
		// con - objeto
		Connection con = null;
		// tratamento de exceções
		try {// uso do driver
			Class.forName(driver);
			// estabelecendo a conexão
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			;
			System.out.println(e);
			return null;
		}
	}

//
	public void testarConexao() {
		try {

			Connection con = conectar();
			System.out.println("Conectado: " + con);
			con.close();
		} catch (Exception e) {
			System.out.println(e);

		}

	}

	public void inserirItem(JavaBeans javabeans) {

		String create = "insert into tbcar(item,quantidade,preco) values (?,?,?)";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1, javabeans.getItem());
			pst.setString(2, javabeans.getQuantidade());
			pst.setString(3, javabeans.getPreco().replace(",", "."));

			pst.executeUpdate();
			con.close();
			System.out.println("item adicionado");

		} catch (Exception e) {
			System.out.println(e);
		}
	}

//metodo com retorno criado com a referencia ao vetor dinamico
	/* CRUD READ */
public ArrayList<JavaBeans> listarItem(){
	//criando objeto para acessar a classe Javabeans
	ArrayList<JavaBeans> itens = new ArrayList<>();
	String read = "select * from tbcar order by codigo";
			try {
				Connection con = conectar();
				PreparedStatement pst = con.prepareStatement(read);
				ResultSet rs = pst.executeQuery();
			 while(rs.next()){
				 //variaveis de apoio que recebem os dados do banco
				 String codigo = rs.getString(1);
				 String item = rs.getString(2);
				 String quantidade = rs.getString(3);
				 String preco = rs.getString(4);
				 //populando o Arraylist
				 
				 itens.add(new JavaBeans(codigo,item,quantidade,preco));
				 
			 }
				con.close();
				return itens;
			} catch (Exception e) {
				System.out.println(e);
				return null;
			}
	
	
	
}
public void alterarItem(JavaBeans item) {
	
	String update = "update tbcar set item=?,quantidade=?,preco=? where codigo=?";
	try {
		Connection con = conectar();
		PreparedStatement pst = con.prepareStatement(update);
		pst.setString(1, item.getItem());
		pst.setString(2, item.getQuantidade());
		pst.setString(3, item.getPreco());
		pst.setString(4, item.getCodigo());
		pst.executeUpdate();
		con.close();
		
	} catch (Exception e) {
		System.out.println(e);
	}
}







	public void selecionarItem(JavaBeans item) {
		String read2 = "select * from tbcar where codigo=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, item.getCodigo());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				item.setCodigo(rs.getString(1));
				item.setItem(rs.getString(2));
				item.setQuantidade(rs.getString(3));
				item.setPreco(rs.getString(4));
			}
			con.close();

		} catch (Exception e) {
			System.out.println(e);

		}
	}


	

		public void deletarItem(JavaBeans item)  {
			String delete = "delete from tbcar where codigo=?";
			
				try {
					Connection con = conectar();
					PreparedStatement pst = con.prepareStatement(delete);
					pst.setString(1, item.getCodigo());
					
					pst.executeUpdate();
					
					con.close();
				} catch (Exception e) {
					System.out.println(e);
				}
		}}
//		public void  somando(JavaBeans item) {
//			String somar = "select * FROM tbcar" ;
//			try {
//				Connection con = conectar();
//				PreparedStatement pst = con.prepareStatement(somar);
//				ResultSet rs = pst.executeQuery(); // Passo 3 - slide 22
//				while (rs.next()) {
//
//					item.setQuantidade(rs.getString(3));
//					item.setPreco(rs.getString(4));
//					
//				}
//				con.close();
//			
//			} catch (Exception e) {
//				System.out.println(e);
//			
//				}}		
//}
		