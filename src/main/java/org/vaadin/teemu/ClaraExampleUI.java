package org.vaadin.teemu;

import javax.servlet.annotation.WebServlet;

import org.vaadin.teemu.clara.Clara;
import org.vaadin.teemu.clara.binder.annotation.UiField;
import org.vaadin.teemu.clara.binder.annotation.UiHandler;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.UI;

@SuppressWarnings("serial")
public class ClaraExampleUI extends UI {

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = ClaraExampleUI.class, widgetset = "com.vaadin.DefaultWidgetSet")
    public static class Servlet extends VaadinServlet {
    }

    /**
     * Bind the "main-layout" to this instance variable.
     */
    @UiField("main-layout")
    private Layout layout;

    @Override
    protected void init(VaadinRequest request) {
        /*
         * Create the layout from file ClaraExampleUI.xml (see the
         * src/main/resources folder), which has to be in the classpath inside
         * the same package as this class.
         */
        setContent(Clara.create("ClaraExampleUI.xml", this));
    }

    /**
     * Bind the ClickEvent handling of "my-button" to this method. The method
     * must be public.
     */
    @UiHandler("my-button")
    public void handleButtonClick(ClickEvent event) {
        layout.addComponent(new Label("Thank you for clicking"));
    }

}
