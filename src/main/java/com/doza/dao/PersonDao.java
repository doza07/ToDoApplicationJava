package com.doza.dao;

import com.doza.entity.account.Account;
import com.doza.entity.person.Person;
import com.doza.entity.person.PersonRole;
import com.doza.exception.DaoException;
import com.doza.util.ConnectionManager;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//TODO доделать CRUD
public class PersonDao {

    private static final PersonDao INSTANCE = new PersonDao();

    public static final String FIND_ALL_PERSON_SQL = """
                        SELECT id, first_name, last_name, phone, email, password, date_of_birth, role
            FROM person;
            """;

    public static final String FIND_PERSON_BY_ID_SQL = """
            SELECT id, first_name, last_name, phone, email, password, date_of_birth, role
            FROM person
            WHERE id=?;
            """;

    public static final String CREATE_ACCOUNT_SQL = """
            INSERT INTO  person (first_name, last_name, phone, email, password, date_of_birth, role) 
            VALUES  (?, ?, ?, ?, ?, ?, ?);
            """;

    public Person findUserById(Long id) throws DaoException {
        try (Connection connection = ConnectionManager.get();
             var prepareStatement = connection.prepareStatement(FIND_PERSON_BY_ID_SQL)) {
            prepareStatement.setLong(1, id);
            var resultSet = prepareStatement.executeQuery();
            Person person = null;
            if (resultSet.next()) {
                person = buildUser(resultSet);
            }
            return person;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }


    public List<Person> findAllPerson() {
        try (Connection connection = ConnectionManager.get();
             var prepareStatement = connection.prepareStatement(FIND_ALL_PERSON_SQL);) {
            ResultSet resultSet = prepareStatement.executeQuery();
            List<Person> persons = new ArrayList<>();
            while (resultSet.next()) {
                persons.add(buildUser(resultSet));
            }
            return persons;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public Person savePerson(Person person) {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement prepareStatement = connection.prepareStatement(CREATE_ACCOUNT_SQL, Statement.RETURN_GENERATED_KEYS)) {
            prepareStatement.setString(1, person.getFirstName());
            prepareStatement.setString(2, person.getLastName());
            prepareStatement.setString(3, person.getPhone());
            prepareStatement.setString(4, person.getEmail());
            prepareStatement.setString(5, person.getPassword());
            prepareStatement.setDate(6, Date.valueOf((LocalDate) person.getDateOfBirth()));
            prepareStatement.setInt(7, person.getRole().ordinal());


            prepareStatement.executeUpdate();

            ResultSet generatedKeys = prepareStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                person.setId(generatedKeys.getLong("id"));
            }
            return person;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }


    //TODO(исправить заполнения projectList)
    private static Person buildUser(ResultSet resultSet) throws SQLException {
        Long userId = resultSet.getLong("id");

        return new Person(
                resultSet.getLong("id"),
                resultSet.getString("first_name"),
                resultSet.getString("last_name"),
                resultSet.getString("phone"),
                resultSet.getString("email"),
                resultSet.getString("password"),
                resultSet.getDate("date_of_birth").toLocalDate(),
                PersonRole.fromId(resultSet.getInt("role")),
                ProjectDao.getProjectsByUserId(userId)
        );
    }

    public static PersonDao getInstance() {
        return INSTANCE;
    }
}
