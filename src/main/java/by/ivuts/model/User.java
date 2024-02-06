package by.ivuts.model;

import java.time.LocalDate;

public class User {
    private Long id;
    private String username;
    private String password;
    private LocalDate createdDate;
    private Boolean active;

    public User(Long id, String username, String password, Boolean active, LocalDate createdDate) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.active = active;
        this.createdDate = createdDate;
    }
public User(){

}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    
    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }
    public LocalDate getCreatedDate(LocalDate now){
        return createdDate;
    }
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }

        if (object == null || object.getClass() != getClass()) {
            return false;
        }

        User aThat = (User) object;
        if (aThat.getId() == null || getId() == null) {
            return false;
        }
        if (aThat.getUsername() == null || getUsername() == null) {
            return false;
        }
        if (aThat.getPassword() == null || getPassword() == null) {
            return false;
        }
        if (aThat.isActive() == null || isActive() == null) {
            return false;
        }
        if (aThat.getCreatedDate(LocalDate.now()) == null || getCreatedDate(LocalDate.now()) == null) {
            return false;
        }
        return getId().equals(aThat.getId()) &&
                getUsername().equals(aThat.getUsername()) &&
                getPassword().equals(aThat.getPassword()) &&
                isActive().equals(aThat.isActive()) &&
                getCreatedDate(LocalDate.now()).equals(aThat.getCreatedDate(LocalDate.now()));
    }

   

    @Override
    public int hashCode() {
        int result = 31;
        result += getId() == null ? 0 : getId().hashCode() + 31 * result;
        result += getUsername() == null ? 0 : getUsername().hashCode() + 31 * result;
        result += getPassword() == null ? 0 : getPassword().hashCode() + 31 * result;
        result += isActive() == null ? 0 : isActive().hashCode() + 31 * result;
        result += getCreatedDate(LocalDate.now()) == null ? 0 : getCreatedDate(LocalDate.now()).hashCode() + 31 * result;
        return result;
    }

    @Override
    public String toString() {
        return new StringBuilder(getClass().getSimpleName()).append("{id = ").append(getId()).
                append(", username = ").append(getUsername()).
                append(", password = ").append(getPassword()).
                append(", active = ").append(isActive()).
                append(", createdDate = ").append(getCreatedDate(LocalDate.now())).
                append("}").toString();
    }


}
