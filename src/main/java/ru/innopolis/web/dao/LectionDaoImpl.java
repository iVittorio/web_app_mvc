package ru.innopolis.web.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.innopolis.web.beans.Lection;
import ru.innopolis.web.exception.MyException;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static ru.innopolis.web.constants.Queries.*;

/**
 * Created by i.viktor on 28/11/2016.
 */
public class LectionDaoImpl implements LectionDao {
    private Logger logger = LoggerFactory.getLogger(LectionDaoImpl.class);

    private DataSource dataSource;

    @Autowired
    public LectionDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * @return list lections from database
     */
    @ExceptionHandler({MyException.class})
    public List<Lection> getLections() {
        List<Lection> lections = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_LECTIONS_QUERY)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String text = resultSet.getString("text");
                lections.add(new Lection(id, name, text));
            }
        } catch (SQLException e) {
            logger.error("Error with SQL in getLections method", e);
            throw new MyException(e.getMessage());
        }
        return lections;
    }

    /**
     * @param id lection
     * @return Lection from database
     */
    @ExceptionHandler({MyException.class})
    public Lection getLectionById(int id) {
        Lection lection = null;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_LECTION_BY_ID_QUERY)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String text = resultSet.getString("text");
                lection = new Lection(id, name, text);
            }

        } catch (SQLException e) {
            logger.error("Error with SQL in getLectionById method", e);
            throw new MyException(e.getMessage());
        }
        return lection;
    }

    /**
     * Delete lection from database
     * @param id
     */
    @ExceptionHandler({MyException.class})
    public void deletLectionById(int id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_LECTION_BY_ID_QUERY)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Error with SQL in deletLectionById method", e);
            throw new MyException(e.getMessage());
        }
    }

    /**
     * Add lection in database
     * @param lection
     */
    @ExceptionHandler({MyException.class})
    public void addLection(Lection lection) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD_LECTION_QUERY)) {
            preparedStatement.setString(1, lection.getName());
            preparedStatement.setString(2, lection.getText());
            preparedStatement.execute();
        } catch (SQLException e) {
            logger.error("Error with SQL in addLection method", e);
            throw new MyException(e.getMessage());
        }
    }

    /**
     * Edit lection in database
     * @param lection
     */
    @ExceptionHandler({MyException.class})
    public void editLection(Lection lection) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(EDIT_LECTION_QUERY)) {
            preparedStatement.setString(1, lection.getName());
            preparedStatement.setString(2, lection.getText());
            preparedStatement.setInt(3, lection.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            logger.error("Error with SQL in editLection method", e);
            throw new MyException(e.getMessage());
        }
    }
}
