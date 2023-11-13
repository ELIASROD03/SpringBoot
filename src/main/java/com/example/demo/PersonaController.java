
package com.example.demo;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PersonaController {

    private List<Persona> personas = new ArrayList<>();

    @GetMapping("/ingresar")
    public String mostrarFormulario() {

        return "formulario";
    }

    @PostMapping("/ingresar")
    public String ingresarPersona(Persona persona) {
        persona.setId((long) (personas.size() + 1));
        personas.add(persona);
        return "redirect:/mostrar";
    }

    @GetMapping("/mostrar")
    public String mostrarPersonas(Model model) {
        model.addAttribute("personas", personas);
        return "mostrar";
    }
}