# Grupo 3 DDS 2022

## Ejemplo de uso de carga de mediciones y calculo de huella

mvn compile exec:java -Dexec.mainClass="dds.grupo3.clases.CalculadorHU" -Dexec.args="-p "./src/files/parametros.txt"
-m "./src/files/mediciones.csv""

## Ejemplo de uso API Rest

- GET https://dds-ma-no-g03.herokuapp.com/api/organizations
- GET https://dds-ma-no-g03.herokuapp.com/api/organizations/1
- POST https://dds-ma-no-g03.herokuapp.com/api/organizations  
  requestBody: {"razonSocial":"organizacion_humo","mediciones":[],"postulados":[],"sectores":[]}
- DELETE https://dds-ma-no-g03.herokuapp.com/api/organizations/2
