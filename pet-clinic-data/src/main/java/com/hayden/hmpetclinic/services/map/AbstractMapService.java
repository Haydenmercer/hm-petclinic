package com.hayden.hmpetclinic.services.map;

import com.hayden.hmpetclinic.model.BaseEntity;
import com.hayden.hmpetclinic.services.CrudService;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractMapService<T extends BaseEntity, ID> implements CrudService<T, ID>{

    protected Map<ID, T> map = new HashMap<>();

    @Override
    public Set<T> findAll(){
        return new HashSet<>(map.values());
    }

    @Override
    public T findByID(ID id) {
        return map.get(id);
    }

    public <S extends T> S save(ID id, S obj){
        return (S) map.put(id, obj);
    }

    @Override
    public <S extends T> S save(S obj){
        return save((ID) obj.getId(), obj);
    }

    @Override
    public void deleteByID(ID id){
        map.remove(id);
    }

    @Override
    public void delete(T obj){
        map.entrySet().removeIf(entry -> entry.getValue().equals(obj));
    }



}
