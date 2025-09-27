import { useEffect, useState } from "react";
import API from "./api";
import { useNavigate } from "react-router-dom";

export default function Dashboard() {
  const [profile, setProfile] = useState(null);
  const navigate = useNavigate();

  useEffect(() => {
    API.get("/auth/profile")
      .then((res) => setProfile(res.data))
      .catch(() => {
        alert("Not authorized. Please login.");
        navigate("/");
      });
  }, [navigate]);

  const logout = () => {
    localStorage.removeItem("token");
    navigate("/");
  };

  if (!profile) return <p>Loading...</p>;

  return (
    <div>
      <h1>Welcome {profile.username}</h1>
      <button onClick={logout}>Logout</button>
    </div>
  );
}
