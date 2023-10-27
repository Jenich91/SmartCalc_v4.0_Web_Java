package edu.school.calc;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

public class History {
    private static final Preferences history = Preferences.userRoot().node("History");

    public static void addRecord(String exp, String x){
        String exp_with_replaced_x = exp.replace("x", x);
        history.put(new Date().toString(), exp_with_replaced_x);
    }

    public static List<String> getAllRecords() throws BackingStoreException {
        List<String> values = new LinkedList<>();
        for (String key : history.keys()) {
            var value = history.get(key, "");
            values.add(key+": "+value);
        }

        return values;
    }

    public static void clear() throws BackingStoreException {
        history.clear();
    }




}

