package cl.becerra.ms_usuarios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import cl.becerra.ms_usuarios.entity.Usuario;
import cl.becerra.ms_usuarios.model.Carro;
import cl.becerra.ms_usuarios.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private RestTemplate restTemplate;

    public List<Carro> getCarros(int usuarioId) {
        List<Carro> carros = restTemplate.getForObject("http://localhost:8060/carro/usuario/" + usuarioId, List.class);
        return carros;
    }

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> getAll(){
        return usuarioRepository.findAll();
    }

    public Usuario getUsuarioById(int id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario save(Usuario usuario) {
        Usuario nuevoUsuario = usuarioRepository.save(usuario);
        return nuevoUsuario;
    }
}
