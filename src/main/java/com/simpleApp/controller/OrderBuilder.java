package com.simpleApp.controller;
import com.simpleApp.model.Applications;
import com.simpleApp.service.ApplicationService;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.*;

public class OrderBuilder {
    private ApplicationService applicationService;
    private int orderNumber;
    HashMap<Long, JSONObject> usedApps;

    public OrderBuilder(ApplicationService applicationService) {
        this.applicationService = applicationService;
        orderNumber = 1;
        usedApps = new HashMap<>();
    }

    private JSONObject appToObject(Applications application) {
        JSONObject app = new JSONObject();
        app.put("name", application.getNameApplication());
        String prev = application.getPreviousApplication();
        if (prev.isEmpty()) {
            app.put("order", orderNumber++);
        }
        else {
            String[] prevApps = prev.split(" ");
            JSONArray prevAppsArray = new JSONArray();

            for (String prevId : prevApps) {
                Applications prevApp = applicationService.getById(Long.valueOf(prevId));

                if (usedApps.get(prevApp.getId()) == null) {
                    JSONObject currentApp = appToObject(prevApp);
                    prevAppsArray.put(currentApp);
                    usedApps.put(prevApp.getId(), currentApp);
                }
                else {
                    prevAppsArray.put(usedApps.get(prevApp.getId()));
                }
            }

            app.put("children", prevAppsArray);
            app.put("order", orderNumber++);
        }

        return app;
    }

    public String getOrder(List<Long> apps) {
        LinkedList<Applications> queue = new LinkedList<>();
        for (Long i : apps) {
            queue.add(applicationService.getById(i));
        }
        JSONObject orders = new JSONObject();

        for (Applications app : queue) {
            if (usedApps.get(app.getId()) == null) {
                orders = appToObject(app);
                usedApps.put(app.getId(), orders);
            }
        }

        return orders.toString();
    }

}