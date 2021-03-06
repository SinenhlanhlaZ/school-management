package za.ac.cput.schoolmanagement.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/*
    Country.java
    Nonzwakazi Mgxaji 2131815284
*/
@Entity
public class Country {

    @Id
    @NotNull
    private String id;

    private String name;

    public Country() {
    }

    private Country(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
    }



    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id='" + id + '\'' +
                ", name=" + name +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return id.equals(country.id) && name.equals(country.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public static class Builder {
        private String id, name;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder copy(Country country) {
            this.id = country.id;
            this.name = country.name;
            return this;
        }

        public Country build() {
            return new Country(this);
        }
    }
}