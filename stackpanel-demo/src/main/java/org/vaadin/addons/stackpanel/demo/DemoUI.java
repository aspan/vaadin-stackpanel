package org.vaadin.addons.stackpanel.demo;

import javax.servlet.annotation.WebServlet;

import org.vaadin.addons.stackpanel.StackPanel;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Theme("demo")
@Title("Vaadin StackPanel Extension Demo")
@SuppressWarnings("serial")
public class DemoUI extends UI {

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = DemoUI.class, widgetset = "org.vaadin.addons.stackpanel.demo.DemoWidgetSet")
    public static class Servlet extends VaadinServlet {
    }

    @Override
    protected void init(VaadinRequest request) {

        // panel with standard toggle icons
        Panel section1 = new SectionPanel();
        StackPanel.extend(section1);

        // panel with individual icons
        Panel section2 = new SectionPanel();
        StackPanel panel2 = StackPanel.extend(section2);
        panel2.setToggleDownIcon(FontAwesome.CARET_SQUARE_O_DOWN);
        panel2.setToggleUpIcon(FontAwesome.CARET_SQUARE_O_UP);

        // panel without toggle icons
        Panel section3 = new SectionPanel();
        StackPanel panel3 = StackPanel.extend(section3);
        panel3.setToggleIconsEnabled(false);

        setContent(new VerticalLayout(section1, section2, section3));
    }

    public static class SectionPanel extends Panel {

        public SectionPanel() {
            setCaption("StackPanel");
            setContent(new HorizontalLayout() {

                {
                    setSizeFull();
                    setMargin(true);
                    setSpacing(true);
                    setDefaultComponentAlignment(Alignment.BOTTOM_LEFT);
                    addComponents(new TextField("First Name"),
                            new TextField("Last Name"), new TextField("Phone"),
                            new Button("Save"));
                }
            });
        }
    }

}