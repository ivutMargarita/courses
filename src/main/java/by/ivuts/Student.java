package by.ivuts;

public class Student {
    private Long id;
    private String name;
    private String surname;
    private Integer grade;
    private String gradeBook;
    private Long userId;

    public Student(Long id, String name, String surname, Integer grade, String gradeBook, Long userId) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.grade = grade;
        this.gradeBook = gradeBook;
        this.userId = userId;
    }

    public Student() {
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

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getGradeBook() {
        return gradeBook;
    }

    public void setGradeBook(String gradeBook) {
        this.gradeBook = gradeBook;
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

        Student aThat = (Student) object;
        if (aThat.getId() == null || getId() == null) {
            return false;
        }
        if (aThat.getName() == null || getName() == null) {
            return false;
        }
        if (aThat.getSurname() == null || getSurname() == null) {
            return false;
        }
        if (aThat.getGrade() == null || getGrade() == null) {
            return false;
        }
        if (aThat.getGradeBook() == null || getGradeBook() == null) {
            return false;
        }
        if (aThat.getUserId() == null || getUserId() == null) {
            return false;
        }
        return getId().equals(aThat.getId()) &&
                getName().equals(aThat.getName()) &&
                getSurname().equals(aThat.getSurname()) &&
                getGrade().equals(aThat.getGrade()) &&
                getGradeBook().equals(aThat.getGradeBook()) &&
                getUserId().equals(aThat.getUserId());
    }

    @Override
    public int hashCode() {
        int result = 31;
        result += getId() == null ? 0 : getId().hashCode() + 31 * result;
        result += getName() == null ? 0 : getName().hashCode() + 31 * result;
        result += getSurname() == null ? 0 : getName().hashCode() + 31 * result;
        result += getGrade() == null ? 0 : getGrade().hashCode() + 31 * result;
        result += getGradeBook() == null ? 0 : getGradeBook().hashCode() + 31 * result;
        result += getUserId() == null ? 0 : getUserId().hashCode() + 31 * result;
        return result;
    }

    @Override
    public String toString() {
        return new StringBuilder(getClass().getSimpleName()).append("{id = ").append(getId()).
                append(", name = ").append(getName()).
                append(", surname = ").append(getSurname()).
                append(", grade = ").append(getGrade()).
                append(", gradeBook = ").append(getGradeBook()).
                append(", userId = ").append(getUserId()).
                append("}").toString();
    }
}
