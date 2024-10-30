package ejercicios;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;

public class importarRegistrosXML {

    public static void main(String[] args) {
        try {
            // Cargar el archivo XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("src/ejercicios/Monaco2017.xml");
            document.getDocumentElement().normalize();

            System.out.println("Resultado de carrera:");

            // Obtener la lista de resultados
            NodeList resultList = document.getElementsByTagName("result");

            // Iterar sobre cada resultado
            for (int i = 0; i < resultList.getLength(); i++) {
                Node resultNode = resultList.item(i);

                if (resultNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element resultElement = (Element) resultNode;

                    // Obtener información del conductor
                    Element driver = (Element) resultElement.getElementsByTagName("Driver").item(0);
                    String givenName = driver.getElementsByTagName("GivenName").item(0).getTextContent();
                    String familyName = driver.getElementsByTagName("FamilyName").item(0).getTextContent();

                    // Obtener información del constructor
                    Element constructor = (Element) resultElement.getElementsByTagName("Constructor").item(0);
                    String constructorName = constructor.getElementsByTagName("Name").item(0).getTextContent();

                    // Obtener posiciones de inicio y finalización
                    String startingPosition = resultElement.getElementsByTagName("Grid").item(0).getTextContent();
                    String finishingPosition = resultElement.getElementsByTagName("position").item(0).getTextContent();

                    // Obtener vueltas y tiempo en milisegundos, convertir a minutos y segundos
                    String laps = resultElement.getElementsByTagName("Laps").item(0).getTextContent();
                    int timeMillis = Integer.parseInt(resultElement.getElementsByTagName("Time").item(0).getAttributes().getNamedItem("millis").getTextContent());
                    int minutes = timeMillis / 60000;
                    double seconds = (timeMillis % 60000) / 1000.0;
                    String formattedTime = String.format("%d:%06.3f", minutes, seconds);

                    // Obtener clasificación de vuelta rápida
                    Element fastestLap = (Element) resultElement.getElementsByTagName("FastestLap").item(0);
                    String fastestLapRank = fastestLap.getAttribute("rank");
                    String fastestLapTime = fastestLap.getElementsByTagName("lapTime").item(0).getTextContent();

                    // Imprimir el resultado en el formato solicitado
                    System.out.printf("%s %s conduciendo un %s%n", familyName, givenName, constructorName);
                    System.out.printf("Parte de la posición %s y termina en la %s%n", startingPosition, finishingPosition);
                    System.out.printf("Ha completado %s vueltas tardando %s%n", laps, formattedTime);
                    System.out.printf("Su clasificación en vuelta rápida personal %s%n%n", fastestLapRank);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

