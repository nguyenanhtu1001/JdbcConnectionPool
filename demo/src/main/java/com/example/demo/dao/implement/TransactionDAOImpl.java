package com.example.demo.dao.implement;


import com.example.demo.dao.DataSource;
import com.example.demo.dao.TransactionDAO;
import com.example.demo.data.entity.TagFinance;
import com.example.demo.data.entity.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class TransactionDAOImpl implements TransactionDAO {
    public static final String SELECT_ALL = "SELECT * FROM Transactions inner join TagFinance on Transactions.tagId = TagFinance.id ";
    public static final String INSERT_TRAN = "INSERT INTO Transactions (title, description,amount,tagId) VALUES (?,?,?,?)";
    public static final String UPDATE_TRANSACTION = "UPDATE Transactions SET title=?, description =?,amount=? WHERE tagId =?";
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
                ;
                String title = rs.getString("title");
                String description = rs.getString("description");
                double amount = rs.getDouble("amount");
                int tagId = rs.getInt("tagId");
                String name = rs.getString("name");
                String descriptionTag = rs.getString("description");
                TagFinance tagFinance = new TagFinance(tagId, name, descriptionTag);
                Transaction transaction = new Transaction("", title, description, amount, tagId, tagFinance);
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
    public void updateTransaction(String title, String description, double amount, int tagId) {
        Connection conn = null;
        try {
            conn = DataSource.getInstance().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(UPDATE_TRANSACTION);
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