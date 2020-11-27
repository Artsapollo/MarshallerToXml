package marshaller;

import dto.Car;

import javax.xml.bind.JAXBContext;
import java.io.StringWriter;

public class Marshaller {

    public static void main(String[] args) {
        Car car = new Car();
        car.setName("Skyline");
        car.setColor("Space grey");
        car.setSpeed(350);

        System.out.println(marshalObjectToXml(car));
    }

    public static String marshalObjectToXml(Object object) {
        String result = null;
        try {
            StringWriter sw = new StringWriter();

            JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
            javax.xml.bind.Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(object, sw);

            result = sw.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
