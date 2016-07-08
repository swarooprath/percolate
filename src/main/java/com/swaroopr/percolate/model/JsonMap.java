package com.swaroopr.percolate.model;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Interface for objects that needs to be translated to a map to print Json values.
 * For the rest, {@link Object#toString()} would suffice.
 * Created by sr on 7/7/16.
 */
public interface JsonMap {

    LinkedHashMap<String, Object> toJsonMap();
}
