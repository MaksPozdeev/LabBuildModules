package build;

import parser.JaxbParser;

import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamException;

public class AppMain {

    public static void main(String[] args) throws JAXBException, XMLStreamException {
        System.out.println(JaxbParser.run());
    }
}
