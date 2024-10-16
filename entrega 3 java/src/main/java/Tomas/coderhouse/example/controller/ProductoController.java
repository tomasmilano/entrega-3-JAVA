
package Tomas.coderhouse.example.controller;

import Tomas.coderhouse.example.Service.ProductoService;

import Tomas.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.;

import javax.print.attribute.standard.Media;
import java.awt.;
import java.util.Optional;

@RestController
@RequestMapping("/api/Productos")
public class ProductoController {

    @Autowired
    private ProductoService Service;

    public ProductoController(ProductoService service) {
        this.Service = Service;
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Iterable<producto>> getAll() {
        Iterable<producto> productos = Service.getproductos();
        return ResponseEntity.ok(productos);
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Optional<Producto>> getById(@PathVariable Long id) {
        Optional<Producto> producto = service.getById(id);

        if (producto.isPresent()) {
            // Si el producto existe
            return ResponseEntity.ok(producto);
        } else {
            // Si el producto no existe
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Producto> create(@RequestBody Producto producto) {
        try {
            Producto nuevoProducto = service.save(producto);
            return ResponseEntity.ok(nuevoProducto);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }
}