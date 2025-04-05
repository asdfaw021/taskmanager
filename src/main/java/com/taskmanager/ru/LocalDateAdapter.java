package com.taskmanager.ru;

import com.google.gson.*;
import java.lang.reflect.Type;
import java.time.LocalDate;

public class LocalDateAdapter implements JsonSerializer<LocalDate>, JsonDeserializer<LocalDate>{
    @Override
    public JsonElement serialize(LocalDate dt, Type typeOfSrc, JsonSerializationContext context){
        return new JsonPrimitive(dt.toString());
    }

    @Override
    public LocalDate deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return LocalDate.parse(jsonElement.getAsString());
    }
}
