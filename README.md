# LunarExample

This is an example application that uses [LunarCat](https://github.com/muchq/LunarCat) as a rest framework and [Mentat](https://github.com/muchq/Mentat) for MySQL-compatible db access.
To run it, you will need:

 - java 8+
 - MySQL / Percona / Maria database

```mysql
create table something (
  id bigint auto_increment primary key,
  name varchar(128) charset utf8
) engine=InnoDB default charset utf8;
```

Ok, now that we have that out of the way, run the example app:

```shell
git clone git@github.com:muchq/LunarExample.git && cd LunarExample
mvn clean package
java -DPORT=8080 -Dexample.db.user=root -Dexample.db.pass= -Dexample.db.host=localhost -Dexample.db.db=foo -jar target/LunarExample-1.0-SNAPSHOT.jar
```

Awesome, now let's make some requests:

```shell
➜  ~ curl -H "Content-Type: application/json" -X POST http://localhost:8080/hello\?name\=Andy
{"id":1,"name":"Andy"}

➜  ~ curl http://localhost:8080/hello/1
{"id":1,"name":"Andy"}%
```

