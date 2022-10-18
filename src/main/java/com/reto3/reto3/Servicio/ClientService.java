package com.reto3.reto3.Servicio;

import com.reto3.reto3.Entidad.Client;
import com.reto3.reto3.Repositorio.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    public List<Client> getClients(){
        return repository.findAll();
    }
    public Client saveClient(Client client){
        return repository.save(client);
    }


    public Client updateClient(Client client) {



        if (client.getIdClient() != null) {
            Optional<Client> clientU = repository.findById(client.getIdClient());



            if (!clientU.isEmpty()) {



                for (Field f : client.getClass().getDeclaredFields()) {
                    f.setAccessible(true);
                    Object value;
                    try {
                        value = f.get(client);
                        if (value != null) {
                            System.out.println("entro");
                            f.set(clientU.get(), value);
                        }
                    } catch (IllegalArgumentException ex) {
                        Logger.getLogger(CategoryService.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IllegalAccessException ex) {
                        Logger.getLogger(CategoryService.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            return repository.save(clientU.get());
        }
        return client;
    }

    public boolean deleteClient(int id) {
        Optional<Client> clientd = repository.findById(id);
        if (clientd.isEmpty()) {
            return false;
        } else {
            repository.delete(clientd.get());
            return true;
        }
    }
}
