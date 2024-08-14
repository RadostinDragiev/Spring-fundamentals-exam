package com.paintingscollectors.util.impl;

import com.paintingscollectors.util.SessionUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.util.Enumeration;

@Component
public class SessionUtilsImpl implements SessionUtils {

    @Override
    public void clearErrorMessages(HttpSession httpSession) {
        Enumeration<String> attributeNames = httpSession.getAttributeNames();

        while (attributeNames.hasMoreElements()) {
            String attributeName = attributeNames.nextElement();
            if (attributeName.contains("Err")) {
                httpSession.removeAttribute(attributeName);
            }
        }
    }
}
