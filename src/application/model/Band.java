package application.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Band {
    private IntegerProperty id;
    private StringProperty name;
    private IntegerProperty genre_id;
    private IntegerProperty agent_id;


    public Band(){
        this.id = new SimpleIntegerProperty();
        this.name = new SimpleStringProperty();
        this.genre_id = new SimpleIntegerProperty();
        this.agent_id = new SimpleIntegerProperty();
    }

    public Band(IntegerProperty id, StringProperty name, IntegerProperty genre_id, IntegerProperty agent_id) {
        this.id = id;
        this.name = name;
        this.genre_id = genre_id;
        this.agent_id = agent_id;
    }

    @Override
    public String toString() {
        return "Band{" +
                "id=" + id +
                ", name=" + name +
                ", genre_id=" + genre_id +
                ", agent_id=" + agent_id +
                '}';
    }

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public int getGenre_id() {
        return genre_id.get();
    }

    public IntegerProperty genre_idProperty() {
        return genre_id;
    }

    public void setGenre_id(int genre_id) {
        this.genre_id.set(genre_id);
    }

    public int getAgent_id() {
        return agent_id.get();
    }

    public IntegerProperty agent_idProperty() {
        return agent_id;
    }

    public void setAgent_id(int agent_id) {
        this.agent_id.set(agent_id);
    }
}
