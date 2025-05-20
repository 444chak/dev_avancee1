package chkb.dev_avancee1;

import chkb.dev_avancee1.action.Action;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class ActionFactory {
    private static final Map<String, Class<? extends Action>> actions = new HashMap<>();

    static {
        try {
            InputStream is = ActionFactory.class.getClassLoader().getResourceAsStream("actions.xml");
            if (is != null) {
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(is);
                NodeList nList = doc.getElementsByTagName("action");
                for (int i = 0; i < nList.getLength(); i++) {
                    Element elem = (Element) nList.item(i);
                    String name = elem.getAttribute("name");
                    String className = elem.getAttribute("class");
                    Class<?> clazz = Class.forName(className);
                    if (Action.class.isAssignableFrom(clazz)) {
                        actions.put(name, (Class<? extends Action>) clazz);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Action getAction(String actionName) {
        Class<? extends Action> actionClass = actions.get(actionName);
        if (actionClass != null) {
            try {
                return actionClass.getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}