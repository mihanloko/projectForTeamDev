package com.simpleApp.controller;
import com.simpleApp.model.Applications;
import com.simpleApp.service.ApplicationService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeSet;

public class OrderBuilder {
    private ApplicationService applicationService;
    private int orderNumber;

    public OrderBuilder(ApplicationService applicationService) {
        this.applicationService = applicationService;
        orderNumber = 1;
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
                prevAppsArray.put(appToObject(prevApp));
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
        JSONObject order = new JSONObject();

        for (Applications app : queue) {
            order = appToObject(app);
        }

        return order.toString();//todo return

    }

}