package com.example.Gimnasio.service;

import com.example.Gimnasio.interfaceService.IReservaGimnasioService;
import com.example.Gimnasio.model.ReservaGimnasio;
import com.example.Gimnasio.repository.RepositoryReservaGimnasio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service

public class ServiceReservaGimnasio implements IReservaGimnasioService {

    @Autowired
    private RepositoryReservaGimnasio repositoryReservaGimnasio;

    @Override
    public List<ReservaGimnasio> listar(){
        return (List<ReservaGimnasio>) repositoryReservaGimnasio.findAll();
    }

    @Override
    public Optional<ReservaGimnasio> listId(int id){
        return repositoryReservaGimnasio.findById(id);
    }

    @Override
    public int save(ReservaGimnasio r){
        int res=0;
        ReservaGimnasio reservaGimnasio = repositoryReservaGimnasio.save(r);
        if(!reservaGimnasio.equals(null)){
            res = 1;
        }
        return res;
    }

    @Override
    public void delete(int id){
        repositoryReservaGimnasio.deleteById(id);
    }
}
