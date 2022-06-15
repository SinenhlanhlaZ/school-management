package za.ac.cput.schoolmanagement.factory;

/*
 *
 * Sinenhlanhla Zondi
 * 220008922
 * 12/06/20220
 *
 * */

import za.ac.cput.schoolmanagement.domain.City;
import za.ac.cput.schoolmanagement.helper.StringHelper;

public class CityFactory {
    public static City build(String id, String name)
    {
        StringHelper.isEmptyOrNull("1");
        StringHelper.checkStringParam("name", name);

        return new City.CityBuilder().setCityId(id)
                .setCityName(name)
                .build();
    }
}
