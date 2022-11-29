package org.generation.SpringAssessment.controller;

import org.generation.SpringAssessment.controller.dto.TodoDto;
import org.generation.SpringAssessment.repository.entity.Todo;
import org.generation.SpringAssessment.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
//import java.util.Date;
/*
java.sql.Date:
- main purpose is to represent SQL DATE, which keeps years, months and days. No time data is kept.
In fact, the date is stored as milliseconds since the 1st of January 1970 00:00:00 GMT and the time part is normalized, i.e. set to zero.
Basically, it's a wrapper around java.util.Date that handles SQL specific requirements. java.sql.Date should be used only when dealing with databases.
However, as java.sql.Date doesn't hold timezone information, the timezone conversion between our local environment and database server depends on an implementation of JDBC driver. This adds another level of complexity.
Finally, let's note, in order to support other SQL data types: SQL TIME and SQL TIMESTAMP, two other java.sql classes are available: Time and Timestamp.
The latter, even though extends from java.util.Date, supports nanoseconds.

java.util.Date:
- class that represents a particular moment in time, with millisecond precision since the 1st of January 1970 00:00:00 GMT (the epoch time). The class is used to keep coordinated universal time (UTC).

//In short,
Class java.util.Date stores a date-time value as milliseconds since the epoch.
Class java.sql.Date stores a date only value and is commonly used in JDBC.

DATE: It is used for values with a date part but no time part. MySQL retrieves and displays DATE values in YYYY-MM-DD format. The supported range is 1000-01-01 to 9999-12-31.

DATETIME: It is used for values that contain both date and time parts. MySQL retrieves and displays DATETIME values in YYYY-MM-DD HH:MM:SS format. The supported range is 1000-01-01 00:00:00 to 9999-12-31 23:59:59.

TIMESTAMP: It is also used for values that contain both date and time parts, and includes the time zone. TIMESTAMP has a range of 1970-01-01 00:00:01 UTC to 2038-01-19 03:14:07 UTC.

TIME: Its values are in HH:MM:SS format (or HHH:MM:SS format for large hours values). TIME values may range from -838:59:59 to 838:59:59. The hours part may be so large because the TIME type can be used not only to represent a time of day (which must be less than 24 hours), but also elapsed time or a time interval between two events (which may be much greater than 24 hours, or even negative).
 */


@RestController
@RequestMapping("/todo")
public class TodoController {

    private final TodoService todoService;

    public TodoController(@Autowired TodoService todoService) {
        this.todoService = todoService;
    }

    @CrossOrigin
    @GetMapping("/all")
    public Iterable<Todo> getTodo() {
        return todoService.all();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public Todo findTodoById (@PathVariable Integer id) {
        return todoService.findById(id);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public void delete (@PathVariable Integer id) {
        todoService.delete(id);
    }

    @CrossOrigin
    @PostMapping("/add")
    public void save (@RequestParam(name="title", required = true) String title,
                      @RequestParam(name="description", required = true) String description,
                      @RequestParam(name="targetDate", required = true) Date targetDate) {



        TodoDto todoDto = new TodoDto(title, description, targetDate);
        todoService.save(new Todo(todoDto));
    }

}
