const todoItemsControl = new TodoItemsController();

newTodoForm.addEventListener('submit', (event) => {
    // Prevent default action
    event.preventDefault();
    // Select the inputs
    const newTitle = document.querySelector('#newTitle');
    const newDescription = document.querySelector('#newDescription');
    const newTargetDate = document.querySelector('#newTargetDate');

    // Get the values of the inputs - variable names to be same as MySQL columns
    const title = newTitle.value;
    const description = newDescription.value;
    const targetDate = newTargetDate.value;

    // Clear the form
    newTitle.value = '';
    newDescription.value = '';
    newTargetDate.value = '';

    // Add the task to the task manager
    todoItemsControl.addTodo(title, description, targetDate);
});
