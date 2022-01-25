package com.coderhouse.ClientAop.controller;

import com.coderhouse.ClientAop.exceptions.ClientSearchError;
import com.coderhouse.ClientAop.exceptions.MissedFieldsException;
import com.coderhouse.ClientAop.model.Client;
import com.coderhouse.ClientAop.service.ClientService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/clients")
public class ClientController {
    private List<Client> clientList = new ArrayList<Client>();

    Logger logger = LogManager.getLogger(ClientController.class);

    @Autowired
    ClientService clientService;


    @GetMapping
    public List<Client> getProductList() throws ClientSearchError {
        logger.info("Peticion GET");

        if(clientList.isEmpty()){
            throw new ClientSearchError("No hay Clientes cargados");
        }
        return clientList;
    }


    @GetMapping("/{id}")
    public Client getClient(@PathVariable Integer id) throws ClientSearchError {
        logger.info("Peticion GET");

        for(Client client : clientList){
            if(client.getId() == id){
                return client;
            }
        }
        throw new ClientSearchError("El cliente con el ID solicitado no existe :( ");
    }

    @PostMapping
    public String addClient(@RequestBody Map<String,String> requestParam) {
        logger.info("Peticion POST");

        String name = requestParam.get("name");
        String lastname = requestParam.get("lastname");
        int size=clientList.size();
        Client client = new Client(size,name,lastname);
        clientList.add(client);
        return "Se agrego un Cliente con el siguiente ID: " + clientList.size();
    }


    @PutMapping("/{id}")
    public String updateClient(@RequestBody Client client, @PathVariable Integer id ) throws MissedFieldsException {
        logger.info("Peticion PUT");
        if(client.getName() == "" || client.getLastname() == "" || client.getName() == null || client.getLastname() == null ){
            throw new MissedFieldsException("Missed fields");
        }
        else{
        this.clientList.set(id, client);
            }
        return"Se Modifico el Cliente id: "+id+"   Los datos ahora son los siguientes : "+client.getName()+"   "+client.getLastname();
    }

    @DeleteMapping(path = "/{id}")
    private String deleteCliente(@PathVariable Integer id) {
        logger.info("Peticion DELETE");
        clientList.remove(id);
        return "Se elimino el Cliente id : "+id;
    }
}



