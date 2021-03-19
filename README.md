# Yalinki

To run project you need:

1. In a root directory run `mvn clean install`.
   
2. To run backend and frontend use `mvn spring-boot:run`. Navigate to `http://localhost:8090/`.

3. To run only frontend navigate to directory `frontend` and run `ng serve`. Navigate to `http://localhost:4200/`. The app will automatically reload if you change any of the source files.


## Users
### Post
* /api/v1/login – логин, передавать объект {”login”:       ,   ”password”: }, на выходе ”ok” или ”forbidden”
* /api/v1/register – регистрация, на вход  {”login”:       ,   ”password”:   , ”permission”: String}, результат BAD_REQUEST, forbidden,  CREATED
* /api/v1/addUserOrder/{userid}/{orderid}

### Get
* /api/v1/get_user – получение юзера по айди body: id, на выходе объект юзера
* /api/v1/get_users/{role}
## Orders
### Post
* api/v1/create_order – на вход обьект (String toyName, int quantity, Priority priority, Date deadline, String status, int id), ответ – CREATED
* api/v1/change_status – на вход обьект (int id; String status;), ответ ACCEPTED
* api/v1/change_priority – на вход обьект (int id; String priority;), Ответ – ACCEPTED
* api/v1/delete_order – на вход int id, ответ OK or  NOT_FOUND
### Get
* api/v1/get_orders – получить все заказы
## Materials
### Post
* api/v1/create_material – на вход String name, ответ – ACCEPTED
* api/v1/add_quantity/{id}/{quantity} – добавить количество к материалу, входящие в пути запроса, ответ ACCEPTED
* api/v1/sub_quantity/{id}/{quantity} – отнять количество, может прокинуться BAD_REQUEST
* api/v1/delete_material – на вход int id, ответ ACCEPTED
### Get
* api/v1/get_materials – получить все материалы, может прокинуться NOT_FOUND
