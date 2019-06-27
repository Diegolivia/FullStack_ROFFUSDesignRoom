package pe.roffus.org.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import pe.roffus.org.model.ListaMuebles;
import pe.roffus.org.service.ListaMueblesService;

import java.util.List;

@RestController
@RequestMapping("/listaMuebles")
@ComponentScan
public class ListaMueblesController {
    ListaMueblesService listaMueblesService;

    @Autowired

    public ListaMueblesController(ListaMueblesService listaMueblesService) { this.listaMueblesService=listaMueblesService;    }

    @RequestMapping
    List<ListaMuebles> listListaMuebless(){       return listaMueblesService.listAll();    }

    @RequestMapping(path="/{id}",method = RequestMethod.GET)
    ListaMuebles getListaMuebles(@PathVariable int id){        return listaMueblesService.getById(id);    }

    @PostMapping
    ListaMuebles create(@RequestBody ListaMuebles listaMuebles){ return (listaMueblesService.insert(listaMuebles)); }

    @PutMapping
    ListaMuebles update(@RequestBody ListaMuebles listaMuebles){ return listaMueblesService.update(listaMuebles); }

    @RequestMapping(path="/{id}",method = RequestMethod.DELETE)
    Boolean delete(@PathVariable int id){
        return listaMueblesService.delete(id);
    }

}
