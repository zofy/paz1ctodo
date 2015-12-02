package sk.upjs.ics.todo;

import java.util.LinkedList;
import java.util.List;

public class Kategoria {

    private Long id;
    private String nazov;
    private List<Uloha> ulohy = new LinkedList<Uloha>();

    public void setId(Long id) {
        this.id = id;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
    }

    public void setUlohy(List<Uloha> ulohy) {
        this.ulohy = ulohy;
    }

    public Long getId() {
        return id;
    }

    public String getNazov() {
        return nazov;
    }

    public List<Uloha> getUlohy() {
        return ulohy;
    }
}
