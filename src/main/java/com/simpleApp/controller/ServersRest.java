package com.simpleApp.controller;

import com.simpleApp.model.Servers;
import com.simpleApp.service.ServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/servers")
public class ServersRest {
    @Autowired
    private ServerService serverService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Servers> getServers(@PathVariable("id") Long serversId) {
        if (serversId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Servers servers = this.serverService.getById(serversId);

        if (servers == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(servers, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Servers> saveServers(@RequestBody @Valid Servers servers) {
        HttpHeaders headers = new HttpHeaders();

        if (servers == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.serverService.save(servers);
        return new ResponseEntity<>(servers, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Servers> updateServers(@RequestBody @Valid Servers servers, UriComponentsBuilder builder) {
        HttpHeaders headers = new HttpHeaders();

        if (servers == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.serverService.save(servers);

        return new ResponseEntity<>(servers, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Servers> deleteServers(@PathVariable("id") Long id) {
        Servers servers = this.serverService.getById(id);

        if (servers == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.serverService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Servers>> getAllServers() {
        List<Servers> servers = this.serverService.getAll();

        if (servers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(servers, HttpStatus.OK);
    }

    @RequestMapping("/findall")
    public String findAll(){
        String result = "<html>";

        for(Servers cust : serverService.getAll()){
            result += "<div>" + cust.toString() + "</div>";
        }

        return result + "</html>";
    }

    @RequestMapping("/findbyid")
    public String findById(@RequestParam("id") long id){
        String result = "";
        result = serverService.getById(id).toString();
        return result;
    }
}
