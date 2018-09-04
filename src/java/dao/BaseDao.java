package dao;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public abstract class BaseDao {

    public static String folderPath = "./web/WEB-INF/data";

    public static void setFolderPath(String filepath) {
        if (filepath != null) {
            folderPath = filepath;
        }
    }

    public String getXmlFile(String xmlFile) {
        return BaseDao.folderPath + "/" + xmlFile;
    }

    /**
     * read xml into java object
     */
    public Object get(Class neededClass) {
        String filePath = getXmlFile(neededClass.getSimpleName().toLowerCase()+".xml");
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(neededClass);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            return neededClass.cast(jaxbUnmarshaller.unmarshal(new File(filePath)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * save any object to xml
     */
    public void save(Object obj) {
        String filePath = getXmlFile(obj.getClass().getSimpleName().toLowerCase()+".xml");
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(obj.getClass());
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, obj.getClass().getSimpleName().toLowerCase() + ".xsd");

            // Marshal the users list in file
            jaxbMarshaller.marshal(obj, new File(filePath));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

}
