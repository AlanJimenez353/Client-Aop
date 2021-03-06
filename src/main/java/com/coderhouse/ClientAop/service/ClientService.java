package com.coderhouse.ClientAop.service;


import com.coderhouse.ClientAop.annotations.CustomMethodAnnotation;
import com.coderhouse.ClientAop.exceptions.MissedFieldsException;
import com.coderhouse.ClientAop.model.Client;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    Logger logger = LogManager.getLogger(ClientService.class);

    public void getClients() {
        logger.debug("Client list");
    }

    public void createClient() {
        logger.debug("Created client");
    }

    public void getClientById() {
        logger.debug("Client with given id");
    }

    @CustomMethodAnnotation
    public boolean updateClient(Client client) throws MissedFieldsException {
        if(client.getName() == "" || client.getLastname() == "" || client.getName() == null || client.getLastname() == null ){
            return false;
        }  else {
            logger.debug("Client updated");
            return true;
        }

    }

    @CustomMethodAnnotation
    public void deleteClient() {
        logger.debug("Delete");
    }

}

