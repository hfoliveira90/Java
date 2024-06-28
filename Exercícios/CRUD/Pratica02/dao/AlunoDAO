package dao;

import factory.ConnectionFactory;
import modelo.Aluno;
import java.sql.*;
import java.sql.PreparedStatement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Administrator
 */
public class AlunoDAO {
    private Connection connection;
    
    public AlunoDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void adiciona(Aluno aluno){
        String sql = "INSERT INTO aluno(cpf, nome, datanasc, peso, altura) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, aluno.getCpf()); // Define o CPF
            stmt.setString(2, aluno.getNome()); // Define o nome
            stmt.setString(3, aluno.getDatanasc()); // Define a data de nascimento
            stmt.setDouble(4, aluno.getPeso()); // Define o peso
            stmt.setDouble(5, aluno.getAltura()); // Define a altura
            stmt.execute();
            stmt.close(); 
        }
        catch (SQLException u){
            throw new RuntimeException(u);
        }
    }
    
    public Aluno listaAluno(String cpf){
        String sql_seleciona_aluno = "SELECT cpf, nome, datanasc, peso, altura FROM aluno WHERE cpf = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql_seleciona_aluno);
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String nome = rs.getString("nome");
                String data = rs.getString("datanasc");
                double peso = rs.getDouble("peso");
                double altura = rs.getDouble("altura");
                return new Aluno(cpf, nome, data, peso, altura);
            } else {
                return null;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Houve algum erro ao listar o aluno, tente mais tarde!");
            throw new RuntimeException(e);
        }
    
    }
    
    public void alterar(String cpf, Aluno aluno){
    
        String sql_altere_aluno = "UPDATE aluno SET cpf = ?, nome = ?, datanasc = ?, peso = ?, altura = ? WHERE cpf = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql_altere_aluno);
            stmt.setString(1, aluno.getCpf());
            stmt.setString(2, aluno.getNome());
            stmt.setString(3, aluno.getDatanasc());
            stmt.setDouble(4, aluno.getPeso());
            stmt.setDouble(5, aluno.getAltura());
            stmt.setString(6, cpf);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Houve algum erro ao alterar os dados do aluno, tente mais tarde!");
            throw new RuntimeException(e);
        }
    }
    
    public void remover(String cpf){
        // Comandos SQL para remover o histórico de peso e o aluno
        String sql_remove_historico = "DELETE FROM historico WHERE cpf_aluno = ?";
        String sql_remove_aluno = "DELETE FROM aluno WHERE cpf = ?";

        try {
            // Inicia a transação.
            connection.setAutoCommit(false);

            // Remove o histórico de peso do aluno
            PreparedStatement stmtHistorico = connection.prepareStatement(sql_remove_historico);;
            stmtHistorico.setString(1, cpf);
            stmtHistorico.executeUpdate();
            stmtHistorico.close();

            // Remove o aluno
            PreparedStatement stmtAluno = connection.prepareStatement(sql_remove_aluno);
            stmtAluno.setString(1, cpf);
            stmtAluno.executeUpdate();
            stmtAluno.close();

            // Confirma a transação. O que é transação? Para que serve essa linha?
            connection.commit();
            connection.setAutoCommit(true);

        } catch (SQLException e) {
            try {
                // Reverte a transação em caso de erro
                connection.rollback();
            } catch (SQLException rollbackException) {
                throw new RuntimeException("Erro ao reverter a transação.", rollbackException);
            }
            
            JOptionPane.showMessageDialog(null, "Houve algum erro ao remover o aluno e seu histórico de peso, tente mais tarde!");
            throw new RuntimeException(e);
        }
    }
}
