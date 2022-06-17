package za.ac.cput.schoolmanagement.domain;

/*
 *
 * Sinenhlanhla Zondi
 * 220008922
 * 12/06/20220
 *
 * */

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

public class Address {

    private String unitNumber;
    private String complexName;
    private String streetName;
    private String streetNumber;
    private int postalCode;

    @Embedded
    private City city;

    public Address()
    {}

    public Address(AddressBuilder addB)
    {
        this.complexName = addB.complexName;
        this.streetName = addB.streetName;
        this.streetNumber = addB.streetNumber;
        this.postalCode = addB.postalCode;
        this.unitNumber = addB.unitNumber;
        this.city = addB.city;
    }

    public String getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(String unitNumber) {
        this.unitNumber = unitNumber;
    }

    public String getComplexName() {
        return complexName;
    }

    public void setComplexName(String complexName) {
        this.complexName = complexName;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "unitNumber='" + unitNumber + '\'' +
                ", complexName='" + complexName + '\'' +
                ", streetName='" + streetName + '\'' +
                ", streetNumber='" + streetNumber + '\'' +
                ", postalCode=" + postalCode +
                ", city=" + city +
                '}';
    }

    public static class AddressBuilder
    {
        private String unitNumber;
        private String complexName;
        private String streetNumber;
        private String streetName;
        private int postalCode;
        private City city;

        public AddressBuilder setUnitNumber(String unitNumber)
        {
            this.unitNumber = unitNumber;
            return this;
        }

        public AddressBuilder setComplexName(String complexName)
        {
            this.complexName = complexName;
            return this;
        }

        public AddressBuilder setStreetNumber(String streetNumber)
        {
            this.streetNumber = streetNumber;
            return this;
        }

        public AddressBuilder setStreetName(String streetName)
        {
            this.streetName = streetName;
            return this;
        }

        public AddressBuilder setPostalCode(int postalCode)
        {
            this.postalCode = postalCode;
            return this;
        }

        public AddressBuilder setCity(City city)
        {
            this.city = city;
            return this;
        }

        public Address.AddressBuilder copy(Address address)
        {
            this.unitNumber = address.unitNumber;
            this.complexName = address.complexName;
            this.streetNumber = address.streetNumber;
            this.streetName = address.streetName;
            this.postalCode = address.postalCode;
            this.city = address.city;
            return this;
        }

        public Address build()
        {
            Address addr = new Address(this);
            return addr;
        }

    }

}
