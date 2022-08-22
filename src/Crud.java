import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Crud {
	
	public void cadastrar(String nome, String telefone) {
		try {
			//Banco de dados em Java e qualquer aplica��o
			
			//1� Etapa - Conex�o com um SGBD			
			//2� Etapa - Conectar com um BD - URL - protocolo://localiza��o/recurso
			//URL JDBC - driver://ip/database
			Connection servidor = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/agenda","root","");
			
			//3� Etapa - Executar uma consulta (SQL)
			//Statement consulta = (Statement) servidor.createStatement();
			//consulta.executeUpdate("INSERT INTO cadastro (nome,telefone)" + "values('"+nome+"',"+telefone+")");
			
			PreparedStatement consulta = servidor.prepareStatement("INSERT INTO cadastro (nome, telefone) VALUES (?, ?)");
			consulta.setString(1, nome);
			consulta.setString(2, telefone);
			consulta.executeUpdate();
			
			//4� Etapa - Encerrar a conex�o com o SGBD
			servidor.close();
		} catch(Exception erro) {
			System.out.println("Aconteceu algum erro! E o erro foi esse: " + erro.getMessage());
		}
				
	}
	
	
	public void excluir(int id) {
		try {
			
			Connection servidor = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/agenda","root","");
			
			//3� Etapa - Executar uma consulta (SQL)
			Statement consulta = (Statement) servidor.createStatement();
			
			consulta.executeUpdate("DELETE FROM cadastro where id = " + id);
			
			//4� Etapa - Encerrar a conex�o com o SGBD
			servidor.close();
		} catch(Exception erro) {
			System.out.println("Aconteceu algum erro! E o erro foi esse: " + erro.getMessage());
		}
				
	}
	
	public void editar(int id, String novoNome, String novoTelefone) {
		try {
			
			Connection servidor = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/agenda","root","");
			
			//3� Etapa - Executar uma consulta (SQL)
			Statement consulta = (Statement) servidor.createStatement();
			
			consulta.executeUpdate("UPDATE cadastro set nome = '"+novoNome+"', telefone = '"+novoTelefone+"' where id = " + id);
			
			//4� Etapa - Encerrar a conex�o com o SGBD
			servidor.close();
		} catch(Exception erro) {
			System.out.println("Aconteceu algum erro! E o erro foi esse: " + erro.getMessage());
		}
				
	}
	
	public void selecionarTudo() {
		try {
			
			Connection servidor = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/agenda","root","");
			
			//3� Etapa - Executar uma consulta (SQL)
			Statement consulta = (Statement) servidor.createStatement();
			
			//Consulta SQL Select - Retorna Inst�ncias da classe ResultSet
			ResultSet cadastro = consulta.executeQuery("SELECT * FROM cadastro");
			
			String relatorio = "";
			
			while(cadastro.next()) {
				relatorio += cadastro.getString("nome") + "\t" + cadastro.getString("telefone") + "\n";
			}
			
			System.out.println(relatorio);
			//4� Etapa - Encerrar a conex�o com o SGBD
			servidor.close();
		} catch(Exception erro) {
			System.out.println("Aconteceu algum erro! E o erro foi esse: " + erro.getMessage());
		}
	}
}
