package org.vaadin.addons.javaee.selenium.input;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;

/**
 * Creates a fitting InputMethod for the given element.
 * 
 * @author Thomas Letsch (contact@thomas-letsch.de)
 * 
 */
public class InputMethodFactory {

    List<InputMethod> inputMethods = new ArrayList<>();

    public InputMethodFactory(WebDriver driver) {
        inputMethods.add(new DateInputMethod(driver));
        inputMethods.add(new DropDownInputMethod(driver));
        inputMethods.add(new OptionGroupInputMethod(driver));
        inputMethods.add(new TextInputMethod(driver));
        inputMethods.add(new TextAreaInputMethod(driver));
        inputMethods.add(new CheckBoxInputMethod(driver));
    }

    /**
     * Returns a matching InputMethod for the element with the given id.
     */
    public InputMethod get(String id) {
        for (InputMethod inputMethod : inputMethods) {
            if (inputMethod.accepts(id)) {
                return inputMethod;
            }
        }
        throw new IllegalArgumentException("No InputMethod found for entity with id " + id);
    }

    /**
     * Returns a matching InputMethod for the element with the id "&lt;entityName&gt;.&lt;attribute&gt;".
     */
    public InputMethod get(String entityName, String attribute) {
        for (InputMethod inputMethod : inputMethods) {
            if (inputMethod.accepts(entityName, attribute)) {
                return inputMethod;
            }
        }
        throw new IllegalArgumentException("No InputMethod found for entity " + entityName + " with attribute " + attribute);
    }
}
