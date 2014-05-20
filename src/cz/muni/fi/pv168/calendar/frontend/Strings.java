package cz.muni.fi.pv168.calendar.frontend;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author Jiri Stary
 */
public class Strings {
    private static ResourceBundle bundle;

    public static String getString(String string) {
        return getStringBundle().getString(string);
    }

    private static ResourceBundle getStringBundle() {
        if (bundle == null)
            bundle = ResourceBundle.getBundle("cz.muni.fi.pv168.calendar.resources.strings", Locale.getDefault());
        return bundle;
    }
}
