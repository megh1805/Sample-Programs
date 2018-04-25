package program_challenge;

/*
 * Implement a function folderNames, which accepts a string containing an XML file that specifies folder structure and returns all folder names that start with startingLetter. The XML format is given in the example below.
For example, for the letter 'u' and an XML file:
<?xml version="1.0" encoding="UTF-8"?>
<folder name="c">
    <folder name="program files">
        <folder name="uninstall information" />
    </folder>
    <folder name="users" />
</folder>
the function should return a collection with items "uninstall information" and "users" (in any order).

 */
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class ReadXML {
	
	public static Collection<String> folderNames(String xml, char startingLetter) throws Exception {
		Collection<String> s= new ArrayList<>();
		DocumentBuilderFactory dbf =
	            DocumentBuilderFactory.newInstance();
	        DocumentBuilder db = dbf.newDocumentBuilder();
	        InputSource is = new InputSource();
	        is.setCharacterStream(new StringReader(xml));

	        Document doc = db.parse(is);
	        NodeList nodes = doc.getElementsByTagName("folder");
	        for (int i = 0; i < nodes.getLength(); i++) {
	        	NamedNodeMap m=nodes.item(i).getAttributes();
	        	if (m.getNamedItem("name").getNodeValue().startsWith(Character.toString(startingLetter))){
	        		s.add(m.getNamedItem("name").getNodeValue());
	        	}
	        	
	        	
	        }
  	 return s;
  	 
  }
  
  public static void main(String[] args) throws Exception {
      String xml =
              "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
              "<folder name=\"c\">" +
                  "<folder name=\"program files\">" +
                      "<folder name=\"uninstall information\" />" +
                  "</folder>" +
                  "<folder name=\"users\" />" +
              "</folder>";

      Collection<String> names = folderNames(xml, 'u');
      for(String name: names)
          System.out.println(name);
  }
}
