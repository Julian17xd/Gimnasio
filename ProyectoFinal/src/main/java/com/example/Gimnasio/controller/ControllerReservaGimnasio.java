package com.example.Gimnasio.controller;

import com.example.Gimnasio.interfaceService.IReservaGimnasioService;
import com.example.Gimnasio.model.ReservaGimnasio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping
public class ControllerReservaGimnasio {
    @Autowired
    private IReservaGimnasioService reservaGimnasioService;

    @GetMapping("/inicio")
    public String inicio(Model model){
        List<ReservaGimnasio> reservaGimnasio = reservaGimnasioService.listar();
        model.addAttribute("reservaGimnasio", reservaGimnasio);
        return "index";
    }

    @GetMapping("/listar")
    public String listar(Model model){
        List<ReservaGimnasio> reservas = reservaGimnasioService.listar();
        model.addAttribute("reservas", reservas);
        return "visualizacion-reservas";
    }

    @PostMapping("/save")
    public String save(@Validated ReservaGimnasio r, @RequestParam("servicio") String servicio, Model model) {
        r.setServicio(servicio);
        reservaGimnasioService.save(r);
        model.addAttribute("mensaje", "Reserva realizada correctamente");
        model.addAttribute("reserva", new ReservaGimnasio());  // Esto reinicia el formulario
        return "redirect:/inicio";
    }
    @GetMapping("/reservar")
    public String reservarServicio(Model model) {
        model.addAttribute("reserva", new ReservaGimnasio());
        return "reserva";
    }

    @GetMapping("eliminar/{id}")
    public String delete(@PathVariable int id){
        reservaGimnasioService.delete(id);
        return "redirect:/listar";
    }

}
