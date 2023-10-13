package com.example.demo.dao.implement;

import com.example.demo.dao.DataSource;
import com.example.demo.dao.TagFinanceDAO;
import com.example.demo.model.TagFinance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TagFinanceDAOImpl implements TagFinanceDAO {
    public static final String ADD_TAG = "INSERT INTO tag_finance (name, description) VALUES (?, ?)";
    public static final String SELECT_ALL = "SELECT id, name, description FROM tag_finance";
    public static final String DELETE_TAG = "DELETE FROM tag_finance WHERE id =?";
    public static final String UPDATE_TAG = "UPDATE tag_finance SET name =?, description =? WHERE id =?";
    public static final String GET_TAG = "SELECT id, name, description FROM tag_finance WHERE id =?";

    @Override
    public TagFinance create(TagFinance tagFinance) {
        Connection conn = null;
        try {
            conn = DataSource.getInstance().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(ADD_TAG);
            pstmt.setString(1, tagFinance.getName());
            pstmt.setString(2, tagFinance.getDescription());
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
                try {
                    conn.close();
                } catch (SQLException e) {
                }
            }
        }
        return tagFinance;
    }

    @Override
    public TagFinance update(TagFinance tagFinance, int id) {
        Connection conn = null;
        try {
            conn = DataSource.getInstance().getConnection();

            PreparedStatement pstmt = conn.prepareStatement(UPDATE_TAG);

            pstmt.setString(1, tagFinance.getName());
            pstmt.setString(2, tagFinance.getDescription());
            pstmt.setInt(3, id);
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
        return tagFinance;
    }

    @Override
    public List<TagFinance> getAll() {
        List<TagFinance> list = new ArrayList<>();
        Connection conn = null;
        try {
            conn = DataSource.getInstance().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                TagFinance tagFinance = new TagFinance();
                tagFinance.setId(rs.getInt("id"));
                tagFinance.setName(rs.getString("name"));
                tagFinance.setDescription(rs.getString("description"));
                list.add(tagFinance);
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
    public void delete(int id) {
        Connection conn = null;
        try {
            conn = DataSource.getInstance().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(DELETE_TAG);
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
    public TagFinance getById(int id) {
        Connection conn = null;
        try {
            conn = DataSource.getInstance().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(GET_TAG);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                TagFinance tagFinance = new TagFinance();
                tagFinance.setId(rs.getInt("id"));
                tagFinance.setName(rs.getString("name"));
                tagFinance.setDescription(rs.getString("description"));
                return tagFinance;
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
