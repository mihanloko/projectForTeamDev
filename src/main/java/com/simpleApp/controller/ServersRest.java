package com.simpleApp.controller;

import com.simpleApp.convert.ApplicationToApplication;
import com.simpleApp.convert.ServerToServer;
import com.simpleApp.model.Applications;
import com.simpleApp.model.ApplicationsForm;
import com.simpleApp.model.Servers;
import com.simpleApp.model.ServersForm;
import com.simpleApp.service.ApplicationService;
import com.simpleApp.service.ServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.LinkedList;

@Controller
public class ServersRest {

    private ServerService serverService;
    private ApplicationService applicationService;
    private ServerToServer serverToServer;
    private ApplicationToApplication applicationToApplication;

    @Autowired
    public void setServerToServer(ServerToServer serverToServer) {
        this.serverToServer = serverToServer;
    }

    @Autowired
    public void setApplicationToApplication(ApplicationToApplication applicationToApplication) {
        this.applicationToApplication = applicationToApplication;
    }

    @Autowired
    public void setServerService(ServerService serverService) {
        this.serverService = serverService;
    }

    @Autowired
    public void setApplicationService(ApplicationService applicationService) { this.applicationService = applicationService; }

    @RequestMapping("/")
    public String redirToList(){
        return "redirect:/server/show";
    }

    @RequestMapping({"/server/list", "/server"})
    public String listServers(Model model){
        model.addAttribute("servers", serverService.getAll());
        return "server/list";
    }

    @RequestMapping("/server/listApplication")
    public String listApplications(Model model){
        model.addAttribute("app", applicationService.getAll());
        return "server/listApplication";
    }

    @RequestMapping("/server/show")
    public String getShow(){
        return "server/show";
    }

    @RequestMapping("/server/graph")
    public String getGraph(Model model){

//        Gson gson = new Gson();
//
//        HashMap<String, Object> map = new HashMap<>();
//        map.put("name", "GRAPH");
//        HashMap<String, Object> child = new HashMap<>();
//        child.put("name", "child");
//        child.put("size", 5000);
//        ArrayList<HashMap<String, Object>> list = new ArrayList<>();
//        list.add(child);
//        map.put("children", list);
////        map.put("size", 2000);
//
//        String json = gson.toJson(applicationService.getById(1L));
//        //System.out.println(json);
//
//        json = gson.toJson(map);
//        System.out.println(json);
//        model.addAttribute("json_obj", json);

//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("name", "App1");
//        jsonObject.put("size", 5000);
//        JSONArray jsonArray = new JSONArray();
//        jsonArray.put(jsonObject);
//        jsonArray.put(jsonObject);
//        jsonArray.put(jsonObject);
//
//        String jsonString = new JSONObject()
//                .put("name", "Server1")
//                .put("children", jsonArray).toString();
//
//        model.addAttribute("json_obj", jsonString);
//        System.out.println(jsonString);
        OrderBuilder builder = new OrderBuilder(applicationService);
        LinkedList<Long> list = new LinkedList<>();
        list.add(7L);
        list.add(3L);
        list.add(4L);
        model.addAttribute("json_obj", builder.getOrder(list));
        return "/server/graph";
    }

    @RequestMapping("server/edit/{id}")
    public String edit(@PathVariable String id, Model model){
        Servers servers = serverService.getById(Long.valueOf(id));
        ServersForm serversForm = serverToServer.convert(servers);

        model.addAttribute("serverForm", serversForm);
        return "server/serverform";
    }

    @RequestMapping("server/editApplication/{id}")
    public String editApplication(@PathVariable String id, Model model){
        Applications applications = applicationService.getById(Long.valueOf(id));
        ApplicationsForm applicationsForm = applicationToApplication.convert(applications);

        model.addAttribute("applicationForm", applicationsForm);
        return "server/applicationform";
    }

    @RequestMapping("/server/new")
    public String newServer(Model model){
        model.addAttribute("serverForm", new ServersForm());
        return "server/serverform";
    }

    @RequestMapping("/server/newApplication")
    public String newApplication(Model model){
        model.addAttribute("applicationForm", new ApplicationsForm());
        return "server/applicationform";
    }

    @RequestMapping(value = "/server", method = RequestMethod.POST)
    public String saveOrUpdateServer(@Valid ServersForm serverForm, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "server/serverform";
        }

        Servers savedServers = serverService.saveOrUpdateServersForm(serverForm);

        return "redirect:/server/list";
        //return "redirect:/server/show/" + savedServers.getId();
    }

    @RequestMapping(value = "/appl", method = RequestMethod.POST)
    public String saveOrUpdateApplication(@Valid ApplicationsForm applicationsForm, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "server/applicationform";
        }

        Applications savedApplications = applicationService.saveOrUpdateApplicationForm(applicationsForm);

        return "redirect:/server/listApplication";
    }

    @RequestMapping("/server/delete/{id}")
    public String deleteServers(@PathVariable String id){
        serverService.delete(Long.valueOf(id));
        return "redirect:/server/list";
    }

    @RequestMapping("/server/deleteApplication/{id}")
    public String deleteApplications(@PathVariable String id){
        applicationService.delete(Long.valueOf(id));
        return "redirect:/server/listApplication";
    }
}