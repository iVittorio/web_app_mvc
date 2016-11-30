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

/**
 * Created by i.viktor on 28/11/2016.
 */
public class JournalDao {
    private DataSource dataSource;

    @Autowired
    public JournalDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Journal> showJurnalByIdUser(int id) {
        List<Journal> list = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT DISTINCT id_user, name FROM journal, lections WHERE id_lection=id AND id_user=?")) {
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
}
