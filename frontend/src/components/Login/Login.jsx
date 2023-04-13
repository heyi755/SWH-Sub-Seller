import { useState } from "react";
import { Navigate } from "react-router-dom";

const Login = ({ onLogin }) => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [isAuthenticated, setIsAuthenticated] = useState(false);

  const handleLogin = (e) => {
    e.preventDefault();
    // 检查用户名和密码是否正确，此处省略
    // 如果正确，则设置 isAuthenticated 为 true
    localStorage.setItem('isAuthenticated', true);
    onLogin();
  };
  

  // 如果已经登录，则重定向到首页
  if (isAuthenticated) {
    return <Navigate to="/" />;
  }

  return (
    <div className="login-page">
      <h1>Login Page</h1>
      <form onSubmit={handleLogin}>
        <div>
          <label>Username:</label>
          <input type="text" value={username} onChange={(e) => setUsername(e.target.value)} />
        </div>
        <div>
          <label>Password:</label>
          <input type="password" value={password} onChange={(e) => setPassword(e.target.value)} />
        </div>
        <button type="submit">Login</button>
      </form>
    </div>
  );
};

export default Login;
