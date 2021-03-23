import React, { useEffect, useState } from "react";

const TodoItem = (props) => {
    const { emitDeleteTask } = props; // handleDeleteTask invoked from parent class as emitDeleteTask
    const [todoItem, setTodoItem] = useState(props.data);
    const [isModified, setModified] = useState(false);
    useEffect(() => {
        if (isModified) {
            fetch(`http://localhost:8080/api/todo/${todoItem.id}`,
                {
                    method: 'PUT',
                    headers: {
                        "content-type": "application/json"
                    },
                    body: JSON.stringify(todoItem)
                })
                .then((response) => response.json())
                .then((data) => {
                    setModified(false);
                    setTodoItem(data);

                });
        }
    }, [todoItem, isModified]); //depends on todoItem


    function updateIsDone() {
        setTodoItem({ ...todoItem, status: !todoItem.status });//setTodoItem({'id': id, 'status': status, 'name'= name})

    }
    function updateTask(e) {
        setModified(true); //when its modified, we'll send a Put request to the server side
        setTodoItem({ ...todoItem, name: e.target.value });
        //console.log(todoItem.name);
    }
    function deleteTask() {
        fetch(`http://localhost:8080/api/todo/${todoItem.id}`,
            {
                method: 'DELETE',
                headers: {
                    "content-type": "application/json"
                },
            })
            .then((response) => response.json())
            .then((data) => {
                emitDeleteTask(todoItem);

            });
    }

    return (
        <div>
             {
                !todoItem.status ? //isDone or not
                    (<button style={{width: "0px !important", marginRight:"45px !important", background:"none", border:"none"}} value={todoItem.name } onClick={() => {
                        setModified(true);
                        setTodoItem({ ...todoItem, status: !todoItem.status });
                        
                       // value=isModified ? "+":"-"
                    }}><img src="https://www.freeiconspng.com/uploads/black-checkmark-png-4.png" width="27" alt="Black Check" /></button>) //style wants object inside thats the reasonf of 2 curlies
                    :
                    (<button style={{width: "50px !important" , marginRight:"20px !important", background:"none", border:"none"}} value={todoItem.name } onClick={() => {
                        setModified(true);
                        setTodoItem({ ...todoItem, status: !todoItem.status });
                        
                       // value=isModified ? "+":"-"
                    }} ><img src="http://www.pngmart.com/files/8/Multiplication-Sign-PNG-HD.png" width="18" alt="Black Cross" /></button>)
            }

            {
                todoItem.status ? //isDone or not
                    (<input readOnly className ="formargin alert alert-dark" style={{textDecoration: 'line-through' }} value={todoItem.name}/>) //style wants object inside thats the reasonf of 2 curlies
                    :
                    (<input  className="formargin alert alert-dark" type="text" value={todoItem.name} onChange={updateTask} />)
            }
            <span style={{marginLeft: "2rem", cursor: "pointer" }} onClick={deleteTask}>🗑️</span>


        </div>
    );

};

export default TodoItem;