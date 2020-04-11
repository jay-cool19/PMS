<h1>Pre-requisites</h1>

MYSQL database: 
Update the config.yaml if your configuration differs. In this example, we use

    database: mysql_dbname
    user: mysql_usename
    pass: Mysql_use_password
Build:

    mvn clean package
Database creation:

java -jar target/PMS-1.0-SNAPSHOT.jar db migrate config.yaml
Run:

java -jar target/PMS-1.0-SNAPSHOT.jar server config.yaml
Open browser pointing at

http://localhost:9000/person

Available apis

1.Get all persons
curl --location --request GET 'http://localhost:9000/person'

2. Create new person record

curl --location --request POST 'http://localhost:9000/person' \
--header 'Content-Type: application/json' \
--data-raw '{
    "id": 4,
    "name": "name",
    "phone": "mob-no",
    "address": "address"
}'

3.Update an existing person

curl --location --request PUT 'http://localhost:9000/person/2' \
--header 'Content-Type: application/json' \
--data-raw '{"name": "JDB"}'

4.Delete a Person

curl --location --request DELETE 'http://localhost:9000/person/5'