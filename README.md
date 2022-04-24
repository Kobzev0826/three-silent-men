# Three silent men BEST HACK 2022
## Описание решения


## работа с конфигурационным файлом 
Конфигурационный файл config.yaml. *Может быть передан другой в Application.*  
В файле перечисляются источники с последовательной нумерацией совместе с атрибутами.  
Для всех источников обязательными являются поля type и addr.  
В конце документа зполняются два поля:
- UniqueValue
- validAttributes

UniqueValue - атрибут по которому проходит проверка уникальности
validAttributes - list с атрибутами для сохранения

в поле type указывается тип источника: 
- Для БД - "DB"
- для CSV подобных файлов "CSV"
- для json "json"

в поле addr указывется полный путь для файла или адрес БД  

Для CSV подобный файлов необходимо указать параметр separator  

для БД указываются следующие параметры: 
- login
- password
- table

## пример конфигурационного файла
```
  source1:  
    type: "CSV"  
    addr: "src/main/resources/azs.csv"  
    separator: "|"  
    
  source2:
    type: "json"
    addr: "src/main/resources/azs.json"
    
  source3:
    type: "DB"
    addr: "jdbc:postgresql://localhost:5432/best_hack"
    login: "postgres"
    password: "1"
    table: "gas_stations"
    
  UniqueValue: "name"
    
  validAttributes:
 - address
 - latitude
 - longtitude
 - name
 - country
 - phone
```

## Поддерживаемые форматы фалйлов
- csv подобные 
- json
