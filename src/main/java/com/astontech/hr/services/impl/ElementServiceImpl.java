package com.astontech.hr.services.impl;

import com.astontech.hr.domain.Element;
import com.astontech.hr.repositories.ElementRepository;
import com.astontech.hr.services.ElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElementServiceImpl implements ElementService {

    @Autowired
    private ElementRepository elementRepository;

    @Override
    public Iterable<Element> listAllElements() {
        return elementRepository.findAll();
    }

    @Override
    public Element getElementById(Integer elementId) {
        return elementRepository.findById(elementId).orElse(null);
    }

    @Override
    public Element saveElement(Element element) {
        return elementRepository.save(element);
    }

    @Override
    public Iterable<Element> saveElementList(Iterable<Element> elementIterable) {
        return elementRepository.saveAll(elementIterable);
    }

//    @Override
    public void deleteElement(Integer elementId) {
        elementRepository.deleteById(elementId);
    }

    @Override
    public Element findByElementName(String elementName) {
        return elementRepository.findByElementName(elementName);
    }

    @Override
    public List<Element> findAllByElementName(String elementName) {
        return elementRepository.findAllByElementName(elementName);
    }

    @Override
    public List<Element> findAllByElementNameIgnoreCase(String elementName) {
        return elementRepository.findAllByElementNameIgnoreCase(elementName);
    }
}
