package SOLID.Models;

import java.util.HashMap;

public abstract class Prod extends HashMap {
    @Override
    public Object get(Object key) {
        return super.get(key);
    }

    @Override
    public Object put(Object key, Object value) {
        return super.put(key, value);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
