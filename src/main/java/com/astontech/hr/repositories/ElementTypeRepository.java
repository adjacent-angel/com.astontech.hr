package com.astontech.hr.repositories;

import com.astontech.hr.domain.Element;
import com.astontech.hr.domain.ElementType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ElementTypeRepository extends CrudRepository<ElementType, Integer> {

    ElementType findByElementType(String elementType);

    List<ElementType> findAllByElementType(String elementType);

    ElementType findByElementTypeId(Integer id);

    List<ElementType> findAllByElementTypeId(Integer elementId);
}
