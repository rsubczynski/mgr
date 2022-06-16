package com.ad.mgr.view.util;

import java.util.List;

public class ListUtils {

    public static boolean indexExists(final List list, final int index) {
        return index >= 0 && index < list.size();
    }
}
