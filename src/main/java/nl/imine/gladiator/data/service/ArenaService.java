package nl.imine.gladiator.data.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import nl.imine.gladiator.data.arena.Arena;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ArenaService {

    public List<Arena> loadArenas(Path arenaFile) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Arena> arenas = new ArrayList<>();
        try {
             arenas = objectMapper.readValue(Files.newInputStream(arenaFile), new TypeReference<List<Arena>>(){
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arenas;
    }
}
