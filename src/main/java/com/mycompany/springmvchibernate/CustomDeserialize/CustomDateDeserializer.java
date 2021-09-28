/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmvchibernate.CustomDeserialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author MinhTo
 */
public class CustomDateDeserializer extends StdDeserializer<Date>{

    private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    public CustomDateDeserializer() {
        this(null);
    }

    public CustomDateDeserializer(Class<Date> vc) {
        super(vc);
    }

    @Override
    public Date deserialize(JsonParser jp, DeserializationContext dc) throws IOException, JsonProcessingException {
        try {
            String textDate = jp.getText();

            Date utilDate = formatter.parse(textDate);
            return utilDate;
        } catch (ParseException ex) {
            throw new RuntimeException(ex);
        }
    }

}
