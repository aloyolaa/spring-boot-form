package com.aloyolaa.springbootform.editor;

import com.aloyolaa.springbootform.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;

@AllArgsConstructor
@Component
public class RolePropertyEditor extends PropertyEditorSupport {

    private RoleService roleService;

    @Override
    public void setAsText(String id) throws IllegalArgumentException {
        try {
            this.setValue(roleService.findById(Integer.parseInt(id)).orElseThrow());
        } catch (NumberFormatException e) {
            setValue(null);
        }
    }

}
