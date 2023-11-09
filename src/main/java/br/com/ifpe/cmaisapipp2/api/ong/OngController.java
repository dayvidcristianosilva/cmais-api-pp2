package br.com.ifpe.cmaisapipp2.api.ong;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.

        RestController;

import br.com.ifpe.cmaisapipp2.modelo.ong.Ong;
import br.com.ifpe.cmaisapipp2.modelo.ong.OngService;

@RestController
@RequestMapping("/api/ong")
@CrossOrigin
public class OngController {

    @Autowired
    private OngService ongService;

    @PostMapping
    public ResponseEntity<Ong> save(@RequestBody @Valid OngRequest request) {

        Ong ong = ongService.save(request.build());
        return new ResponseEntity<Ong>(ong, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Ong> findAll() {

        return ongService.findAll();
    }

    @GetMapping("/{id}")
    public Ong findById(@PathVariable Long id) {

        return ongService.findById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ong> update(@PathVariable("id") Long id, @RequestBody OngRequest request) {

        ongService.update(id, request.build());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        ongService.delete(id);
        return ResponseEntity.ok().build();
    }

}