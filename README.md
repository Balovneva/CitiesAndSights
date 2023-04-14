# CitiesAndSights
<h2 align="center">Города и достопримечательности API на Spring Boot c DB</h2>

Java v17.0.6

Стек: Spring Boot, SQL, JSON, Lombok

<h3>Описание:</h3>
Созданы два объекта: город и достопримечательность. 

Cоздан интерфейс API на основе REST для проведения CRUD операций над объектами. 

Связь объектов @OneToMany в базе данных:


![00000000](https://user-images.githubusercontent.com/122821058/232010232-30fb5717-2507-4565-99e6-544f7ce72671.png)

Для тестирование API был использован API Tester.

POST request для объекта City:


![image](https://user-images.githubusercontent.com/122821058/232017102-c3badd20-a2fa-41ee-a866-49a6cc441279.png)
![image](https://user-images.githubusercontent.com/122821058/232017440-03c6e8fe-81ea-460b-80f6-635a93790c6d.png)

Если недостаточно данных для создания объекта:


![image](https://user-images.githubusercontent.com/122821058/232019678-fe82fbf6-ad45-4704-a72e-1b7f408ea5a2.png)


В базе данных:


![image](https://user-images.githubusercontent.com/122821058/232018058-456bce36-dbc9-4e15-9c3f-a332fad3a2ca.png)


POST request для объекта Sight:


![image](https://user-images.githubusercontent.com/122821058/232018709-65787bd5-06fa-493a-b438-a855f69c514a.png)
![image](https://user-images.githubusercontent.com/122821058/232018857-d81db682-c913-4c54-a56d-3a264962d697.png)

Если недостаточно данных для создания объекта:


![image](https://user-images.githubusercontent.com/122821058/232019444-24b53394-6d3d-4995-8306-20396206310e.png)


В базе данных:


![image](https://user-images.githubusercontent.com/122821058/232018973-0c1516d4-b932-4a89-a8c8-3ccb7aef0a96.png)
