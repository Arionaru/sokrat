package ru.ariona.sokrat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Sokrat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String userLink;

    private String shortLink;

    public Sokrat() {

    }

    public Sokrat(String userLink) {
        this.userLink = userLink;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserLink() {
        return userLink;
    }

    public void setUserLink(String userLink) {
        this.userLink = userLink;
    }

    public String getShortLink() {
        return shortLink;
    }

    public void setShortLink(String shortLink) {
        this.shortLink = shortLink;
    }
}
