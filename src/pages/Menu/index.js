import React from 'react';
import { FaUser, FaCalendarAlt, FaHeadset, FaSignOutAlt } from 'react-icons/fa';
import { Link, useNavigate } from 'react-router-dom';
import './index.css';
import { Button, Card, Typography } from '@mui/material';

function Menu() {
  const navigate = useNavigate();

  const handleLogout = () => {
    navigate('/logout');
  };

  return (
    <div className="menu-container">
      <Button className="menu-sair" sx={{ position: 'fixed', top: '20px', right: '20px'
  }} onClick={handleLogout}>
        <FaSignOutAlt className="menu-logout-icon" />
        Sair
      </Button>
      <div className="menu-logo">
        <img src="/images/images-removebg-preview.png" alt="Logo" />
      </div>
      <Typography variant="h4" className="menu-title">
        Menu
      </Typography>
      
      <Card className="menu-card">
        <ul className="menu-items">
          <li>
            <FaUser className="menu-icon-home" />
            <Link to="/MeuPerfil" className="menu-link">Meu Perfil</Link>
          </li>
          <li>
            <FaCalendarAlt className="menu-icon-home" />
            <Link to="/Agendamento" className="menu-link">Agendamento de Avaliações</Link>
          </li>
          <li>
            <FaHeadset className="menu-icon-home" />
            <Link to="/Suporte" className="menu-link">Suporte</Link>
          </li>
        </ul>
      </Card>
    </div>
  );
}

export default Menu;