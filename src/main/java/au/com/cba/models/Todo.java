package au.com.cba.models;

import java.util.Date;

public class Todo {
    private int id;
    private String description;
    private Date targerDate;
    private boolean isDone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getTargerDate() {
        return targerDate;
    }

    public void setTargerDate(Date targerDate) {
        this.targerDate = targerDate;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public Todo(int id, String description, Date targerDate, boolean isDone) {
        this.id = id;
        this.description = description;
        this.targerDate = targerDate;
        this.isDone = isDone;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", targerDate=" + targerDate +
                ", isDone=" + isDone +
                '}';
    }
}
