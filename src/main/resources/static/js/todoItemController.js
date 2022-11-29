const createHTMLList = (title, description, targetDate) =>
`<tr>
<td>${title}</td>
<td>${description}</td>
<td>${targetDate}</td>
</tr>
`;

class TodoItemsController {

   constructor() {
   this._todos = []; //create an empty array to store the details of to-do list
   }

   //method to add the to-do into database through todoForm
   addTodo(title, description, targetDate) {

   let todoItemController = this;
       const formData = new FormData();
       formData.append('title', title);
       formData.append('description', description);
       formData.append('targetDate', targetDate);

       fetch('http://localhost:8080/todo/add', {
            method: 'POST',
            body: formData
       })
       .then(function(response) {
            console.log(response.status); // Will show you the status
            if (response.ok) {
                alert("Successfully Added TODO List!")
            }
            else {
               throw Error(response.statusText);  //the fetch() API only rejects a promise when a “network error is encountered, although this usually means permissions issues or similar.”
            }
       })
       .catch((error) => {
            console.error('Error:', error);
            alert("Error Adding to TODO List")
       });
   }

    //convert date to as requested for assessment
    /*
    what it does is take the Date string
    Which is smth like 2022-6-15
    split into 3 values
    2022,6,15
    reverse the array
    15,6,2022
    join it back with /
    15/6/2022
    return it as a string
    */
    //alternative way (A)// no need add 'function' in front cz it should be considered as method in class
//        flipDate(date) {
//            let newDate = date.split("-");
//            newDate = newDate.reverse();
//            return newDate.join("/");
//        }

    displayTodo() {
        let todoItemController = this;
        todoItemController._todos = [];

        function flipDate(date) {
                    return date.split('-').reverse().join("/");
        }

        fetch('http://localhost:8080/todo/all')  //if not specify any method here, default will be GET method, however others like POST, DELETE, PUT, PATCH have to specify method here
            .then((resp) => resp.json())
            .then(function(data) {
//                console.log("2. receive data")
//                console.log(data);
                data.forEach(function (todo, index) {

                    const todoObj = {
                        id: todo.id,
                        title: todo.title,
                        description: todo.description,
                        targetDate: flipDate(todo.targetDate)
//                        targetDate: todoItemController.flipDate(todo.targetDate) //alternative way (A)//
                   };

                    todoItemController._todos.push(todoObj);
                });

                todoItemController.renderTodoPage();   //call renderTodoPage()

            })
            .catch(function(error) {
                console.log(error);
            });

    }

    //Display to-do list
    renderTodoPage() {
        let todoHTMLList = [];

        for (let i=0; i<this._todos.length; i++)
        {
            const todo = this._todos[i];            //assign the individual item to the variable

            const todoHTML = createHTMLList(todo.title, todo.description, todo.targetDate);

            todoHTMLList.push(todoHTML);
        }
    //Join all the elements/items in my todoHTMLList array into one string, and separate by a break
    const pHTML = todoHTMLList.join('\n');
    document.querySelector('#todoTask').innerHTML = pHTML;
//        console.log(todoHTMLList);  //to see how it's joined in console log

    }
}