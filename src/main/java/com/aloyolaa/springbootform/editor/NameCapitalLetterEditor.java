package com.aloyolaa.springbootform.editor;

import java.beans.PropertyEditorSupport;

public class NameCapitalLetterEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(text.toUpperCase().trim());
    }

}
