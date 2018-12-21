### How To Setup Local Dev Environment

**For local development you need:**
- JDK 10
- PostgreSQL 10 + Postgis (https://postgis.net/install/)
- npm + Node.js (https://www.npmjs.com/get-npm)
- git
- IntelliJ IDEA (Ultimate Edition is preferable)

**Run backend project:**
java -jar -Dspring.profiles.active=dev application.jar

**Run frontend project:**
npm run start

**Useful links:**
- http://geojson.org/
- https://www.mapbox.com/
- https://postgis.net/docs/
- ...


### Database
If you want to run this application and **connect it to the local database**, you need to **change configuration** in the [application.yml](https://github.com/bobocode-labs/gojohnny-rest-api/blob/master/src/main/resources/application.yml) file.
* change active profile to `dev`. See the following code snippet
```
spring:
  profiles:
    active: 'dev'
```
* check database properties for `dev` profile
```
spring:
  profiles: 'dev'
  datasource:
    url: 'jdbc:postgresql://localhost:5432/gojohnny_db'
    username: 'postgres'
    password: 'postgres'
```
* **don't commit any local changes** from [application.yml](https://github.com/bobocode-labs/gojohnny-rest-api/blob/master/src/main/resources/application.yml)

* **if you need to run application locally without changing [application.yml](https://github.com/bobocode-labs/gojohnny-rest-api/blob/master/src/main/resources/application.yml), set active spring profile from "prod" to "dev" or "testing":**
```
open Edit Configurations in your IDEA and in Environment Variables set 
name:"spring.profiles.active" and value: "dev" or "testing"
```

* if you are running project for first time (using empty database), you should **change flyway configuration**:
```
  flyway:
    baseline-on-migrate: true
```
* If you are creating flyway migration scripts, you should use next naming convention:
   `V{MAJOR_VERSION}.{MINOR_VERSION}__Name_of_script.sql`
   
   **Pay attention to double underscores before name!**
   
   For example, we are creating a migration script and current version is `1.8`:
   `V1.9__Add_photo_url_to_place.sql`
  