package com.aloyolaa.springbootform.editor;

import com.aloyolaa.springbootform.service.CountryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;

@AllArgsConstructor
@Component
public class CountryPropertyEditor extends PropertyEditorSupport {

    private CountryService countryService;

    @Override
    public void setAsText(String id) throws IllegalArgumentException {
        try {
            this.setValue(countryService.findById(Integer.parseInt(id)).orElseThrow());
        } catch (NumberFormatException e) {
            setValue(null);
        }
    }

}
