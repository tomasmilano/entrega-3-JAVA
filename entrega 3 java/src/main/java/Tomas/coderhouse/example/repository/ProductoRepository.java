package Tomas.coderhouse.example.repository;


import Tomas.coderhouse.example.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository repository;

    public ProductoService(ProductoRepository repository) {
        this.repository = repository;
    }

    public Producto save(Producto producto) {
        return repository.save(producto);
    }

    public List<Producto> getproductos() {
        return repository.findAll();
    }

    public Optional<Producto> getById(Long id) {
        return repository.findById(id);
    }
}