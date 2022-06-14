package za.ac.cput.schoolmanagement.factory;

import za.ac.cput.schoolmanagement.domain.Name;
import za.ac.cput.schoolmanagement.domain.Country;
import za.ac.cput.schoolmanagement.helper.StringHelper;

/*
    CountryFactory.java
    Country factory
    Nonzwakazi Mgxaji 2131815284
*/
public class CountryFactory {
    public static Country build(String id, String name) {
        StringHelper.checkStringParam("id", id);
        StringHelper.checkStringParam("name", name);
        return new Country.Builder().id(id).name(name).build();
    }
}