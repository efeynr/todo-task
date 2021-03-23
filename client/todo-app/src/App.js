import logo from './logo.svg';
import './App.css';
import { useEffect, useState, Fragment } from "react";
import TodoItem from './components/todoItem';
function App() {

  const [todoItems, setTodoItems] = useState(null); //todoItems is null getter and setter like.

  useEffect(() => { //executes on load
    console.log("loaded");
    if (!todoItems) {
      fetch("http://localhost:8080/api/todo").then((response) => response.json())
        .then(data => {
          console.log("ToDo Tasks List: ", data);
          setTodoItems(data);
        });
    }
  }, []);
  //ternary operator
 


  function addNewTask() {
    fetch("http://localhost:8080/api/todo", {
      headers: {
        'content-type': 'application/json'
      },
      method: 'POST',
      body: JSON.stringify(todoItems[(todoItems.length) - 1])
    })
      .then((response) => response.json())
      .then((data) => {
        console.log(data);
        setTodoItems([...todoItems, data]);
      });
  }

  function handleDeleteTask(item) {
    const updatedTodos = todoItems.filter(a => a.id !== item.id);
    setTodoItems([...updatedTodos]);
  }


  return (
    <div className="">
      <div className="wrapper">
        <div className="headpart">
          <div className="col">
           <h1><b>Todo App</b></h1>
         </div>
         <div className="col-6"></div>
      <div className="create-div col">
        <button className="btn btn-secondary" onClick={addNewTask}>Create New Task</button>
      </div>
      <br/>
      </div>
      <div className="center-div">
        {todoItems
          ? todoItems.map(item => { //todoitems null değilse mapping uygula 
            return (
              <TodoItem
                key={item.id}
                data={item}
                emitDeleteTask={handleDeleteTask} />
            );
          })
          : "loading data"}
      </div>
      </div>
    </div>
  ); //json to html lets go bum!
}

export default App;
