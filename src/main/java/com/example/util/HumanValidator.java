package com.example.util;

import com.example.dao.HumanDAO;
import com.example.models.Human;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class HumanValidator implements Validator {

    private final HumanDAO humanDAO;

    @Autowired
    public HumanValidator(HumanDAO humanDAO) {
        this.humanDAO = humanDAO;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Human.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Human human = (Human) target;
        if(humanDAO.getCurrentHuman(human.getName()) != null){

        }
        errors.rejectValue("name", "", "Name already exists");
    }
}
