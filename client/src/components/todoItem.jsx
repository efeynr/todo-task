import React, { useEffect,useState } from "react";

const TodoItem = (props) =>{
    const {emitDeleteTask} =props; // handleDeleteTask invoked from parent class as emitDeleteTask
    const[todoItem,setTodoItem]=useState(props.data);
    const [isModified,setModified] =useState(false);
    useEffect(() => { 
        if(isModified) {
        fetch(`http://localhost:8080/api/todo/${todoItem.id}`,
       { method: 'PUT',
        headers: {
            "content-type": "application/json"
        },
         body: JSON.stringify(todoItem)
    })
    .then((response) =>response.json())
    .then((data)=> {
        setModified(false);
        setTodoItem(data);
        
    });
                    }
    },[todoItem,isModified]); //depends on todoItem
       

    function updateIsDone() {
        setTodoItem({...todoItem, status: !todoItem.status});//setTodoItem({'id': id, 'status': status, 'name'= name})

    }
    function updateTask(e){
        setModified(true); //when its modified, we'll send a Put request to the server side
        setTodoItem({...todoItem, name :e.target.value });
        //console.log(todoItem.name);
    }
    function deleteTask() {
        fetch(`http://localhost:8080/api/todo/${todoItem.id}`,
        { method: 'DELETE',
         headers: {
             "content-type": "application/json"
         },
     })
     .then((response) =>response.json())
     .then((data)=> {
         emitDeleteTask(todoItem);
         
     });
    }

    return (
        <div>               
         <input
          type="checkbox"
        checked={todoItem.status} 
        onChange={()=>{
            setModified(true);
            setTodoItem({...todoItem, status: !todoItem.status}); 
            }}
            />
            {
                todoItem.status ? //isDone or not
                (<span style={{textDecoration:'line-through'}}>{todoItem.name}</span>) //style wants object inside thats the reasonf of 2 curlies
                :
                (<input type="text" value={todoItem.name} onChange={updateTask}/>) 
            }
            <span style={{marginLeft:"2rem",cursor:"pointer"}} onClick={deleteTask}>⚰️</span>
         

        </div>
    );

};

export default TodoItem;