package ru.innopolis.web.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.innopolis.web.beans.Journal;
import ru.innopolis.web.exception.MyException;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static ru.innopolis.web.constants.Queries.ADD_LECTION_IN_JOURNAL;
import static ru.innopolis.web.constants.Queries.SHOW_USER_JOURNAL;

/**
 * Created by i.viktor on 28/11/2016.
 */
public class JournalDaoImpl implements JournalDao {
    private Logger logger = LoggerFactory.getLogger(JournalDaoImpl.class);

    private DataSource dataSource;

    @Autowired
    public JournalDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @ExceptionHandler(MyException.class)
    public List<Journal> showJurnalByIdUser(int id) {
        List<Journal> list = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SHOW_USER_JOURNAL)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");

                list.add(new Journal(id, name));
            }
        } catch (SQLException e) {
            logger.error("Error with SQL in showJurnalByIdUser method", e);
            throw new MyException(e.getMessage());
        }
        return list;
    }

    @ExceptionHandler(MyException.class)
    public void addEntryInJournal(String login, int id) {

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD_LECTION_IN_JOURNAL)) {
            preparedStatement.setString(1, login);
            preparedStatement.setInt(2, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            logger.error("Error with SQL in addEntryInJournal method", e);
            throw new MyException(e.getMessage());
        }
    }
}
