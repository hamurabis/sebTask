## Build with maven
 
mvn clean install

## Start application

mvn tomcat7:run

## Run REST unit tests only on local app on 8080 port

mvn clean install

## Suggestion example link 

http://localhost:8090/bundle-suggestion/services/suggest?age=10&income=0&isStudent=true

## Custom bundle example with json

http://localhost:8090/bundle-suggestion/services/custom?age=20&income=50000&isStudent=true

{
"bundleName" : "Classic",
"productsToAdd" : ["Credit Card"],
 "productsToRemove" : ["Current Account"]
}

