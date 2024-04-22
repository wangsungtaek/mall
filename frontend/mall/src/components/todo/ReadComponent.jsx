import React, { useState } from "react";

const initState = {
  tno: 0,
  title: '',
  writer: '',
  dueDate: '',
  complete: false
}

function ReadComponent(props) {

  const [todo, setTodo] = useState(initState);

  return (
    <div>

    </div>
  )
}

export default ReadComponent;