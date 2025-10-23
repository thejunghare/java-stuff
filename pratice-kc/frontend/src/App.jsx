import { useState, useEffect } from 'react';
import axios from 'axios'

const App = () => {
  const [tasks, setTasks] = useState([]);
  // const [error, setError] = useState(null);

  const getTask = async () => {
    try {
      let result = await axios.get("http://localhost:8080/api/tasks");
      setTasks(result.data);
    } catch (e) {
      console.log(e.message)
    }
  }

  useEffect(() => {
    getTask();
  }, [])

  return (
    <ul>
      {tasks.map(task => (
        <li key={task.id}>{task.name}</li>
      ))}
    </ul>
  )
}

export default App;