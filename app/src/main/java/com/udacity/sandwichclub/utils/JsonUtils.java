package com.udacity.sandwichclub.utils;

import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public final class JsonUtils {

    private static final String NAME = "name";
    private static final String MAIN_NAME = "mainName";
    private static final String ALSO_KNOWN_AS = "alsoKnownAs";
    private static final String PLACE_OF_ORIGIN = "placeOfOrigin";
    private static final String DESCRIPTION = "description";
    private static final String IMAGE = "image";
    private static final String INGREDIENTS = "ingredients";

    public static Sandwich parseSandwichJson(String json) {
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONObject name = jsonObject.getJSONObject(NAME);
            return Sandwich.builder().setMainName(name.getString(MAIN_NAME))
                    .setAlsoKnownAs(newList(name.getJSONArray(ALSO_KNOWN_AS)))
                    .setPlaceOfOrigin(jsonObject.getString(PLACE_OF_ORIGIN))
                    .setDescription(jsonObject.getString(DESCRIPTION))
                    .setImage(jsonObject.getString(IMAGE))
                    .setIngredients(newList(jsonObject.getJSONArray(INGREDIENTS)))
                    .build();
        } catch (JSONException e) {
            Log.e(JsonUtils.class.getSimpleName(), e.getMessage());
        }
        Log.w(JsonUtils.class.getSimpleName(), "Unable to parse: " + json);
        return null;
    }

    private static final List<String> newList(JSONArray jsonArray) throws JSONException {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            list.add(jsonArray.getString(i));
        }
        return list;
    }
}
