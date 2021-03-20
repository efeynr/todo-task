import logo from './logo.svg';
import './App.css';
import {useEffect,useState,Fragment} from "react";
import TodoItem from './components/todoItem';
function App() {

  const [todoItems, setTodoItems] = useState(null); //todoItems is null getter and setter like.

  useEffect(()=>{ //executes on load
      console.log("loaded");
      if(!todoItems){
      fetch("http://localhost:8080/api/todo").then((response) => response.json())
      .then(data =>{
        console.log("ToDo Tasks List: ",data);
        setTodoItems(data);
      });
    }
  }, [todoItems]);
    //ternary operator



      function addNewTask() {
          fetch("http://localhost:8080/api/todo",{
            headers: {
              'content-type' : 'application/json'
            },
            method:'POST'
          })
          .then((response)=> response.json())
          .then((data)=>{
              console.log(data);
              setTodoItems([...todoItems,data]);
          });
      }

      function handleDeleteTask(item){
        const updatedTodos = todoItems.filter(a=> a.id !==item.id );
        setTodoItems([...updatedTodos]);
      } 


  return(
    <>
    <div>
      <button onClick={addNewTask}>Create New Task</button>
    </div>
     <div>    
        {todoItems 
          ? todoItems.map(item =>{ //todoitems null değilse mapping uygula 
              return(
                 <TodoItem
                  key={item.id} 
                  data={item}
                  emitDeleteTask={handleDeleteTask} />
              );   
     })
      :"loading data" } 
  </div>
  </>
  ); //json to html lets go bum!
}

export default App;
