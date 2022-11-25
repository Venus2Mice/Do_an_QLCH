package Framework;

import java.util.HashMap;

public class Parameter {

    private HashMap<String, String> pairs = new HashMap<String, String>();

    public String getPairs(String key) {
        return pairs.get(key);
    }

    public String setPairs(String key, String value) {
        return pairs.replace(key, value) ;
    }

    public boolean containsKey(String key) {
        return pairs.containsKey(key);
    }

    public Parameter(String parameter) {
        var pairs = parameter.split("&");
        for (String pair : pairs) {
            var p = pair.split("=");
            if (p.length == 2) {
                var key = p[0].trim();
                var value = p[1].trim();
                this.pairs.put(key, value);
            }
        }
    }
}