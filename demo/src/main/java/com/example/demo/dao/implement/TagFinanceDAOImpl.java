package com.example.demo.dao.implement;

import com.example.demo.dao.DataSource;
import com.example.demo.dao.TagFinanceDAO;
import com.example.demo.data.entity.TagFinance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TagFinanceDAOImpl implements TagFinanceDAO {
    public static final String ADD_TAG = "INSERT INTO TagFinance(name,description) VALUES (?, ?)";
    public static final String SELECT_ALL = "SELECT id, name, description FROM TagFinance";
    public static final String DELETE_TRAN = "DELETE FROM TagFinance WHERE id =?";
    public static String UPDATE_TAG = "UPDATE TagFinance SET name =?, description =? WHERE id =?";
    public static final String GET_TAG = "SELECT * FROM TagFinance WHERE id =?";

    @Override
    public void createTagFinance(String name, String description) throws SQLException {
        Connection conn = null;
        try {
            conn = DataSource.getInstance().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(ADD_TAG);
            pstmt.setString(1, name);
            pstmt.setString(2, description);
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
            if (Objects.nonNull(conn)) {
                conn.close();
            }
        }
    }

    @Override
    public void updateTagFinance(int id,String name, String description ){
        Connection conn = null;
        try {
            conn = DataSource.getInstance().getConnection();

            PreparedStatement pstmt = conn.prepareStatement(UPDATE_TAG);
            pstmt.setInt(3, id);
            pstmt.setString(1, name);
            pstmt.setString(2, description);
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
    public List<TagFinance> getAllTagFinance() {
        List<TagFinance> list = new ArrayList<>();
        Connection conn = null;
        try {
            conn = DataSource.getInstance().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                TagFinance tagFinance2 = new TagFinance(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"));
                list.add(tagFinance2);
            }
        } catch (SQLException e) {
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
    public void deleteTagFinance(int id) {
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

    @Override
    public TagFinance getTagFinanceById(int id) throws Exception {
        Connection conn = null;
        try {
            conn = DataSource.getInstance().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(GET_TAG);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                TagFinance tagFinanceGet = new TagFinance(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"));
                return tagFinanceGet;
            }

        } catch (SQLException e) {
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
        return null;
    }

}