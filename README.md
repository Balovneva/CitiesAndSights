# CitiesAndSights
<h2 align="center">Города и достопримечательности API на Spring Boot c DB</h2>

Java v17.0.6

Стек: Spring Boot, SQL, JSON, Lombok

<h3>Описание:</h3>
Созданы два объекта: город и достопримечательность. 

Cоздан интерфейс API на основе REST для проведения CRUD операций над объектами. 


Инструкция по запуску: https://docs.google.com/document/d/1Xv1jVHBs9Uy0PUB9VCtlijK0E4kMtiNi/edit?usp=sharing&ouid=103002682866459275054&rtpof=true&sd=true


Связь объектов @OneToMany в базе данных:


![00000000](https://user-images.githubusercontent.com/122821058/232010232-30fb5717-2507-4565-99e6-544f7ce72671.png)

Для тестирование API был использован Talend API Tester.

GET request для объекта City:


![image](https://user-images.githubusercontent.com/122821058/232020157-faff6f14-baac-4507-8e35-a96d689e2756.png)
![image](https://user-images.githubusercontent.com/122821058/232020312-3a410bda-ec0f-451b-a307-26e96ecda308.png)

Если список пуст:

GET request для объекта Sight:


![image](https://user-images.githubusercontent.com/122821058/232021190-da97cf35-ebf4-4731-8321-9230b2e61a85.png)

![image](https://user-images.githubusercontent.com/122821058/232020976-294204af-b553-4b2a-ab72-e614373a0f3a.png)


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


PATCH request для объекта City:


![image](https://user-images.githubusercontent.com/122821058/232021858-d408d135-7432-42d6-be66-d12e3f356b2e.png)
![image](https://user-images.githubusercontent.com/122821058/232021949-0df04ef9-5f35-4bf7-bcc9-7af123cce565.png)

В базе данных:

![image](https://user-images.githubusercontent.com/122821058/232022103-51c58002-c778-4a9a-aaf8-7ddcadfb95ed.png)


Если объекта с таким ID не существует:

![image](https://user-images.githubusercontent.com/122821058/232022325-4e55bbf9-6740-48b3-9d01-d46013965692.png)
![image](https://user-images.githubusercontent.com/122821058/232022488-e17f6dcd-6963-476b-b159-7e84e283164e.png)




