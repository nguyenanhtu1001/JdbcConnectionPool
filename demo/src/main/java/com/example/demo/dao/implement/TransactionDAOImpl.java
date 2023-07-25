package com.example.demo.dao.implement;


import com.example.demo.dao.DataSource;
import com.example.demo.dao.TransactionDAO;
import com.example.demo.dto.response.TransactionResponse;
import com.example.demo.entity.Transaction;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class TransactionDAOImpl implements TransactionDAO {
    public static final String CREATE_TRANSACTION_TAG = "INSERT INTO Transaction_Tag_Finance (tag_id, transaction_id) VALUES (?, ?)";
    public static final String SELECT_ALL = "SELECT * FROM Transaction inner join Transaction_Tag_Finance on Transaction.id=Transaction_Tag_Finance.transaction_id";
    public static final String INSERT_TRAN = "INSERT INTO Transaction (title, description,amount) VALUES (?,?,?)";
    public static final String UPDATE_TRANSACTION = "UPDATE Transaction SET title=?, description =?,amount=? WHERE id =?";
    public static final String DELETE_TRAN = "DELETE FROM Transaction WHERE id =?";
    private static final String SELECT_TAGS_BY_TRANSACTION_ID = "SELECT tag_id FROM Transaction_Tag_Finance WHERE transaction_id = ?";


    @Override
    public List<TransactionResponse> getAllTransactions() {
        Connection conn = null;
        List<TransactionResponse> list = new ArrayList<>();
        try {
            conn = DataSource.getInstance().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String description = rs.getString("description");
                double amount = rs.getDouble("amount");

                PreparedStatement pstmtTags = conn.prepareStatement(SELECT_TAGS_BY_TRANSACTION_ID);
                pstmtTags.setInt(1, id);
                ResultSet rsTags = pstmtTags.executeQuery();

                List<Integer> tagIds = new ArrayList<>();
                while (rsTags.next()) {
                    int tagId = rsTags.getInt("tag_id");
                    tagIds.add(tagId);
                }
                TransactionResponse response = new TransactionResponse(id, title, description, amount, tagIds);
                list.add(response);
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
    public Transaction createTransaction(Transaction transaction, List<Integer> tagIds) {
        Connection conn = null;
        try {
            conn = DataSource.getInstance().getConnection();

            PreparedStatement insert = conn.prepareStatement(INSERT_TRAN, Statement.RETURN_GENERATED_KEYS);
            insert.setString(1, transaction.getTitle());
            insert.setString(2, transaction.getDescription());
            insert.setDouble(3, transaction.getAmount());
            insert.executeUpdate();

            ResultSet generatedKeys = insert.getGeneratedKeys();
            int transactionId;
            if (generatedKeys.next()) {
                transactionId = generatedKeys.getInt(1);
            } else {
                throw new SQLException("Failed to retrieve generated transaction ID");
            }

            for (int tagId : tagIds) {
                PreparedStatement create = conn.prepareStatement(CREATE_TRANSACTION_TAG);
                create.setInt(1, tagId);
                create.setInt(2, transactionId);
                create.executeUpdate();
            }

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
        return transaction;
    }

    @Override
    public Transaction updateTransaction(Transaction transaction, int id) {
        Connection conn = null;
        try {
            conn = DataSource.getInstance().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(UPDATE_TRANSACTION);
            pstmt.setString(1, transaction.getTitle());
            pstmt.setString(2, transaction.getDescription());
            pstmt.setDouble(3, transaction.getAmount());
            pstmt.setInt(4, id);
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
        return transaction;
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