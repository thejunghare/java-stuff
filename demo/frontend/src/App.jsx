import { useState, useEffect } from "react";
import axios from "axios";
import "./App.css";

function App() {
  const [tasks, setTask] = useState([]);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);

  const [taskId, setTaskId] = useState("");
  const [singleTask, setSingleTask] = useState(null);

  async function getAllTask() {
    setLoading(true);
    try {
      let result = await axios.get("http://localhost:8080/api/tasks");
      setTask(result.data);
    } catch (e) {
      setError(e.message);
    } finally {
      setLoading(false);
    }
  }

  async function getTask() {
    setLoading(true);
    try {
      let result = await axios.get(`http://localhost:8080/api/tasks/${taskId}`);
      setSingleTask(result.data);
    } catch (e) {
      setError(e.message);
    } finally {
      setLoading(false);
    }
  }

  useEffect(() => {
    getAllTask();
  }, []);

  if (loading) return <p>Loading..!</p>;
  if (error) return <p>error..! {error}</p>;

  return (
    <div>
      <ul>
        {tasks.map((task) => (
          <li key={task.id}>{task.name}</li>
        ))}
      </ul>

      <input
        type="text"
        name=""
        id=""
        onChange={(e) => setTaskId(e.target.value)}
      />
      <button onClick={getTask}>get</button>

      <div>{singleTask && <p>{singleTask.name}</p>}</div>
    </div>
  );
}

export default App;
