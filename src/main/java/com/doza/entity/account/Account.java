package com.doza.entity.account;

import com.doza.entity.person.Person;

import java.time.LocalDate;
import java.util.Objects;

public class Account {
    private Long id;
    private Person person;
    private AccountStatus accountStatus;
    private LocalDate dateRegistration;
    private LocalDate dateUpdateInfo;

    public Account() {
    }

    public Account(Long id, Person user, AccountStatus status, LocalDate dateRegistration, LocalDate dateUpdateInfo) {
        this.id = id;
        this.person = user;
        this.accountStatus = status;
        this.dateRegistration = dateRegistration;
        this.dateUpdateInfo = dateUpdateInfo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getUser() {
        return person;
    }

    public void setPerson(Person user) {
        this.person = user;
    }

    public AccountStatus getStatus() {
        return accountStatus;
    }

    public void setStatus(AccountStatus status) {
        this.accountStatus = status;
    }

    public LocalDate getDateRegistration() {
        return dateRegistration;
    }

    public void setDateRegistration(LocalDate dateRegistration) {
        this.dateRegistration = dateRegistration;
    }

    public LocalDate getDateUpdateInfo() {
        return dateUpdateInfo;
    }

    public void setDateUpdateInfo(LocalDate dateUpdateInfo) {
        this.dateUpdateInfo = dateUpdateInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id) && Objects.equals(person, account.person) && accountStatus == account.accountStatus && Objects.equals(dateRegistration, account.dateRegistration) && Objects.equals(dateUpdateInfo, account.dateUpdateInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, person, accountStatus, dateRegistration, dateUpdateInfo);
    }

    @Override
    public String toString() {
        return "Account{" +
               "id=" + id +
               ", person=" + person +
               ", status=" + accountStatus +
               ", dateRegistration=" + dateRegistration +
               ", dateUpdateInfo=" + dateUpdateInfo +
               '}';
    }
}
