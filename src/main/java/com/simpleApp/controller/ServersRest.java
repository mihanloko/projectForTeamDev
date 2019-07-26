package com.simpleApp.controller;

import com.simpleApp.convert.ServerToServer;
import com.simpleApp.model.Servers;
import com.simpleApp.model.ServersForm;
import com.simpleApp.service.ServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class ServersRest {

    private ServerService serverService;
    private ServerToServer serverToServer;

    @Autowired
    public void setServerToServer(ServerToServer serverToServer) {
        this.serverToServer = serverToServer;
    }

    @Autowired
    public void setServerService(ServerService serverService) {
        this.serverService = serverService;
    }

    @RequestMapping("/")
    public String redirToList(){
        return "redirect:/server/list";
    }

    @RequestMapping({"/server/list", "/server"})
    public String listServers(Model model){
        model.addAttribute("servers", serverService.getAll());
        return "server/list";
    }

    @RequestMapping("/server/show/{id}")
    public String getServer(@PathVariable String id, Model model){
        model.addAttribute("server", serverService.getById(Long.valueOf(id)));
        return "server/show";
    }

    @RequestMapping("server/edit/{id}")
    public String edit(@PathVariable String id, Model model){
        Servers servers = serverService.getById(Long.valueOf(id));
        ServersForm serversForm = serverToServer.convert(servers);

        model.addAttribute("serverForm", serversForm);
        return "server/serverform";
    }

    @RequestMapping("/server/new")
    public String newServer(Model model){
        model.addAttribute("serverForm", new ServersForm());
        return "server/serverform";
    }

    @RequestMapping(value = "/server", method = RequestMethod.POST)
    public String saveOrUpdateServer(@Valid ServersForm serverForm, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "server/serverform";
        }

        Servers savedServers = serverService.saveOrUpdateServersForm(serverForm);

        return "redirect:/server/show/" + savedServers.getId();
    }

    @RequestMapping("/server/delete/{id}")
    public String delete(@PathVariable String id){
        serverService.delete(Long.valueOf(id));
        return "redirect:/server/list";
    }
}
