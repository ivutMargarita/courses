package by.ivuts;

public class Teacher {
    private Long id;
    private String name;
    private String surname;
    private String rank;
    private Long userId;

    public Teacher(Long id, String name, String surname, String rank, Long userId) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.rank = rank;
        this.userId = userId;
    }

    public Teacher() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }

        if (object == null || object.getClass() != getClass()) {
            return false;
        }

        Teacher aThat = (Teacher) object;
        if (aThat.getId() == null || getId() == null) {
            return false;
        }
        if (aThat.getName() == null || getName() == null) {
            return false;
        }
        if (aThat.getSurname() == null || getSurname() == null) {
            return false;
        }
        if (aThat.getRank() == null || getRank() == null) {
            return false;
        }
        if (aThat.getUserId() == null || getUserId() == null) {
            return false;
        }
        return getId().equals(aThat.getId()) &&
                getName().equals(aThat.getName()) &&
                getSurname().equals(aThat.getSurname()) &&
                getRank().equals(aThat.getRank()) &&
                getUserId().equals(aThat.getUserId());
    }

    @Override
    public int hashCode() {
        int result = 31;
        result += getId() == null ? 0 : getId().hashCode() + 31 * result;
        result += getName() == null ? 0 : getName().hashCode() + 31 * result;
        result += getSurname() == null ? 0 : getSurname().hashCode() + 31 * result;
        result += getRank() == null ? 0 : getRank().hashCode() + 31 * result;
        result += getUserId() == null ? 0 : getUserId().hashCode() + 31 * result;
        return result;
    }

    @Override
    public String toString() {
        return new StringBuilder(getClass().getSimpleName()).append("{id = ").append(getId()).
                append(", name = ").append(getName()).
                append(", surname = ").append(getSurname()).
                append(", rank").append(getRank()).
                append(", userId = ").append(getUserId()).
                append("}").toString();
    }
}
