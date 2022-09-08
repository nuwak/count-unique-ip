[Задача](Task.md)

Скомпилировать под Java 17.

`./gradlew shadowJar`


### Short

`java -jar build/libs/count-unique-ip-all.jar short ips1000000.txt`

Должны получить следующий вывод

```text
[main] INFO commands.CountCommand - Найдено уникальных IP адресов: 999912
[main] INFO Commander - time: 1348 ms, memory: 38 mb
```

В большинстве тестов он самый быстрый и эффективный по памяти.

### Set

Для сравнения можно запустить подсчет при помощи **Set**:

`java -jar build/libs/count-unique-ip-all.jar set ips1000000.txt`

```text
[main] INFO commands.SetCommand - Найдено уникальных IP адресов: 999912
[main] INFO Commander - time: 1526 ms, memory: 84 mb
```

В большинстве случаев он медленней и потребляет больше памяти чем *short*

### Pair

Первый подход, не самый быстрый и эффективный по памяти, но рабочий.

`java -jar build/libs/count-unique-ip-all.jar pair ips1000000.txt`

Результат

```text
[main] INFO commands.PairCommand - Найдено уникальных IP адресов: 999912
[main] INFO Commander - time: 3983 ms, memory: 213 mb
```