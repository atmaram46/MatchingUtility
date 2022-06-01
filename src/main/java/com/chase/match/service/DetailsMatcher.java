package com.chase.match.service;

import com.chase.match.model.Address;
import com.chase.match.model.Applicants;
import com.chase.match.model.PersonDetails;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;

public class DetailsMatcher {

    public String matchXMLTags(String incomingXML, PersonDetails personDetails) {
        Document doc = null;
        try {
            doc = generateXML(incomingXML);
        } catch (ParserConfigurationException e) {
            System.out.println("Error while parsing the incoming String, its not valid XML!!!");
        } catch (IOException e) {
            System.out.println("Error while parsing the incoming String, its not valid XML!!!");
        } catch (SAXException e) {
            System.out.println("Error while parsing the incoming String, its not valid XML!!!");
        }

        NodeList searchApplicants = doc.getElementsByTagName("applicants");
        Applicants[] applicants = personDetails.getApplicants();
        int size = searchApplicants.getLength();
        for(int i=0; i<size; i++) {
            NamedNodeMap attr = searchApplicants.item(i).getAttributes();
            Node nodeAttr = attr.getNamedItem("value");
            nodeAttr.setTextContent(param);
        }

        String resultString = null;
        try {
            resultString = generateStringFromXML(doc);
        } catch (TransformerException e) {
            System.out.println("Error while parsing the XML to String!!!");
        }
        return resultString;
    }

    public Node updateAddress(Node nodeAttr, Address address) {

    }

    public String generateStringFromXML(Document doc) throws TransformerException {
        String resultVal = new String();
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(resultVal);
        transformer.transform(source, result);
        return resultVal;
    }

    public Document generateXML(String incomingXML) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder;
        docBuilder = docFactory.newDocumentBuilder();
        return docBuilder.parse(incomingXML);
    }
}
