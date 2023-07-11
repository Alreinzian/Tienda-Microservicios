package com.msvc.tienda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msvc.tienda.entity.Usuario;
import com.msvc.tienda.repository.UsuarioRepository;

import javax.transaction.Transactional;

@Service
@Transactional
public class UsuarioServices {

    @Autowired
    private UsuarioRepository repositorio;

    public Usuario crear(Usuario usuario) {
        return repositorio.save(usuario);
    }

    public List<Usuario> buscarTodo() {
        return (List<Usuario>) repositorio.findAll();
    }

    public Usuario buscarPorId(Integer id) {
        return repositorio.findById(id).orElse(null);
    }

    public Usuario actualizar(Usuario usuarioActualizar) {
        Usuario usuarioActual = repositorio.findById(usuarioActualizar.getIdUsuario()).orElse(null);

        if (usuarioActual != null) {
            usuarioActual.setApellido(usuarioActualizar.getApellido());
            usuarioActual.setCargo(usuarioActualizar.getCargo());
            usuarioActual.setCreateAt(usuarioActualizar.getCreateAt());
            usuarioActual.setDireccion(usuarioActualizar.getDireccion());
            usuarioActual.setDni(usuarioActualizar.getDni());
            usuarioActual.setEmail(usuarioActualizar.getEmail());
            usuarioActual.setNombre(usuarioActualizar.getNombre());
            usuarioActual.setTelefono(usuarioActualizar.getTelefono());
            usuarioActual.setPassword(usuarioActualizar.getPassword());

            Usuario usuarioActualizado = repositorio.save(usuarioActual);
            return usuarioActualizado;
        } else {
            return null;
        }
    }

    public void eliminarUsuario(Integer id) {
        repositorio.deleteById(id);
    }
}

