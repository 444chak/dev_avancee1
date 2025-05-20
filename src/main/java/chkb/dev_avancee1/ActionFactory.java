package chkb.dev_avancee1;

import chkb.dev_avancee1.action.*;
import java.util.HashMap;
import java.util.Map;

public class ActionFactory {
    private static final Map<String, Class<? extends Action>> actions = new HashMap<>();

    static {
        actions.put("index.htm", IndexAction.class);
        actions.put("login.do", LoginAction.class);
        actions.put("logout.do", LogoutAction.class);
        actions.put("updateAttributes.do", UpdateAttributesAction.class);
        actions.put("validateAttributes.do", ValidateAttributesAction.class);
        actions.put("start.do", StartAction.class);
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