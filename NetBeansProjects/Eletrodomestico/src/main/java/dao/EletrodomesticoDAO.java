/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author aluno.den
 */
import com.mycompany.eletrodomestico.conexao.ConexaoMySQL;
import com.mycompany.eletrodomestico.modelo.Pessoa;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class EletrodomesticoDAO {
    
     public void cadastrar(Eletrodomestico eletrodomestico){
        String sql = "INSERT INTO eletrodomestico (nome, marca, voltagem, preco) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexaoMySQL.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, eletrodomestico.getNome());
            stmt.setString(2, eletrodomestico.getMarca());
            stmt.setString(3, eletrodomestico.getVoltagem());
            stmt.setDouble(4, eletrodomestico.getPreco());
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
    }

    public List<Eletrodomestico> listar() throws SQLException {
        List<Eletrodomestico> lista = new ArrayList<>();
        String sql = "SELECT * FROM eletrodomestico";
        try (Connection conn = ConexaoMySQL.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Eletrodomestico e = new Eletrodomestico();
                e.setId(rs.getInt("id"));
                e.setNome(rs.getString("nome"));
                e.setMarca(rs.getString("marca"));
                e.setVoltagem(rs.getString("voltagem"));
                e.setPreco(rs.getDouble("preco"));
                lista.add(e);
            }
        }
        return lista;
    }

    public void atualizar(Eletrodomestico e) throws SQLException {
        String sql = "UPDATE eletrodomestico SET nome=?, marca=?, voltagem=?, preco=? WHERE id=?";
        try (Connection conn = ConexaoMySQL.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, e.getNome());
            stmt.setString(2, e.getMarca());
            stmt.setString(3, e.getVoltagem());
            stmt.setDouble(4, e.getPreco());
            stmt.setInt(5, e.getId());
            stmt.executeUpdate();
        }
    }

    public void remover(int id) throws SQLException {
        String sql = "DELETE FROM eletrodomestico WHERE id=?";
        try (Connection conn = ConexaoMySQL.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}