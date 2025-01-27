package adaptador;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

public class AdaptadorFecha extends XmlAdapter<String, LocalDate> {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public LocalDate unmarshal(String date) {
        return LocalDate.parse(date, FORMATTER);
    }

    @Override
    public String marshal(LocalDate date) {
        return date.format(FORMATTER);
    }
}
