import { BrowserRouter as Router, Route, Routes, Navigate } from 'react-router-dom';
import Login from './pages/Login';
import RedefinirSenha from './pages/RedefinirSenha';
import Menu from './pages/Menu';
import MeuPerfil from './pages/MeuPerfil';
import Agendamento from './pages/Agendamento';
import Suporte from './pages/Suporte';
import Logout from './pages/Logout';
import Polo from './pages/Polo';
import Administrador from './pages/Administrador';
import './App.css';

function App() {
  return (
    <div className="containerBase">

   
    <Router>
      <Routes>
      <Route path="/" element={<Navigate to="/Login" />} />
        <Route path="/Login" element={<Login />} />
        <Route path="/RedefinirSenha" element={<RedefinirSenha />} />
        <Route path="/Menu" element={<Menu />} />
        <Route path="/MeuPerfil" element={<MeuPerfil />} />
        <Route path="/Agendamento" element={<Agendamento />} />
        <Route path="/Suporte" element={<Suporte />} />
        <Route path="/Logout" element={<Logout />} />
        <Route path="/Polo" element={<Polo />} />
        <Route path="/Administrador" element={<Administrador />} />
      </Routes>
    </Router>
    </div>
  );
}

export default App;