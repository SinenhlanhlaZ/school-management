package za.ac.cput.schoolmanagement.factory;

/*
 *
 * Sinenhlanhla Zondi
 * 220008922
 * 12/06/20220
 *
 * */

import za.ac.cput.schoolmanagement.domain.Address;
import za.ac.cput.schoolmanagement.domain.City;
import za.ac.cput.schoolmanagement.helper.StringHelper;

public class AddressFactory {
    public static Address build(String unitNumber, String streetName, String streetNumber, String complexName, int postalCode, City city) {
        StringHelper.checkObjectNull("streetName", streetName);
        StringHelper.checkObjectNull("streetNumber", streetNumber);
        StringHelper.checkObjectNull("city", city);

        return new Address.AddressBuilder()
                .setUnitNumber(unitNumber)
                .setStreetName(streetName)
                .setStreetNumber(streetNumber)
                /*.setCity(city)*/.build();
    }
}
