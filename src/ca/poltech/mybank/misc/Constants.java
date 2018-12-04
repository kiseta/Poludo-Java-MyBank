package ca.poltech.mybank.misc;

public class Constants {
    public static final String CANADA_POSTAL_CODE_REGEX = "^(?!.*[DFIOQU])[A-VXY][0-9][A-Z] ?[0-9][A-Z][0-9]$";
    public static final String DECIMAL_NUMBER_REGEX = "[-+]?[0-9]*\\.?[0-9]+";
    public static final String BIRTH_DATE_REGEX = "^\\d{1,2}\\/\\d{1,2}\\/\\d{4}$";
    public static final String BIRTH_DATE_ACCEPTED_FORMAT = "dd/mm/yyyy";    
}
