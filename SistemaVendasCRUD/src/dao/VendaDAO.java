package dao;

import model.Venda;
import model.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VendaDAO {

    public void create(Venda venda) throws SQLException {
        String sql = "INSERT INTO vendas (data_venda, cliente_id, produto_id, quantidade, valor_total) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setDate(1, Date.valueOf(venda.getDataVenda()));
            stmt.setInt(2, venda.getClienteId());
            stmt.setInt(3, venda.getProdutoId());
            stmt.setInt(4, venda.getQuantidade());
            stmt.setDouble(5, venda.getValorTotal());
            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    venda.setId(generatedKeys.getInt(1));
                }
            }
        }
    }

    public List<Venda> read() throws SQLException {
        List<Venda> vendas = new ArrayList<>();
        String sql = "SELECT v.*, c.nome as cliente_nome, p.nome as produto_nome " +
                "FROM vendas v " +
                "JOIN clientes c ON v.cliente_id = c.id " +
                "JOIN produtos p ON v.produto_id = p.id " +
                "ORDER BY v.data_venda DESC";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Venda venda = new Venda();
                venda.setId(rs.getInt("id"));
                venda.setDataVenda(rs.getDate("data_venda").toLocalDate());
                venda.setClienteId(rs.getInt("cliente_id"));
                venda.setClienteNome(rs.getString("cliente_nome"));
                venda.setProdutoId(rs.getInt("produto_id"));
                venda.setProdutoNome(rs.getString("produto_nome"));
                venda.setQuantidade(rs.getInt("quantidade"));
                venda.setValorTotal(rs.getDouble("valor_total"));
                vendas.add(venda);
            }
        }
        return vendas;
    }

    public void update(Venda venda) throws SQLException {
        String sql = "UPDATE vendas SET data_venda=?, cliente_id=?, produto_id=?, quantidade=?, valor_total=? WHERE id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDate(1, Date.valueOf(venda.getDataVenda()));
            stmt.setInt(2, venda.getClienteId());
            stmt.setInt(3, venda.getProdutoId());
            stmt.setInt(4, venda.getQuantidade());
            stmt.setDouble(5, venda.getValorTotal());
            stmt.setInt(6, venda.getId());
            stmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM vendas WHERE id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}