package za.ac.cput.schoolmanagement.domain;

/*
 *
 * Sinenhlanhla Zondi
 * 220008922
 * 12/06/20220
 *
 * */

public class City
{
    private String id;
    private String name;
    //private Country country;

    public City()
    {}

    public City(CityBuilder b)
    {
        this.id = b.id;
        this.name = b.name;
        //this.country = b.country;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    /*public Country getCountry() {
        return country;
    }*/

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*public void setCountry(Country country) {
        this.country = country;
    }*/

    @Override
    public String toString() {
        return "City{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj)
    {
        if(this == obj)
        {
            return true;
        }
        if(obj == null || getClass() != obj.getClass())
        {
            return false;
        }
        if(!super.equals(obj))
        {
            return false;
        }
        City c = (City) obj;
        return id.equals(c.id) &&
                name.equals(c.name) /*&&
                country.equals(c.country)*/;
    }

    public static class CityBuilder
    {
        private String id;
        private String name;
        //private Country country;

        public CityBuilder setCityId(String id)
        {
            this.id = id;
            return this;
        }

        public CityBuilder setCityName(String name)
        {
            this.name = name;
            return this;
        }

        /*public CityBuilder setCityCountry(Country country)
        {
            this.country = country;
            return this;
        }*/

        public City.CityBuilder copy(City city)
        {
            this.id = city.id;
            this.name = city.name;
            //this.country = city.country;
            return this;
        }

        public City build()
        {
            City c = new City(this);
            return c;
        }
    }
}
