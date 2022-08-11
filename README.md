# Grupo 3 DDS 2022

## Ejemplo de uso de carga de mediciones y calculo de huella
  mvn compile exec:java -Dexec.mainClass="dds.grupo3.clases.CalculadorHU" -Dexec.args="-p "./src/files/parametros.txt" -m "./src/files/mediciones.csv""

## Ejemplo de uso API Rest
- GET http://localhost:9000/api/organizations
- GET http://localhost:9000/api/organizations/:id
- POST http://localhost:9000/api/organizations  
  requestBody: {"razonSocial":"organizacion_humo","mediciones":[],"postulados":[],"sectores":[]}
- DELETE http://localhost:9000/api/organizations/:id
