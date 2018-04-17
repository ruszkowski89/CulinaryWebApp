package ruszkowski89.springmvc.conversion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormatter implements Formatter<Date> {
    private MessageSource messageSource;

    @Autowired
    public DateFormatter(MessageSource messageSource) {
        super();
        this.messageSource = messageSource;
    }

    @Override
    public Date parse(String text, Locale locale) throws ParseException {
        SimpleDateFormat dateFormat = createDateFormat(locale);
        return dateFormat.parse(text);
    }

    @Override
    public String print(Date date, Locale locale) {
        SimpleDateFormat dateFormat = createDateFormat(locale);
        return dateFormat.format(date);
    }

    private SimpleDateFormat createDateFormat(Locale locale){
        String format = this.messageSource.getMessage("Date.format", null, locale);
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        dateFormat.setLenient(false);
        return dateFormat;
    }
}
