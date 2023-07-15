package com.example.demo.dao.implement;


import com.example.demo.dao.DataSource;
import com.example.demo.dao.TransactionDAO;
import com.example.demo.entity.TagFinance;
import com.example.demo.entity.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class TransactionDAOImpl implements TransactionDAO {
    public static final String SELECT_ALL = "SELECT * FROM Transactions inner join Tag_Finances on Transactions.tag_Id = Tag_Finances.id ";
    public static final String INSERT_TRAN = "INSERT INTO Transactions (title, description,amount,tag_Id) VALUES (?,?,?,?)";
    public static final String UPDATE_TRANSACTION = "UPDATE Transactions SET title=?, description =?,amount=?, tag_Id=? WHERE id =?";
    public static final String DELETE_TRAN = "DELETE FROM Transactions WHERE id =?";

    @Override
    public List<Transaction> getAllTransactions() {
        Connection conn = null;
        List<Transaction> list = new ArrayList<>();
        try {
            conn = DataSource.getInstance().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                java.util.Date createAt = rs.getDate("Create_at");
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String description = rs.getString("description");
                double amount = rs.getDouble("amount");
                int tagId = rs.getInt("Tag_id");
                String name = rs.getString("name");
                String descriptionTag = rs.getString("description");
                TagFinance tagFinance = new TagFinance(tagId, name, descriptionTag);
                Transaction transaction = new Transaction(createAt, title, description, amount, id, tagFinance);
                list.add(transaction);
            }

        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Error closing");
                }
            }
        }
        return list;
    }

    @Override
    public void createTransaction(String title, String description, double amount, int tagId) {
        Connection conn = null;
        try {
            conn = DataSource.getInstance().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(INSERT_TRAN);
            pstmt.setString(1, title);
            pstmt.setString(2, description);
            pstmt.setDouble(3, amount);
            pstmt.setInt(4, tagId);
            pstmt.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Error closing");
                }
            }
        }
    }

    @Override
    public void updateTransaction(String title, String description, double amount, int tagId, int id) {
        Connection conn = null;
        try {
            conn = DataSource.getInstance().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(UPDATE_TRANSACTION);
            pstmt.setString(1, title);
            pstmt.setString(2, description);
            pstmt.setDouble(3, amount);
            pstmt.setInt(4, tagId);
            pstmt.setInt(5, id);
            pstmt.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Error closing");
                }
            }
        }
    }

    @Override
    public void deleteTransaction(int id) {
        Connection conn = null;
        try {
            conn = DataSource.getInstance().getConnection();

            PreparedStatement pstmt = conn.prepareStatement(DELETE_TRAN);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            throw new RuntimeException("Failed to delete");

        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Error closing");
                }
            }
        }
    }
}