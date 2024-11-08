package com.doza.dao;

import com.doza.entity.account.Account;
import com.doza.entity.account.AccountStatus;
import com.doza.exception.DaoException;
import com.doza.generator.GeneratorPerson;
import com.doza.util.ConnectionManager;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class AccountDao {
    private static final AccountDao INSTANCE = new AccountDao();

    public static final String FIND_ALL_ACCOUNT_SQL = """
            SELECT id, user_id, account_status_id, date_registration, date_update_info FROM account;
            """;

    public static final String CREATE_ACCOUNT_SQL = """
            INSERT INTO account (user_id, account_status_id, date_registration, date_update_info) 
            VALUES  (?, ?, ?, ?);
            """;

    private static final String UPDATE_ACCOUNT_BY_ID_SQL = """
            UPDATE account 
            SET user_id = ?,
             account_status_id = ?,
             date_registration = ?,
             date_update_info = ?
            WHERE id = ?
            """;

    private static final String DELETE_ACCOUNT_BY_ID_SQL = """
            DELETE FROM account 
                   WHERE id = ?
            """;

    public List<Account> findAllAccount() {
        try (Connection connection = ConnectionManager.get();
             var prepareStatement = connection.prepareStatement(FIND_ALL_ACCOUNT_SQL);) {
            ResultSet resultSet = prepareStatement.executeQuery();
            List<Account> accounts = new ArrayList<>();
            while (resultSet.next()) {
                accounts.add(buildAccount(resultSet));
            }
            return accounts;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public Account saveAccount(Account account) {
        GeneratorPerson generatorPerson = new GeneratorPerson();
        try (Connection connection = ConnectionManager.get();
             PreparedStatement prepareStatement = connection.prepareStatement(CREATE_ACCOUNT_SQL, Statement.RETURN_GENERATED_KEYS)) {
            prepareStatement.setObject(1, generatorPerson.createPerson());
            prepareStatement.setObject(2, account.getStatus());
            prepareStatement.setDate(3, Date.valueOf((LocalDate) account.getDateRegistration()));
            prepareStatement.setDate(4, Date.valueOf((LocalDate) account.getDateUpdateInfo()));

            prepareStatement.executeUpdate();

            ResultSet generatedKeys = prepareStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                account.setId(generatedKeys.getLong("id"));
            }
            return account;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public Account update(Account account) {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement prepareStatement = connection.prepareStatement(UPDATE_ACCOUNT_BY_ID_SQL)) {
            prepareStatement.setObject(1, account.getUser());
            prepareStatement.setObject(2, account.getStatus());
            prepareStatement.setDate(3, Date.valueOf((LocalDate) account.getDateRegistration()));
            prepareStatement.setDate(4, Date.valueOf((LocalDate) account.getDateUpdateInfo()));

            prepareStatement.executeUpdate();

            return account;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public boolean delete(Long id) {
        try (Connection connection = ConnectionManager.get();
             PreparedStatement prepareStatement = connection.prepareStatement(DELETE_ACCOUNT_BY_ID_SQL)) {
            prepareStatement.setLong(1, id);
            return prepareStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    private static Account buildAccount(ResultSet resultSet) throws SQLException {
        PersonDao userDao = new PersonDao();
        return new Account(
                resultSet.getLong("id"),
                userDao.findUserById(resultSet.getLong("user_id")),
                AccountStatus.fromId(resultSet.getInt("account_status_id")),
                resultSet.getDate("date_registration").toLocalDate(),
                resultSet.getDate("date_update_info").toLocalDate()
        );
    }

    public static AccountDao getInstance() {
        return INSTANCE;
    }
}
