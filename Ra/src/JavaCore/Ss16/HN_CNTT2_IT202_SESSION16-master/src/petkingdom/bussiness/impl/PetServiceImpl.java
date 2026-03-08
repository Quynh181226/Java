package petkingdom.bussiness.impl;

import petkingdom.bussiness.IGenericRepository;
import petkingdom.model.Pet;

import java.util.ArrayList;
import java.util.List;

public class PetServiceImpl implements IGenericRepository<Pet> {

    private List<Pet> pets = new ArrayList<>();

    @Override
    public Pet add(Pet pet) {
        if (findById(pet.getId()) != null) {
            System.out.println("ID pet đã tồn tại!");
            return null;
        }
        pets.add(pet);
        return pet;
    }

    @Override
    public void remove(String id) {
        pets.removeIf(p -> p.getId().equals(id));
    }

    @Override
    public Pet findById(String id) {
        for (Pet p : pets) {
            if (p.getId().equals(id)) return p;
        }
        return null;
    }

    @Override
    public List<Pet> findAll() {
        return new ArrayList<>(pets);
    }
}