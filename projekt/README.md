# Projekt JavaEE

### Przygotowanie

Aby uruchomić poprawnie aplikację należy wejść do folderu z projektem i zastosować komendy:

```sh
$ ./scripts/runHSQLDBServer.sh
$ ./scripts/runHSQLDBClient.sh
```

### Uruchomienie

Aby zdeployować poprawnie program należy zastosować komendę:

```sh
$ mvn wildfly:deploy
```

### Postman

Przygotowana została kolekcja requestów w folderze
```sh
src/test/java/com/example/restejbjpa
```

w pliku
```sh
restejbjpademo.postman_collection.json
```
