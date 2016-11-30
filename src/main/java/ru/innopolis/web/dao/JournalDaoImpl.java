package ru.innopolis.web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import ru.innopolis.web.beans.Journal;

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
    private DataSource dataSource;

    @Autowired
    public JournalDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

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
            e.printStackTrace();
        }
        return list;
    }

    public void addEntryInJournal(String login, int id) {

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD_LECTION_IN_JOURNAL)) {
            preparedStatement.setString(1, login);
            preparedStatement.setInt(2, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
