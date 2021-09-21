package repositories;


import com.astontech.hr.configuration.RepositoryConfiguration;
import com.astontech.hr.domain.Element;
import com.astontech.hr.repositories.ElementRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.xml.stream.events.EndElement;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {RepositoryConfiguration.class})
public class ElementRepositoryTest {

    @Autowired
    private ElementRepository elementRepository;

    @Test
    public void testSaveElement() {
        // setup an element
        Element element = new Element();
        element.setElementName("Phone");

        // save element, verify it has an ID after save
        assertNull(element.getElementId());
        elementRepository.save(element);
        assertNotNull(element.getElementId());

        // fetch
        Element fetchedElement = elementRepository.findById(element.getElementId()).orElse(null);
        assertNotNull(fetchedElement);
        assertEquals(element.getElementId(), fetchedElement.getElementId());

        // update
        fetchedElement.setElementName("Email");
        elementRepository.save(fetchedElement);

        Element updatedElement = elementRepository.findById(fetchedElement.getElementId()).orElse(null);
        assertEquals(updatedElement.getElementName(), "Email");
    }

    @Test
    public void testSaveElementList() {
        List<Element> elementList = new ArrayList<>();

        elementList.add(new Element("Phone"));
        elementList.add(new Element("Email"));
        elementList.add(new Element("Laptop"));
        elementList.add(new Element("PayRate"));

        elementRepository.saveAll(elementList);

        Iterable<Element> fetchedElementList = elementRepository.findAll();

        int count = 0;
        for(Element element : fetchedElementList) {
            count++;
        }

        assertEquals(4, count);
    }

    @Test
    public void testFindByName() {
        Element element = new Element("FindTest");
        elementRepository.save(element);

        Element foundByNameElement = elementRepository.findByElementName("FindTest");

        assertEquals(element.getElementId(), foundByNameElement.getElementId());
    }

    @Test
    public void testFindAllByName() {
        Element element1 = new Element("FindTest");
        elementRepository.save(element1);
        Element element2 = new Element("FindTest");
        elementRepository.save(element2);
        Element element3 = new Element("FindTest");
        elementRepository.save(element3);

        List<Element> foundAllByNameElement = elementRepository.findAllByElementName("FindTest");

        assertEquals(3, foundAllByNameElement.size());
    }

    @Test
    public void testFindByElementId() {
        Element element = new Element("Test");
        elementRepository.save(element);

        Element foundById = elementRepository.findByElementId(1);
        assertEquals(element.getElementId(), foundById.getElementId());
    }

    @Test
    public void testFindAllByElementId() {
        Element element1 = new Element("First");
        elementRepository.save(element1);
        Element element2 = new Element("Second");
        elementRepository.save(element2);
        Element element3 = new Element("Third");
        elementRepository.save(element3);

        List<Element> fetchedIDList = elementRepository.findAllByElementId(2);

        assertEquals(1, fetchedIDList.size());
    }

    @Test
    public void testFindByElementIdOrElementNameIgnoreCase() {
        Element element1 = new Element("testing1");
        elementRepository.save(element1);

        Element foundByIdOrName = elementRepository.findByElementIdOrElementNameIgnoreCase(1, "Testing1");
        assertEquals(element1.getElementName(), foundByIdOrName.getElementName());
        assertEquals(element1.getElementId(), foundByIdOrName.getElementId());
    }

    @Test
    public void testFindAllByElementNameIgnoreCase() {
        Element element1 = new Element("NameTest");
        elementRepository.save(element1);
        Element element2 = new Element("nameTest");
        elementRepository.save(element2);
        Element element3 = new Element("Nametest");
        elementRepository.save(element3);

        List<Element> foundAllByNameIgnoreCase = elementRepository.findAllByElementNameIgnoreCase("NameTest");

        assertEquals(3, foundAllByNameIgnoreCase.size());
    }

    @Test
    public void testFindAllByElementNameStartingWith() {
        Element element1 = new Element("Info");
        elementRepository.save(element1);
        Element element2 = new Element("Not Info");
        elementRepository.save(element2);
        Element element3 = new Element("Info");
        elementRepository.save(element3);

        List<Element> foundAllByNameStartingWith = elementRepository.findAllByElementNameStartingWith("I");

        assertEquals(2, foundAllByNameStartingWith.size());
    }

}
