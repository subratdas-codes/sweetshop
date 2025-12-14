import { useState } from "react";
import api from "../api/axiosConfig";
import "./Login.css";

function Login() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [showPassword, setShowPassword] = useState(false);
  const [error, setError] = useState("");

  const handleLogin = async (e) => {
    e.preventDefault();
    setError("");

    try {
      const res = await api.post("/api/auth/login", {
        username,
        password,
      });

      localStorage.setItem("token", res.data.token);
      alert("Login successful 🍬");
    } catch {
      setError("Invalid username or password");
    }
  };

  return (
    <div className="login-page">
      <div className="login-card">
        <h1 className="title">🍬Sweet Shop</h1>
        <p className="subtitle"></p>

        {error && <p className="error">{error}</p>}

        <form className="login-form" onSubmit={handleLogin}>
          <input
            type="text"
            placeholder="Username"
            className="input"
            value={username}
            onChange={(e) => setUsername(e.target.value)}
            required
          />

          <div className="password-wrapper">
            <input
              type={showPassword ? "text" : "password"}
              placeholder="Password"
              className="input"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              required
            />

            <i
              className={`fa-solid ${
                showPassword ? "fa-eye-slash" : "fa-eye"
              } eye-icon`}
              onClick={() => setShowPassword(!showPassword)}
              title="Show / Hide Password"
            ></i>
          </div>

          <button className="login-btn" type="submit">
            Login
          </button>
        </form>
      </div>
    </div>
  );
}

export default Login;
