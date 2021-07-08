# To-do API

## About

To-do API is simple RESTful API built using Spring Boot.
The API allow you to add item to a to-do list, update, select and remove from the list.

## Technologies used

* <a href="https://www.java.com/en/">Java 11</a>
* <a href="https://github.com/apache/maven">Maven</a>
* <a href="https://github.com/spring-projects/spring-boot">Spring Boot 2.5.2</a>
* <a href="https://www.postman.com/">Postman</a>
* <a href="http://hibernate.org/">Hibernate</a>
* <a href="https://www.postgresql.org/">PostgreSQL</a>

## Usage:

## API Overview
### Tasks

Method | Endpoint | Description | Returns
------------ | ------------- |-------|--------
POST | `/api/tasks`| Add a Task | `Task`
GET | `/api/tasks` | Get all tasks | `List<Task>`
DELETE|`/api/tasks/{taskId}` | Delete task | `void`
PUT |`/api/tasks/complete/{taskId}` | Mark task as completed | `Task`

### Task Model
```
{
  "id": Long,
  "name": String,
  "dueDate": LocalDateTime,   
  "dateAdded": LocalDateTime,
  "estimatedTime": Integer,
  "finished": boolean,
  "actualTime": Integer,
  "finishedDate": LocalDateTime
}
```

- LocalDateTime format: `yyyy-mm-dd hh:mm:ss.s`

### Add a new task
```
POST -> /api/tasks
{
  "name": "post",
  "taskType": "HOME",
  "dueDate": "2021-07-08T03:33:12",
  "estimatedTime": 0
}
```

- The date and time of the submission is saved automatically in `dateAdded`
- The `finished` property defaults to `false`

### Mark task as completed

```
PUT -> /api/tasks/complete/{taskId}?time_spent={time}
```

- `time_spent` being the actual time spent on completing the task, 
which will be saved as the `actualTime` field
- The date and time will be saved as the `finishedDate` of the task

