package com.example.Gimnasio.interfaceService;

import com.example.Gimnasio.model.ReservaGimnasio;

import java.util.List;
import java.util.Optional;

public interface IReservaGimnasioService {

    public List<ReservaGimnasio> listar();

    public Optional<ReservaGimnasio> listId(int id);
    public int save (ReservaGimnasio r);
    public void delete(int id);

}
