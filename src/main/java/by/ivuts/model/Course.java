package by.ivuts.model;

public class Course {
    private Long id;
    private String name;
    private Integer hours;
    private Long teacherId;

    public Course(Long id, String name, Integer hours, Long teacherId) {
        this.id = id;
        this.name = name;
        this.hours = hours;
        this.teacherId = teacherId;
    }

    public Course() {
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

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }

        if (object == null || object.getClass() != getClass()) {
            return false;
        }

        Course aThat = (Course) object;
        if (aThat.getId() == null || getId() == null) {
            return false;
        }
        if (aThat.getName() == null || getName() == null) {
            return false;
        }
        if (aThat.getHours() == null || getHours() == null) {
            return false;
        }
        if (aThat.getTeacherId() == null || getTeacherId() == null) {
            return false;
        }
        return getId().equals(aThat.getId()) &&
                getName().equals(aThat.getName()) &&
                getHours().equals(aThat.getHours()) &&
                getTeacherId().equals(aThat.getTeacherId());
    }

    @Override
    public int hashCode() {
        int result = 31;
        result += getId() == null ? 0 : getId().hashCode() + 31 * result;
        result += getName() == null ? 0 : getName().hashCode() + 31 * result;
        result += getHours() == null ? 0 : getHours().hashCode() + 31 * result;
        result += getTeacherId() == null ? 0 : getTeacherId().hashCode() + 31 * result;
        return result;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{id = " + getId() +
                ", name = " + getName() +
                ", hours = " + getHours() +
                ", teacherId = " + getTeacherId() +
                "}";
    }
}
