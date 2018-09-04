package dto;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "flights")
@XmlAccessorType(XmlAccessType.FIELD)
public class Flights {

    @XmlElement(name = "flight")
    private List<Flight> books;

    public Flights() {
        this.books = new ArrayList<Flight>();
    }

    public Flights(List<Flight> books) {
        this.books = books;
    }

    public List<Flight> getBooks() {
        return books;
    }

    public void setBooks(List<Flight> books) {
        this.books = books;
    }

    public void addBook(Flight p) {
        this.books.add(p);
    }
    
    public int size() {
        return this.books.size();
    }
}
