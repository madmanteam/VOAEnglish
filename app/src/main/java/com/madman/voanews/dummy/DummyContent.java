package com.madman.voanews.dummy;

import com.madman.voanews.db.VOANews;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<VOANews> ITEMS = new ArrayList<VOANews>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, VOANews> ITEM_MAP = new HashMap<String, VOANews>();


    public static void initData(List<VOANews> items) {
        for (VOANews voa:items) {
            ITEMS.add(voa);
            ITEM_MAP.put(voa.getId(), voa);
        }

    }
}
