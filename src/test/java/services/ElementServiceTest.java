package services;

import com.astontech.hr.Application;
import com.astontech.hr.domain.Element;
import com.astontech.hr.services.ElementService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {Application.class})
@WebAppConfiguration
public class ElementServiceTest {

    @Autowired
    private ElementService elementService;

    @Test
    public void elementServiceSaveTest() {
        Element element = new Element("ServiceTest");

        // save element, verify it has an ID after save
        assertNull(element.getElementId());
        elementService.saveElement(element);
        assertNotNull(element.getElementId());

        // fetch
        Element fetchedElement = elementService.getElementById(element.getElementId());
        assertNotNull(fetchedElement);
        assertEquals(element.getElementId(), fetchedElement.getElementId());

        // update
        fetchedElement.setElementName("Email");
        elementService.saveElement(fetchedElement);

        Element updatedElement = elementService.getElementById(fetchedElement.getElementId());
        assertEquals(updatedElement.getElementName(), "Email");
    }
}
