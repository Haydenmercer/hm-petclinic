package com.hayden.hmpetclinic.services.map;

import com.hayden.hmpetclinic.model.BaseEntity;
import com.hayden.hmpetclinic.services.CrudService;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> implements CrudService<T, ID> {

    protected Map<Long, T> map = new HashMap<>();

    @Override
    public Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    @Override
    public T findByID(ID id) {
        return map.get(id);
    }

    @Override
    public T save(T obj) {
        if (obj != null) {
            if (obj.getId() != null) {
                map.put(obj.getId(), obj);
                return obj;
            }
        }
        else{
            throw new RuntimeException("Object cannot be null");
        }
        Long id = getNextId();
        obj.setId(id);
        map.put(id, obj);
        return obj;
    }

    @Override
    public void deleteByID(ID id){
        map.remove(id);
    }

    @Override
    public void delete(T obj){
        map.entrySet().removeIf(entry -> entry.getValue().equals(obj));
    }

    private Long getNextId(){
        try{
            return Collections.max(map.keySet()) + 1;
        }
        catch (NoSuchElementException e){
            return 1L;
        }
    }

}
