package uk.camsw.cib.bdd;

import cucumber.api.Transformer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateTransformer extends Transformer<LocalDate> {

    @Override
    public LocalDate transform(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.parse(date, formatter);
    }

}
